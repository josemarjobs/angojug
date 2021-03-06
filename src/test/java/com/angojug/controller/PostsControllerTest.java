package com.angojug.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Calendar;

import javax.validation.ConstraintViolationException;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;

import com.angojug.ControllerTestSetUp;
import com.angojug.CreateTestDataBase;
import com.angojug.dao.PostDAO;
import com.angojug.dao.TagDAO;
import com.angojug.model.ComentarioStatus;
import com.angojug.model.Postagem;
import com.angojug.model.User;
import com.angojug.model.UsuarioWeb;

/**
 * 
 * @author josemarjobs
 * @since 15/05/2011 23:40
 */

public class PostsControllerTest extends TestCase {

	private PostsController controller;
	private Validator validator;
	private Result result;
	private PostDAO dao;
	private TagDAO tagDao;
	private UsuarioWeb usuarioWeb;
	private static int i = 0;

	public static junit.framework.Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(PostsControllerTest.class);
		return new ControllerTestSetUp(suite);
	}

	@Override
	protected void setUp() throws Exception {
		validator = mock(Validator.class);
		result = mock(Result.class);
		usuarioWeb = mock(UsuarioWeb.class);

		User user = createUser("josemar_" + ++i + "_jobs", "josemar_" + i
				+ "@msn.com");
		usuarioWeb.login(user);
		when(usuarioWeb.getUser()).thenReturn(user);

		dao = new PostDAO(CreateTestDataBase.getSessionFactory().openSession());
		tagDao = new TagDAO(CreateTestDataBase.getSessionFactory()
				.openSession());
		controller = new PostsController(result, dao, validator, usuarioWeb,
				tagDao);
		when(validator.onErrorRedirectTo(controller)).thenReturn(controller);
		when(validator.onErrorUsePageOf(controller)).thenReturn(controller);
		when(result.redirectTo(controller)).thenReturn(controller);
		
	}

	@Test
	public void testCreate() {
		assertNotNull(controller);
	}

	@Test
	public void testCriaPostagemComDadosValidos() {
		int count = this.dao.list().size();
		Postagem p = createValidPost();

		controller.adiciona(p);

		assertNotNull(p.getId());
		assertEquals(count + 1, this.dao.list().size());
	}

	@Test
	public void testNaoCriaPostSemTitulo() {
		Postagem post = createValidPost();
		post.setTitulo(null);
		try {
			controller.adiciona(post);
			fail("N�o pode criar post sem titulo");
		} catch (ConstraintViolationException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testNaoCriaPostSemPeloMenosUmaTag() {
		Postagem post = createValidPost();
		post.setMarcadores(null);
		try {
			controller.adiciona(post);
			fail("N�o pode criar post sem Tags");
		} catch (ConstraintViolationException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testEditPost() {
		int count = this.dao.list().size();
		Postagem p = createValidPost();

		controller.adiciona(p);

		assertNotNull(p.getId());
		assertEquals(count + 1, this.dao.list().size());

		Postagem p2 = dao.load(p.getId());
		p2.setTitulo("Titulo Alterado");
		p2.setCorpo("corpo tbm alterado");
		controller.atualiza(p2);
		
		Postagem p3 = controller.show(p2.getId());
		assertEquals(p3.getId(), p.getId());
		assertEquals("Titulo n�o foi alterado", "Titulo Alterado", p3.getTitulo());
		assertEquals("Corpo n�o foi alterado","corpo tbm alterado", p3.getCorpo());
		assertEquals("a quantidade de posts errada",count + 1, this.dao.list().size());
	}

//	@Test
//	public void testRemovePost(){
//		int count = this.dao.list().size();
//		Postagem p = createValidPost();
//
//		controller.adiciona(p);
//
//		assertNotNull(p.getId());
//		assertEquals("Adicionou o post correctamente", count + 1, this.dao.list().size());
//
//		Postagem p2 = dao.load(p.getId());
//		controller.remove(p2);
//		assertEquals("N�o removeu [quantidade de posts errada]", count, this.dao.list().size());
//	}
	
	private Postagem createValidPost() {
		Postagem post = new Postagem();
		post.setTitulo("Primeiro Post & tbm post de Test");
		post.setData(Calendar.getInstance());
		post.setComentarioStatus(ComentarioStatus.OPEN);
		post.setCorpo("All projects are private at creation on Java.net. "
				+ "The two major reasons for this are spam control, "
				+ "and the fact that over 90% of projects requested "
				+ "never go anywhere beyond the original request. "
				+ "We prefer to keep these projects out of public.");
		post.setMarcadores("java, php, rubyonrails, rails");
		return post;
	}

	private User createUser(String nome, String email) {
		User user = new User();
		user.setNome(nome);
		user.setEmail(email);
		user.setPassword("12345675");
		Session session = CreateTestDataBase.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
		return user;
	}
}

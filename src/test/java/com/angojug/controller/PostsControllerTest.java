package com.angojug.controller;

import java.util.Calendar;

import javax.validation.ConstraintViolationException;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import static org.mockito.Mockito.*;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;

import com.angojug.ControllerTestSetUp;
import com.angojug.CreateTestDataBase;
import com.angojug.dao.PostDAO;
import com.angojug.model.ComentarioStatus;
import com.angojug.model.Postagem;
import com.angojug.model.User;

public class PostsControllerTest extends TestCase {

	private PostsController controller;
	private Validator validator;
	private Result result;
	private PostDAO dao;

	public static junit.framework.Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(PostsControllerTest.class);
		return new ControllerTestSetUp(suite);
	}

	@Override
	protected void setUp() throws Exception {
		validator = mock(Validator.class);
		result = mock(Result.class);
		dao = new PostDAO(CreateTestDataBase.getSessionFactory().openSession());
		controller = new PostsController(result, dao, validator);
		when(validator.onErrorRedirectTo(controller)).thenReturn(controller);
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
		p.setAutor(createUser("bill gates", "gates@ms.com"));
		controller.adiciona(p);
		assertNotNull(p.getId());
		assertEquals(count + 1, this.dao.list().size());
	}

	@Test
	public void testNaoCriaPostSemTitulo() {
		Postagem post = createValidPost();
		post.setTitulo(null);
		post.setAutor(createUser("josemar jobs", "josemar@jobs.com"));
		try {
			controller.adiciona(post);
			fail("Não pode criar post sem titulo");
		} catch (ConstraintViolationException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testNaoCriaPostSemPeloMenosUmaTag() {
		Postagem post = createValidPost();
		post.setAutor(createUser("josemar jobs1", "jobs@josemar.com"));
		post.setMarcadores(null);
		try {
			controller.adiciona(post);
			fail("Não pode criar post sem Tags");
		} catch (ConstraintViolationException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testNaoCriaPostSemAutor() {
		Postagem post = createValidPost();
		try {
			controller.adiciona(post);
			fail("Não pode criar post sem Autor");
		} catch (org.hibernate.exception.ConstraintViolationException e) {
			assertTrue(true);
		}
	}

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

package com.angojug.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Calendar;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import br.com.caelum.vraptor.Result;

import com.angojug.ControllerTestSetUp;
import com.angojug.CreateTestDataBase;
import com.angojug.dao.ComentarioDAO;
import com.angojug.model.Comentador;
import com.angojug.model.Comentario;
import com.angojug.model.ComentarioStatus;
import com.angojug.model.Postagem;
import com.angojug.model.User;

public class ComentariosControllerTest extends TestCase {

	private ComentariosController controller;
	private Result result;
	private ComentarioDAO dao;

	public static junit.framework.Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(ComentariosControllerTest.class);
		return new ControllerTestSetUp(suite);
	}

	@Override
	protected void setUp() throws Exception {
		dao = new ComentarioDAO(CreateTestDataBase.getSessionFactory()
				.openSession());
		result = mock(Result.class);
		controller = new ComentariosController(result, dao);
		PostsController postsController = mock(PostsController.class);
		when(result.redirectTo(PostsController.class)).thenReturn(
				postsController);
	}

	@Test
	public void testCriaController() {
		assertNotNull(controller);
	}

	@Test
	public void testAdicionaComentario() {
		Postagem p = createValidPost();
		Comentario c = createValidComment();
		controller.adiciona(c, p);
		assertNotNull(c.getId());
		assertEquals(c.getPostagem(), p);
	}

	private Comentario createValidComment() {
		Comentario c = new Comentario();
		c.setCorpo("All projects are private at creation on Java.net. "
				+ "The two major reasons for this are spam control,");
		c.setData(Calendar.getInstance());
		c.setComentador(new Comentador("cruz", "cruz@msn.com", "msn.com"));
		return c;
	}

	private Postagem createValidPost(String nome, String email) {
		Long uId = createUser(nome, email).getId();

		Session session = CreateTestDataBase.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		User user = (User) session.load(User.class, uId);

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
		user.addPost(post);
		tx.commit();
		session.close();
		return post;
	}

	private Postagem createValidPost() {
		return createValidPost("jjoossemmar", "mar@jose.com");
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

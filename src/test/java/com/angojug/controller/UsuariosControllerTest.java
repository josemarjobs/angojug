package com.angojug.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.junit.Test;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;

import com.angojug.ControllerTestSetUp;
import com.angojug.CreateTestDataBase;
import com.angojug.IndexController;
import com.angojug.dao.UserDAO;
import com.angojug.model.User;

public class UsuariosControllerTest extends TestCase {

	private Validator validator;
	private Result result;
	private UserDAO dao;
	private UsuariosController controller;

	public static junit.framework.Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(UsuariosControllerTest.class);
		return new ControllerTestSetUp(suite);
	}

	@Override
	protected void setUp() throws Exception {
		validator = mock(Validator.class);
		result = mock(Result.class);
		controller = new UsuariosController(result, dao, validator);
		dao = new UserDAO(CreateTestDataBase.getSessionFactory().openSession());
		controller = new UsuariosController(result, dao, validator);
		when(validator.onErrorRedirectTo(controller)).thenReturn(controller);

		when(result.redirectTo(controller)).thenReturn(controller);
	}

	@Test
	public void testCreateController() {
		assertNotNull(controller);
	}

	@Test
	public void testCriaUsuarioComDadosValidos() {
		int count = dao.list().size();
		User user = criaUsuarioValido("josemar da costa", "josemar@gmail.com");
		controller.adiciona(user);
		assertNotNull(user.getId());
		assertEquals(new Long(1), user.getId());
		assertEquals(count + 1, dao.list().size());
	}

	@Test
	public void testLancaErroAoInserirNomeJaCadastrado() {
		User user = criaUsuarioValido("josemar ja cadastrado",
				"cadastrado@gmail.com");
		controller.adiciona(user);

		User userJaCadastrado = criaUsuarioValido("josemar ja cadastrado",
				"cadastrado@gmail.com");
		try {
			controller.adiciona(userJaCadastrado);
			fail("Não pode criar usuario com dados ja cadastrados");
		} catch (Exception e) {
			assertTrue(true);
		}

	}

	@Test
	public void testLancaErroAoCriarUsuarioSemNome() {
		User user = new User();
		user.setEmail("josemar@gmail.com");
		user.setPassword("12345675");
		try {
			controller.adiciona(user);
			fail("Dados de usuario Sem o NOME não pode ser salvo.");
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	@Test
	public void testLancaErroAoCriarUsuarioSemEmail() {
		User user = new User();
		user.setNome("Josemar da Costa");
		user.setPassword("12345675");
		try {
			controller.adiciona(user);
			fail("Dados de usuario Sem o EMAIL não pode ser salvo.");
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	@Test
	public void testLancaErroAoCriarUsuarioSemPassword() {
		User user = new User();
		user.setNome("Josemar da Costa");
		user.setEmail("cruz@gmail.com");
		try {
			controller.adiciona(user);
			fail("Dados de usuario Sem o PASSWORD não pode ser salvo.");
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	@Test
	public void testActualizaDadosCorretamente() {
		User user = criaUsuarioValido("steve jobs", "jobs@apple.com");
		controller.adiciona(user);

		User user1 = controller.edita(user.getId());

		user1.setNome("josemar da costa magalhaes");
		user1.setEmail("josemarjobs@gmail.com");
		user1.setPassword("04028910");

		when(validator.onErrorUsePageOf(controller)).thenReturn(controller);

		controller.atualizar(user1);

		User u = controller.dados(user1.getId());
		assertEquals("josemar da costa magalhaes", u.getNome());
		assertEquals("josemarjobs@gmail.com", u.getEmail());
		assertEquals("04028910", u.getPassword());
	}

	@Test
	public void testDeleteUsuario() {
		User user = criaUsuarioValido("Bill Gates", "gates@ms.com");
		controller.adiciona(user);
		int count = dao.list().size();
		assertNotNull("ID NULL significa que o usuario não foi criado",
				user.getId());
		IndexController index = mock(IndexController.class);

		when(result.redirectTo(IndexController.class)).thenReturn(index);

		controller.remove(user.getId());
		assertEquals("O controlador não removeu usuario", count - 1, dao.list()
				.size());
	}

	public void testListarUsuariosCadastrados() {
		int count = dao.list().size();
		User u1 = criaUsuarioValido("marilinda da costa", "marilinda@soft.com");
		User u2 = criaUsuarioValido("crua da costa", "cruz@soft.com");
		controller.adiciona(u1);
		controller.adiciona(u2);
		assertEquals("Usuarios não listados corretamente", count + 2,
				controller.list().size());

	}

	private User criaUsuarioValido(String nome, String email) {
		User user = new User();
		user.setNome(nome);
		user.setEmail(email);
		user.setPassword("12345675");
		return user;
	}

}

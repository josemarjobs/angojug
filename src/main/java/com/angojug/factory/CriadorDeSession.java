package com.angojug.factory;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;
import br.com.caelum.vraptor.ioc.RequestScoped;

/**
 * 
 * @author josemarjobs
 * @since 14/05/2011:17:40
 * 
 *        Criados de Session, classe que permite a criação de session do
 *        hibernate automaticamente pelo VRaptor, e assim o VRaptor vai gerencia
 *        todo o ciclo de vida, fazer a injeção das dependencias, e injetar
 *        sessions onde for preciso.
 */

@Component
@RequestScoped
public class CriadorDeSession implements ComponentFactory<Session> {

	private final SessionFactory factory;
	private Session session;
	List<Session> sessions;

	public CriadorDeSession(SessionFactory factory) {
		this.factory = factory;
	}

	/**
	 * cria a session, executado sempre logo no inicio de cada requisição
	 */
	@PostConstruct
	public void abre() {
		session = factory.openSession();
		System.out.println("Criada uma Session");
	}

	@Override
	public Session getInstance() {
		// this.session = this.factory.openSession();
		// sessions.add(session);
		// System.out.println("+++++++> Mais uma session criada");
		return session;
	}

	/**
	 * fecha a session, executado sempre logo depois de cada requisição
	 */
	@PreDestroy
	public void fecha() {
		// for (Session s : sessions) {
		// s.close();
		// System.out.println("+++++++> Eliminada uma session");
		// }
		System.out.println("Fechando a session");
		this.session.close();
	}

}

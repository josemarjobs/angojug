package com.angojug.factory;

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
 * Criados de Session, classe que permite a cria��o de session do hibernate
 * automaticamente pelo VRaptor, e assim o VRaptor vai gerencia todo o ciclo de vida, 
 * fazer a inje��o das dependencias, e injetar sessions onde for preciso.
 */

@Component
@RequestScoped
public class CriadorDeSession implements ComponentFactory<Session> {

	private final SessionFactory factory;
	private Session session;

	public CriadorDeSession(SessionFactory factory) {
		this.factory = factory;
	}

	/**
	 * cria a session, executado sempre logo no inicio de cada requisi��o
	 */
	@PostConstruct
	public void abre() {
		this.session = this.factory.openSession();
	}

	@Override
	public Session getInstance() {
		return this.session;
	}

	/**
	 * fecha a session, executado sempre logo depois de cada requisi��o
	 */
	@PreDestroy
	public void fecha() {
		this.session.close();
	}

}

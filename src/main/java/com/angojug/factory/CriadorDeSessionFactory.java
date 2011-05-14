package com.angojug.factory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

/**
 * 
 * @author josemarjobs
 * @since 14/05/2011:17:40
 * 
 * Criados de SessionFactory, classe que permite a cria��o de SessionFactory do hibernate
 * automaticamente pelo VRaptor, e assim o VRaptor vai gerencia todo o ciclo de vida, 
 * fazer a inje��o das dependencias, e injetar sessionfactory's onde for preciso.
 */

@Component
@ApplicationScoped
public class CriadorDeSessionFactory implements
		ComponentFactory<SessionFactory> {
	private SessionFactory factory;

	/**
	 * cria as configura��es atraves do hibernate.cfg.xml, e cria a sessionfactory
	 * logo qua a aplica��o � iniciada
	 */
	@PostConstruct
	public void abre() {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure();
		this.factory = cfg.buildSessionFactory();
	}

	@Override
	public SessionFactory getInstance() {
		return factory;
	}

	/**
	 * fecha a sessionFactory no final da aplica��o
	 */
	@PreDestroy
	public void fecha() {
		this.factory.close();
	}
}
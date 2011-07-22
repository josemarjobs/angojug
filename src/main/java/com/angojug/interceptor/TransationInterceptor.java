package com.angojug.interceptor;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.resource.ResourceMethod;

@Intercepts
@RequestScoped
public class TransationInterceptor implements Interceptor {

	private Session session;

	public TransationInterceptor(Session session) {
		this.session = session;
	}

	@Override
	public boolean accepts(ResourceMethod method) {
		return method.containsAnnotation(Transational.class);
	}

	@Override
	public void intercept(InterceptorStack stack, ResourceMethod method,
			Object instance) throws InterceptionException {
		System.out.println("/+>Intercepting the Method: "
				+ method.getMethod().getName());
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			stack.next(method, instance);
			tx.commit();
		} catch (RuntimeException e) {
			try {
				tx.rollback();
			} catch (RuntimeException ee) {
				System.out.println("Can't rollback the transation\n"
						+ e.getMessage());
			}
			throw e;
		}

	}

}

package jsf.companies.util;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class TransacionalInterceptor implements Serializable {

    private static final long serialVersionUID = -3388581029674738231L;

    @Inject
    private EntityManager manager;

    @AroundInvoke
    public Object invoke(InvocationContext context) throws Exception {
	EntityTransaction transaction = manager.getTransaction();
	boolean criador = false;

	try {
	    if (!transaction.isActive()) {
		// Change to rollback on what is passed
		// Or in an future commit, it confirms the operation without transaction
		transaction.begin();
		transaction.rollback();

		// begin transaction

		transaction.begin();

		criador = true;
	    }
	    return context.proceed();
	} catch (Exception e) {
	    if (transaction != null && criador) {
		transaction.rollback();
	    }
	    throw e;
	} finally {
	    if (transaction != null && transaction.isActive()
		    && criador) {
		transaction.commit();
	    }
	}
    }
}

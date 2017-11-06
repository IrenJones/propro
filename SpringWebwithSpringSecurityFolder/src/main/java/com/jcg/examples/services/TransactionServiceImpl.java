package com.jcg.examples.services;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.jcg.examples.models.Transfer;

import java.util.LinkedList;
import java.util.List;

public class TransactionServiceImpl implements TransactionService{

	@Override
	public List<Transfer> selectAll() {
		SessionFactory sf = null;
		Session session = null;
		List<Transfer> tr_list = new LinkedList<Transfer>();
		try {			
			sf = new Configuration().configure().buildSessionFactory();
			session = sf.openSession();
			session.beginTransaction();
			Query q = session.createQuery("from Transfer");
			tr_list = q.list();
		} catch (RuntimeException e) {
			try {				
				session.getTransaction().rollback();
			} catch (RuntimeException rbe) {
				System.err.println("Couldn’t roll back transaction" + rbe);
			}
		} finally {
			if(session != null) {				
				session.close();
			}
			if(sf != null) {
				sf.close();	       				
			}
		}
		return tr_list;
	}

}

package com.jcg.examples.services;

import com.jcg.examples.models.BankAccount;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.LinkedList;
import java.util.List;

public class BankAccountServiceImpl implements BankAccountService {
    @Override
    public List<BankAccount> selectAll() {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = null;
        List<BankAccount> tr_list = new LinkedList<BankAccount>();
        try {
            session = sf.openSession();
            Query q = session.createQuery("from BankAccount");
            tr_list = q.list();
        } catch (RuntimeException e) {
            throw new RuntimeException("Error while transaction performing");
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return tr_list;
    }

    @Override
    public void changeStatusById(long id) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        Session sess = null;
        try {
            sess = sf.openSession();
            Transaction tx = null;
            try {
                tx = sess.beginTransaction();
                BankAccount acc = (BankAccount) sess.get(BankAccount.class, id);
                if (acc.getIs_blocked() == true) {
                    acc.setIs_blocked(false);
                }
                else{
                    acc.setIs_blocked(true);
                }
                sess.save(acc);
                tx.commit();
            } catch(RuntimeException e2) {
                try {
                    if(tx != null) tx.rollback();
                } catch (Exception e3) {
                    throw new RuntimeException("Rollback error");
                }
                throw new RuntimeException("Error while performing transaction");
            }

        } catch (RuntimeException e1) {
            throw new RuntimeException(e1.getMessage());
        } finally {
            if(sess != null) sess.close();
        }
    }

    @Override
    public BankAccount getById(long id) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        Session sess = null;
        BankAccount bankAccount = null;

        try {

            sess = sf.openSession();
            Transaction tx = null;

            try {
                tx = sess.beginTransaction();
                Query q = sess.createQuery("from BankAccount where id = :id");
                q.setParameter("id", id);
                bankAccount = (BankAccount)q.list().get(0);
                tx.commit();
            } catch(RuntimeException e2) {
                try {
                    if(tx != null) tx.rollback();
                } catch (Exception e3) {
                    throw new RuntimeException("Rollback error");
                }
                throw new RuntimeException("Error while making query");
            }

        } catch (RuntimeException e1) {
            throw new RuntimeException(e1.getMessage());
        } finally {
            if(sess != null) sess.close();
        }

        if(bankAccount == null) throw new RuntimeException("BankAccount  not found");
        return bankAccount;

    }
}

package com.maskbor.cakemanager.dto;

import com.maskbor.cakemanager.model.Cake;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author root
 */
public class CakeRepositoryImp implements CakeRepository{
    public static final Logger logger = LoggerFactory.getLogger(CakeRepositoryImp.class);
    
    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public CompletableFuture<Cake> getItem(int id) {
        Session session = sessionFactory.getCurrentSession();
        return CompletableFuture.supplyAsync((Supplier<Cake>)((Cake) session.load(Cake.class, id)) );
    }

    @Override
    public CompletableFuture<List<Cake>> getRange(CakeFilter filter) {
        Session session = sessionFactory.getCurrentSession();
        return CompletableFuture.supplyAsync(
                    (Supplier<List<Cake>>)
                           (session.createQuery("").list()));
    }
  
    @Override
    public CompletableFuture<Void> addItem(final Cake cake) {
        final Session session = sessionFactory.getCurrentSession();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                 session.persist(cake);
            }
        };
        return CompletableFuture.runAsync(r);
    }

    @Override
    public CompletableFuture<Void> updateItem(final Cake cake) {
        final Session session = sessionFactory.getCurrentSession();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                 session.update(cake);
            }
        };
        return CompletableFuture.runAsync(r);
    }

    @Override
    public CompletableFuture<Void> removeItem(final Cake cake) {
        final Session session = sessionFactory.getCurrentSession();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                if(cake!=null)
                    session.delete(cake);
            }
        };
        return CompletableFuture.runAsync(r);
    }

    @Override
    public CompletableFuture<Long> getTotal(Cake cake) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

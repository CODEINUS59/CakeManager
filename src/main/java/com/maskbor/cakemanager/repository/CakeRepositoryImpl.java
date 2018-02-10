package com.maskbor.cakemanager.repository;

import com.maskbor.cakemanager.model.Cake;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "CakeRepository")
public class CakeRepositoryImpl implements CakeRepository{
    public static final Logger logger = LoggerFactory.getLogger(CakeRepositoryImpl.class);
    
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
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
        final Session session = sessionFactory.getCurrentSession();
        Supplier<List<Cake>> s;
        s = new Supplier<List<Cake>>() {
            @Override
            public List<Cake> get() {
                String query = "from Cake where ";
                //filter.limit
                return session.createQuery(query).list();
            }
        };
        return CompletableFuture.supplyAsync(s);
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
    public CompletableFuture<Long> getTotal(CakeFilter filter) {
        final Session session = sessionFactory.getCurrentSession();
        Supplier<Long> s;
        s = new Supplier<Long>() {
            @Override
            public Long get() {
                String query = "select count(id) from Cake where ";
                //filter.limit
//                Long total = session.createQuery(query).
                return new Long(0);
            }
        };
        return CompletableFuture.supplyAsync(s);
    }

}

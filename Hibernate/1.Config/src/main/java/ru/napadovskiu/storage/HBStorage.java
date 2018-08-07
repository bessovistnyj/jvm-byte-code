package ru.napadovskiu.storage;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import ru.napadovskiu.models.Items;

import java.util.Collection;
import java.util.List;

public class HBStorage implements Storage {

    private final SessionFactory factory;


    public HBStorage() {
        this.factory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public boolean update(Items items) {
        boolean result =false;
        final Session session = this.factory.openSession();
        Transaction tr = session.beginTransaction();
        try {
            session.save(items);
            result = true;
        } finally {
            tr.commit();
            session.close();
        }
        return result;
    }

    @Override
    public boolean delete(Items items) {
        boolean result =false;
        final Session session = this.factory.openSession();
        Transaction tr = session.beginTransaction();
        try {
            session.delete(items);
            result = true;
        } finally {
            tr.commit();
            session.close();
        }
        return result;
    }

    @Override
    public int add(Items items) {
        final Session session = this.factory.openSession();
        Transaction tr = session.beginTransaction();
        try {
            session.save(items);
            return items.getId();
        } finally {
            tr.commit();
            session.close();
        }
    }

    @Override
    public Items get(int id) {
        final Session session = this.factory.openSession();
        Transaction tr = session.beginTransaction();
        try {
            return (Items) session.get(Items.class, id);
        } finally {
            tr.commit();
            session.close();
        }

    }

    @Override
    public Collection<Items> getAll() {
        List<Items> items;
        final Session session = this.factory.openSession();
        Transaction tr = session.beginTransaction();
        try {
            items =  session.createQuery("from ru.napadovskiu.models.Items").list();
        } finally {
            tr.commit();
            session.close();
        }
        return items;
    }

    @Override
    public Items findByDesc(String desc) {
        return null;
    }

    @Override
    public void close() {
        this.factory.close();
    }


}

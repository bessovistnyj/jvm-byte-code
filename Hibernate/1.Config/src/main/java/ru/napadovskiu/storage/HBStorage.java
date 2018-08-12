package ru.napadovskiu.storage;


import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.napadovskiu.models.Items;

import java.util.List;

/**
 *
 */
public class HBStorage implements Storage<Items> {

    /**
     *
     */
    private static final HBStorage INSTANCE = new HBStorage();


    /**
     *
     */
    public HBStorage() {
    }

    /**
     *
     * @return
     */
    public static HBStorage getInstance() {
        return INSTANCE;
    }


    /**
     *
     * @param items
     * @return
     */
    @Override
    public boolean update(Items items) {
        boolean result = false;
        final Session session = HibernateFactory.getInstance().openSession();
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

    /**
     *
     * @param items
     * @return
     */
    @Override
    public boolean delete(Items items) {
        boolean result = false;
        final Session session = HibernateFactory.getInstance().openSession();
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

    /**
     *
     * @param items
     * @return
     */
    @Override
    public int add(Items items) {
        final Session session = HibernateFactory.getInstance().openSession();
        Transaction tr = session.beginTransaction();
        try {
            session.save(items);
            return items.getId();
        } finally {
            tr.commit();
            session.close();
        }
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Items get(int id) {
        final Session session = HibernateFactory.getInstance().openSession();
        Transaction tr = session.beginTransaction();
        try {
            return (Items) session.get(Items.class, id);
        } finally {
            tr.commit();
            session.close();
        }

    }

    /**
     *
     * @return
     */
    @Override
    public List<Items> getAll() {
        List items;
        final Session session = HibernateFactory.getInstance().openSession();
        Transaction tr = session.beginTransaction();
        try {
            items =  session.createQuery("from ru.napadovskiu.models.Items").list();
        } finally {
            tr.commit();
            session.close();
        }
        return items;
    }

    /**
     *
     */
    @Override
    public void close() {
        HibernateFactory.getInstance().close();
    }


}

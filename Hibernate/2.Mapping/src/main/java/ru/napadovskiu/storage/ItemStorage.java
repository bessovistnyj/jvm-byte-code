package ru.napadovskiu.storage;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.napadovskiu.entities.Item;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class ItemStorage implements Storage<Item> {


    /**
     *
     */
    private static final ItemStorage INSTANCE = new ItemStorage();


    /**
     *
     */
    public ItemStorage() {
    }

    /**
     *
     * @return
     */
    public static ItemStorage getInstance() {
        return INSTANCE;
    }



    private <T> T tx(final Function<Session, T> command) {
        final Session session = HibernateFactory.getInstance().openSession();
        final Transaction tx = session.beginTransaction();
        try {
            return command.apply(session);
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            tx.commit();
            session.close();
        }
    }

    /**
     *
     * @param item
     * @return
     */
    @Override
    public boolean update(Item item) {
        return this.tx(session -> {
            session.save(item);
            return true;
        });
    }


    /**
     *
     * @param item
     * @return
     */
    @Override
    public boolean delete(Item item) {
        return this.tx(session -> {
            session.delete(item);
            return true;
        });
    }

    /**
     *
     * @param item
     * @return
     */
    @Override
    public int add(Item item) {
        return this.tx(session -> {
            session.save(item);
            return item.getItemId();
        });
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Item get(int id) {
        return this.tx(session -> (Item) session.get(Item.class, id));

    }

    /**
     *
     * @return
     */
    @Override
    public List<Item> getAll() {
        return this.tx(session -> {
            List<Item> list = session.createQuery("from ru.napadovskiu.entities.Item").list();
            return list;
        });

    }


    /**
     *
     */
    public Set<Item> getAllByUser(int user_id) {
        return this.tx (session -> {
            Set<Item> result = new HashSet<>();
            Query query = session.createSQLQuery("from useritems where user_id=:userid");
            query.setParameter("userid",user_id);
            List<Integer> itemIdList = query.getResultList();
            for (Integer id:itemIdList) {
                result.add(this.get(id));
            }
            return result;
        });
    }

    /**
     *
     */
    @Override
    public void close() {
        HibernateFactory.getInstance().close();
    }


}

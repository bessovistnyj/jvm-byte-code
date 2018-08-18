package ru.napadovskiu.storage;


import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.napadovskiu.entities.Car;
import ru.napadovskiu.entities.Transmission;

import java.util.List;
import java.util.function.Function;

/**
 *
 */
public class TransStorage implements Storage<Transmission> {

    /**
     *
     */
    private static final TransStorage INSTANCE = new TransStorage();


    /**
     *
     */
    public TransStorage() {
    }

    /**
     *
     * @return
     */
    public static TransStorage getInstance() {
        return INSTANCE;
    }

    /**
     *
     * @param command
     * @param <T>
     * @return
     */
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
     * @param transmission
     * @return
     */
    @Override
    public boolean update(Transmission transmission) {
        return this.tx(session -> {
            session.save(transmission);
            return true;
        });
    }

    /**
     *
     * @param transmission
     * @return
     */
    @Override
    public boolean delete(Transmission transmission) {
        return this.tx(session -> {
            session.delete(transmission);
            return true;
        });
    }


    /**
     *
     * @param transmission
     * @return
     */
    @Override
    public int add(Transmission transmission) {
        return this.tx(session -> {
            session.save(transmission);
            return transmission.getTransId();
        });
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Transmission get(int id) {
        return this.tx(session -> (Transmission) session.get(Transmission.class, id));

    }

    /**
     *
     * @return
     */
    @Override
    public List<Transmission> getAll() {
        return this.tx(session -> session.createQuery("from ru.napadovskiu.entities.Transmission").list());
    }

    /**
     *
     */
    @Override
    public void close() {
        HibernateFactory.getInstance().close();
    }


}

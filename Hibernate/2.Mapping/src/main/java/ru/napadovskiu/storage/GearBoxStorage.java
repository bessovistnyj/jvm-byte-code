package ru.napadovskiu.storage;


import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.napadovskiu.entities.GearBox;

import java.util.List;
import java.util.function.Function;

/**
 *
 */
public class GearBoxStorage implements Storage<GearBox> {

    /**
     *
     */
    private static final GearBoxStorage INSTANCE = new GearBoxStorage();


    /**
     *
     */
    public GearBoxStorage() {
    }

    /**
     *
     * @return
     */
    public static GearBoxStorage getInstance() {
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
     * @param gearBox
     * @return
     */
    @Override
    public boolean update(GearBox gearBox) {
        return this.tx(session -> {
            session.save(gearBox);
            return true;
        });
    }


    /**
     *
     * @param gearBox
     * @return
     */
    @Override
    public boolean delete(GearBox gearBox) {
        return this.tx(session -> {
            session.delete(gearBox);
            return true;
        });
    }


    /**
     *
     * @param gearBox
     * @return
     */
    @Override
    public int add(GearBox gearBox) {
        return this.tx(session -> {
            session.save(gearBox);
            return gearBox.getGearBoxId();
        });
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public GearBox get(int id) {
        return this.tx(session -> (GearBox) session.get(GearBox.class, id));

    }

    /**
     *
     * @return
     */
    @Override
    public List<GearBox> getAll() {
        return this.tx(session -> session.createQuery("from ru.napadovskiu.entities.GearBox").list());
    }

    /**
     *
     */
    @Override
    public void close() {
        HibernateFactory.getInstance().close();
    }


}

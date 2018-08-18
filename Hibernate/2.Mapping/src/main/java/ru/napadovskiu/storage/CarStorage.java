package ru.napadovskiu.storage;


import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.napadovskiu.entities.Car;


import java.util.List;
import java.util.function.Function;

/**
 *
 */
public class CarStorage implements Storage<Car> {

    /**
     *
     */
    private static final CarStorage INSTANCE = new CarStorage();


    /**
     *
     */
    public CarStorage() {
    }

    /**
     *
     * @return
     */
    public static CarStorage getInstance() {
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
     * @param car
     * @return
     */
    @Override
    public boolean update(Car car) {
        return this.tx(session -> {
            session.save(car);
            return true;
        });
    }


    /**
     *
     * @param car
     * @return
     */
    @Override
    public boolean delete(Car car) {
        return this.tx(session -> {
            session.delete(car);
            return true;
        });
    }

    /**
     *
     * @param car
     * @return
     */
    @Override
    public int add(Car car) {
        return this.tx(session -> {
            session.save(car);
            return car.getCarId();
        });
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Car get(int id) {
        return this.tx(session -> (Car) session.get(Car.class, id));

    }

    /**
     *
     * @return
     */
    @Override
    public List<Car> getAll() {
        return this.tx(session -> session.createQuery("from ru.napadovskiu.entities.Car").list());
    }

    /**
     *
     */
    @Override
    public void close() {
        HibernateFactory.getInstance().close();
    }


}

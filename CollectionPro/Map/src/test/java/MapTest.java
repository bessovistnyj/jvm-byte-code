import org.junit.Test;
import ru.napadovskiuB.User;
import ru.napadovskiuB.UserEquals;
import ru.napadovskiuB.UserEqualsHashCode;
import ru.napadovskiuB.UserHashCode;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 *
 * @author Napadovskiy Bohdan
 * @version 1.0
 * @since 17.07.2017
 */
public class MapTest {

    /**
     *
     */
    @Test
    public void whenHashCodeAndEqualsNotOverride() {
        Calendar birthDate = new GregorianCalendar(1990,8,15);

        User firstUser = new User("Иван", birthDate);

        User secondUser = new User("Иван", birthDate);

        HashMap<User,Object> mapTest = new HashMap<User,Object>();

        mapTest.put(firstUser,firstUser);
        mapTest.put(secondUser,secondUser);

        System.out.println(mapTest+" "+mapTest.keySet());

    }

    /**
     *
     */
    @Test
    public void whenHashCodeOverrideButEqualsNotOverride () {
        Calendar birthDate = new GregorianCalendar(1990,8,15);

        UserHashCode firstUser = new UserHashCode("Иван", birthDate);

        UserHashCode secondUser = new UserHashCode("Иван", birthDate);

        HashMap<User,Object> mapTest = new HashMap<User,Object>();

        mapTest.put(firstUser,firstUser);
        mapTest.put(secondUser,secondUser);

        System.out.println(mapTest+" "+mapTest.keySet());


    }

    /**
     *
     */
    @Test
    public void whenEqualsOverrideButHashCodeNotOverride () {
        Calendar birthDate = new GregorianCalendar(1990,8,15);

        UserEquals firstUser = new UserEquals("Иван", birthDate);

        UserEquals secondUser = new UserEquals("Иван", birthDate);

        HashMap<User,Object> mapTest = new HashMap<User,Object>();

        mapTest.put(firstUser,firstUser);
        mapTest.put(secondUser,secondUser);

        System.out.println(mapTest+" "+mapTest.keySet());

    }

    /**
     *
     */
    @Test
    public void whenEqualsAndHashCodeOverride () {
        Calendar birthDate = new GregorianCalendar(1990,8,15);

        UserEqualsHashCode firstUser = new UserEqualsHashCode("Иван", birthDate);

        UserEqualsHashCode secondUser = new UserEqualsHashCode("Иван", birthDate);

        HashMap<User,Object> mapTest = new HashMap<User,Object>();

        mapTest.put(firstUser,firstUser);
        mapTest.put(secondUser,secondUser);

        System.out.println(mapTest+" "+mapTest.keySet());

    }

}

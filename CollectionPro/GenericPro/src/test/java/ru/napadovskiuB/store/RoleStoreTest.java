package ru.napadovskiuB.store;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Package of CollectionPro testTask.
 *
 * @author Napadovskiy Bohdan
 * @version 1.0
 * @since 04.07.2017
 **/
public class RoleStoreTest {

    /**
     *
     */
    @Test
    public void whenAddNewElementThenReturnValue() {
        final int arraySize = 3;
        Role role1 = new Role();
        role1.setId("58697");
        Role role2 = new Role();
        role2.setId("3598");
        RoleStore<Role> roleStore = new RoleStore<Role>(arraySize);
        roleStore.add(role1);
        roleStore.add(role2);

        Base returnValue = roleStore.get(0);
        assertThat(returnValue.getId(), is("58697"));

    }

    /**
     *
     */
    @Test
    public void whenUpdateElementThenReturnNewValue() {
        final int arraySize = 3;
        Role role1 = new Role();
        role1.setId("89752");
        Role role2 = new Role();
        role2.setId("56987");
        RoleStore<Role> roleStore = new RoleStore<Role>(arraySize);
        roleStore.add(role1);

        roleStore.update(0, role2);

        Base returnValue = roleStore.get(0);
        assertThat(returnValue.getId(), is("56987"));

    }

    /**
     *
     */
    @Test(expected = NullPointerException.class)
    public void whenDeleteElementThenReturnNewNull() {
        final int arraySize = 3;
        Role role1 = new Role();
        role1.setId("89752");
        Role role2 = new Role();
        role2.setId("56987");
        RoleStore<Role> roleStore = new RoleStore<Role>(arraySize);
        roleStore.add(role1);

        roleStore.delete(role1);

        Base returnValue = roleStore.get(0);

    }


}
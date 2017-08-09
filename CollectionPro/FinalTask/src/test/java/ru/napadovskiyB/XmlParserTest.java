package ru.napadovskiyB;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;


/**
 *
 */
public class XmlParserTest {
    /**
     *
     */
    Order firstOrder = new Order(true, 50.0, 70, 1);

    /**
     *
     */
    Order secondOrder = new Order(false, 25.0, 40, 2);

    /**
     *
     */
    Order thirdOrder = new Order(false, 40.0, 80, 3);

    Order thortOrder = new Order(true, 35.0,30,4);

    OrderBook orderBook = new OrderBook();

    /**
     *
     */
    @Test
    public void whenAddOrderThenReturnMapSize() {

        this.orderBook.addOrder(this.firstOrder);
        this.orderBook.addOrder(this.secondOrder);
        this.orderBook.addOrder(this.thirdOrder);
        assertThat(this.orderBook.getUnsortedMap().size(), is(3));
    }

    @Test
    public void whenDeleteOrderThenReturnSize() {
        this.orderBook.addOrder(this.firstOrder);
        this.orderBook.addOrder(this.secondOrder);
        this.orderBook.addOrder(this.thirdOrder);
        this.orderBook.deleteOrder(this.secondOrder.getIdOrder());
        assertThat(this.orderBook.getUnsortedMap().size(), is(2));
    }

    @Test
    public void testCheckElement() {
        this.orderBook.addOrder(this.firstOrder);
        this.orderBook.addOrder(this.secondOrder);
        this.orderBook.addOrder(this.thirdOrder);
        this.orderBook.checkElement();
        int a =1;
    }



}
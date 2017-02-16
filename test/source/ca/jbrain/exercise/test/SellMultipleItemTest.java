package ca.jbrain.exercise.test;

import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

/**
 * Created by enricooliva on 15/02/2017.
 */
public class SellMultipleItemTest {

    @Test
    public void zeroItemTest() throws Exception {

        Display display = new Display();
        Sale sale = new Sale(display, null);
        sale.onTotal();
        assertEquals("No sell in process. Try scanning a product.", display.getText());

    }

    @Test
    public void oneItemFound() throws Exception {
        Catalog catalog = new Catalog(Collections.singletonMap("12345","$6.5"));
        Display display = new Display();
        Sale sale = new Sale(display, catalog);

        sale.onBarCode("12345");

        sale.onTotal();

        assertEquals("Total: $6.5",display.getText());

    }
}

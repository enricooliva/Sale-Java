package ca.jbrain.exercise.test;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;

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
        Catalog catalog = new Catalog(Collections.singletonMap("12345","$6.50"),
                Collections.singletonMap("12345", 650));
        Display display = new Display();
        Sale sale = new Sale(display, catalog);

        sale.onBarCode("12345");

        sale.onTotal();

        assertEquals("Total: $6.50",display.getText());
    }

    @Test
    public void oneItemNotFound() throws Exception {
        Catalog catalog = new Catalog(Collections.singletonMap("12345","$6.50"), Collections.singletonMap("12345",650));
        Display display = new Display();
        Sale sale = new Sale(display, catalog);

        sale.onBarCode("99999");

        sale.onTotal();

        assertEquals("No sell in process. Try scanning a product.",
                display.getText());
    }

    @Test
    public void severalItemNotFound() throws Exception {

        Display display = new Display();
        Sale sale = new Sale(display, catalogWithoutBarcodes(
                "product you won't find",
                "another product you won't find" ));

        sale.onBarCode("product you won't find");
        sale.onBarCode("another product you won't find");

    }

    private Catalog catalogWithoutBarcodes(String barCode, String barCode1) {
        return new Catalog(Collections.emptyMap(),Collections.emptyMap());
    }


        @Ignore
    public void severItemFound() throws Exception {
        Catalog catalog = new Catalog(new HashMap<String, Integer>(){{
            put("1", 850);
            put("2", 1275);
            put("3", 330);
        }});
        Display display = new Display();
        Sale sale = new Sale(display, catalog);

        sale.onBarCode("1");
        sale.onBarCode("2");
        sale.onBarCode("3");

        sale.onTotal();

        assertEquals("Total: $24.55", display.getText());

    }
}

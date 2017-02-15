package ca.jbrain.exercise.test;


import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by enricooliva on 13/02/2017.
 */
public class SellOneItemTest {
    private Display display;
    private Sale sale;

    @Before
    public void setUp(){
        display = new Display();
        sale = new Sale(display, new Catalog(new HashMap<String, String>() {{
            put("12345", "$7.95");
            put("232324", "$8.15");
        }}));
    }

    @Test
    public void productFound() throws Exception {
        sale.onBarCode("12345");
        assertEquals("$7.95", display.getText());
    }

    @Test
    public void anotherProductFound() throws Exception {
        sale.onBarCode("232324");
        assertEquals("$8.15", display.getText());
    }

    @Test
    public void productNotFound() throws Exception {
        sale.onBarCode("99999");
        assertEquals("Product not found 99999",display.getText());
    }

    @Test
    public void emptyBarCode() throws Exception {
        final Sale sale = new Sale(display, new Catalog(null));
        sale.onBarCode("");
        assertEquals("Scanning error: empty barcode", display.getText());
    }

}



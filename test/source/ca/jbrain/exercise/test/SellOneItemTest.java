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

    public static class Display{

        private String text;

        public String getText() {
            return text;
        }

        private void setText(String text) {
            this.text = text;
        }

        public void displayProductNotFoudMessage(String barCode) {
            setText("Product not found " +
                    barCode);
        }

        public void displayEmptyProductMessage() {
            setText("Scanning error: empty barcode");
        }

        public void displayPrice(String text, Sale sale) {
            setText(text);
        }
    }

    public static class Sale {

        private final Catalog catalog;
        private Display display;

        public Sale(Display display, Catalog catalog) {
            this.display = display;
            this.catalog = catalog;
        }

        public void onBarCode(String barCode) {
            if (barCode.isEmpty()){
                display.displayEmptyProductMessage();
                return;
            }

            final String priceAsText = catalog.findPrice(barCode);
            if (priceAsText==null) {
                display.displayProductNotFoudMessage(barCode);
            } else {
                display.displayPrice(priceAsText, this);
            }
        }

    }

}



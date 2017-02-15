package ca.jbrain.exercise.test;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Stream;

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
        sale = new Sale(display,new HashMap<String,String>(){{
            put("12345","$7.95");
            put("232324","$8.15");
        }});
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
        final Sale sale = new Sale(display, null);
        sale.onBarCode("");
        assertEquals("Scanning error: empty barcode", display.getText());
    }

    public static class Display{

        private String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    public static class Sale {

        private Display display;
        private Map<String, String> pricesByBarCode;

        public Sale(Display display, Map<String,String> pricesByBarCode) {
            this.display = display;
            this.pricesByBarCode = pricesByBarCode;
        }

        public void onBarCode(String barCode) {
            if (barCode.isEmpty()){
                displayEmptyProductMessage();
                return;
            }

            if (pricesByBarCode.containsKey(barCode)) {
                displayPrice(findPrice(barCode));
            } else {
                displayProductNotFoudMessage(barCode);
            }

        }

        private String findPrice(String barCode) {
            return pricesByBarCode.get(barCode);
        }

        private void displayPrice(String text) {
            display.setText(text);
        }

        private void displayProductNotFoudMessage(String barCode) {
            display.setText("Product not found " +
                    barCode);
        }

        private void displayEmptyProductMessage() {
            display.setText("Scanning error: empty barcode");
        }

    }

}



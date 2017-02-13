package ca.jbrain.exercise.test;


import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.StringJoiner;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * Created by enricooliva on 13/02/2017.
 */
public class SellOneItemTest {
    @Test
    public void productFound() throws Exception {
        final Display display = new Display();
        final Sale sale = new Sale(display);

        sale.onBarCode("12345");

        assertEquals("$7.95", display.getText());

    }

    @Test
    public void anotherProductFound() throws Exception {

        final Display display = new Display();
        final Sale sale = new Sale(display);

        sale.onBarCode("232324");

        assertEquals("$8.15", display.getText());

    }

    @Test
    public void productNotFound() throws Exception {

        final Display display = new Display();
        final Sale sale = new Sale(display);

        sale.onBarCode("99999");

        assertEquals("Product not found 99999",display.getText());
    }

    @Test
    public void emptyBarCode() throws Exception {

        final Display display = new Display();
        final Sale sale = new Sale(display);

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

        public Sale(Display display) {
            this.display = display;
        }

        public void onBarCode(String barCode) {
            if (barCode.isEmpty()){
                display.setText("Scanning error: empty barcode");
            }else {
                //introduce lookup table
                HashMap<String,String> pricesByBarCode = new HashMap<String,String>(){{
                    put("12345","$7.95");
                    put("232324","$8.15");
                }};

                if (pricesByBarCode.containsKey(barCode)) {
                    display.setText(pricesByBarCode.get(barCode));
                } else {
                    display.setText("Product not found " +
                            barCode);
                }
            }
        }

    }

}



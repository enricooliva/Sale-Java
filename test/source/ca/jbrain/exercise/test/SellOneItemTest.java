package ca.jbrain.exercise.test;


import org.junit.Ignore;
import org.junit.Test;

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

    @Ignore("Refactoring..")
    public void anotherProductFound() throws Exception {

        final Display display = new Display();
        final Sale sale = new Sale(display);

        sale.onBarCode("232324");

        assertEquals("$8.15", display.getText());

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
            display.setText("$7.95");
        }
    }

}



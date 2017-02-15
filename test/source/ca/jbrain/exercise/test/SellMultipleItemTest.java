package ca.jbrain.exercise.test;

import org.junit.Test;

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
}

package ca.jbrain.exercise.test;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by enricooliva on 18/02/2017.
 */
public class ComputePurchaseTotalTest {

    @Test
    public void zeroItems() throws Exception {
        Assert.assertEquals(0,
                computePurchseTotal(Collections.<Integer>emptyList()));

    }

    @Test
    public void oneItem() throws Exception {
        Assert.assertEquals(795,
                computePurchseTotal(Collections.singletonList(795)));
    }

    @Test
    public void name() throws Exception {
        Assert.assertEquals(2450,
                computePurchseTotal(Arrays.asList(850,1275,325)));
    }

    private int computePurchseTotal(List<Integer> purchseItemPrices) {
        return Sale.computePurchaseTotal(purchseItemPrices).intValue();
    }


}

package ca.jbrain.exercise.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * Created by enricooliva on 15/02/2017.
 */
public class Sale {

    private final Catalog catalog;
    private Display display;
    private String scannedPrice;

    public Sale(Display display, Catalog catalog) {
        this.display = display;
        this.catalog = catalog;
    }


    public void onBarCode(String barCode) {
        if (barCode.isEmpty()) {
            display.displayEmptyProductMessage();
            return;
        }

        scannedPrice = catalog.findPrice(barCode);
        if (scannedPrice == null) {
            display.displayProductNotFoudMessage(barCode);
        } else {
            display.displayPrice(formatMonetaryAmount(scannedPrice));
        }
    }

    private String formatMonetaryAmount(String scannedPrice) {
        return  scannedPrice;
    }

    private Integer parsePrinceInCents(String scannedPrice) {
        return 0;
    }

    public void onTotal() {
        boolean saleInProgress = scannedPrice != null;
        if (saleInProgress) {
            display.displayTotalPrice(scannedPrice);
        } else {
            display.displayNoSellInProcessMessage();
        }
    }

}

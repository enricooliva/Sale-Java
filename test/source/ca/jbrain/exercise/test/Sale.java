package ca.jbrain.exercise.test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by enricooliva on 15/02/2017.
 */
public class Sale {

    private final Catalog catalog;
    private Display display;
    private String scannedPrice;
    private Collection<Integer> pendingPurchaseItemPrices = new ArrayList<Integer>();

    public Sale(Display display, Catalog catalog) {
        this.display = display;
        this.catalog = catalog;
    }


    public void onBarCode(String barCode) {
        if (barCode.isEmpty()) {
            display.displayEmptyProductMessage();
            return;
        }

        Integer princeInCents = catalog.findPrice(barCode);
        if (princeInCents == null) {
            display.displayProductNotFoudMessage(barCode);
        } else {
            pendingPurchaseItemPrices.add(princeInCents);
            display.displayPrice(princeInCents);
        }
    }

    private String formatMonetaryAmount(String scannedPrice) {
        return  scannedPrice;
    }

    private Integer parsePrinceInCents(String scannedPrice) {
        return 0;
    }

    public void onTotal() {
        if (pendingPurchaseItemPrices.isEmpty()) {
            display.displayNoSellInProcessMessage();
        } else {
            display.displayPurchaseTotal(Display.format(pendingPurchaseTotal()));
        }
    }

    private Integer pendingPurchaseTotal() {
        return pendingPurchaseItemPrices.iterator().next();
    }

}

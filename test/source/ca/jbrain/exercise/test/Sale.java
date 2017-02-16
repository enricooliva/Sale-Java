package ca.jbrain.exercise.test;

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
            display.displayPrice(scannedPrice, this);
        }
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

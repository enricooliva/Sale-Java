package ca.jbrain.exercise.test;

/**
 * Created by enricooliva on 15/02/2017.
 */
public class Sale {

    private final Catalog catalog;
    private Display display;

    public Sale(Display display, Catalog catalog) {
        this.display = display;
        this.catalog = catalog;
    }

    public void onBarCode(String barCode) {
        if (barCode.isEmpty()) {
            display.displayEmptyProductMessage();
            return;
        }

        final String priceAsText = catalog.findPrice(barCode);
        if (priceAsText == null) {
            display.displayProductNotFoudMessage(barCode);
        } else {
            display.displayPrice(priceAsText, this);
        }
    }

    public void onTotal() {
        display.displayNoSellInProcessMessage(this);
    }

}

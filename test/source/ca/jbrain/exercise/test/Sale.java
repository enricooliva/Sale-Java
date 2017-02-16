package ca.jbrain.exercise.test;

/**
 * Created by enricooliva on 15/02/2017.
 */
public class Sale {

    private final Catalog catalog;
    private Display display;
    private String price;

    public Sale(Display display, Catalog catalog) {
        this.display = display;
        this.catalog = catalog;
    }

    public void onBarCode(String barCode) {
        if (barCode.isEmpty()) {
            display.displayEmptyProductMessage();
            return;
        }

        price = catalog.findPrice(barCode);
        if (price == null) {
            display.displayProductNotFoudMessage(barCode);
        } else {
            display.displayPrice(price, this);
        }
    }

    public void onTotal() {
        if (price == null)
        display.displayNoSellInProcessMessage();
        else
            display.displayTotalPrice(price);
    }

}

package ca.jbrain.exercise.test;

/**
 * Created by enricooliva on 15/02/2017.
 */
public class Display {

    private String text;

    public String getText() {
        return text;
    }

    private void setText(String text) {
        this.text = text;
    }

    public void displayProductNotFoudMessage(String barCode) {
        setText("Product not found " +
                barCode);
    }

    public void displayEmptyProductMessage() {
        setText("Scanning error: empty barcode");
    }

    public void displayText(String text) {
        setText(text);
    }

    public void displayNoSellInProcessMessage() {
        text = "No sell in process. Try scanning a product.";
    }

    void displayPurchaseTotal(String price) {
        text = "Total: "+ price;
    }

    public static String format(int priceInCents) {
        return String.format("$%,.2f", priceInCents / 100.0d);
    }

    public void displayPrice(int priceInCents) {
        this.setText(format(priceInCents));
    }
}

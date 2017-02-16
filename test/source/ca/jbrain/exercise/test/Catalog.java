package ca.jbrain.exercise.test;

import java.util.Map;

public class Catalog {
    private final Map<String, String> pricesByBarCodeAsText;
    private final Map<String, Integer> pricesByBarCodeAsCents;


    public Catalog(Map<String, String> pricesByBarCodeAsText, Map<String, Integer> pricesByBarCodeAsCents) {
        this.pricesByBarCodeAsText =pricesByBarCodeAsText;
        this.pricesByBarCodeAsCents = pricesByBarCodeAsCents;
    }

    public Map<String, String> getPricesByBarCodeAsText() {
        return pricesByBarCodeAsText;
    }

    public String findPrice(String barCode) {
        return pricesByBarCodeAsText.get(barCode);
    }
}

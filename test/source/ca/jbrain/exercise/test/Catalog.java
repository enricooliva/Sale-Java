package ca.jbrain.exercise.test;

import java.util.HashMap;
import java.util.Map;

public class Catalog {
    private final Map<String, String> pricesByBarCode;
    private final Map<String, Integer> pricesByBarCodeAsCents;

    @Deprecated
    public Catalog(Map<String, String> pricesByBarCode) {
        this.pricesByBarCode = pricesByBarCode;
        this.pricesByBarCodeAsCents=null;
    }

    public Catalog(Map<String, String> pricesByBarCodeAsText, Map<String, Integer> pricesByBarCodeAsCents) {
        this.pricesByBarCode=pricesByBarCodeAsText;
        this.pricesByBarCodeAsCents = pricesByBarCodeAsCents;
    }

    public Map<String, String> getPricesByBarCode() {
        return pricesByBarCode;
    }

    public String findPrice(String barCode) {
        return pricesByBarCode.get(barCode);
    }
}

package ca.jbrain.exercise.test;

import java.util.Map;

public class Catalog {
    private final Map<String, String> pricesByBarCode;

    public Catalog(Map<String, String> pricesByBarCode) {
        this.pricesByBarCode = pricesByBarCode;
    }

    public Map<String, String> getPricesByBarCode() {
        return pricesByBarCode;
    }

    public String findPrice(String barCode) {
        return pricesByBarCode.get(barCode);
    }
}

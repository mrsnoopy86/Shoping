package ua.kh.tremtyachiy.shoping.util;

/**
 * Created by Admin on 10.06.2015.
 */
public class ProductContent {
    private String product;
    private String unitOfMeasure;
    private int value;

    public ProductContent(String product, String unitOfMeasure, int value) {
        this.product = product;
        this.unitOfMeasure = unitOfMeasure;
        this.value = value;
    }

    public String getProduct() {
        return product;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public int getValue() {
        return value;
    }
}

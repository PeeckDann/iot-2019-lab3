package ua.lviv.iot.seafood.model;

public class Seafood {

    protected int priceInGryvnias;

    protected String producer;

    protected String speciesOfProduct;

    protected ConditionOfProduct conditionOfProduct;

    protected Integer seafoodId;

    private String headers = "priceInGryvnias, producer, speciesOfProduct, conditionOfProduct";

    public Seafood() {
        this(25, "Company", "Fish", ConditionOfProduct.FROSEN);
    }
    
    public Seafood(int priceInGryvnias, String producer, String speciesOfProduct,
            ConditionOfProduct conditionOfProduct) {
        this.priceInGryvnias = priceInGryvnias;
        this.producer = producer;
        this.speciesOfProduct = speciesOfProduct;
        this.conditionOfProduct = conditionOfProduct;
    }

    public Integer getId() {
        return seafoodId;
    }

    public void setId(Integer id) {
        this.seafoodId = id;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getPriceInGryvnias() {
        return priceInGryvnias;
    }

    public void setPriceInGryvnias(int priceInGryvnias) {
        this.priceInGryvnias = priceInGryvnias;
    }

    public String getSpeciesOfProduct() {
        return speciesOfProduct;
    }

    public void setSpeciesOfProduct(String speciesOfProduct) {
        this.speciesOfProduct = speciesOfProduct;
    }

    public ConditionOfProduct getConditionOfProduct() {
        return conditionOfProduct;
    }

    public void setConditionOfProduct(ConditionOfProduct conditionOfProduct) {
        this.conditionOfProduct = conditionOfProduct;
    }

    public String getHeaders() {
        return headers;
    }

    public String toCSV() {
        return "priceInGryvnias: " + getPriceInGryvnias() + ", producer: " + getProducer() + ", speciesOfProduct: "
                + getSpeciesOfProduct() + ", conditionOfProduct: " + getConditionOfProduct();
    }
}
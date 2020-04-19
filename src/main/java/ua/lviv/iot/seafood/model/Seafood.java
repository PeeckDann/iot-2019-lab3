package ua.lviv.iot.seafood.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Seafood {

    @Column(name = "price_in_uah")
    protected int priceInGryvnias;

    protected String producer;

    protected String speciesOfProduct;

    @Enumerated(EnumType.STRING)
    protected ConditionOfProduct conditionOfProduct;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
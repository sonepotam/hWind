package ru.pavel2107.hwind.dto;

import ru.pavel2107.hwind.model.PRODUCT_TYPE;
import ru.pavel2107.hwind.model.Product;

/**
 * Created by admin on 29.03.2016.
 */
public class ProductDTO {

    private Integer Id;
    private PRODUCT_TYPE productType;
    private Boolean spice;

    private String lang;
    private String productName;


    private ProductDTO(){}

    public static ProductDTO convertProductToProductDTO(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId( product.getID());
        productDTO.setSpice( product.getSpice());
        productDTO.setProductType( product.getProductType());

        //TODO : проставить название и язык в ProductDTO

        return productDTO;
    }


    public static Product convertProductDTOToProduct( ProductDTO productDTO){
        Product product = new Product();
        product.setID( product.getID());
        product.setSpice( product.getSpice());
        product.setProductType( product.getProductType());

        //TODO: обновить список названий

        return product;
    }


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public PRODUCT_TYPE getProductType() {
        return productType;
    }

    public void setProductType(PRODUCT_TYPE productType) {
        this.productType = productType;
    }

    public Boolean getSpice() {
        return spice;
    }

    public void setSpice(Boolean spice) {
        this.spice = spice;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}

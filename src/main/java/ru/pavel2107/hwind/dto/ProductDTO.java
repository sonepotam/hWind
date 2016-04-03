package ru.pavel2107.hwind.dto;

import ru.pavel2107.hwind.model.PRODUCT_TYPE;
import ru.pavel2107.hwind.model.Product;
import ru.pavel2107.hwind.model.ProductName;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    public static ProductDTO convertProductToProductDTO(Product product, String lang){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId( product.getID());
        productDTO.setSpice( product.getSpice());
        productDTO.setProductType( product.getProductType());

        Optional<ProductName>  name =       product.getProductNames()
                             .stream()
                             .filter( p ->( lang.equals( p.getLanguage())))
                             .findFirst();
        if( name.isPresent()) {
            productDTO.lang = name.get().getLanguage();
            productDTO.productName = name.get().getProductName();
        }

        return productDTO;
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

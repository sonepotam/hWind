package ru.pavel2107.hwind.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by admin on 29.03.2016
 *
 */
@Entity
@Table( name = "products")
public class Product {

    @Id
    @SequenceGenerator( name="prod_id_gen", sequenceName = "products_seq", allocationSize = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "prod_id_gen")
    private Integer ID;

    @Column( name="pr_type", nullable = false)
    private PRODUCT_TYPE productType;

    @Column( name = "spice")
    private Boolean spice;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    //public Set<ProductName> getProductNames(){ return productNames;};
    //public void setProductNames( Set<ProductName> productNames){ this.productNames = productNames; }
    private Set<ProductName> productNames;



    public Boolean getSpice() {
        return spice;
    }

    public void setSpice(Boolean spice) {
        this.spice = spice;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public PRODUCT_TYPE getProductType() {
        return productType;
    }

    public void setProductType(PRODUCT_TYPE productType) {
        this.productType = productType;
    }

    public Product() {}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!ID.equals(product.ID)) return false;
        if (productType != product.productType) return false;
        return spice.equals(product.spice);

    }

    @Override
    public int hashCode() {
        int result = ID.hashCode();
        result = 31 * result + productType.hashCode();
        result = 31 * result + spice.hashCode();
        return result;
    }
}

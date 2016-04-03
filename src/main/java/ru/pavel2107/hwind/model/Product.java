package ru.pavel2107.hwind.model;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by admin on 29.03.2016
 * http://www.codejava.net/frameworks/hibernate/hibernate-basics-3-ways-to-delete-an-entity-from-the-datastore
 * http://www.concretepage.com/hibernate/elementcollection_hibernate_annotation
 * http://www.dineshonjava.com/p/configuring-collections-and-adding-keys.html#.Vv-KEl5RW5A
 *
 *
 */
@Entity
@Table( name = "products")
public class Product {

    @Id
    // postgres
    //@SequenceGenerator( name="prod_id_gen", sequenceName = "products_seq", allocationSize = 1)
    //@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "prod_id_gen")
    //mysql
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer ID;

    @Column( name="pr_type", nullable = false)
    private PRODUCT_TYPE productType;

    @Column( name = "spice")
    private Boolean spice;

    @ElementCollection( fetch = FetchType.EAGER)
    @JoinTable(
            name = "names",
            joinColumns = @JoinColumn( name = "product_id")  )
    private Collection<ProductName> name = new ArrayList<>();

    public Collection<ProductName> getProductNames(){ return name;};
    public void setProductNames( Collection<ProductName> productNames){ this.name = productNames; }


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

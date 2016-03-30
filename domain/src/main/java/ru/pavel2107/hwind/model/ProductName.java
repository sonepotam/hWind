package ru.pavel2107.hwind.model;

import javax.persistence.*;

/**
 * Created by admin on 29.03.2016.
 *
 */

@Entity
@Table( name = "names")
public class ProductName {

    @Id
    @SequenceGenerator( name ="gen_names_id", sequenceName = "names_seq", allocationSize = 10)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "gen_names_id")
    private Integer ID;

    @Column( name = "lang", nullable = false)
    private String language;


    @Column( name ="name", nullable = false)
    private  String productName;


    @ManyToOne
    //@JoinColumn( name = "product")
    //public Product getProduct(){ return product;}
    //public void setProduct( Product product){ this.product = product;}
    //@JoinTable( name="product", joinColumns = )
    private Product product;


    public ProductName() {}


    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductName that = (ProductName) o;

        if (!ID.equals(that.ID)) return false;
        if (!language.equals(that.language)) return false;
        return productName.equals(that.productName);

    }

    @Override
    public int hashCode() {
        int result = ID.hashCode();
        result = 31 * result + language.hashCode();
        result = 31 * result + productName.hashCode();
        return result;
    }


    @Override
    public String toString() {
        return "ProductName{" +
                "ID=" + ID +
                ", language='" + language + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }
}

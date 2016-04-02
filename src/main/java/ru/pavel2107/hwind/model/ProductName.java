package ru.pavel2107.hwind.model;

import javax.persistence.*;

/**
 * Created by admin on 29.03.2016.
 *
 * @JoinTable(name="USER_ADDRESS",
joinColumns=@JoinColumn(name="USER_ID"))
 @GenericGenerator(strategy="hilo", name = "hilo-gen")
 @CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "hilo-gen", type = @Type(type="long"))
 */

//@Entity
@Table( name = "names")
@Embeddable
public class ProductName {

    //@Id
    //@SequenceGenerator( name ="gen_names_id", sequenceName = "names_seq", allocationSize = 10)
    //@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "gen_names_id")
    //@Column( name="ID")
    //private Integer ID;

    @Column( name = "lang", nullable = false)
    private String language;


    @Column( name ="name", nullable = false)
    private  String productName;


   // @ManyToOne
   // @JoinColumn( name = "product")
   // private Product product;


    public ProductName() {}

    public ProductName( String lang, String productName) {
        this.language = lang;
        this.productName = productName;
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
        if (!language.equals(that.language)) return false;
        return productName.equals(that.productName);

    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        return result;
    }
}

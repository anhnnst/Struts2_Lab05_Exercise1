package edu.poly.shop.domain;

import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Validations(requiredStrings = {
        @RequiredStringValidator(fieldName = "name", key = "product.required.name")
},
intRangeFields = {
        @IntRangeFieldValidator(fieldName = "quantity", key = "product.range.quantity", min = "0", max = "50000")
})
@NamedEntityGraph(name = "productGraph", attributeNodes = {
        @NamedAttributeNode("category")})
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "unit_price", nullable = false)
    private float unitPrice;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "description", nullable = true, length = 500)
    private String description;

    @ManyToOne(cascade = {CascadeType.REFRESH})
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Transient
    public void setCategoryId(String id){
        this.category = new Category();
        this.category.setId(Long.parseLong(id));
    }
    @Transient
    public Long getCategoryId(){
        if (this.category != null) {
            System.out.println("CID: " + this.category.getId());
            return this.category.getId();
        }
        return 0l;
    }
}

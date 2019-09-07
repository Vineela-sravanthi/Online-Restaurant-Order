package org.launchcode.Online.restaurant.order.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Menu {

    @Id
    @GeneratedValue
    private int itemId;

    @NotNull
    @Size(min=3, max=25)
    private String itemName;

    @NotNull
    @Size(min=1, message = "Description must not be empty")
    private String itemDescription;

    private double price;

    @ManyToOne
    private Category category;

    public Menu(String itemName, String itemDescription, double price) {

        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.price = price;
    }

    public Menu() {

    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getItemId() {
        return itemId;
    }
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
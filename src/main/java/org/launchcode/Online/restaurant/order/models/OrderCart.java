package org.launchcode.Online.restaurant.order.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class OrderCart {

    @Id
    @GeneratedValue
    private int Id;

    @NotNull
    @Size(min = 3, max =15)
    private String itemName;

    @NotNull
    private int quantity;

    public OrderCart(String itemName, int quantity) {

        this.itemName = itemName;
        this.quantity = quantity;
    }

    public OrderCart() {

    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

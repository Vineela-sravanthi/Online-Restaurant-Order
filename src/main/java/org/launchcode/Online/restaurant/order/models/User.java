package org.launchcode.Online.restaurant.order.models;

import org.hibernate.validator.constraints.Email;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User  {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=5,max=15)
    private String username;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min=6,message="password must contain atleast 6 characters")
    private String password;

    public User(){

    }

   /* public User(){
        this.username = "";
        this.email = "";
        this.password = "";
    } */

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


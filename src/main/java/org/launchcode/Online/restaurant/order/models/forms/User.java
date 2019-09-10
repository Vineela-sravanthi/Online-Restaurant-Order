package org.launchcode.Online.restaurant.order.models.forms;

import org.hibernate.validator.constraints.Email;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User  {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(min=5,max=15)
    private String name;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min=6,message="password must contain atleast 6 characters")
    private String password;

    @Transient
    private String verifyPassword;

    @NotNull
    private Boolean active;

    public User(){

    }

   /* public User(){
        this.username = "";
        this.email = "";
        this.password = "";
    } */

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

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
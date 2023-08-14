package org.example.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

//mark class as an Entity
@Entity
//defining class name as Table name
@Table
public class Customer {
    //mark id as primary key
    @Id
    //defining id as column name
    @Column
    private int id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @ManyToMany
    private List<Address> addressList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }
}

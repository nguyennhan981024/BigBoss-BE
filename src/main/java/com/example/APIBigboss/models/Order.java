package com.example.APIBigboss.models;


import com.sun.istack.NotNull;
import java.util.Set;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
public class Order {
    @Id
    // set up primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String code_order;
    private String userName;
    private String phoneNumber;
    private String email;
    private String address;
    private int city;
    private int district;
    private int ward;
    private String note;
    private String option;

    public Order() {
    }

    public Order(int id, String code_order, String userName, String phoneNumber, String email, String address, int city, int district, int ward, String note, String option) {
        this.id = id;
        this.code_order = code_order;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.city = city;
        this.district = district;
        this.ward = ward;
        this.note = note;
        this.option = option;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode_order() {
        return code_order;
    }

    public void setCode_order(String code_order) {
        this.code_order = code_order;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

    public int getWard() {
        return ward;
    }

    public void setWard(int ward) {
        this.ward = ward;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }
}

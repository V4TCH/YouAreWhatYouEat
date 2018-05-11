package com.vatchproductions.vatch.youarewhatyoueat;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private String foodname;
    private String foodtype;
    private String foodcalcount;
    private String foodweight;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return  email;
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

    public String getFoodName() {
        return foodname;
    }
    public void setFoodName(String foodname) {
        this.foodname = foodname;
    }
    public String getFoodType() {
        return foodtype;
    }
    public void setFoodType(String foodtype) {
        this.foodtype = foodtype;
    }
    public String getFoodCalCount() {
        return foodcalcount;
    }
    public void setFoodCalCount(String foodcalcount) {
        this.foodcalcount = foodcalcount;
    }
    public String getFoodWeight() {
        return foodweight;
    }
    public void setFoodWeight(String foodweight) {
        this.foodweight = foodweight;
    }

}

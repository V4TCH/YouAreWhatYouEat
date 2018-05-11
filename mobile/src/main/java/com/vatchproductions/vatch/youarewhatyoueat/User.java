package com.vatchproductions.vatch.youarewhatyoueat;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private String food_name;
    private String food_type;
    private String food_cal_count;
    private String food_weight;

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
        return food_name;
    }
    public void setFoodName(String food_name) {
        this.food_name = food_name;
    }
    public String getFoodType() {
        return food_type;
    }
    public void setFoodType(String food_type) {
        this.food_type = food_type;
    }
    public String getFoodCalCount() {
        return food_cal_count;
    }
    public void setFoodCalCount(String food_cal_count) {
        this.food_cal_count = food_cal_count;
    }
    public String getFoodWeight() {
        return food_weight;
    }
    public void setFoodWeight(String food_weight) {
        this.food_weight = food_weight;
    }
}

package com.example.pj.foodlistfinalproject;


import java.util.UUID;
/**
 * Created by PJ on 12/6/2016.
 */

public class FoodModel {

    private UUID id;
    private String foodName;
    private String foodLocation;
    private String foodNotes;
    //date

    public FoodModel ()
    {
        this.id = UUID.randomUUID();
        this.setFoodName("");
        this.setFoodNotes("");
        this.setFoodLocation("list");

    }

    public FoodModel(String fName)
    {
        this.id = UUID.randomUUID();
        this.setFoodLocation("list");
        this.setFoodName(fName);
        this.setFoodNotes("");

    }

    public FoodModel(String fName, String fNotes)
    {
        this.id = UUID.randomUUID();
        this.setFoodLocation("list");
        this.setFoodName(fName);
        this.setFoodNotes(fNotes);

    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodLocation() {
        return foodLocation;
    }

    public void setFoodLocation(String foodLocation) {
        this.foodLocation = foodLocation;
    }

    public String getFoodNotes() {
        return foodNotes;
    }

    public void setFoodNotes(String foodNotes) {
        this.foodNotes = foodNotes;
    }

    public UUID getId() {
        return id;
    }


}

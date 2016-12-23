package com.example.pj.foodlistfinalproject;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by PJ on 12/6/2016.
 */
public class FoodCollection {

    private static FoodCollection collection;
    private List<FoodModel> allFoodList;
    private List<FoodModel> listFoodList;
    private List<FoodModel> cartFoodList;
    private List<FoodModel> homeFoodList;





    public static FoodCollection Get()
    {
        if(collection == null)
        {
            collection = new FoodCollection();
        }
        return collection;

    }

    private FoodCollection()
    {
        this.allFoodList = new ArrayList<>();
        this.listFoodList = new ArrayList<>();
        this.cartFoodList = new ArrayList<>();
        this.homeFoodList = new ArrayList<>();
        FoodModel food = new FoodModel("Bacon");
        this.allFoodList.add(food);
        this.listFoodList.add(food);

    }

    public FoodModel getFood(UUID id)
    {
        for (FoodModel food : this.allFoodList)
        {
            if(food.getId().equals(id))
            {
                return food;
            }
        }
        return null;

    }

    public void addToAll(FoodModel food)
    {
        this.allFoodList.add(food);
    }

    public void removeFromAll(FoodModel food)
    {
        this.allFoodList.remove(food);
    }

    public void addToList(FoodModel food)
    {
        this.listFoodList.add(food);
    }

    public void removeFromShop(FoodModel food)
    {
        this.listFoodList.remove(food);
    }

    public void addToCart(FoodModel food)
    {
        this.cartFoodList.add(food);
    }

    public void removeFromCart(FoodModel food)
    {
        this.cartFoodList.remove(food);
    }

    public void removeAllFromCart()
    {
        int j = cartFoodList.size();
        for(int i = 0; i < j ; i++) {
            this.cartFoodList.remove(0);
        }

    }

    public void addToHome(FoodModel food)
    {
        this.homeFoodList.add(food);
    }

    public void addAllToHome(List<FoodModel> foodlist)
    {
        this.homeFoodList.addAll(foodlist);
    }

    public void removeFromHome(FoodModel food)
    {
        this.homeFoodList.remove(food);
    }

    public List<FoodModel> getListFoodList() {
        return listFoodList;
    }

    public List<FoodModel> getCartFoodList() {
        return cartFoodList;
    }

    public List<FoodModel> getHomeFoodList() {
        return homeFoodList;
    }
}

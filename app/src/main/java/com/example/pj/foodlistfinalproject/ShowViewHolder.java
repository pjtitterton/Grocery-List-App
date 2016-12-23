package com.example.pj.foodlistfinalproject;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.pj.foodlistfinalproject.Activity.FoodDetailActivity;


public class ShowViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener

{
    private TextView tv_showFood;
    private static final String EX_FOOD_NAME = "foodName";
    private static final String EX_FOOD_NOTES = "foodNotes";
    private static final String EX_FOOD_ID = "foodId";

    private FoodModel food;
    private Context context;
    private String newFoodName;
    private String newFoodNotes;


    public ShowViewHolder(Context context, TextView foodView)
    {
        super(foodView);
        this.tv_showFood = foodView;
        this.context = context;
        foodView.setOnClickListener(this);
    }


    public void populate(FoodModel food)
    {
        this.food = food;
        this.tv_showFood.setText(food.getFoodName());
    }
    @Override
    public void onClick(View view)
    {
        Intent foodIntent = new Intent(this.context, FoodDetailActivity.class);
        foodIntent.putExtra(EX_FOOD_ID, this.food.getId());
        //foodIntent.putExtra(EX_FOOD_NAME, this.food.getFoodName());
        //foodIntent.putExtra(EX_FOOD_NOTES, this.food.getFoodNotes());
        context.startActivity(foodIntent);
    }



    public void fill(String showEq)
    {
        this.tv_showFood.setText(showEq);
    }



}
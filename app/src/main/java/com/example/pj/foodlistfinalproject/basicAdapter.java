package com.example.pj.foodlistfinalproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import com.example.pj.foodlistfinalproject.FoodModel;
import com.example.pj.foodlistfinalproject.Fragments.ListFragment;
import com.example.pj.foodlistfinalproject.ShowViewHolder;

/**
 * Created by PJ on 12/6/2016.
 */

public class basicAdapter extends RecyclerView.Adapter<ShowViewHolder> //implements View.OnClickListener
{
    private Context context;
    private List<String> foodListNames;
    private List<FoodModel> foodList;
    private FoodModel food;


    public basicAdapter(Context context, List<FoodModel> band)
    {
        this.context = context;
        this.foodList = band;
    }

    @Override
    public ShowViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        TextView view = (TextView) inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ShowViewHolder(context, view);
    }

    @Override
    public void onBindViewHolder(ShowViewHolder holder, int position)
    {
        FoodModel item = this.foodList.get(position);
        holder.populate(item);
    }

    @Override
    public int getItemCount()
    {
        return this.foodList.size();
    }



    public void swap(int firstPosition, int secondPosition)
    {
        Collections.swap(foodList, firstPosition, secondPosition);
        notifyItemMoved(firstPosition,secondPosition);
    }
    public void shift(int position)
    {
        food = foodList.get(position);
        if (food.getFoodLocation() == "list")
        {
            food.setFoodLocation("cart");
            FoodCollection.Get().addToCart(food);
            FoodCollection.Get().removeFromShop(food);
            notifyDataSetChanged();
        }
        else if (food.getFoodLocation() == "cart")
        {
            food.setFoodLocation("home");
            FoodCollection.Get().addToHome(food);
            FoodCollection.Get().removeFromCart(food);
            notifyDataSetChanged();
        }
        else if (food.getFoodLocation() == "home")
        {
            food.setFoodLocation("list");
            FoodCollection.Get().addToList(food);
            FoodCollection.Get().removeFromHome(food);
            notifyDataSetChanged();
        }
        notifyDataSetChanged();

    }


}

package com.example.pj.foodlistfinalproject;

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.content.Context;




/**
 * Created by PJ on 11/15/2016.
 */

public class OnTouchHelper extends ItemTouchHelper.SimpleCallback
{
    public static final String EX_BAND_ID = "band_id";
    private FoodModel food;
    private basicAdapter foodAdapter;
    private Context context;

    public OnTouchHelper(Context context, basicAdapter fAdapter)
    {

        super(ItemTouchHelper.UP | ItemTouchHelper.DOWN , ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        this.foodAdapter = fAdapter;
        this.context = context;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target)
    {
        foodAdapter.swap(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction)
    {
        foodAdapter.shift(viewHolder.getAdapterPosition());
    }








}
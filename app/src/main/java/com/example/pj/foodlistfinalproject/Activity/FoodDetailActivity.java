package com.example.pj.foodlistfinalproject.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pj.foodlistfinalproject.FoodCollection;
import com.example.pj.foodlistfinalproject.FoodModel;
import com.example.pj.foodlistfinalproject.R;

import java.util.UUID;

public class FoodDetailActivity extends AppCompatActivity {

    private static final String EX_FOOD_NAME = "foodName";
    private static final String EX_FOOD_NOTES = "foodNotes";
    private static final String EX_FOOD_ID = "foodId";

    EditText et_itemName;
    EditText  et_itemNotes;
    Button btn_add;
    Button btn_del;
    FoodModel food;
    boolean newfood;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);
        this.et_itemName = (EditText) findViewById(R.id.et_itemName);
        this.et_itemNotes = (EditText) findViewById(R.id.et_itemNotes);
        this.btn_add = (Button) findViewById(R.id.btn_add);
        this.btn_del = (Button) findViewById(R.id.btn_del);
        Intent intent = this.getIntent();
        UUID foodID = (UUID) intent.getSerializableExtra(EX_FOOD_ID);
        if(foodID != null) {


            this.food = FoodCollection.Get().getFood(foodID);

            et_itemName.setText(food.getFoodName());

            if(food.getFoodNotes() != null)
            {
                et_itemNotes.setText(food.getFoodNotes());
            }
            btn_add.setText("update");
            newfood = false;
        }
        else
        {
            newfood = true;
            food = new FoodModel();
            btn_del.setVisibility(View.INVISIBLE);
        }


        et_itemName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(et_itemName !=  null)
                {
                    food.setFoodName(et_itemName.getText().toString());
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        et_itemNotes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(et_itemNotes != null)
                {
                    food.setFoodNotes(et_itemNotes.getText().toString());
                }
                if(et_itemNotes == null)
                {
                    food.setFoodNotes("facts and musings about your food choice");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    public void addClicked(View view) {

        if (food.getFoodName().length()< 1)
        {
            food.setFoodName("Mystery Meat");
        }
        if(newfood)
        {
            FoodCollection.Get().addToAll(food);
            FoodCollection.Get().addToList(food);
        }

        this.finish();

    }

    public void delClicked (View view)
    {
        String loc = food.getFoodLocation();

        switch (loc)
        {
            case "list":
                FoodCollection.Get().removeFromShop(food);


            case "cart":
                FoodCollection.Get().removeFromCart(food);


            case "home":
                FoodCollection.Get().removeFromHome(food);
        }
        FoodCollection.Get().removeFromAll(food);
        this.finish();

    }


}

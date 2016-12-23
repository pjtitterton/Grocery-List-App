package com.example.pj.foodlistfinalproject.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.pj.foodlistfinalproject.Activity.MainActivity;
import com.example.pj.foodlistfinalproject.FoodCollection;
import com.example.pj.foodlistfinalproject.FoodModel;
import com.example.pj.foodlistfinalproject.OnTouchHelper;
import com.example.pj.foodlistfinalproject.R;
import com.example.pj.foodlistfinalproject.basicAdapter;

import java.util.List;

/**
 * Created by PJ on 12/6/2016.
 */

public class HomeFragment extends Fragment {
    private RecyclerView rv_didNotCopy;
    private RecyclerView.Adapter notCopiedAdapter;
    private RecyclerView.LayoutManager aLayoutManager;
    private List<FoodModel> foodList;

    private static final String ARG_SECTION_NUMBER = "section_number";

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate view
        View fragmentView = inflater.inflate(R.layout.fragment_home, container, false);
        final MainActivity activity = (MainActivity) this.getActivity();
        foodList = FoodCollection.Get().getHomeFoodList();
        //implement recycle view
        rv_didNotCopy = (RecyclerView) fragmentView.findViewById(R.id.rv_homeList);

        return fragmentView;
    }

    @Override
    public void onResume()
    {
        super.onResume();
        if(this.rv_didNotCopy.getAdapter() == null) {


            notCopiedAdapter = new basicAdapter(this.getActivity(), this.foodList);
            rv_didNotCopy.setAdapter(notCopiedAdapter);
            this.aLayoutManager = new LinearLayoutManager(this.getActivity());
            this.rv_didNotCopy.setLayoutManager(aLayoutManager);
            ItemTouchHelper.Callback callit = new OnTouchHelper(this.getActivity(), (basicAdapter) notCopiedAdapter);
            ItemTouchHelper helper = new ItemTouchHelper(callit);
            helper.attachToRecyclerView(rv_didNotCopy);
        }
        else
        {
            this.rv_didNotCopy.getAdapter().notifyDataSetChanged();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);


        if (this.isVisible()) {
            onResume();
            if (!isVisibleToUser) {
                Log.d("HomeFragment", "Not visible anymore.");

            }
        }
    }

    public static HomeFragment newInstance(int sectionNumber) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }
}

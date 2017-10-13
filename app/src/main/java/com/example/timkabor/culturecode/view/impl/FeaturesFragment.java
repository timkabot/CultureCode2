package com.example.timkabor.culturecode.view.impl;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.timkabor.culturecode.Constants;
import com.example.timkabor.culturecode.R;
import com.example.timkabor.culturecode.adapter.FeatureAdapter;
import com.example.timkabor.culturecode.model.Feature;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Timkabor on 10/13/2017.
 */

public class FeaturesFragment extends Fragment {
    @BindView(R.id.features_recycler) RecyclerView mFeaturesRecyclerView;
    private ArrayList<Feature> featureList;
    private FeatureAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_features, container, false);
        ButterKnife.bind(this, view);

        setHasOptionsMenu(true);
        initToolbar();
        System.out.println("hello");
        Constants c = new Constants();
        System.out.println(c.getFeatures().size());
        setSightsRecyclerViewData(c.getFeatures());
        return view;
    }
    public void setSightsRecyclerViewData(ArrayList<Feature> features) {
        GridLayoutManager manager = new GridLayoutManager(getActivity().getApplicationContext(), 2);
        featureList = features;

        mAdapter = new FeatureAdapter(featureList, getActivity());
        System.out.println(mFeaturesRecyclerView);
        mFeaturesRecyclerView.setAdapter(mAdapter);
        mFeaturesRecyclerView.setHasFixedSize(true);
        mFeaturesRecyclerView.setLayoutManager(manager);
    }
    private void initToolbar() {
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Возможности");
    }
}

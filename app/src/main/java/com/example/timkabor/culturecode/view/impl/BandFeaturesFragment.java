package com.example.timkabor.culturecode.view.impl;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.timkabor.culturecode.Constants;
import com.example.timkabor.culturecode.R;
import com.example.timkabor.culturecode.adapter.FeatureAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Timkabor on 10/13/2017.
 */

public class BandFeaturesFragment extends Fragment {
    @BindView(R.id.band_features_list)
    ListView mFeaturesView;
    private ArrayList<String> featureList;
    private FeatureAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_band_features, container, false);
        ButterKnife.bind(this, view);

        setHasOptionsMenu(true);
        initToolbar();

        Constants c = new Constants();
        setBandInfoData(c.getBandFeatures());
        return view;
    }
    public void setBandInfoData(ArrayList<String> features) {
        featureList = features;
        ArrayAdapter adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, featureList);

        mFeaturesView.setAdapter(adapter);

    }
    private void initToolbar() {
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Возможности Браслета");
    }
}

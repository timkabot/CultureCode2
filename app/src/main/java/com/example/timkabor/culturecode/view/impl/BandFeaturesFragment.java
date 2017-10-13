package com.example.timkabor.culturecode.view.impl;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
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
    @BindView(R.id.band_features_list) LinearLayout mFeaturesView;
    @BindView(R.id.band_commands_list) LinearLayout mCommandsView;

    @BindView(R.id.slider) SliderLayout slider;
    private ArrayList<String> featureList;
    private ArrayList<String> commandsList;

    private FeatureAdapter mAdapter;
    Constants c;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_band_features, container, false);
        ButterKnife.bind(this, view);

        setHasOptionsMenu(true);
        initToolbar();

        c = new Constants();
        for(String url : c.getBandImagesUrls()){
            DefaultSliderView sliderView = new DefaultSliderView(getActivity());
            System.out.println(url);
            sliderView
                    .image(url)
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop);
            slider.addSlider(sliderView);
        }

        setBandInfoData(c.getBandFeatures());
        setBandCommandData(c.getBandCommands());
        return view;
    }
    public void setBandInfoData(ArrayList<String> features) {
        featureList = features;
        for(int i=0;i<c.getBandFeatures().size();i++) {
            TextView tv = new TextView(getContext());
            tv.setText(c.getBandFeatures().get(i));
            mFeaturesView.addView(tv);
        }
    }
    public void setBandCommandData(ArrayList<String> features) {
        commandsList = features;
        for(int i=0;i<c.getBandCommands().size();i++) {
            TextView tv = new TextView(getContext());
            tv.setText(c.getBandCommands().get(i));
            tv.setGravity(Gravity.LEFT);
            mCommandsView.addView(tv);
        }
    }
    private void initToolbar() {
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Возможности Браслета");
    }
}

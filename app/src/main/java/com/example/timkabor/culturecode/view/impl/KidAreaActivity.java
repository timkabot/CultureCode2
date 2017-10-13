package com.example.timkabor.culturecode.view.impl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.timkabor.culturecode.R;

import butterknife.ButterKnife;


/**
 * Created by Timkabor on 10/13/2017.
 */

public class KidAreaActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kid_area);
        ButterKnife.bind(this);

    }
}

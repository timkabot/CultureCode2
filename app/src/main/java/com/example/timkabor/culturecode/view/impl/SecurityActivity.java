package com.example.timkabor.culturecode.view.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.timkabor.culturecode.R;

/**
 * Created by Timur on 14.10.2017.
 */

public class SecurityActivity extends AppCompatActivity {
    static Button mSendButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security);
    }
}

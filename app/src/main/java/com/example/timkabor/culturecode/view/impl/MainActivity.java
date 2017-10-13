package com.example.timkabor.culturecode.view.impl;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.timkabor.culturecode.App;
import com.example.timkabor.culturecode.R;
import com.example.timkabor.culturecode.model.ParkingAction;
import com.example.timkabor.culturecode.view.MainActivityInterface;

import java.io.IOException;
import java.sql.SQLOutput;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements MainActivityInterface {
    @BindView(R.id.bottom_navigation) BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        showNewFragment(new FeaturesFragment());
        setListenerToBottomMenu();
    }

    public void setListenerToBottomMenu() {
       bottomNavigationView.setOnNavigationItemSelectedListener(view -> {
            switch (view.getItemId()){
                case R.id.band_menu_item:
                    showNewFragment(new BandFeaturesFragment());
                    break;
                case R.id.emergency_menu_item:
                    showNewFragment(new FeaturesFragment());
                    break;
                case R.id.my_account_menu_item:
                    showNewFragment(new AccountFragment());
                    break;
            }
            return true;
       });
    }

    @Override
    public void showNewFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void showFragment(Fragment fragment) {

    }

    @Override
    public void hideFragment(Fragment fragment) {

    }
}

package com.example.timkabor.culturecode.view.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.BoolRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.timkabor.culturecode.App;
import com.example.timkabor.culturecode.Constants;
import com.example.timkabor.culturecode.R;
import com.example.timkabor.culturecode.model.Account;
import com.example.timkabor.culturecode.model.Feature;
import com.example.timkabor.culturecode.model.ParkingAction;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Timkabor on 10/13/2017.
 */

public class AccountFragment extends Fragment {
    @BindView(R.id.doubtList) ListView doubtList;
    @BindView(R.id.account_balance) TextView balance;
    @BindView(R.id.account_name) TextView name;
    private ArrayList<String> doubts;
    private Account myAccount;
    SharedPreferences sPref;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        ButterKnife.bind(this, view);
        sPref = getActivity().getSharedPreferences("",Context.MODE_PRIVATE);
        setHasOptionsMenu(true);
        initToolbar();
        myAccount = findAccount();
        assignValues();
        return view;
    }

    public void assignValues() {
        name.setText(myAccount.getName() + " " + myAccount.getSurname());
        balance.setText("У вас на счету " + myAccount.getBalance() + Html.fromHtml(" &#x20bd"));
        doubts = new ArrayList<>();
        doubts.add("Электричество -> " + myAccount.getElectricity() + Html.fromHtml(" &#x20bd"));
        doubts.add("Свет -> "          + myAccount.getLight() +  Html.fromHtml(" &#x20bd"));
        doubts.add("Газ -> "           + myAccount.getGas() + Html.fromHtml(" &#x20bd"));
        doubts.add("Вода -> "          + myAccount.getWater() + Html.fromHtml(" &#x20bd"));
        doubts.add("Интернет -> "      + myAccount.getInternet() + Html.fromHtml(" &#x20bd"));
        doubts.add("Телефон -> "       + myAccount.getPhone() + Html.fromHtml(" &#x20bd"));
        doubts.add("Телевидение -> "   + myAccount.getTV() + Html.fromHtml(" &#x20bd"));
        ArrayAdapter<String>  adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, doubts);

        doubtList.setAdapter(adapter);
    }
    public Account findAccount() {
        String login = sPref.getString("login","empty"), password = sPref.getString("password","empty");
        Constants c = new Constants();
        for(int i=0;i<c.getAccounts().size();i++) {
            Account acc = c.getAccounts().get(i);
            //System.out.println(acc.getLogin() + " " + login);
            if( login.equals(acc.getLogin()) && password.equals(acc.getPassword())) {
                //System.out.println(login + " " + password);
                return acc;
            }
        }
        return null;
    }
    public void setSightsRecyclerViewData(ArrayList<Feature> features) {

    }
    private void initToolbar() {
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Личный аккаунт");
    }
}

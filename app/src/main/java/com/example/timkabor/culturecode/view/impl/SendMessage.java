package com.example.timkabor.culturecode.view.impl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.example.timkabor.culturecode.R;

import butterknife.ButterKnife;

/**
 * Created by Timur on 13.10.2017.
 */

public class SendMessage extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_message_to_concierge);

        EditText mRegPhoneView = findViewById(R.id.send_message);

        mRegPhoneView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().isEmpty() || !isValidPhoneNumber(s.toString())) {
                    mRegPhoneView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_close_red, 0);
                } else {
                    mRegPhoneView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_input_ok, 0);
                }
            }
        });
    }

    public boolean isValidPhoneNumber(String phone) {
        String ePattern = "\\+[\\d]{1,3}-[\\d]{6,}";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(phone);
        return m.matches();
    }


}

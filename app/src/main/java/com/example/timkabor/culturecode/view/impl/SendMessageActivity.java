package com.example.timkabor.culturecode.view.impl;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.timkabor.culturecode.App;
import com.example.timkabor.culturecode.R;
import com.example.timkabor.culturecode.model.Message;
import com.example.timkabor.culturecode.model.None;
import com.example.timkabor.culturecode.model.ParkingAction;
import com.example.timkabor.culturecode.model.Trouble;
import com.example.timkabor.culturecode.model.TroubleLab;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SendMessageActivity extends AppCompatActivity {
    private ArrayList<CheckBox> problems;
    private RecyclerView mTroubleRecyclerView;
    private TroubleAdapter mAdapter;
    private EditText mEditText;
    private Button mSendButton;
    private String messageSend;
    private String messageTopic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_message_to_concierge);

        mTroubleRecyclerView = findViewById(R.id.troubles_recycler_view);
        mTroubleRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mSendButton = findViewById(R.id.send_button);
        mSendButton.setEnabled(false);

        mSendButton.setOnClickListener(view ->
        {
            SharedPreferences sPref = getSharedPreferences("",MODE_PRIVATE);
            String name = sPref.getString("login","empty");
            Message message = new Message( name, messageTopic + " " + messageSend);
            Toast.makeText(getApplicationContext(),messageTopic + " " + messageSend, Toast.LENGTH_SHORT).show();
            Call<None> call =  App.getAPI().sendMessage(message);
            call.enqueue(new Callback<None>() {
                @Override
                public void onResponse(Call<None> call, Response<None> response) {
                    if(response.isSuccessful()){
                        System.out.println("Succesfull response");
                    }
                }

                @Override
                public void onFailure(Call<None> call, Throwable t) {

                }
            });
        });

        mEditText = findViewById(R.id.message_to_send);
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                messageSend = editable.toString();
            }
        });
        updateUI();
    }

    public class TroubleHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView mTroubleText;
        CheckBox mCheckBox;
        private Trouble mTrouble;

        public TroubleHolder(View itemView) {
            super(itemView);
            mTroubleText = itemView.findViewById(R.id.trouble_text_view);
            mCheckBox = itemView.findViewById(R.id.trouble_check_box);
        }

        public void bindCrime(Trouble trouble) {
            itemView.setOnClickListener(this);
            mTrouble = trouble;
            mTroubleText.setText(mTrouble.getText());
        }

        @Override
        public void onClick(View view) {
            mSendButton.setEnabled(true);
            mCheckBox.setChecked(!mCheckBox.isChecked());
            messageTopic = (String) mTroubleText.getText();
        }
    }

    public class TroubleAdapter extends RecyclerView.Adapter<TroubleHolder> {
        private List<Trouble> mTroubles;

        TroubleAdapter(List<Trouble> troubles) {
            mTroubles = troubles;
        }

        @Override
        public TroubleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.check_layout, parent, false);
            return new TroubleHolder(view);
        }

        @Override
        public void onBindViewHolder(TroubleHolder holder, int position) {
            Trouble trouble = mTroubles.get(position);
            holder.bindCrime(trouble);
        }

        @Override
        public int getItemCount() {
            return mTroubles.size();
        }
    }

    private void updateUI() {
        if (mAdapter == null) {
            TroubleLab crimeLab = TroubleLab.get(this);
            List<Trouble> crimes = crimeLab.getCrimes();
            mAdapter = new TroubleAdapter(crimes);
            mTroubleRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }
}
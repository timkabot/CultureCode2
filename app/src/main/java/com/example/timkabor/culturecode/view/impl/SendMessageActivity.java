package com.example.timkabor.culturecode.view.impl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.timkabor.culturecode.R;
import com.example.timkabor.culturecode.model.Trouble;
import com.example.timkabor.culturecode.model.TroubleLab;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Timur on 13.10.2017.
 */

public class SendMessageActivity extends AppCompatActivity{
    private ArrayList<CheckBox> problems;
    private RecyclerView mTroubleRecyclerView;
    private TroubleAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_message_to_concierge);

        mTroubleRecyclerView = findViewById(R.id.troubles_recycler_view);
        mTroubleRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        updateUI();
    }

    public class TroubleHolder extends RecyclerView.ViewHolder {
        TextView mTroubleText;
        CheckBox mCheckBox;
        private Trouble mTrouble;

        public TroubleHolder(View itemView) {
            super(itemView);
            mTroubleText = itemView.findViewById(R.id.trouble_text_view);
            mCheckBox = itemView.findViewById(R.id.trouble_check_box);
        }

        public void bindCrime(Trouble trouble) {
            mTrouble = trouble;
            mTroubleText.setText(mTrouble.getText());
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

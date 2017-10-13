package com.example.timkabor.culturecode.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.timkabor.culturecode.App;
import com.example.timkabor.culturecode.R;
import com.example.timkabor.culturecode.model.Feature;
import com.example.timkabor.culturecode.model.ParkingAction;
import com.example.timkabor.culturecode.view.impl.KidAreaActivity;
import com.example.timkabor.culturecode.view.impl.MainActivity;
import com.example.timkabor.culturecode.view.impl.SendMessageActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Timkabor on 10/13/2017.
 */

public class FeatureAdapter extends RecyclerView.Adapter<FeatureAdapter.ViewHolder> {
    private Context mContext;
    private List<Feature> mFeatureList;
    private MainActivity mainActivity;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.card_feature, parent, false);
        return new ViewHolder(cardView);
    }
    public FeatureAdapter(List<Feature> features, FragmentActivity activity) {
        mFeatureList = features;
        mainActivity = (MainActivity) activity;
        mContext = activity.getApplicationContext();
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Feature feature = mFeatureList.get(position);
        holder.mFeatureTitle.setText(feature.getName());
        App.setDrawableByName(feature.getCover(), holder.mFeatureImage,mContext.getApplicationContext());
    }

    @Override
    public int getItemCount() {
        return mFeatureList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.feature_cardview)   CardView mCardView;
        @BindView(R.id.feature_card_image) ImageView mFeatureImage;
        @BindView(R.id.feature_card_title) TextView mFeatureTitle;

        public ViewHolder(CardView itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }
        public void onNextBooking()
        {

        }
        public void onError()
        {

        }
        /**
         * Обработка нажатия на выбранном элементе
         * Запускает фрагмент описания фичи
         * @param view компонент, на котором был сделан клик
         */
        @Override
        public void onClick(View view) {
            Feature feature = mFeatureList.get(getAdapterPosition());

            switch (feature.getId()){
                case 1:
                    goToKidArea();
                    break;
                case 2:
                    Call<ParkingAction> call =  App.getAPI().changeParkingState();
                    call.enqueue(new Callback<ParkingAction>() {
                        @Override
                        public void onResponse(Call<ParkingAction> call, Response<ParkingAction> response) {
                            if(response.isSuccessful()) {
                                System.out.println("Lucky request");
                            }
                        }

                        @Override
                        public void onFailure(Call<ParkingAction> call, Throwable t) {
                        }
                    });
                    break;
                case 4:
                    Intent intent = new Intent(view.getContext(), SendMessageActivity.class);
                    Toast.makeText(view.getContext(), "pressed", Toast.LENGTH_SHORT).show();
                    view.getContext().startActivity(intent);
                    break;
            }
        }
        public void goToKidArea() {
            mContext.getApplicationContext().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://streamserv.cmko.ru:54016/stream")));
        }

    }
}

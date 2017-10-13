package com.example.timkabor.culturecode;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;

import com.example.timkabor.culturecode.model.APIService;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.squareup.picasso.Picasso;

import java.sql.SQLOutput;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Timkabor on 10/13/2017.
 */

public class App extends Application {

    private static APIService sService;
    public static final String BASE_URL = "http://10.91.37.77:8080";
    private static ColorDrawable placeholder ;
    private static Resources resources;
    private static Context context;
    private static Retrofit mRetrofit;

    @Override
    public void onCreate() {
        super.onCreate();
        placeholder = new ColorDrawable(getResources().getColor(R.color.white));
        resources = this.getResources();
        context = this;

        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        sService = mRetrofit.create(APIService.class);
    }
    public static APIService getAPI() {
        return sService;
    }


    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static ColorDrawable getPlaceholder() {
        return placeholder;
    }

    public static void setPlaceholder(ColorDrawable placeholder) {
        App.placeholder = placeholder;
    }


    public static void setResources(Resources resources) {
        App.resources = resources;
    }

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        App.context = context;
    }

    public static Retrofit getmRetrofit() {
        return mRetrofit;
    }

    public static void setmRetrofit(Retrofit mRetrofit) {
        App.mRetrofit = mRetrofit;
    }

    /**
     * Загрузка изображений с помощью Picasso
     * @param url ссылка на изображение
     * @param imageView компонент, в который будет загружено изображение
     */
    public static void loadImageFromURL(String url, ImageView imageView, Context context) {
        Picasso.with(context).
                load(url)
                .resize(349, 160)
                .centerInside()
                .into(imageView);
    }
    public static void setDrawableByName(String name, ImageView container, Context context) {
        name = name.split("\\.")[0];//Расширение убираем
        System.out.println(resources + " name");
        resources = context.getResources();
        final int resourceId = resources.getIdentifier(name, "drawable", context.getPackageName());
        if(resourceId!=0)
            container.setImageDrawable(resources.getDrawable(resourceId));

    }
}

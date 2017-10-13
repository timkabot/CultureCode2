package com.example.timkabor.culturecode;

import android.app.Application;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Timkabor on 10/13/2017.
 */

public class App extends Application {
    private static ColorDrawable placeholder ;

    @Override
    public void onCreate() {
        super.onCreate();
        placeholder = new ColorDrawable(getResources().getColor(R.color.white));
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

}

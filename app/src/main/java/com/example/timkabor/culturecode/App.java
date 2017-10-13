package com.example.timkabor.culturecode;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Timkabor on 10/13/2017.
 */

public class App extends Application {
    private static ColorDrawable placeholder ;
    private static Resources resources;
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        placeholder = new ColorDrawable(getResources().getColor(R.color.white));
        resources = this.getResources();
        context = this;
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

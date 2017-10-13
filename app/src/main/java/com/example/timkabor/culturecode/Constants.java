package com.example.timkabor.culturecode;

import com.example.timkabor.culturecode.model.Account;
import com.example.timkabor.culturecode.model.Feature;

import java.util.ArrayList;
import java.util.SplittableRandom;

/**
 * Created by Timkabor on 10/13/2017.
 */

public class Constants {
    ArrayList<Feature> features;
    ArrayList<String> bandFeatures;
    ArrayList<Account> accounts;
    ArrayList<String> bandImagesUrls;
    ArrayList<String> bandCommands;
    public Constants() {
        features = new ArrayList<>();
        features.add( new Feature(1,"Детская площадка", "http://www.buildindia.co.in/wp-content/themes/buildindia/images/cate_1.png"));
        features.add( new Feature(2,"Парковка", "http://kometa-hotel.ru/wp-content/uploads/2016/04/advantage_2.png"));
        features.add( new Feature(3,"Магазин", "http://www.embygames.com/assets/img/icons/shop-icon.png"));
        features.add( new Feature(4,"ЖКХ", "http://fondenergo.ru/templates/fondenergo/images/clients/jkh.png"));
        features.add( new Feature(5,"Досуг", "https://previews.123rf.com/images/guillermain/guillermain1310/guillermain131000062/23226957-Leisure-icons-Stock-Photo.jpg"));
        features.add( new Feature(6,"Дистанционный мониторинг", "http://icons.iconarchive.com/icons/custom-icon-design/flatastic-9/512/Monitoring-icon.png"));


        bandFeatures = new ArrayList<>();
        bandFeatures.add("У вас есть возможность использовать браслет как кредитную карту ");
        bandFeatures.add("С помощью браслета можно отслеживать местоположение носителя ");
        bandFeatures.add("Местная инфраструктура поддерживает обслуживание браслета (магазины, )");

        bandCommands = new ArrayList<>();
        bandCommands.add("Проверка количества свободных мест -> 'Сколько свободных мест на моей парковке?' ");
        bandCommands.add("Проверка наличия товара в магазине -> 'Есть ли 'имя товара' в ближайшем магазине?' ");

        accounts = new ArrayList<>();
        accounts.add(new Account("Albert","123qwerty","Albert","Badretdinov",19, 2374, 1956, 723, 837, 500, 777, 381 , 15423));
        accounts.add(new Account("Timur","123qwerty" ,"Timur" ,"Borgalinov" ,20, 2121, 1321, 463, 519, 1000, 456, 258, 7843));

        bandImagesUrls = new ArrayList<>();
        bandImagesUrls.add("https://shoot-n-joy.ru/blog/wp-content/uploads/2016/03/xiaomi-mi-band-2-2015.jpg");
        bandImagesUrls.add("https://hsto.org/files/fd5/62c/e1f/fd562ce1f9484d2f90410ec3ccf29201.jpg");
        bandImagesUrls.add("https://images-na.ssl-images-amazon.com/images/I/51BVLVfHlXL.jpg");
        bandImagesUrls.add("http://moto360.com.ua/wp-content/uploads/2017/07/mi-band-3.jpg");
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public ArrayList<String> getBandImagesUrls() {
        return bandImagesUrls;
    }

    public void setBandImagesUrls(ArrayList<String> bandImagesUrls) {
        this.bandImagesUrls = bandImagesUrls;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public ArrayList<String> getBandFeatures() {
        return bandFeatures;
    }

    public void setBandFeatures(ArrayList<String> bandFeatures) {
        this.bandFeatures = bandFeatures;
    }

    public ArrayList<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(ArrayList<Feature> features) {
        this.features = features;
    }
}

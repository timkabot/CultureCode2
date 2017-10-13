package com.example.timkabor.culturecode.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Timur on 13.10.2017.
 */

public class TroubleLab {
    private static TroubleLab sTroubleLab;
    private static List<Trouble> mTroubleList;

    public static TroubleLab get(Context context){
        if (sTroubleLab == null) {
            sTroubleLab = new TroubleLab(context);
        }
        return sTroubleLab;
    }

    private TroubleLab(Context context) {
        mTroubleList = new ArrayList<>();
        mTroubleList = new ArrayList<>();
        mTroubleList.add(new Trouble("Соседи"));
        mTroubleList.add(new Trouble("ЖКХ"));
        mTroubleList.add(new Trouble("Квартира"));
        mTroubleList.add(new Trouble("Безопасность"));
        mTroubleList.add(new Trouble("Питание"));
        mTroubleList.add(new Trouble("Инфраструктура"));
    }

    public List<Trouble> getCrimes() {
        return mTroubleList;
    }

    public void addCrime (Trouble crime){
        mTroubleList.add(crime);
    }

    public Trouble getCrime(UUID uuid) {
        for (Trouble trouble : mTroubleList) {
            if (trouble.getId().equals(uuid)) {
                return trouble;
            }
        }
        return null;
    }
}

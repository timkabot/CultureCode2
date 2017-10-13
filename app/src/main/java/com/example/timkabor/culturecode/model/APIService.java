package com.example.timkabor.culturecode.model;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Timkabor on 10/14/2017.
 */

public interface APIService {
        @POST("/set_gate")
        Call<ParkingAction> changeParkingState();

        @POST("/message")
        Call<None> sendMessage(@Body Message message);
}

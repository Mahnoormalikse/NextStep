package com.example.nextstep.services;


import com.example.nextstep.common.EndPoint;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Retrofit_Interface {

    @Headers({"Accept: application/json"})
    @FormUrlEncoded
    @POST(EndPoint.REGISTER)
    Call<Object> register(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password
    );
}

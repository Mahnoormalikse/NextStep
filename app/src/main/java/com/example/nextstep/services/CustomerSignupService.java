package com.example.nextstep.services;


import com.example.nextstep.common.EndPoint;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface CustomerSignupService {

    @Headers({"Accept: application/json"})
    @FormUrlEncoded
    @POST(EndPoint.CUSTOMER_SIGNUP_URL)
    Call<JsonObject> customer_signup(@Field("name") String name, @Field("email") String email, @Field("password") String password);
}

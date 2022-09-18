package com.example.nextstep.services;


import com.example.nextstep.common.EndPoint;
import com.example.nextstep.model.Customer;
import com.google.gson.JsonObject;
import com.pusher.client.channel.User;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface CustomerSignupService {

    @Headers({"Accept: application/json"})
    @POST(EndPoint.CUSTOMER_SIGNUP_URL)
    Call<JsonObject> customer_signup( @Body Customer customer);
}

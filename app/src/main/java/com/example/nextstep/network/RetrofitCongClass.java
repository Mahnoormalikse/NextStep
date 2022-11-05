package com.example.nextstep.network;



import com.example.nextstep.common.EndPoint;
import com.example.nextstep.services.Retrofit_Interface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitCongClass {

    //GSON support init
    private static Gson gson = new GsonBuilder().setLenient().create();

    //okhttp client  init
    private static OkHttpClient
            okHttpClient = new OkHttpClient().newBuilder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build();

    //ini retorfit using singelton pattern
    private static Retrofit_Interface retrofit = null;

    public static Retrofit_Interface getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(EndPoint.BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build().create(Retrofit_Interface.class);
        }

        return retrofit;
    }

}

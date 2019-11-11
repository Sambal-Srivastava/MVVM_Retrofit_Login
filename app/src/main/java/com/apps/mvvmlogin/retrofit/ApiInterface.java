package com.apps.mvvmlogin.retrofit;


import com.apps.mvvmlogin.response.SignInResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("login")
    Call<SignInResponse> getResponse(@Field("email") String email,
                                     @Field("password") String password,
                                     @Field("device_type") String device_type,
                                     @Field("device_token") String device_token);

}

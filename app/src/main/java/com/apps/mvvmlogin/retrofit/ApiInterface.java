package com.apps.mvvmlogin.retrofit;


import com.apps.mvvmlogin.api_inputs.SignInInputs;
import com.apps.mvvmlogin.response.SignInResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("login")
    Call<SignInResponse> getResponse(@Body SignInInputs input);

}

package com.apps.mvvmlogin.repositories;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.apps.mvvmlogin.api_inputs.SignInInputs;
import com.apps.mvvmlogin.response.SignInResponse;
import com.apps.mvvmlogin.retrofit.Api;
import com.apps.mvvmlogin.retrofit.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInRepository {
    private Application application;

    public SignInRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<SignInResponse> getMutableData(String email, String password, String device_type, String device_token) {
        final MutableLiveData<SignInResponse> mutableLiveData = new MutableLiveData<>();

        ApiInterface apiInterface = Api.getClient().create(ApiInterface.class);
        SignInInputs input = new SignInInputs(email, password, device_type, device_token);
        Call<SignInResponse> call = apiInterface.getResponse(input);
        call.enqueue(new Callback<SignInResponse>() {
            @Override
            public void onResponse(Call<SignInResponse> call, Response<SignInResponse> response) {
                if (response.isSuccessful()) {
                    mutableLiveData.setValue(response.body());
                } else {
                    SignInResponse signInResponse = new SignInResponse();
                    signInResponse.setStatus(signInResponse.status);
                    signInResponse.setMessage(signInResponse.message);
                    mutableLiveData.setValue(signInResponse);
                }
            }

            @Override
            public void onFailure(Call<SignInResponse> call, Throwable t) {
                SignInResponse signInResponse = new SignInResponse();
                signInResponse.setStatus(signInResponse.status);
                signInResponse.setMessage(signInResponse.message);
                mutableLiveData.setValue(signInResponse);
            }
        });
        return mutableLiveData;
    }

}

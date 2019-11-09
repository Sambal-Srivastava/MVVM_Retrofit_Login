package com.apps.mvvmlogin.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.apps.mvvmlogin.repositories.SignInRepository;
import com.apps.mvvmlogin.response.SignInResponse;

public class SignInViewModel extends AndroidViewModel {
    private SignInRepository signInRepository;
    public SignInViewModel(@NonNull Application application) {
        super(application);
        signInRepository = new SignInRepository(application);
    }

    public LiveData<SignInResponse> getResponse(String email, String password, String device_type, String device_token) {

        return signInRepository.getMutableData(email, password, device_type, device_token);
    }
}

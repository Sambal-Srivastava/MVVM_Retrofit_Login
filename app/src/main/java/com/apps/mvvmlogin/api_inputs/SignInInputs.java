package com.apps.mvvmlogin.api_inputs;

public class SignInInputs {

    private String email, password, device_type, devive_token;

    public SignInInputs(String email, String password, String device_type, String devive_token) {
        this.email = email;
        this.password = password;
        this.device_type = device_type;
        this.devive_token = devive_token;
    }
}

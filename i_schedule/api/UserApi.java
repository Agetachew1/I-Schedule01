package com.example.i_schedule.api;

import com.example.i_schedule.models.User;
import com.example.i_schedule.models.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserApi {
    @POST("register")
    Call<User> registerUser(@Body User user);
}

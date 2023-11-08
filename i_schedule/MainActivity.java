package com.example.i_schedule;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.example.i_schedule.models.User;
import com.example.i_schedule.api.UserApi;
import com.example.i_schedule.api.RetrofitClient;
import android.util.Log; // for logging the errors
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Reference the button from the XML layout
        Button loginButton = findViewById(R.id.loginButton);

        // Set an OnClickListener for the button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // On button click, perform login
                loginUser();
            }
        });
    }

    private void loginUser() {
        // Create an instance of User
        User user = new User("test@example.com", "securePassword123");

        // Make the API call using Retrofit
        UserApi api = RetrofitClient.getInstance().create(UserApi.class);
        Call<User> call = api.registerUser(user);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()) {
                    // Handle the successful response, e.g.:
                    User returnedUser = response.body();
                    Log.d("API_SUCCESS", "User registered: " + returnedUser.getEmail());
                } else {
                    // Handle the error response, e.g.:
                    Log.e("API_ERROR", "Error code: " + response.code());
                }
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                // Handle the failure, e.g.:
                Log.e("API_FAILURE", t.getMessage());
            }
        });
    }
}

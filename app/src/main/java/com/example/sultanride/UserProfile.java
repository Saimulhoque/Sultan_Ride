package com.example.sultanride;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sultanride.model.User;

public class UserProfile extends AppCompatActivity {
    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile);

        user = new User();
        user.setName("Saimul");
        user.setEmail("saimulhoque@gmail.com");
        user.setPhone("23455666");
        user.setAddress("mirpur-1");
    }
}
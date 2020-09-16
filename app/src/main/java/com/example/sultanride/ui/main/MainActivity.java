package com.example.sultanride.ui.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sultanride.R;
import com.example.sultanride.phoneAuth.PhoneAuthActivity;
import com.google.android.play.core.tasks.OnCompleteListener;
import com.google.android.play.core.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnLogin,btnLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.login);
        btnLogout = findViewById(R.id.logout);
        btnLogin.setOnClickListener(this);
        btnLogout.setOnClickListener(this);


        if(FirebaseAuth.getInstance().getCurrentUser()==null){
            btnLogout.setVisibility(View.GONE);


        }else{
            btnLogin.setVisibility(View.GONE);
        }

    }

    @Override
    public void onClick(View view) {
        if(view==btnLogin){
            startActivity(new Intent(getApplicationContext(), PhoneAuthActivity.class));
        }else if(view==btnLogout){
            FirebaseAuth.getInstance().signOut();
            recreate();
        }
    }
}

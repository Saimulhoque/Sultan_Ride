package com.example.sultanride.phoneAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.sultanride.OTP_Activity;
import com.example.sultanride.R;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;


public class PhoneAuthActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etPhoneNUmber;
    private static final String TAG = "Saimul";
    private Button btnVarify;


    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_auth);

        etPhoneNUmber = findViewById(R.id.phone_number);
        btnVarify = findViewById(R.id.varifybtn);
        btnVarify.setOnClickListener(this);



        mCallback = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                Log.d(TAG, "onVerificationCompleted:" + phoneAuthCredential.getSmsCode());
            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                Log.d(TAG, "onVerificationCompleted:" + e.getMessage());
            }

            @Override
            public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(verificationId, forceResendingToken);
                Log.d(TAG, "onCodeSent:" + verificationId);
                Log.d(TAG, "onCodeSent:" + forceResendingToken.toString());
                Toast.makeText(getApplicationContext(),"Code sent", Toast.LENGTH_SHORT).show();
                String mVerificationId = verificationId;
                Intent intent = new Intent(getApplicationContext() , OTP_Activity.class);
                intent.putExtra("verificationId" , mVerificationId);
                startActivity(intent);
                finish();

            }


        };


    }

    @Override
    public void onClick(View view) {
        String phoneNumber = etPhoneNUmber.getText().toString().trim();
        PhoneAuthProvider.getInstance().verifyPhoneNumber("+88" + phoneNumber, 60, TimeUnit.SECONDS, this, mCallback);

    }


}
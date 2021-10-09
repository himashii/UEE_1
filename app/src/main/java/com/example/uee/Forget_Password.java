package com.example.uee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class Forget_Password extends AppCompatActivity {

    EditText email;
    Button reset;
    ProgressBar progressBar;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        email = findViewById(R.id.emailReset);
        reset = findViewById(R.id.resetBtn);
        progressBar = findViewById(R.id.progressBarReset);

        firebaseAuth = FirebaseAuth.getInstance();

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetPassword();
            }

        });
    }

    public void resetPassword(){
        String emailReset = email.getText().toString().trim();

        if(emailReset.isEmpty()){
            email.setError("Email is required");
            email.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        firebaseAuth.sendPasswordResetEmail(emailReset).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Forget_Password.this, "Check your email to reset password!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(Forget_Password.this, "Try again! Something wrong happened!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
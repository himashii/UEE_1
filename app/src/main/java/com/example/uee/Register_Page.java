package com.example.uee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register_Page extends AppCompatActivity {

    EditText regName , regEmail , regPassword , regConfPassword;
    Button registerBtn ;
    FirebaseAuth fAuth;
    ProgressBar progressBar;
    TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        regName = findViewById(R.id.registerName);
        regEmail = findViewById(R.id.registerEmail);
        regPassword = findViewById(R.id.registerPassword);
        regConfPassword = findViewById(R.id.registerConfirmPassword);
        registerBtn = findViewById(R.id.registerBtn);
        login = findViewById(R.id.logintext);

        fAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Login_Page.class));
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //extract the data from the form

                String name = regName.getText().toString();
                String email = regEmail.getText().toString();
                String password = regPassword.getText().toString();
                String confPassword = regConfPassword.getText().toString();

                if(name.isEmpty()){
                    regName.setError("Name is Required");
                    return;
                }

                if(email.isEmpty()){
                    regEmail.setError("Email is Required");
                    return;
                }

                if(password.isEmpty()){
                    regPassword.setError("Password is Required");
                    return;
                }

                if(confPassword.isEmpty()){
                    regConfPassword.setError("Confirm Password is Required");
                    return;
                }

                if(password.equals(confPassword)){
                    regConfPassword.setError("Password Do not Match");
                }
                //data is validated

                progressBar.setVisibility(View.VISIBLE);



                //register using firebase
                Toast.makeText(Register_Page.this, "Data Inserted", Toast.LENGTH_SHORT).show();

                fAuth.createUserWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        startActivity(new Intent(getApplicationContext(),Login_Page.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Register_Page.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
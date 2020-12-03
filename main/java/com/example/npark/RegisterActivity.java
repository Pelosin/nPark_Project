package com.example.npark;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private static final String TAG = "LoginActivity";
    private EditText emailTxT;
    private EditText passwordTxT;
    private EditText n_telefone;
    private Button registerButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();

        emailTxT = (EditText) findViewById(R.id.Email);
        passwordTxT = (EditText) findViewById(R.id.Password);
        n_telefone = (EditText) findViewById(R.id.Telefone);
        registerButton = (Button) findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailTxT.getText().toString();
                String password = passwordTxT.getText().toString();
                if (email.isEmpty() || password.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Por favor preencha todos os" +
                            "campos", Toast.LENGTH_LONG).show();
                } else {
                  registerUser(email, password);
                }
            }
        });

    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        // updateUI(currentUser);
    }

    public void registerUser(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "Registado com Sucesso");

                            FirebaseUser user = mAuth.getCurrentUser();
                            // updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "Authentication Error", task.getException());
                            Toast.makeText(RegisterActivity.this, "Erro de Autenticação",
                                    Toast.LENGTH_SHORT).show();
                            // updateUI(null);
                        }

                        // ...
                    }
                });
    }

}
package com.example.meeba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login2 extends AppCompatActivity {

    EditText SignupEmail_s,SignupPassword_s;
    Button Login_l;
    String email_pattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    FirebaseAuth mAuth;
    FirebaseUser mUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        SignupEmail_s=findViewById(R.id.LoginEmail);
        SignupPassword_s=findViewById(R.id.Lognipassword);

        Login_l=findViewById(R.id.Login_button);

        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();

        Login_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Login();

            }
        });
    }

    private void Login() {
        String email = SignupEmail_s.getText().toString();
        String password = SignupPassword_s.getText().toString();

        if (!email.matches(email_pattern)) {
            SignupEmail_s.setError("Enter Email");
        } else if (password.isEmpty() || password.length() < 8) {
            SignupPassword_s.setError("Enter password");
        } else
        {
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful())
                    {
                        NextActivity1();
                        Toast.makeText(Login2.this,"Registration Successfully",Toast.LENGTH_SHORT).show();
                    }else
                    {
                        Toast.makeText(Login2.this,"Account does not exist",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }
    private void NextActivity1() {
        Intent intent=new Intent(Login2.this,HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}














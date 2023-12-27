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

public class Signup2 extends AppCompatActivity {

    EditText SignupEmail_s, SignupPassword_s;
    Button GetStarted_s;
    String email_pattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    FirebaseAuth mAuth;
    FirebaseUser mUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);

        SignupEmail_s = findViewById(R.id.SignupEmail);
        SignupPassword_s = findViewById(R.id.SignupPassword);

        GetStarted_s = findViewById(R.id.GetStarted2);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        GetStarted_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Auth();
            }
        });
    }

    private void Auth() {
        String email=SignupEmail_s.getText().toString();
        String password=SignupPassword_s.getText().toString();

        if (!email.matches(email_pattern))
        {
            SignupEmail_s.setError("Enter Email");
        }
        else if(password.isEmpty() || password.length()<8)
        {
            SignupPassword_s.setError("Enter password");
        }else
        {

            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful())
                    {
                        NextActivity();
                        Toast.makeText(Signup2.this,"Registration Successfully",Toast.LENGTH_SHORT).show();
                    }else
                    {
                        Toast.makeText(Signup2.this,"Account already exists",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    private void NextActivity() {
        Intent intent=new Intent(Signup2.this,HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}

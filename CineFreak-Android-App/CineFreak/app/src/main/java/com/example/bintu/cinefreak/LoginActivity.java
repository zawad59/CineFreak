package com.example.bintu.cinefreak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    public static final String ex="com.example.bintu.cinefreak.MESSAGE";
    public static final String ex2="userid";
    Databasehelper h=new Databasehelper(this);
    Infromation checkp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

        public void onLoginClick(View v)
    {
            EditText name = (EditText) (findViewById(R.id.login_id));
            EditText pass = (EditText) (findViewById(R.id.login_pass));

            String n = name.getText().toString();
            String p = pass.getText().toString();

            checkp=h.searchitem(n);

            if (p.equals(checkp.password)) {


               Intent intent = new Intent(this, MenuActivity.class);
                intent.putExtra(ex,"Hello, "+ checkp.name + "!");
                intent.putExtra(ex2,checkp.userid);
               startActivity(intent);
                finish();
            } else {

                Toast t = Toast.makeText(LoginActivity.this, "Password doesn't match", Toast.LENGTH_SHORT);
                t.show();


            }
        }


    public void onSignupclick(View v)
    {
            Intent intent = new Intent(this, SignUpActivity.class);
            startActivity(intent);

    }

    }


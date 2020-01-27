package com.example.bintu.cinefreak;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{

    Databasehelper handler=new Databasehelper(this);
    public static int a=0;
    EditText name,userid,pass,repass;
    String username,iid,password,repassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

    }
    public void onClick(View V) {
        if (V.getId()== R.id.SignUp) {

            name = (EditText) (findViewById(R.id.name));
            userid = (EditText) (findViewById(R.id.SignId));
            pass = (EditText) (findViewById(R.id.SignPass));
            repass = (EditText) (findViewById(R.id.Repass));
            username = name.getText().toString();
            iid = userid.getText().toString();
            password = pass.getText().toString();
            repassword = repass.getText().toString();

            Infromation s = handler.searchitem(iid);
            if (s.getUserid().equals(iid) && !iid.equals("")) {
                Toast t = Toast.makeText(SignUpActivity.this, "Username not available", Toast.LENGTH_SHORT);
                t.show();
                userid.setText("");
            }
            else if (!password.equals(repassword)) {
                Toast t = Toast.makeText(SignUpActivity.this, "Password doesn't match", Toast.LENGTH_SHORT);
                t.show();

            }else {
                Infromation i = new Infromation();
                i.setUserid(iid);
                i.setPassword(password);
                i.setName(username);
                if (!username.equals("") && !iid.equals("") && !password.equals("") && handler.in(i)) {
                    Toast t = Toast.makeText(SignUpActivity.this, "   Sign Up Successfull\nLogin to proceed further", Toast.LENGTH_SHORT);
                    t.show();
                    Intent intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast t = Toast.makeText(SignUpActivity.this, "Fill up all the sectors correctly", Toast.LENGTH_LONG);
                    t.show();
                }
            }
        }

        }
    }
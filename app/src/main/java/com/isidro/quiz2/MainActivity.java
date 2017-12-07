package com.isidro.quiz2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.isidro.quiz2.welcome;


import static com.isidro.quiz2.R.id.button;
import static com.isidro.quiz2.R.id.button2;
import static com.isidro.quiz2.R.id.editText;
import static com.isidro.quiz2.R.id.editText2;

public class MainActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnRem, btnLogin;
    SharedPreferences preferences;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsername=(EditText) findViewById(editText);
        etPassword=(EditText) findViewById(editText2);
        btnRem=(Button) findViewById(button);
        btnLogin=(Button) findViewById(button2);
        preferences= getPreferences(Context.MODE_PRIVATE);
    }

    public void rem(View view){
        String username = preferences.getString("username","");
        String password = preferences.getString("password","");
        etUsername.setText(username,TextView.BufferType.EDITABLE);
        etPassword.setText(password,TextView.BufferType.EDITABLE);
    }

    public void login(View view){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", etUsername.getText().toString());
        editor.putString("password", etPassword.getText().toString());
        editor.commit();
        nextAct();
    }
    public void nextAct() {
        Intent intent = new Intent(this, welcome.class);
        intent.putExtra("username", etUsername.getText().toString());
        startActivity(intent);
    }
}

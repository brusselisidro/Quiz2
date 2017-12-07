package com.isidro.quiz2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;





public class welcome extends AppCompatActivity {
    TextView welcome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        welcome = (TextView) findViewById(R.id.textView6);
        welcome.setText(getIntent().getStringExtra("username"));
    }

    public void logout(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}

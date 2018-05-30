package com.fabiocorreia.androidstudyhelloworld;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HelloWorldActivity extends Activity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_world);
        final EditText username = findViewById(R.id.editText);
        final EditText password = findViewById(R.id.editText2);
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                if(login(username.getText().toString(), password.getText().toString())) {

                    Toast.makeText(getApplicationContext(),
                            "Logando...", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(getApplicationContext(),LoggedInActivity.class);
                    startActivity(i);
                    setContentView(R.layout.logged_in);

                } else {
                    Toast.makeText(getApplicationContext(),
                            "Credenciais Inválidas.", Toast.LENGTH_SHORT).show();


                }
            }



        });

    }

    public boolean login(String username, String password){
        return username.equals("admin@admin.com") && password.equals("admin");
    }
}

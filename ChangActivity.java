package com.example.lab8;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import static com.example.lab8.MainActivity.user;

public class ChangActivity extends AppCompatActivity {

    SharedPreferences usrAccs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chang);
    }

    public void changepassword(View V) {
        EditText pwd = (EditText) findViewById(R.id.newp);

        usrAccs = getApplicationContext().getSharedPreferences(" UserAccounts", 0);
        SharedPreferences.Editor usrAccsEditor = usrAccs.edit();
        usrAccsEditor.putString(user, pwd.getText().toString());
        usrAccsEditor.commit();

        Toast.makeText(getApplicationContext(), user+ "  .. Password is changed ", Toast.LENGTH_LONG).show();


        Intent Int = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(Int);
        finish();
    }

}

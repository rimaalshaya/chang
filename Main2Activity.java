package com.example.lab8;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    SharedPreferences usrAccs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void signUp(View V){
        EditText usr=(EditText)findViewById(R.id.usrInp);
        EditText pwd=(EditText)findViewById(R.id.pwdInp);

    usrAccs= getApplicationContext().getSharedPreferences(" UserAccounts",0);//take  sem inf

    SharedPreferences.Editor usrAccsEditor=usrAccs.edit();//can do edit

    if(usrAccs.contains(usr.getText().toString())){
    Toast.makeText(getApplicationContext()," The user account is already existent",
    Toast.LENGTH_LONG).show();
        return; }


    usrAccsEditor.putString(usr.getText().toString(),pwd.getText().toString());
    usrAccsEditor.commit();

    Toast.makeText(getApplicationContext(),usr.getText().toString()+ "  .. account is created",Toast.LENGTH_LONG).show();


    Intent Int=new Intent(getApplicationContext(),MainActivity.class);
    startActivity(Int);
    finish();
}
}
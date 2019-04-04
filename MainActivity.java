package com.example.lab8;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtV;
    EditText Password;
    EditText Name;
    Button change;
    static  String user,pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtV=(TextView)findViewById(R.id.txtvSignUp);
        Password=(EditText) findViewById(R.id.pa);
        Name=(EditText) findViewById(R.id.na);
        change=(Button) findViewById(R.id.ch);

        txtV.setOnClickListener(new View.OnClickListener() {

               public void onClick(View v) {
                   Intent it=new Intent(getApplicationContext(),Main2Activity.class);//go anthoer activity
                   startActivity(it);
                   fileList();
               }
           });
        }

    public void log(View V){

            EditText usrName=(EditText) findViewById(R.id.na);
            EditText PassInput=(EditText) findViewById(R.id.pa);
            user=usrName.getText().toString();
            pass=PassInput.getText().toString();

        SharedPreferences userAccounts= getSharedPreferences(" UserAccounts",0); //to save input user can call  طلب برمجي بحفظ القيمة التي قمنا بكتابتها داخل الحقل النصي في حال الرجوع مرة اخرى للتطبيق

        if (!userAccounts.contains(user)){
            Toast.makeText(getApplicationContext(), "  The user account is not existent",Toast.LENGTH_LONG).show();
        return;}



        if ((userAccounts.getString(user,null)).equals(pass)){  //if do't have give null
            Toast.makeText(getApplicationContext(),"  The access is authenticated",Toast.LENGTH_LONG).show();
            change.setVisibility(View.VISIBLE);}


            else Toast.makeText(getApplicationContext(),"  The password entered is wrong",Toast.LENGTH_LONG).show();
        }



        public void changepassword(View V){
        Intent cha=new Intent(getApplicationContext(),ChangActivity.class);
        startActivity(cha);
        finish();
    }
}

package com.example.testing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testing.Sql.DBHelper;

public class SignUp extends AppCompatActivity {

    EditText name , number , email,pass;
    TextView login;
    DBHelper dbHelper;

//    boolean isAllFieldsChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name=findViewById(R.id.textName);
        number=findViewById(R.id.textNumber);
        email=findViewById(R.id.textEmail);
        pass=findViewById(R.id.textPass);
        Button signUpAcc = findViewById(R.id.btnSignUpAcc);
        dbHelper = new DBHelper(this);
        signUpAcc.setOnClickListener(new View.OnClickListener() {

            private Boolean ValidateName(){
                String  val = name.getText().toString();

                if (val.isEmpty()){
                    name.setError("field cannot empty");
                    return false;
                }
                name.setError(null);

                return true;
            }

            private Boolean ValidateNumber(){
                String  val1 = number.getText().toString();


                if (val1.isEmpty()){
                    number.setError("field cannot empty");
                    return false;
                } else if(val1.length() != 10){
                    number.setError("enter valid phone number");
                    return false;
                }
                number.setError(null);

                return true;
            }

            private Boolean ValidateEmail(){
                String  val2 = email.getText().toString();
                String MailPattern = "[a-zA-z0-9._-]+@[a-z]+\\.+[a-z]+";

                if (val2.isEmpty()){
                    email.setError("field cannot empty");
                    return false;
                }else if(!val2.matches(MailPattern)){
                    email.setError("Invalid Email");
                    return false;
                }
                email.setError(null);

                return true;
            }

            private Boolean ValidatePassword(){
                String  val3 = pass.getText().toString();

                if (val3.isEmpty()){
                    pass.setError("field cannot empty");
                    return false;
                }
                pass.setError(null);

                return true;
            }



            @Override
            public void onClick(View view) {
                if(!ValidateName() | !ValidateNumber() | !ValidateEmail() | !ValidatePassword()){
                    return;
                }

                String name1 = name.getText().toString();
                String number1 = number.getText().toString();
                String email1 = email.getText().toString();
                String pass1 = pass.getText().toString();
                boolean b =dbHelper.insetUserData(name1,number1,email1,pass1);

                if (b){

                    Toast.makeText(SignUp.this,"Data inserted",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(SignUp.this,Login.class);
                    startActivity(i);}
                    else {
                        Toast.makeText(SignUp.this,"Failed To insert Data",Toast.LENGTH_SHORT).show();
                    }

            }

        });
        login=findViewById(R.id.loginAcc);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignUp.this,Login.class);
                startActivity(i);
            }
        });
    }
}
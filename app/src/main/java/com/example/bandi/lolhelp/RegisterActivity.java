package com.example.bandi.lolhelp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {


    private DatabaseReference mDatabase;
    private EditText firstname;
    private EditText lastname;
    private EditText phonenumber;
    private Button reg_btn;
    private String dummyimg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        firstname= findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);
        phonenumber = findViewById(R.id.phonenm);
        reg_btn = findViewById(R.id.register_btn);

        mDatabase = FirebaseDatabase.getInstance().getReference();


        dummyimg = "https://www.google.hu/search?q=basic+profile+pic&source=lnms&tbm=isch&sa=X&ved=0ahUKEwi54_TsiKnfAhUJFiwKHVY1AM0Q_AUIDigB&cshid=1545125452510000&biw=1366&bih=695#imgrc=8Bugc0DV4SjwlM:";


        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeNewUser(lastname.getText().toString(),firstname.getText().toString(),phonenumber.getText().toString(),dummyimg);
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void writeNewUser(String lastname, String firstname, String phonenumber,String image) {
        User user = new User(firstname, lastname,phonenumber,image);

        mDatabase.child("users").child(phonenumber).setValue(user);
    }
}

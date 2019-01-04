package com.example.bandi.lolhelp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {


    private Spinner spinner;
    private EditText editText;
    DatabaseReference ref;
    FirebaseDatabase database;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        spinner = findViewById(R.id.spinnerCountries);
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, CountryData.countryNames));

        editText = findViewById(R.id.editTextPhone);

        database = FirebaseDatabase.getInstance();
        ref = database.getReference("users");

        findViewById(R.id.reg_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });


        findViewById(R.id.buttonContinue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.addListenerForSingleValueEvent(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        User user = new User(editText.getText().toString());
                        if(dataSnapshot.child(Objects.requireNonNull(ref.child(user.getPhonenumber()).getKey())).exists()) {
                            //Toast.makeText(getApplicationContext(),"Code is empty",Toast.LENGTH_LONG).show();
                            String code = CountryData.countryAreaCodes[spinner.getSelectedItemPosition()];

                            String number = editText.getText().toString().trim();

                            SharedPreferences mSettings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                            SharedPreferences.Editor editor = mSettings.edit();
                            editor.putString("telefon",editText.getText().toString());
                            editor.apply();
                            Log.d("telefonszam" ,"az en telefonszamom:" + editText.getText().toString());

                            //String number = editText.getText().toString().trim();

                            if (number.isEmpty() || number.length() < 10) {
                                editText.setError("Valid number is required");
                                editText.requestFocus();
                                return;
                            }

                            String phoneNumber = "+" + code + number;

                            Intent intent = new Intent(LoginActivity.this, VerifyPhoneActivity.class);
                            intent.putExtra("phonenumber", phoneNumber);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Wrong Phone number",Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        //bandi swag
                    }
                });
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart ();

        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            startActivity(intent);
        }
    }
}

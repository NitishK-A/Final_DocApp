package com.example.nitishatal.docapp;

import android.app.DatePickerDialog;
//import android.icu.util.Calendar;
import java.util.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Apponintment extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    Button button;
    EditText name,mobile,descript,date,time;
    ImageButton calender;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apponintment);
        firebaseDatabase=FirebaseDatabase.getInstance();
         databaseReference=firebaseDatabase.getReference("appoint");
         name=(EditText)findViewById(R.id.editText3);
         mobile=(EditText)findViewById(R.id.editText4);
         descript=(EditText)findViewById(R.id.editText5);
         date=findViewById(R.id.editText6);
         time=findViewById(R.id.editText7);
        button=(Button)findViewById(R.id.button);
        calender=(ImageButton) findViewById(R.id.imageButton);
        calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar mcurrentDate=Calendar.getInstance();
                int year = mcurrentDate.get(Calendar.YEAR);
                int month = mcurrentDate.get(Calendar.MONTH);
                int day = mcurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker=new DatePickerDialog(Apponintment.this, new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedYear, int selectedMonth, int selectedDay) {
                        Log.e("Date Selected", "Month: " + selectedMonth + " Day: " + selectedDay + " Year: " + selectedYear);
                        date.setText(selectedDay + "/" + selectedMonth + "/" + selectedYear);
                    }
                },year, month, day);
                mDatePicker.setTitle("Select date");
                mDatePicker.show();

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String key=databaseReference.push().getKey();
                String nam=name.getText().toString();
                String mobil=mobile.getText().toString();
                String descr=descript.getText().toString();
                String dat=date.getText().toString();
                String tim=time.getText().toString();
                appoint appoint=new appoint(nam,mobil,dat, tim, descr,"yes");
                databaseReference.child(key).setValue(appoint);
            }
        });




    }
}

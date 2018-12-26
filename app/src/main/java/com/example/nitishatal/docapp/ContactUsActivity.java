package com.example.nitishatal.docapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ContactUsActivity extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
    Button send;
    EditText name,email,subject,msg;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("ContactUs");
        name=(EditText)findViewById(R.id.cname);
        email=(EditText)findViewById(R.id.cemail);
        subject=(EditText)findViewById(R.id.csubject);
        msg=findViewById(R.id.cmsg);

        send=(Button)findViewById(R.id.Send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String key=databaseReference.push().getKey();
                String nam=name.getText().toString();
                String mobil=email.getText().toString();
                String descr=subject.getText().toString();
                String dat=msg.getText().toString();
                //String tim=time.getText().toString();
                contact appoint=new contact(nam,mobil,dat, descr);
                databaseReference.child(key).setValue(appoint);
            }
        });
    }
}

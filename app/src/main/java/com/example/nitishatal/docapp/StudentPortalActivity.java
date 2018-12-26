package com.example.nitishatal.docapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StudentPortalActivity extends AppCompatActivity {
    List<Upload> productList;
    DatabaseReference mDatabaseReference;
    student_portal_adapter adapter;
    ItemClickListener listener;

    //the recyclerview
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_portal);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        productList = new ArrayList<>();

        mDatabaseReference = FirebaseDatabase.getInstance().getReference(Constants.DATABASE_PATH_UPLOADS);

        // Intent intent=getIntent();
        //  String pos=intent.getStringExtra("position");
        adapter = new student_portal_adapter(getApplicationContext(), productList, new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Log.d("ds", "clicked position:" + position);
                Upload upload = productList.get(position);

                //Opening the upload file in browser using the upload url

            }

        });
        recyclerView.setAdapter(adapter);



        //adapter=new student_portal_adapter(getApplicationContext(),

        //retrieving upload data from firebase database
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Upload upload = postSnapshot.getValue(Upload.class);
                    productList.add(upload);
                }

                String[] uploads = new String[productList.size()];

                for (int i = 0; i < uploads.length; i++) {
                    uploads[i] = productList.get(i).getName();
                }

                //displaying it to list
                student_portal_adapter adapter = new student_portal_adapter(getApplicationContext(), productList,listener);

                //setting adapter to recyclerview
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        /*productList.add(new student_portal("das",1));
        productList.add(new student_portal("this book is this",2));
        productList.add(new student_portal("this book is this",3));*/
        // student_portal_adapter adapter = new student_portal_adapter(this, productList);

        //setting adapter to recyclerview
        // recyclerView.setAdapter(adapter);


    }
    public void onClick(View view, int position) {
        Toast.makeText(getApplicationContext(), "dsd", Toast.LENGTH_SHORT).show();

    }
}

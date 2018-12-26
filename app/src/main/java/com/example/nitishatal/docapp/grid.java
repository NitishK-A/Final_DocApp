package com.example.nitishatal.docapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridView;

import com.google.firebase.database.FirebaseDatabase;

public class grid extends AppCompatActivity {
    CardView cardView,cardView2,cardView3,cardView4,cardView5,cardView6,cardView7,cardView8;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        firebaseDatabase=FirebaseDatabase.getInstance();
        cardView=(CardView)findViewById(R.id.cardView);
        cardView2=(CardView)findViewById(R.id.cardView2);
        cardView3=(CardView)findViewById(R.id.cardView3);
        cardView4=(CardView)findViewById(R.id.cardView4);
        cardView5=(CardView)findViewById(R.id.cardView5);
        cardView6=(CardView)findViewById(R.id.cardView6);
        cardView7=(CardView)findViewById(R.id.cardView7);
        cardView8=(CardView)findViewById(R.id.cardView8);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  Intent intent=new Intent(grid.this,onlineconsult.class);
                  startActivity(intent);
            }
        });
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(grid.this,StudentPortal_Upload.class);
                startActivity(intent);

            }
        });
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(grid.this,ContactUsActivity.class);
                startActivity(intent);

            }
        });
        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        cardView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(grid.this,Apponintment.class);
                startActivity(intent);
            }
        });
        cardView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}

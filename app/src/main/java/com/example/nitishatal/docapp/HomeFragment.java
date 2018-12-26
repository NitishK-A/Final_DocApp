package com.example.nitishatal.docapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridView;

import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    CardView cardView,cardView2,cardView3,cardView4,cardView5,cardView6,cardView7,cardView8;
    FirebaseDatabase firebaseDatabase;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_home, container, false);




        firebaseDatabase=FirebaseDatabase.getInstance();
        cardView=(CardView) root.findViewById(R.id.cardView);
        cardView2=(CardView) root.findViewById(R.id.cardView2);
        cardView3=(CardView) root.findViewById(R.id.cardView3);
        cardView4=(CardView) root.findViewById(R.id.cardView4);
        cardView5=(CardView) root.findViewById(R.id.cardView5);
        cardView6=(CardView) root.findViewById(R.id.cardView6);
        cardView7=(CardView) root.findViewById(R.id.cardView7);
        cardView8=(CardView) root.findViewById(R.id.cardView8);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity().getApplicationContext(),onlineconsult.class);
                startActivity(intent);
            }
        });
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity().getApplicationContext(),StudentPortal_Upload.class);
                startActivity(intent);

            }
        });
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity().getApplicationContext(),MainActivity.class);
                startActivity(intent);

            }
        });
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity().getApplicationContext(),ContactUsActivity.class);
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
                Intent intent=new Intent(getActivity().getApplicationContext(),Apponintment.class);
                startActivity(intent);
            }
        });
        cardView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return root;


    }

}

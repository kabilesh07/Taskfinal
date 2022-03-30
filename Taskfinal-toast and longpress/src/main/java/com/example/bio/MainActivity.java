package com.example.bio;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    //Initalizing
    RecyclerView recycle;
    ArrayList<Mainmodel> mainmodel;
    Mainadapter mainadapter;


    //create integer array
    Integer [] r = {R.drawable.burger,R.drawable.pizza,R.drawable.shusi,R.drawable.snacks,R.drawable.burger,R.drawable.pizza,R.drawable.shusi,R.drawable.snacks};
    String [] langname = {"burger","pizza","shusi","snacks","burger","pizza","shusi","snacks"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycle = findViewById( R.id.recyclerview);




        //array list
        mainmodel = new ArrayList<>();


        //for condition
        for (int i =0;i<langname.length;i++){
            Mainmodel model = new Mainmodel( r[i],langname[i] );
            mainmodel.add( model );

        }

        //Horizontal layout
        LinearLayoutManager layoutManager = new LinearLayoutManager( MainActivity.this,LinearLayoutManager.HORIZONTAL,false );
        recycle.setLayoutManager( layoutManager ); // it set into recycler view
        mainadapter = new Mainadapter( mainmodel, MainActivity.this );


        //set adaptor to recycleview
        recycle.setAdapter( mainadapter );
    }



}
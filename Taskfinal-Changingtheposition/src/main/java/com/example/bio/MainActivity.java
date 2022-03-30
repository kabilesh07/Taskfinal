package com.example.bio;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    //Initalizing
    RecyclerView recycle;
    ArrayList<Mainmodel> mainmodel;
    Mainadapter mainadapter;
    View dialog;
    Activity activity;


    //create integer array
    Integer [] r = {R.drawable.burger,R.drawable.pizza, R.drawable.burger,R.drawable.snacks,R.drawable.burger,R.drawable.pizza,R.drawable.shusi,R.drawable.snacks,R.drawable.burger,R.drawable.pizza, R.drawable.burger,R.drawable.snacks};
    String [] langname = {"burger","pizza","shusi","snacks","burger","pizza","shusi","snacks","burger","pizza","shusi","snacks"};


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        activity= MainActivity.this;
        recycle = findViewById( R.id.recyclerview);
//        dialog = findViewById( R.id.textView);




        //array list
        mainmodel = new ArrayList<>();


        //for condition
        for (int i =0;i<langname.length;i++){

            Mainmodel model = new Mainmodel(r[i],langname[i] );
            mainmodel.add(model);



        }

        //Horizontal layout
        LinearLayoutManager layoutManager = new LinearLayoutManager( MainActivity.this,LinearLayoutManager.HORIZONTAL,false );
        recycle.setLayoutManager( layoutManager ); // it set into recycler view

        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView( recycle );



        mainadapter = new Mainadapter( mainmodel, MainActivity.this, recycle );
        recycle.setAdapter( mainadapter );
    }

}
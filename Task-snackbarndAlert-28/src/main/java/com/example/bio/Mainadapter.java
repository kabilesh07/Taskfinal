package com.example.bio;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
public class Mainadapter extends RecyclerView.Adapter<Mainadapter.ViewHolder> {
    ArrayList<Mainmodel> mainmodels;
    Context context;
    Activity activity;

    public Mainadapter(ArrayList<Mainmodel> mainmodels, Context context, Activity activity) {
        this.mainmodels = mainmodels;
        this.context = context;
        this.activity = activity;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.row_item, parent, false );
        return new ViewHolder( view );

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.imageView.setImageResource( mainmodels.get( position ).getR() );
        holder.textView.setText( mainmodels.get( position ).getLangname() );

        holder.itemView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make( view, "Clicked "+mainmodels.get( position ).getLangname(), Snackbar.LENGTH_LONG )
                        .setAction( "Ok", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Snackbar snackbar = null;
//                                snackbar.dismiss();
                            }
                        } )
                        .setActionTextColor( context.getResources().getColor( android.R.color.holo_purple ) )
                        .show();final Snackbar snackbar;
            }
        } );

        holder.itemView.setOnLongClickListener( new View.OnLongClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public boolean onLongClick(View view) {

                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
                LayoutInflater inflater = activity.getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.sample_dialogue, null);
                dialogBuilder.setView(dialogView);

                TextView textView = (TextView) dialogView.findViewById(R.id.textView);
                textView.setText("Hey you have selected the item "+ mainmodels.get( position ).getLangname());

                ImageView imageView = (ImageView) dialogView.findViewById(R.id.images_icon);
                imageView.setImageResource(mainmodels.get( position ).getR());

                Button button = (Button) dialogView.findViewById(R.id.button_ok);
                button.setText( "Selected item is "+ mainmodels.get( position ).getLangname() );
                AlertDialog alertDialog = dialogBuilder.create();
                button.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        alertDialog.dismiss();

                    }
                } );
                alertDialog.show();
                return false;

//                AlertDialog.Builder builder = new AlertDialog.Builder( context );
//                builder.setMessage( "Hey you have selected the item "+ mainmodels.get( position ).getLangname().toUpperCase() );
//                builder.setCancelable( true );
//
//
//                builder.setPositiveButton( "yes i have selected "+mainmodels.get( position ).getLangname().toUpperCase(), new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        return;
//
//                    }
//                } );
//
//                AlertDialog alertDialog = builder.create();
//                alertDialog.show();
//                return false;
            }
        } );
    }





    @Override
    public int getItemCount() {
        return mainmodels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public Object setOnclick;
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super( itemView );
            //getting image and text view
            imageView = itemView.findViewById( R.id.image_view );
            textView = itemView.findViewById( R.id.Textview );
        }
    }
}
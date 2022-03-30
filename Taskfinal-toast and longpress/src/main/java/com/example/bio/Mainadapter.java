package com.example.bio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Mainadapter extends RecyclerView.Adapter<Mainadapter.ViewHolder> {


    ArrayList<Mainmodel> mainmodels;
    Context context;


    public Mainadapter(ArrayList<Mainmodel> mainmodels, Context context) {
        this.mainmodels = mainmodels;
        this.context = context;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from( parent.getContext() ).inflate(R.layout.row_item,parent,false);
        return new ViewHolder( view );

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.imageView.setImageResource( mainmodels.get(position).getR());
        holder.textView.setText( mainmodels.get(position).getLangname());
        holder.itemView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText( context,"clicked "+mainmodels.get(position).getLangname(),Toast.LENGTH_LONG ).show();
            }
        } );

        holder.itemView.setOnLongClickListener( new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText( context,"long clicked "+mainmodels.get(position).getLangname(),Toast.LENGTH_LONG ).show();
                return true;
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
        TextView  textView;
        public ViewHolder(@NonNull View itemView) {
            super( itemView );

            //getting image and text view
            imageView = itemView.findViewById( R.id.image_view );
            textView =  itemView.findViewById( R.id.Textview );
        }

    }
}

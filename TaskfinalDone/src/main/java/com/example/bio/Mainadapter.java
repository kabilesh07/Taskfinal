package com.example.bio;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class Mainadapter extends RecyclerView.Adapter<Mainadapter.ViewHolder> {
    ArrayList<Mainmodel> mainmodels;
    MainActivity context;
    RecyclerView recyclerView;
    int selectedPosition = 0;
    int width,height;

    public Mainadapter(ArrayList<Mainmodel> mainmodels, MainActivity context, RecyclerView recyclerView) {
        this.mainmodels = mainmodels;
        this.context = context;
        this.recyclerView = recyclerView;
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
        if (selectedPosition == position) {
            holder.cvMain.setScaleX( 1.1F );
            holder.cvMain.setScaleY( 1.1F );
            LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (layoutManager != null) {
                layoutManager.scrollToPositionWithOffset( position, 0 );
            }
        } else {
            holder.cvMain.setScaleX( 1F );
            holder.cvMain.setScaleY( 1F );
        }

//        holder.itemView.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                LinearLayoutManager layoutManager  = (LinearLayoutManager) recyclerView.getLayoutManager();
//                if (layoutManager != null) {
//                    layoutManager.scrollToPositionWithOffset( position, 0 );
//                }
//            }
//        } );

        holder.itemView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedPosition = position;
                notifyDataSetChanged();
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
        LinearLayout onclick;
        CardView cvMain;

        public ViewHolder(@NonNull View itemView) {
            super( itemView );
            //getting image and text view
            imageView = itemView.findViewById( R.id.image_view );
            textView = itemView.findViewById( R.id.Textview );
            onclick = itemView.findViewById( R.id.onclick );
            cvMain = itemView.findViewById( R.id.cv_main );
        }
    }
}
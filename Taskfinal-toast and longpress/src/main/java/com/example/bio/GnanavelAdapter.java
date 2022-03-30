package com.example.bio;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GnanavelAdapter extends RecyclerView.Adapter<GnanavelAdapter.ViewHolder> {
    @NonNull
    @Override
    public GnanavelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate( parent.getContext(), R.layout.row_item, null);
        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull GnanavelAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super( itemView );
        }
    }
}

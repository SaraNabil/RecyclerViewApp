package com.example.recyclerviewapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private Context context;
    private ArrayList<RecyclerModel> modelRv;

    public RecyclerAdapter(Context context, ArrayList<RecyclerModel> modelRv) {
        this.context = context;
        this.modelRv = modelRv;
    }


    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_listview, viewGroup, false);
        return new RecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, final int position) {

        int imgUrl = modelRv.get(position).getImage();
        Picasso.get().load(imgUrl).into(holder.imageIv);

        holder.nameTv.setText(modelRv.get(position).getName());

        holder.priceTv.setText(modelRv.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return modelRv.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.nameTv)
        TextView nameTv;
        @BindView(R.id.priceTv)
        TextView priceTv;
        @BindView(R.id.imageIv)
        ImageView imageIv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


    }
}

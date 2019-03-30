package com.example.tmdbfilmes.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tmdbfilmes.R;
import com.example.tmdbfilmes.model.Result;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolderFeed> {

    List<Result> resultList;
    Context context;

    public AdapterRecyclerView(List<Result> resultList, Context context) {
        this.resultList = resultList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderFeed onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        return new ViewHolderFeed(inflater.inflate(R.layout.item_recycler,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderFeed holder, int position) {
        Result result = resultList.get(position);
        holder.bind(result.getTitle(),result.getBackdropPath());

    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public class ViewHolderFeed extends RecyclerView.ViewHolder{
        TextView title;
        ImageView image;



        public ViewHolderFeed(View itemView) {
            super(itemView);

            this.title = itemView.findViewById(R.id.titleTextView);
            this.image = itemView.findViewById(R.id.image_feed);


        }
        public void bind (String titulo, String endPointImage){
            this.title.setText(titulo);

            String path = "https://image.tmdb.org/t/p/w500/";
            Picasso.get().load(path+endPointImage).into(this.image);
        }
    }
}

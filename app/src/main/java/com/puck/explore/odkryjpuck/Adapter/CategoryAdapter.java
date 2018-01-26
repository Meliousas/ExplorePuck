package com.puck.explore.odkryjpuck.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.puck.explore.odkryjpuck.MenuActivity;
import com.puck.explore.odkryjpuck.R;
import com.puck.explore.odkryjpuck.model.CategoryItem;

import java.util.List;

/**
 * Created by Mela on 2018-01-25.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private Context context;
    private List<CategoryItem> movies;

    public CategoryAdapter(Context context, List<CategoryItem> movies) {
        this.context = context;
        this.movies = movies;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.movieName.setText(movies.get(position).getName());
        holder.movieGenre.setText(movies.get(position).getAddress());
        Glide.with(context).load(movies.get(position).getImageSrc()).into(holder.imageView);
    }


    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView movieName;
        public TextView movieGenre;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            movieName = (TextView) itemView.findViewById(R.id.moviename);
            imageView = (ImageView) itemView.findViewById(R.id.image);
            movieGenre = (TextView) itemView.findViewById(R.id.genre);
            imageView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
          //  int position = getAdapterPosition();
            Intent intent = new Intent(context, MenuActivity.class);
            context.startActivity(intent);
        }
    }

}

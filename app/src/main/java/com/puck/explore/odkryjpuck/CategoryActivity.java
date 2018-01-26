package com.puck.explore.odkryjpuck;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.puck.explore.odkryjpuck.Adapter.CategoryAdapter;
import com.puck.explore.odkryjpuck.model.CategoryItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mela on 2017-12-30.
 */

public class CategoryActivity extends AppCompatActivity{

    private static final String TAG = CategoryActivity.class.getSimpleName();
    private List<CategoryItem> movies;
    private RecyclerView recyclerView;
    private GridLayoutManager gridLayout;
    private CategoryAdapter adapter;

 protected void onCreate(Bundle savedInstanceState) {

     super.onCreate(savedInstanceState);
     setContentView(R.layout.item_category_view2);

     recyclerView = findViewById(R.id.recyclerview);
     movies = new ArrayList<>();
     // getMoviesFromDB(0);

     gridLayout = new GridLayoutManager(this, 2);
     recyclerView.setLayoutManager(gridLayout);

     adapter = new CategoryAdapter(this, movies);
     recyclerView.setAdapter(adapter);

     recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
         @Override
         public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

             if (gridLayout.findLastCompletelyVisibleItemPosition() == movies.size() - 1) {
                 //  getMoviesFromDB(movies.get(movies.size() - 1).getId());
             }

         }
     });
 }}





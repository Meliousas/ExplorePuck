package com.puck.explore.odkryjpuck;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.puck.explore.odkryjpuck.Adapter.DiscoverAdapter;
import com.puck.explore.odkryjpuck.model.CategoryItem;
import com.puck.explore.odkryjpuck.model.Discover;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Mela on 2017-12-30.
 */

public class DiscoverActivity extends AppCompatActivity{

    private static final String TAG = DiscoverActivity.class.getSimpleName();
    private List<CategoryItem> movies;
    private RecyclerView recyclerView;
    private GridLayoutManager gridLayout;
    private DiscoverAdapter adapter;

 protected void onCreate(Bundle savedInstanceState) {

     super.onCreate(savedInstanceState);
     setContentView(R.layout.item_category_view2);

     recyclerView = findViewById(R.id.recyclerview);
     movies = new ArrayList<>();
     getMoviesFromDB(0);

     gridLayout = new GridLayoutManager(this, 2);
     recyclerView.setLayoutManager(gridLayout);

     adapter = new DiscoverAdapter(this, movies);
     recyclerView.setAdapter(adapter);

     recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
         @Override
         public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

             if (gridLayout.findLastCompletelyVisibleItemPosition() == movies.size() - 1) {
                   getMoviesFromDB(movies.get(movies.size() - 1).getId());
             }

         }
     });
 }

    private void getMoviesFromDB(int id) {
        AsyncTask<Integer, Void, Void> asyncTask = new AsyncTask<Integer, Void, Void>() {
            @Override
            protected Void doInBackground(Integer... movieIds) {

                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                            .url("http://localhost/op.php?id=" + movieIds[0])
                        .build();
                try {
                    Response response = client.newCall(request).execute();

                    JSONArray array = new JSONArray(response.body().string());

                    for (int i = 0; i < array.length(); i++) {

                        JSONObject object = array.getJSONObject(i);

                        Discover movie = new Discover(object.getInt("id"), object.getString("name"), object.getString("desc"),
                        object.getString("img"), object.getString("category"), object.getString("address"));

                        DiscoverActivity.this.movies.add(movie);
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                adapter.notifyDataSetChanged();
            }
        };

        asyncTask.execute(id);
}
}





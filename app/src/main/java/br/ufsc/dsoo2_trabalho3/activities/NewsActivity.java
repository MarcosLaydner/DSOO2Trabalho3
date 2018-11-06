package br.ufsc.dsoo2_trabalho3.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;

import br.ufsc.dsoo2_trabalho3.R;
import br.ufsc.dsoo2_trabalho3.adapters.NewsAdapter;

public class NewsActivity extends AppCompatActivity {


    private JSONArray jsonArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        setDataset();

        RecyclerView recyclerView = findViewById(R.id.newsItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new NewsAdapter(this, jsonArray));
    }


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_enterprises);
//        setDataset();
//
//        RecyclerView recyclerView = findViewById(R.id.eRecyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(new EnterprisesAdapter(this, jsonArray));
//    }

    public void setDataset() {

        String json;

        try {
            InputStream is = getAssets().open("News.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");
            jsonArray = new JSONArray(json);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}

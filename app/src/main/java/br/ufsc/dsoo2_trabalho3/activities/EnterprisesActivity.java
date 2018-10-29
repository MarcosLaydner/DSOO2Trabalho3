package br.ufsc.dsoo2_trabalho3.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import br.ufsc.dsoo2_trabalho3.R;
import br.ufsc.dsoo2_trabalho3.adapters.EnterprisesAdapter;

public class EnterprisesActivity extends AppCompatActivity {

    private String[] dataset = {"item 1","item 2","item 3","item 4","item 5","item 6"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterprises);

        RecyclerView recyclerView = findViewById(R.id.eRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new EnterprisesAdapter(this, dataset));

    }
}

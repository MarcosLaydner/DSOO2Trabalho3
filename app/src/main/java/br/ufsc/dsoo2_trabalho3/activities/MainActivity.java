package br.ufsc.dsoo2_trabalho3.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import br.ufsc.dsoo2_trabalho3.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btNews = findViewById(R.id.btNews);
        btNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), NewsActivity.class);
                startIntent.putExtra("br.ufsc.dsoo2.quicklaucher.SOMETHING", "HELLO WORLD!");
                startActivity(startIntent);
            }
        });
        Button btEnterprises = findViewById(R.id.btEnterprises);
        btEnterprises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), EnterprisesActivity.class);
                startActivity(startIntent);
            }
        });

    }
}

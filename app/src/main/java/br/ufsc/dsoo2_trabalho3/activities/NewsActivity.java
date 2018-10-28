package br.ufsc.dsoo2_trabalho3.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import br.ufsc.dsoo2_trabalho3.R;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        if (getIntent().hasExtra("br.ufsc.dsoo2.quicklaucher.SOMETHING")) {
            TextView tv = findViewById(R.id.tv);
            String text = getIntent().getExtras().getString("br.ufsc.dsoo2.quicklaucher.SOMETHING");
            tv.setText(text);
        }
    }
}

package br.ufsc.dsoo2_trabalho3.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import br.ufsc.dsoo2_trabalho3.R;
import br.ufsc.dsoo2_trabalho3.activities.MapsActivity;

public class EnterprisesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    String[] dataset;

    public EnterprisesAdapter(Context context, String[] dataset) {
        this.context = context;
        this.dataset = dataset;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.enterprise_item, parent, false);
        Item item = new Item(row);
        return item;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((Item) holder).textView.setText(dataset[position]);
        ((Item) holder).btMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(context, MapsActivity.class);
                context.startActivity(startIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataset.length;
    }

    public class Item extends RecyclerView.ViewHolder {
        TextView textView;
        Button btMap;
        Button btVideo;
        public Item(View itemView){
            super(itemView);
            textView = itemView.findViewById(R.id.eItem);
            btMap = itemView.findViewById(R.id.btMap);
            btVideo = itemView.findViewById(R.id.btVideo);

        }
    }
}
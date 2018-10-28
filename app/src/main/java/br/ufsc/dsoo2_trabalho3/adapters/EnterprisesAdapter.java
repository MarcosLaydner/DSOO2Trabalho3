package br.ufsc.dsoo2_trabalho3.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.ufsc.dsoo2_trabalho3.R;

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
    }

    @Override
    public int getItemCount() {
        return dataset.length;
    }

    public class Item extends RecyclerView.ViewHolder {
        TextView textView;
        public Item(View itemView){
            super(itemView);
            textView = itemView.findViewById(R.id.eItem);
        }
    }
}
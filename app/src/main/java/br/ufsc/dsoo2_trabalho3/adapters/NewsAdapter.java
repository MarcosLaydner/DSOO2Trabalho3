package br.ufsc.dsoo2_trabalho3.adapters;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.ufsc.dsoo2_trabalho3.R;
import br.ufsc.dsoo2_trabalho3.activities.NewsActivity;
import br.ufsc.dsoo2_trabalho3.listeners.ItemClickListener;

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    JSONArray dataset;

    public NewsAdapter(Context context, JSONArray dataset) {
        this.context = context;
        this.dataset = dataset;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.news_item, parent, false);
        Item item = new Item(row);
        return item;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        try {

            ((Item) holder).nameTv.setText(dataset.getJSONObject(position).getString("name") );
            ((Item) holder).textTv.setText(dataset.getJSONObject(position).getString("text") );


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return dataset.length();
    }

    public class Item extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView nameTv;
        TextView textTv;

        private ItemClickListener itemClickListener;

        public Item(View itemView){
            super(itemView);
            nameTv = itemView.findViewById(R.id.nameTv);
            textTv = itemView.findViewById(R.id.textTv);
            itemView.setOnClickListener(this);

        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
//            try {
//                itemClickListener.onClick(v,getAdapterPosition());
//            } catch (JSONException e) {
//            }
        }
    }


}

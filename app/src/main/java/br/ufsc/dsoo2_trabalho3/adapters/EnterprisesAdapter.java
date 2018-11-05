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

import com.google.android.youtube.player.YouTubeStandalonePlayer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.ufsc.dsoo2_trabalho3.R;
import br.ufsc.dsoo2_trabalho3.activities.MapsActivity;
import br.ufsc.dsoo2_trabalho3.listeners.ItemClickListener;

public class EnterprisesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    JSONArray dataset;

    public EnterprisesAdapter(Context context, JSONArray dataset) {
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
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        try {

            ((Item) holder).textView.setText(dataset.getJSONObject(position).getString("name") );

            ((Item) holder).btMap.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent startIntent = new Intent(context, MapsActivity.class);
                    try {
                        startIntent.putExtra("latitude", Float.parseFloat(dataset.getJSONObject(position).get("latitude").toString()));
                        startIntent.putExtra("longitude", Float.parseFloat(dataset.getJSONObject(position).get("longitude").toString()));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    context.startActivity(startIntent);
                }
            });

            ((Item) holder).btVideo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    try {
                        Intent intent = YouTubeStandalonePlayer.createVideoIntent((Activity)context, "AIzaSyAXIuxZLdLGKAgYPL6zZzPa_JWrWNm97h8", dataset.getJSONObject(position).get("videoUrl").toString(), 0, true, false);
                        context.startActivity(intent);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            });

            ((Item) holder).setItemClickListener(new ItemClickListener() {
                @Override
                public void onClick(View view, int position) throws JSONException {
                    JSONObject obj = dataset.getJSONObject(position);
                    new AlertDialog.Builder(context)
                            .setTitle("Sobre")
                            .setMessage("Nome: " + obj.getString("name")
                            + "\n\nEndereço: " + obj.getString("address")
                            + "\n\nNumero de quartos: " + obj.getInt("roomQnt")
                            + "\n\nPrazo de entrega: " + obj.getString("finishingDate")
                            + "\n\nValor: R$" + obj.getInt("price") + ",00"
                            + "\n\nPrazo de Financiamento: " + obj.getString("prazoFinanciamento") + "meses")
                            .setPositiveButton("OK", null)
                            .create().show();
                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return dataset.length();
    }

    public class Item extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textView;
        Button btMap;
        Button btVideo;

        private ItemClickListener itemClickListener;

        public Item(View itemView){
            super(itemView);
            textView = itemView.findViewById(R.id.eItem);
            btMap = itemView.findViewById(R.id.btMap);
            btVideo = itemView.findViewById(R.id.btVideo);
            itemView.setOnClickListener(this);

        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            try {
                itemClickListener.onClick(v,getAdapterPosition());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}

//YouTubeStandalonePlayer.createVideoIntent(context, 'AIzaSyAXIuxZLdLGKAgYPL6zZzPa_JWrWNm97h8', dataset.getJSONObject(position).get("videoUrl"));
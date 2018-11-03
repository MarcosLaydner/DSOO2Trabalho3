package br.ufsc.dsoo2_trabalho3.listeners;

import android.view.View;

import org.json.JSONException;

public interface ItemClickListener  {
    void onClick(View view, int position) throws JSONException;
}

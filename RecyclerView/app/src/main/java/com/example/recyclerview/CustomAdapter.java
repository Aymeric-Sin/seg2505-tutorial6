package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private final String[] localDataSet;

    // Référence aux vues d'un élément de la liste (ViewHolder).

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.textView);
        }

        public TextView getTextView() {
            return textView;
        }
    }

    // @param dataSet tableau de chaînes à afficher
    public CustomAdapter(String[] dataSet) {
        localDataSet = dataSet;
    }

    // Crée de nouvelles vues (appelé par le LayoutManager)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);
        return new ViewHolder(view);
    }

    // Remplace le contenu d'une vue (appelé par le LayoutManager)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        viewHolder.getTextView().setText(localDataSet[position]);
    }

    // Retourne la taille du jeu de données (appelé par le LayoutManager)
    @Override
    public int getItemCount() {
        return localDataSet.length;
    }
}
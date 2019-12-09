package com.example.aplicacion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerFondasAdapter extends RecyclerView.Adapter<RecyclerFondasAdapter.ViewHolder> {


    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nombre;
        private ImageView img;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.txtF);
            img = itemView.findViewById(R.id.imgV);
        }
    }
    private List<NegocioModel> lista;

    public RecyclerFondasAdapter(List<NegocioModel> lista) {
        this.lista = lista;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_food,parent,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nombre.setText(lista.get(position).getName());
        holder.img.setImageResource(lista.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}

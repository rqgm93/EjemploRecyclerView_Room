package com.raquel.garvi.ejemplorecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.raquel.garvi.ejemplorecyclerview.room.DigimonDao;

import java.util.ArrayList;
import java.util.List;

public class DigimonAdapter extends RecyclerView.Adapter<DigimonAdapter.DigimonViewHolder> {

    private List<Digimon> digimonList;
    private DigimonDao digimonDao;
    Context context;

    public DigimonAdapter(List<Digimon> digimonList, DigimonDao digimonDao, Context context) {
        this.digimonList = digimonList;
        this.digimonDao = digimonDao;
        this.context = context;
    }

    @NonNull
    @Override
    public DigimonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_digimon, parent, false);
        return new DigimonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DigimonViewHolder holder, int position) {
        Digimon digimon = digimonList.get(position);
        holder.txtName.setText(digimon.getName());
        holder.txtType.setText(digimon.getType());
        holder.txtLevel.setText("Nivel: " + digimon.getLevel());
    }

    @Override
    public int getItemCount() {
        return digimonList.size();
    }

    // Método para eliminar un ítem de la lista
    public void deleteItem(int position) {
        Digimon digimon = digimonList.get(position);
        digimonList.remove(position); // Eliminar el ítem de la lista
        notifyItemRemoved(position); // Notificar al adaptador que un ítem ha sido eliminado
        Toast.makeText(context, "Digimon elimiado", Toast.LENGTH_SHORT).show();

        // Eliminar el ítem de la base de datos
        new Thread(new Runnable() {
            @Override
            public void run() {
                digimonDao.delete(digimon);
            }
        }).start();
    }

    public static class DigimonViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtType, txtLevel;

        public DigimonViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtType = itemView.findViewById(R.id.txtType);
            txtLevel = itemView.findViewById(R.id.txtLevel);
        }
    }
}

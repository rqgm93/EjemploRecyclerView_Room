package com.raquel.garvi.ejemplorecyclerview;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

// Clase que maneja los gestos de deslizamiento para eliminar ítems
public class SwipeToDeleteCallback extends ItemTouchHelper.SimpleCallback {

    private DigimonAdapter digimonAdapter;

    // Constructor que recibe el adaptador
    public SwipeToDeleteCallback(DigimonAdapter digimonAdapter) {
        super(0, ItemTouchHelper.LEFT);
        this.digimonAdapter = digimonAdapter;
    }

    // No necesitamos mover ítems, así que retornamos false
    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
    }

    // Método que se llama cuando un ítem es deslizado
    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        int position = viewHolder.getAdapterPosition();
        digimonAdapter.deleteItem(position); // Eliminar el ítem del adaptador
    }
}

package com.raquel.garvi.ejemplorecyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DigimonAdapter adapter;
    private ArrayList<Digimon> digimonList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recyclerViewDigimon);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        digimonList = new ArrayList<>();
        // Agregar algunos Digimon de ejemplo
        digimonList.add(new Digimon("Agumon", "Reptil", "Infantil"));
        digimonList.add(new Digimon("Gatomon", "Bestia Sagrada", "Adulto"));

        adapter = new DigimonAdapter(digimonList);
        recyclerView.setAdapter(adapter);
    }
}
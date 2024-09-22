package com.raquel.garvi.ejemplorecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.raquel.garvi.ejemplorecyclerview.room.DatabaseClient;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DigimonAdapter digimonAdapter;
    private List<Digimon> digimonList;
    private RecyclerView recyclerView;
    private Button add_digimon;

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


        // Cargar los Digimons y mostrarlos
        loadDigimons();

        // añadir digimon
        add_digimon = findViewById(R.id.add_digimon);

        add_digimon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add_digimon();
            }
        });
    }

    private void loadDigimons() {
        digimonList = DatabaseClient.getInstance(getApplicationContext()).getDigimonDatabase().digimonDao().getAllDigimons();
        digimonAdapter = new DigimonAdapter(digimonList);
        recyclerView.setAdapter(digimonAdapter);
    }

    private void add_digimon() {
        Intent intentAddDigimon = new Intent(this, AddDigimonActivity.class);
        startActivity(intentAddDigimon);
    }
}
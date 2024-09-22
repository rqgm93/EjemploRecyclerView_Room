package com.raquel.garvi.ejemplorecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.raquel.garvi.ejemplorecyclerview.room.DatabaseClient;

public class AddDigimonActivity extends AppCompatActivity {

    private EditText editTextName, editTextType, editTextLevel;
    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_digimon);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Referencias a las vistas
        editTextName = findViewById(R.id.editTextName);
        editTextType = findViewById(R.id.editTextType);
        editTextLevel = findViewById(R.id.editTextLevel);
        buttonSave = findViewById(R.id.buttonSave);

        // Acción del botón para guardar el Digimon
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDigimon();
            }
        });
    }

    private void saveDigimon() {
        String name = editTextName.getText().toString();
        String type = editTextType.getText().toString();
        String level = editTextLevel.getText().toString();

        // Validar que los campos no estén vacíos
        if (name.isEmpty() || type.isEmpty() || level.isEmpty()) {
            Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        // Crear objeto Digimon
        Digimon digimon = new Digimon(name, type, level);

        // Insertar Digimon en la base de datos usando Room
        DatabaseClient.getInstance(getApplicationContext()).getDigimonDatabase().digimonDao().insert(digimon);

        // Mostrar mensaje de éxito
        Toast.makeText(this, "Digimon añadido", Toast.LENGTH_SHORT).show();

        // Finalizar la actividad y volver a la actividad principal
        startActivity(new Intent(this, MainActivity.class));
    }
}
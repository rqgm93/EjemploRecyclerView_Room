package com.raquel.garvi.ejemplorecyclerview.room;
import android.content.Context;
import androidx.room.Room;

public class DatabaseClient {

    private Context context;
    private static DatabaseClient instance;
    private DigimonDatabase digimonDatabase;

    private DatabaseClient(Context context) {
        this.context = context;
        digimonDatabase = Room.databaseBuilder(context, DigimonDatabase.class, "DigimonDB")
                .allowMainThreadQueries()
                .build();
    }

    public static synchronized DatabaseClient getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseClient(context);
        }
        return instance;
    }

    public DigimonDatabase getDigimonDatabase() {
        return digimonDatabase;
    }
}

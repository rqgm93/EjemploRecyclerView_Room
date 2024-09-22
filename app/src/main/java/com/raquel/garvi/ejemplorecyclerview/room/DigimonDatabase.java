package com.raquel.garvi.ejemplorecyclerview.room;
import com.raquel.garvi.ejemplorecyclerview.Digimon;
import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Digimon.class}, version = 1)
public abstract class DigimonDatabase extends RoomDatabase {
    public abstract DigimonDao digimonDao();
}

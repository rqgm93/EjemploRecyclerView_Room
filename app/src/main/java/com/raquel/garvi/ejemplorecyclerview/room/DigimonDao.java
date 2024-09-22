package com.raquel.garvi.ejemplorecyclerview.room;

import com.raquel.garvi.ejemplorecyclerview.Digimon;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DigimonDao {

    @Insert
    void insert(Digimon digimon);

    @Query("SELECT * FROM Digimon")
    List<Digimon> getAllDigimons();
}


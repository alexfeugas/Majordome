package fr.afe.majordome.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;


@Entity(tableName = "Stock")
public class StockEntity implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "StockId")
    public int stockId;

    public String stockName;
}

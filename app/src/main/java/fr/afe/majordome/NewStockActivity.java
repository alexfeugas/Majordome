package fr.afe.majordome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

import fr.afe.majordome.entities.StockEntity;
import fr.afe.majordome.entities.TaskEntity;

public class NewStockActivity extends AppCompatActivity {

    private StockEntity stockEntity;
    private EditText stockNameEditText;
    private NumberPicker quantityNumberPicker;
    private Button okButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_stock);
        stockNameEditText = findViewById(R.id.stockNameEditText);
        quantityNumberPicker = findViewById(R.id.quantityPicker);
        quantityNumberPicker.setMinValue(0);
        quantityNumberPicker.setMaxValue(200);
        quantityNumberPicker.setValue(1);
        okButton = findViewById(R.id.buttonOKStock);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Control data

                // Collect data and create entity
                if (stockEntity == null)
                    stockEntity = new StockEntity();
                stockEntity.stockName = stockNameEditText.getText().toString();
                stockEntity.quantity = quantityNumberPicker.getValue();


                // return it.
                Intent replyIntent = new Intent();
                replyIntent.putExtra("EXTRA_REPLY", stockEntity);
                setResult(RESULT_OK, replyIntent);
                finish();
            }
        });
        // Displaying an existing one ?
        Intent intent = getIntent();
        stockEntity = (StockEntity) intent.getSerializableExtra("STOCK");
        if (stockEntity != null) {
            stockNameEditText.setText(stockEntity.stockName);
            quantityNumberPicker.setValue(stockEntity.quantity);
        }
    }
}

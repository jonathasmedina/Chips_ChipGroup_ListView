package com.example.myapplicationapagar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button bt;
    ChipGroup cg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt  = findViewById(R.id.button2);
        cg  = findViewById(R.id.chipGroupChoice);

        bt.setOnClickListener(view -> {
            //recuperando itens selecionados em um grupo
            List<Integer> ids = cg.getCheckedChipIds();
            ArrayList<String> arrayList = new ArrayList<>();

            for (Integer id:ids){
                Log.e("id:", ""+id);
                Chip chip = cg.findViewById(id);
                String estilo = chip.getText().toString();
                arrayList.add(estilo);
            }
            Intent intent = new Intent(MainActivity.this, Tela2.class);
            intent.putExtra("esse", arrayList);
            startActivity(intent);
        });
    }
}
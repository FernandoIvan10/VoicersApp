package com.example.voicersapp;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;

import com.example.voicersapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    AdaptadorNombres adaptador;

    ArrayList<String> listaNombres = new ArrayList<String>(Arrays.asList("Potter","Ronald","Fulgencio","Traka","Bebote","Costas"));

    private final ActivityResultLauncher<Intent> activityResultLauncher
            = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),result->{
                if(result.getResultCode()== Activity.RESULT_OK){
                    ArrayList<String> data = result.getData()!=null?
                            result.getData().getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS):null;
                    if(data!=null){
                        binding.etNombre.setText(data.get(0));
                    }
                }
    });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.rvNombres.setLayoutManager(new LinearLayoutManager(this));
        adaptador = new AdaptadorNombres(listaNombres);
        binding.rvNombres.setAdaptador(adaptador);

        binding.ibtnMicrofono.setOnClickListener(
                
        );
    }
}
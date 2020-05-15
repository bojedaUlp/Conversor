package com.example.conversor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etEuros, etDolares;
    private TextView tvResultado;
    private RadioButton rbDolar, rbEuros;
    private Button btnC;
    private MainViewModel mv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();

       mv = ViewModelProviders.of(this).get(MainViewModel.class);
        mv.getDolar().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                rbDolar.setChecked(aBoolean);
            }
        });

        mv.getEuro().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                rbEuros.setChecked(aBoolean);
            }
        });


        mv.getResultado().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tvResultado.setText(s);
            }
        });


    }


    private void inicializar(){

        etEuros=findViewById(R.id.etEuro);
        etDolares=findViewById(R.id.etDolar);
        tvResultado=findViewById(R.id.tvResultado);
        rbDolar=findViewById(R.id.rbDolares);
        rbEuros=findViewById(R.id.rbEuros);
        btnC=findViewById(R.id.btnConvertir);

        rbEuros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mv.habilitarEt(etEuros);
                mv.deshabilitarEt(etDolares);
                mv.cambiarEstadoDolar();
            }
        });

        rbDolar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mv.habilitarEt(etDolares);
                mv.deshabilitarEt(etEuros);
                mv.cambiarEstadoEuro();
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mv.convertir(etDolares.getText().toString(),etEuros.getText().toString());
            }
        });

    }



}

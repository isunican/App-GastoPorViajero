package com.isunican.gastoporviajero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Declaramos campos para enlazar con widgets del layout
    private EditText etConsumo;
    private EditText etKm;
    private EditText etPrecio;
    private EditText etPasajeros;
    private TextView tvResultado;
    private Button btnCalcular;
    private Button btnInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // es importante llamar siempre al método de la clase padre, para inicializar
        // correctamente
        super.onCreate(savedInstanceState);

        // instancia la interfaz definida en el Layout activity_main.xml
        setContentView(R.layout.activity_main);

        // Enlazamos con los widgets del layout
        etConsumo = findViewById(R.id.etConsumo);
        etKm = findViewById(R.id.etKm);
        etPrecio = findViewById(R.id.etPrecio);
        etPasajeros = findViewById(R.id.etPasajeros);
        tvResultado = findViewById(R.id.tvResultado);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnInfo = findViewById(R.id.btnInfo);

        // Asignamos los listeners para los botones
        btnCalcular.setOnClickListener(this);
        btnInfo.setOnClickListener(this);
    }

    /**
     * Método de la interfaz View.onClickListener
     * @param view
     */
    @Override
    public void onClick(View view) {
        // listener para el boton calcular
        if (view.getId() == R.id.btnCalcular) {
            // convierte los Strings de los campos de texto en números (double)
            double consumo = Double.parseDouble(etConsumo.getText().toString());
            double km = Double.parseDouble(etKm.getText().toString());
            double precio = Double.parseDouble(etPrecio.getText().toString());
            double pasajeros = Double.parseDouble(etPasajeros.getText().toString());

            // calcula el resultado, y lo muestra en el TextView correspondiente
            double gasto = consumo*km*precio/(100*pasajeros);
            tvResultado.setText(String.valueOf(gasto));

        // listener para el boton información
        } else if (view.getId() == R.id.btnInfo) {
            // lanza la actividad InfoActivity
            Intent intent = new Intent(this, InfoActivity.class);
            startActivity(intent);
        }
    }
}
package com.victoribarra.formulariocontacto;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSiguiente =  findViewById(R.id.btnSiguiente);
        final EditText ietNombre = findViewById(R.id.ietnombre);
        final DatePicker datePicker = findViewById(R.id.dpfecha);
        final EditText ietTelefono = findViewById(R.id.iettelefono);
        final EditText ietEmail = findViewById(R.id.ietemail);
        final EditText ietDescripcion = findViewById(R.id.ietdescripciondelcontacto);
        
        Bundle bundle= getIntent().getExtras();
        if (bundle!=null){
            ietNombre.setText(bundle.getString("tvNombre", " "));
            datePicker.updateDate(bundle.getInt("dpaño"),bundle.getInt("dpmes"),bundle.getInt("dpdia"));
            ietTelefono.setText(bundle.getString("tvTelefono", " "));
            ietEmail.setText(bundle.getString("tvEmail", " "));
            ietDescripcion.setText(bundle.getString("tvDescripcion", " "));



        }
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, confirmacion_datos.class);
                i.putExtra("etnombre",ietNombre.getText().toString());
                i.putExtra("dpdia",datePicker.getDayOfMonth());
                i.putExtra("dpmes",datePicker.getMonth());
                i.putExtra("dpaño",datePicker.getYear());
                i.putExtra("ietTelefono",ietTelefono.getText().toString() );
                i.putExtra("ietEmail",ietEmail.getText().toString());
                i.putExtra("ietDescripcion", ietDescripcion.getText().toString());

                startActivity(i);
            }
        });
    }


}

package com.victoribarra.formulariocontacto;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class confirmacion_datos extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion_datos);

        Button btnEditar =  findViewById(R.id.btnEditar);
        final TextView tvNombre = findViewById(R.id.tvNombre);
        TextView Fecha = findViewById(R.id.Fecha);
        final TextView Telefono = findViewById(R.id.Telefono);
        final TextView Email = findViewById(R.id.Email);
        final TextView Descripcion = findViewById(R.id.Descripcion);
        final  int dia ;
        final int mes ;
        final int año ;

        Bundle bundle= getIntent().getExtras();
        if (bundle!=null){
            tvNombre.setText(bundle.getString("etnombre", " "));
            Telefono.setText( bundle.getString("ietTelefono"));
            Email.setText(bundle.getString("ietEmail"));
            Descripcion.setText( bundle.getString("ietDescripcion"));




        }
        dia = bundle.getInt("dpdia");
        mes =  bundle.getInt("dpmes");
        año =  bundle.getInt("dpaño");
        Fecha.setText( dia + "/" + (mes + 1) + "/" + año );


        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(confirmacion_datos.this, MainActivity.class);
                j.putExtra("tvNombre",tvNombre.getText().toString());
                j.putExtra( "dpdia", dia);
                j.putExtra("dpmes", mes);
                j.putExtra("dpaño", año);
                j.putExtra("tvTelefono",Telefono.getText().toString());
                j.putExtra("tvEmail", Email.getText().toString());
                j.putExtra("tvDescripcion", Descripcion.getText().toString());

                startActivity(j);
            }
       });

    }
}

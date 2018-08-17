package com.samerson.dadosactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    public TextView textoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        textoResultado = (TextView) findViewById(R.id.resultado_texto);

        Bundle extra = getIntent().getExtras();

        if (extra != null){
            String textoPassado = extra.getString("nome");
            textoResultado.setText(textoPassado);
        }


    }
}

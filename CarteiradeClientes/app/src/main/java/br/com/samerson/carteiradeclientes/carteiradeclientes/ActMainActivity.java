package br.com.samerson.carteiradeclientes.carteiradeclientes;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class ActMainActivity extends AppCompatActivity {

    private RecyclerView lsdDados;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       fab = (FloatingActionButton) findViewById(R.id.fab);
       lsdDados = (RecyclerView) findViewById(R.id.lsdDados);

    }

    public void cadastrar (View view) {

        //Intent chama outras páginas.
        Intent it = new Intent(ActMainActivity.this, ActCadCliente.class);
        startActivity(it);

    }

}

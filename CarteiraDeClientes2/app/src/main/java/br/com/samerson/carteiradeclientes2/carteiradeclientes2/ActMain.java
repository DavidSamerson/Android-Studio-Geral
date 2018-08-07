package br.com.samerson.carteiradeclientes2.carteiradeclientes2;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import br.com.samerson.carteiradeclientes2.carteiradeclientes2.Database.DadosOpenHelper;

public class ActMain extends AppCompatActivity {

    private SQLiteDatabase conexao;
    private Toolbar toolbar;
    private FloatingActionButton fab;
    private DadosOpenHelper dadosOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);

        this.fab = (FloatingActionButton) findViewById(R.id.fab);

    }

    private void criarConexao() {

        //bloco de código de testes
        try {

            

        } catch (SQLException ex) {

        }
    }

    public void cadastrar(View v) {

        Intent it = new Intent(ActMain.this, ActCadCliente.class);
        startActivity(it);

    }

}

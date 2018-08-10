package br.com.samerson.carteiradeclientes2.carteiradeclientes2;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.internal.SnackbarContentLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import java.util.List;

import br.com.samerson.carteiradeclientes2.carteiradeclientes2.Database.DadosOpenHelper;
import br.com.samerson.carteiradeclientes2.carteiradeclientes2.Dominio.Entidades.Clientes;
import br.com.samerson.carteiradeclientes2.carteiradeclientes2.Dominio.Repositorio.ClienteRepositorio;

public class ActMain extends AppCompatActivity {

    private SQLiteDatabase conexao;
    private Toolbar toolbar;
    private FloatingActionButton fab;
    private DadosOpenHelper dadosOpenHelper;
    private ConstraintLayout layoutContentMain;
    private RecyclerView lsdDados;
    private ClienteAdapter clienteAdapter;
    private ClienteRepositorio clienteRepositorio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);

        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);
        this.fab = (FloatingActionButton) findViewById(R.id.fab);
        this.layoutContentMain = (ConstraintLayout) findViewById(R.id.layoutContentMain);
        this.lsdDados = (RecyclerView) findViewById(R.id.lsdDados);

        criarConexao();

        // LinearLayout - instância
        LinearLayoutManager linearLayout = new LinearLayoutManager(ActMain.this);

        // Seta uma linear Layout na pagina
        lsdDados.setLayoutManager(linearLayout);

        clienteRepositorio = new ClienteRepositorio(conexao);

        List<Clientes> dados = clienteRepositorio.pesquisar();

        clienteAdapter = new ClienteAdapter(dados);

        lsdDados.setAdapter(clienteAdapter);

    }

    private void criarConexao() {

        //bloco de código de teste de conexão
        try {

            this.dadosOpenHelper = new DadosOpenHelper(this);
            this.conexao = this.dadosOpenHelper.getWritableDatabase();

            Snackbar.make(layoutContentMain, R.string.avisoDeConexaoCriada, Snackbar.LENGTH_LONG)
                    .setAction(R.string.action_menu_ok, null).show();

        } catch (SQLException ex) {

            AlertDialog.Builder alert = new AlertDialog.Builder(this);

            alert.setTitle(R.string.mensagem_erro);
            alert.setMessage(ex.getMessage());
            alert.setNeutralButton(R.string.action_menu_ok, null);
            alert.show();

        }
    }

    public void cadastrar(View v) {

        Intent it = new Intent(ActMain.this, ActCadCliente.class);
        startActivity(it);

    }

}

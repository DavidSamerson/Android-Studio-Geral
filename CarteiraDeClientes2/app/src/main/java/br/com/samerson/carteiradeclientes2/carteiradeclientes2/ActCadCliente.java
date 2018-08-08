package br.com.samerson.carteiradeclientes2.carteiradeclientes2;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import br.com.samerson.carteiradeclientes2.carteiradeclientes2.Database.DadosOpenHelper;
import br.com.samerson.carteiradeclientes2.carteiradeclientes2.Dominio.Entidades.Clientes;
import br.com.samerson.carteiradeclientes2.carteiradeclientes2.Dominio.Repositorio.ClienteRepositorio;

public class ActCadCliente extends AppCompatActivity {

    private EditText inputNome;
    private EditText inputEndereco;
    private EditText inputEmail;
    private EditText inputTelefone;
    private SQLiteDatabase conexao;
    private DadosOpenHelper dadosOpenHelper;
    private ConstraintLayout layoutContentMain;
    private ClienteRepositorio clienteRepositorio;
    private Clientes cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //aponta O LAYOUT
        setContentView(R.layout.act_cad_cliente);

        //toobars
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Declaração de atributos...
        inputNome = (EditText) findViewById(R.id.inputNome);
        inputEndereco = (EditText) findViewById(R.id.inputEndereco);
        inputEmail = (EditText) findViewById(R.id.inputEmail);
        inputTelefone = (EditText) findViewById(R.id.inputTelefone);
        layoutContentMain = (ConstraintLayout) findViewById(R.id.layoutContentActCadCliente);

        criarConexao();

    }

    private void criarConexao() {

        //bloco de código de teste de conexão
        try {

            this.dadosOpenHelper = new DadosOpenHelper(this);
            this.conexao = this.dadosOpenHelper.getWritableDatabase();

            Snackbar.make(layoutContentMain, R.string.avisoDeConexaoCriada, Snackbar.LENGTH_LONG)
                    .setAction(R.string.action_menu_ok, null).show();

            clienteRepositorio = new ClienteRepositorio(conexao);

        } catch (SQLException ex) {

            AlertDialog.Builder alert = new AlertDialog.Builder(this);

            alert.setTitle(R.string.mensagem_erro);
            alert.setMessage(ex.getMessage());
            alert.setNeutralButton(R.string.action_menu_ok, null);
            alert.show();

        }
    }

    private void confirmar() {

        cliente = new Clientes();

        if ( validaCampos() == false ) {

            try {

                clienteRepositorio.inserir(cliente);

                finish();

            } catch (SQLException ex) {

                AlertDialog.Builder alert = new AlertDialog.Builder(this);

                alert.setTitle(R.string.mensagem_erro);
                alert.setMessage(ex.getMessage());
                alert.setNeutralButton(R.string.action_menu_ok, null);
                alert.show();

            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_act_cad_cliente, menu);

        return super.onCreateOptionsMenu(menu);
    }

    //função principal de validação de campos....
    //-------------------------------------------
    //-------------------------------------------
    //-------------------------------------------
    private boolean validaCampos() {

        boolean res = false;

        String nome = inputNome.getText().toString();
        String endereco = inputEndereco.getText().toString();
        String email = inputEmail.getText().toString();
        String telefone = inputTelefone.getText().toString();

        cliente.nome = nome;
        cliente.endereco = endereco;
        cliente.email = email;
        cliente.telefone = telefone;

        if (res = isCampoVazio(nome)) {
            inputNome.requestFocus();
        } else if (res = isCampoVazio(endereco)) {
            inputEmail.requestFocus();
        } else if (res = !isEmailValido(email)) {
            inputEmail.requestFocus();
        } else if (res = isCampoVazio(telefone)) {
            inputTelefone.requestFocus();
        }

        if (res) {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);

            dlg.setTitle(R.string.titulo_aviso);
            dlg.setMessage(R.string.mensagem_aviso);
            dlg.setNeutralButton(R.string.confirmacaoOK, null);

            dlg.show();
        }

        return res;
    }

    private boolean isCampoVazio(String valor) {

        boolean resultado = (TextUtils.isEmpty(valor) || valor.trim().isEmpty());

        return resultado;
    }

    private boolean isEmailValido(String email) {

        boolean resultado = (!isCampoVazio(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());


        return resultado;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.action_ok:
                this.confirmar();
//                Toast.makeText(this, "Botão OK selecionado", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_cancelar:
//                Toast.makeText(this, "Botão Cancelar selecionado", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}


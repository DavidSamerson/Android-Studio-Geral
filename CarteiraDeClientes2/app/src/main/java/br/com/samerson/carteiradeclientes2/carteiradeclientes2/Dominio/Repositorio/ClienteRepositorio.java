package br.com.samerson.carteiradeclientes2.carteiradeclientes2.Dominio.Repositorio;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.samerson.carteiradeclientes2.carteiradeclientes2.Dominio.Entidades.Clientes;

public class ClienteRepositorio {

    private SQLiteDatabase conexao;

    public ClienteRepositorio (SQLiteDatabase conexao) {
        this.conexao = conexao;
    }

    public void inserir (Clientes cliente) {

        ContentValues contentValues = new ContentValues();

        contentValues.put("nome" , cliente.nome);
        contentValues.put("endereco" , cliente.endereco);
        contentValues.put("email" , cliente.email);
        contentValues.put("telefone" , cliente.telefone);


        conexao.insertOrThrow("cliente", null, contentValues );


    }

    public void excluir (int codigo) {


        String[] parametro = new String[1];
        parametro[0] = String.valueOf(codigo);

        conexao.delete("cliente","CODIGO = ?", parametro);


    }

    public void alterar (Clientes cliente) {


        ContentValues contentValues = new ContentValues();

        contentValues.put("nome" , cliente.nome);
        contentValues.put("email" , cliente.endereco);
        contentValues.put("endereco" , cliente.email);
        contentValues.put("telefone" , cliente.telefone);

        String[] parametro = new String[1];
        parametro[0] = String.valueOf(cliente.codigo);

        conexao.update("cliente", contentValues, "CODIGO = ?", parametro);


    }

    public List<Clientes> pesquisar () {

        List< Clientes > clientes = new ArrayList< Clientes > ( );

        StringBuilder string = new StringBuilder();
        string.append("SELECT codigo, nome, endereco, email, telefone");
        string.append("FROM cliente");

        Cursor resultado = conexao.rawQuery(string.toString(), null);

        if (resultado.getCount() > 0) {

            do {

                Clientes cli = new Clientes();

                cli.codigo = resultado.getInt( resultado.getColumnIndex("codigo") );
                cli.nome = resultado.getString( resultado.getColumnIndex("nome") );
                cli.endereco = resultado.getString( resultado.getColumnIndex("endereco") );
                cli.email = resultado.getString( resultado.getColumnIndex("email") );
                cli.telefone = resultado.getString( resultado.getColumnIndex("telefone") );

                clientes.add( cli );

            } while (resultado.moveToNext()) ;
        }

        return clientes;
    }

    public Clientes buscarCliente (int codigo) {

        Clientes clientes = new Clientes ();

        StringBuilder string = new StringBuilder();
        string.append("SELECT codigo, nome, endereco, email, telefone");
        string.append("FROM cliente");
        string.append("WHERE codigo = ?");

        String[] parametros = new String[1];
        parametros[0] = String.valueOf(codigo);

        Cursor resultado = conexao.rawQuery(string.toString(), null);

        if (resultado.getCount() > 0) {

                clientes.codigo = resultado.getInt( resultado.getColumnIndex("codigo") );
                clientes.nome = resultado.getString( resultado.getColumnIndex("nome") );
                clientes.endereco = resultado.getString( resultado.getColumnIndex("endereco") );
                clientes.email = resultado.getString( resultado.getColumnIndex("email") );
                clientes.telefone = resultado.getString( resultado.getColumnIndex("telefone") );

                return clientes;

        }

        return null;
    }
}

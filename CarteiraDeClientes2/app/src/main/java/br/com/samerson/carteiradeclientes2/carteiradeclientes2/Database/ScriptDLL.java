package br.com.samerson.carteiradeclientes2.carteiradeclientes2.Database;

public class ScriptDLL {

    public static String getCreateTable (){

        StringBuilder sql = new StringBuilder();


        sql.append("CREATE TABLE IF NOT EXISTS cliente(   ");
        sql.append(" codigo   INTEGER        PRIMARY KEY AUTOINCREMENT NOT NULL,");
        sql.append(" nome     VARCHAR (250)  NOT NULL DEFAULT (''), ");
        sql.append(" endereco    VARCHAR (250)  NOT NULL DEFAULT (''), ");
        sql.append(" email    VARCHAR (250) NOT NULL DEFAULT (''), ");
        sql.append(" telefone VARCHAR (20)  NOT NULL DEFAULT ('')  )");

        return sql.toString();
    }
}

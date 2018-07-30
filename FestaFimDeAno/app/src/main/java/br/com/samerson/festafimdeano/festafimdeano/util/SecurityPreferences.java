package br.com.samerson.festafimdeano.festafimdeano.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SecurityPreferences {

    private final SharedPreferences mSharedPreferences;

    public SecurityPreferences(Context context) {

        //faço uma instância da minha variavel privativa e passo o mdo privado pra nenhuma outra app ler
        this.mSharedPreferences = context.getSharedPreferences("FimDeAno", context.MODE_PRIVATE);

    }

    //criando armazenamento local...
    public void storeString (String key, String value) {
        this.mSharedPreferences.edit().putString(key, value).apply();
    }

    //retorno do método....
    public String getStorageString ( String key ) {
        return this.mSharedPreferences.getString(key, "");
    }



}

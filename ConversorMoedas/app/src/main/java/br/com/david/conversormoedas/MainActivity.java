package br.com.david.conversormoedas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder(); //instancia aqui o objeto da classe de variaveis.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editValue = (EditText) findViewById(R.id.edit_value);
        this.mViewHolder.textDollar = (TextView) findViewById(R.id.edit_dollar);
        this.mViewHolder.textEuro = (TextView) findViewById(R.id.edit_euro);
        this.mViewHolder.buttonCalculate = (Button) findViewById(R.id.button_calculate);


    }

    //classe de variaveis. (EQUIVALE A MODEL)
    private static class ViewHolder {
        EditText editValue;
        TextView textDollar;
        TextView textEuro;
        Button buttonCalculate;
    }
}

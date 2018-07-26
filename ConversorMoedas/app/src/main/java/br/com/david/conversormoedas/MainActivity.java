package br.com.david.conversormoedas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder(); //instancia aqui o objeto da classe de variaveis.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editValue = (EditText) findViewById(R.id.edit_value);
        this.mViewHolder.textDollar = (TextView) findViewById(R.id.edit_dollar);
        this.mViewHolder.textEuro = (TextView) findViewById(R.id.edit_euro);
        this.mViewHolder.buttonCalculate = (Button) findViewById(R.id.button_calculate);

        this.mViewHolder.buttonCalculate.setOnClickListener(this);

        this.clearValues();
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();
        if (id == R.id.button_calculate)  {
           //código aqui

            Double value = Double.valueOf(this.mViewHolder.editValue.getText().toString());
            this.mViewHolder.textDollar.setText(String.format("%.2f", value * 3));
            this.mViewHolder.textEuro.setText(String.format("%.2f", value * 4));

        }
    }

    private void clearValues() {
        this.mViewHolder.textDollar.setText("0");
        this.mViewHolder.textEuro.setText("0");
    }


    //classe de variaveis. (EQUIVALE A MODEL)
    private static class ViewHolder {
        EditText editValue;
        TextView textDollar;
        TextView textEuro;
        Button buttonCalculate;
    }
}

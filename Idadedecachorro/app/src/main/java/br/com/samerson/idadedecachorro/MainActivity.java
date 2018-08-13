package br.com.samerson.idadedecachorro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText caixaTexto;
    private Button botaoIdade;
    private TextView resultadoIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        caixaTexto = (EditText) findViewById(R.id.caixaTextoID);
        botaoIdade = (Button) findViewById(R.id.botaoTextoID);
        resultadoIdade = (TextView) findViewById(R.id.resultadoTextoID);


        botaoIdade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // reculperar o que a pessoa digitou
              String resultado = caixaTexto.getText().toString();

              if (resultado.isEmpty()){
                  resultado = "Digite alguma coisa !";
              } else {
                  int valorDigitado;

                  valorDigitado = Integer.parseInt(resultado);

                  valorDigitado = valorDigitado * 7;

                  resultado = String.valueOf(valorDigitado +  " anos humanos");

              }

              resultadoIdade.setText(resultado);
            }
        });

    }
}

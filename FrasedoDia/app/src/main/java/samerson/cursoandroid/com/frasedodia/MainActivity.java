package samerson.cursoandroid.com.frasedodia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textoNovaFrase;
    private Button botaoNovaFrase;
    private String[] frases = { "Frase 1",
                                "Frase 2",
                                "Frase 3",
                                "Frase 4",
                                "Frase 5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    textoNovaFrase = (TextView) findViewById(R.id.textoNovaFraseID);
    botaoNovaFrase = (Button) findViewById(R.id.botaoNovaFraseID);

    botaoNovaFrase.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Random num = new Random ();
            int numero = num.nextInt(frases.length);

            textoNovaFrase.setText(frases[numero]);

        }
    });

    }
}

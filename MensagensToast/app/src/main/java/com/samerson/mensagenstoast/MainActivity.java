package com.samerson.mensagenstoast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button botaoToast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoToast = (Button) findViewById(R.id.botaoID);


        botaoToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        getApplicationContext(),
                        "Mensagem teste!",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }
}

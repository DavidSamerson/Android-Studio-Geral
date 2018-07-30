package br.com.samerson.festafimdeano.festafimdeano.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.com.samerson.festafimdeano.festafimdeano.R;
import br.com.samerson.festafimdeano.festafimdeano.constants.FimDeAnoConstants;
import br.com.samerson.festafimdeano.festafimdeano.util.SecurityPreferences;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private SecurityPreferences mSecurityPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.textToday = (TextView) findViewById(R.id.text_today);
        this.mViewHolder.textDaysLeft = (TextView) findViewById(R.id.text_days_left);
        this.mViewHolder.buttonConfirm = (Button) findViewById(R.id.button_confirm);

        this.mViewHolder.buttonConfirm.setOnClickListener(this);

        this.mSecurityPreferences = new SecurityPreferences(this);

        this.verifyPreferences ();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.button_confirm) {
            //execulta a lógica

            String presence = this.mSecurityPreferences.getStorageString(FimDeAnoConstants.PRESENCE);

            //criar uma instância da classe Intent passando o contexto da aplicação e a classe que eu quero chamar.
            Intent intent = new Intent(this, DetailsActivity.class );

            intent.putExtra(FimDeAnoConstants.PRESENCE, presence );
            //starta a classe.
            startActivity(intent);


        }
    }

    private void verifyPreferences (){
        String presence = this.mSecurityPreferences.getStorageString(FimDeAnoConstants.PRESENCE);

        if (presence.equals(""))
            this.mViewHolder.buttonConfirm.setText(R.string.nao_confirmado );
        else if (presence.equals(FimDeAnoConstants.CONFIRMED_WILL_GO))
            this.mViewHolder.buttonConfirm.setText(R.string.sim );
        else
            this.mViewHolder.buttonConfirm.setText(R.string.nao );
    }

    private static class ViewHolder {

        TextView textToday;
        TextView textDaysLeft;
        Button buttonConfirm;
    }
}

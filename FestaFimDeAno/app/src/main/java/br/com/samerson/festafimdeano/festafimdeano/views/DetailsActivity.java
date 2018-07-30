package br.com.samerson.festafimdeano.festafimdeano.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import br.com.samerson.festafimdeano.festafimdeano.R;
import br.com.samerson.festafimdeano.festafimdeano.constants.FimDeAnoConstants;
import br.com.samerson.festafimdeano.festafimdeano.util.SecurityPreferences;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private SecurityPreferences mSecurityPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.mViewHolder.checkParticipate = (CheckBox) findViewById(R.id.VoceVaiParticipar);
        this.mViewHolder.checkParticipate.setOnClickListener(this);

        this.mSecurityPreferences = new SecurityPreferences(this);

        this.loadDataFromActivity();

    }

    private void loadDataFromActivity() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String presences = extras.getString(FimDeAnoConstants.PRESENCE);

            if (presences.equals(FimDeAnoConstants.CONFIRMED_WILL_GO))
                this.mViewHolder.checkParticipate.setChecked(true);
            else
                this.mViewHolder.checkParticipate.setChecked(false);
        }
    }

    @Override
    public void onClick(View v) {

        //id referente a quem dispara a ação.....
        int id = v.getId();

        //se quem dispara for esse botão aqui.....
        if (id == R.id.VoceVaiParticipar) {

            if (this.mViewHolder.checkParticipate.isChecked()) {
                this.mSecurityPreferences.storeString(FimDeAnoConstants.PRESENCE, FimDeAnoConstants.CONFIRMED_WILL_GO);
            } else {
                this.mSecurityPreferences.storeString(FimDeAnoConstants.PRESENCE, FimDeAnoConstants.CONFIRMED_WONT_GO);
            }

        }
    }

    private static class ViewHolder {

        CheckBox checkParticipate;

    }
}

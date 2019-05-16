package games.liu.thesurface;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class CharacterCreation extends AppCompatActivity implements OptionsFragment.onSomeEventListener{

    String[] args;
    Jimmy jim;
    private int ageCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_creation);

        args = new String[0];
        jim = Jimmy.getJimmy();
        ageCounter = 16;
        Log.d("Check", jim.engineering + " engineering");
        updateStats();

        if (savedInstanceState == null) {
            Fragment newFragment = OptionsFragment.newInstance(args);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(R.id.textholder, newFragment).commit();
        }
    }

    @Override
    public void radioResponse(int n){

    }

    public void updateFragment(){
        if(ageCounter < 20){
            args = new String[3];
            args[0] = "Play with friends";
            args[1] = "Study hard in school";
            args[2] = "Hope is freedom";

            Fragment newFragment = OptionsFragment.newInstance(args);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.textholder, newFragment).commit();
        }
    }

    public void updateStats(){
        String s = "Engineering: " + jim.engineering + "\n" +
                "Medicine: " + jim.medicine + "\n" +
                "Speech: " + jim.speech + "\n" +
                "Business: " + jim.business + "\n" +
                "Radiation Resistance: " + jim.radiationResistance + "\n" +
                "Speed: " + jim.speed + "\n" +
                "Strength: " + jim.strength + "\n" +
                "Resilience: " + jim.resilience + "\n" +
                "Zeal: " + jim.zeal + "\n" +
                "Trustworthiness: " + jim.trustworthiness + "\n" +
                "Influence: " + jim.influence;

        TextView stats = findViewById(R.id.stats);
        stats.setText(s);
    }
}

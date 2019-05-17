package games.liu.thesurface;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

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
        if(n == -1){
            Toast.makeText(this, "Please choose an action", Toast.LENGTH_SHORT).show();
        }
        else if(ageCounter < 22){
            ageCounter++;
            if(n == 0){
                jim.speech += 1;
                jim.strength += 1;
                jim.speed += 1;
            }
            else if(n == 1){
                jim.engineering += 2;
                jim.resilience += 1;
            }
            else if(n == 2){
                jim.business += 1;
                jim.zeal += 1;
                jim.influence += 1;
            }
        }
        else if(ageCounter < 30){
            ageCounter++;
            if (n == 0) {
                jim.speech += 1;
                jim.trustworthiness += 1;
            }
            else if(n == 1){
                jim.engineering += 3;
                jim.strength -= 1;
            }
            else if(n == 2){
                jim.strength += 2;
                jim.engineering -= 1;
                jim.radiationResistance += 1;
            }
            else if(n == 3){
                jim.medicine += 1;
                jim.zeal += 1;
            }
            else if(n == 4){
                jim.business += 1;
                jim.resilience += 1;
            }
        }
        updateFragment();
        updateStats();
    }

    public void updateFragment(){
        if(ageCounter < 22){
            args = new String[3];
            args[0] = "Play with friends";
            args[1] = "Study hard in school";
            args[2] = "Spend time with family";

            Fragment newFragment = OptionsFragment.newInstance(args);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.textholder, newFragment).commit();
        }
        else if(ageCounter < 30){
            args = new String[5];
            args[0] = "Hang out with friends";
            args[1] = "Study for school";
            args[2] = "Go to the gym";
            args[3] = "Go to the doctor";
            args[4] = "Compete in the school's contest";

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

        String sA = "Your age: " + (ageCounter / 2);
        TextView a = findViewById(R.id.age);
        a.setText(sA);
    }
}

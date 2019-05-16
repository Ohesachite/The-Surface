package games.liu.thesurface;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class IntroActivity extends AppCompatActivity implements OptionsFragment.onSomeEventListener{

    String[] args;
    int strArg = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        args = new String[0];

        if (savedInstanceState == null) {
            Fragment newFragment = OptionsFragment.newInstance(args);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(R.id.textholder, newFragment).commit();
        }
    }

    @Override
    public void radioResponse(int n) {
        if(n == -1) {
            if (strArg < 3) {
                strArg++;
                TextView txt = findViewById(R.id.introText);
                int resourceId = this.getResources().getIdentifier("@string/intro" + strArg, "string", this.getPackageName());
                txt.setText(resourceId);
                updateFragment();
            }
            else if(strArg == 3)
                Toast.makeText(this, "Please choose a response", Toast.LENGTH_SHORT).show();
            else if(strArg == 4){
                strArg++;
                TextView txt = findViewById(R.id.introText);
                int resourceId = this.getResources().getIdentifier("@string/intro" + strArg, "string", this.getPackageName());
                txt.setText(resourceId);
                updateFragment();
            }
            else if(strArg == 5){
                Intent intent = new Intent(this, CharacterCreation.class);
                startActivity(intent);
            }
        }
        else if(n == 0){
            strArg++;
            TextView txt = findViewById(R.id.introText);
            txt.setText(R.string.intro4a);
            Jimmy.business += 1;
            Jimmy.resilience += 4;
            Jimmy.zeal -= 2;
            updateFragment();
        }
        else if(n == 1){
            strArg++;
            TextView txt = findViewById(R.id.introText);
            txt.setText(R.string.intro4b);
            Jimmy.engineering += 1;
            Jimmy.radiationResistance += 1;
            Jimmy.resilience -= 1;
            Jimmy.zeal += 2;
            updateFragment();
        }
        else if(n == 2){
            strArg++;
            TextView txt = findViewById(R.id.introText);
            txt.setText(R.string.intro4c);
            Jimmy.speech += 1;
            Jimmy.speed += 1;
            Jimmy.strength -= 1;
            Jimmy.resilience += 1;
            Jimmy.zeal += 1;
            updateFragment();
        }
    }

    private void updateFragment(){
        if(strArg == 3) {
            args = new String[3];
            args[0] = "Hope is nonexistent";
            args[1] = "Hope is the thought that one day, I can fulfill my dreams";
            args[2] = "Hope is freedom";

            Fragment newFragment = OptionsFragment.newInstance(args);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.textholder, newFragment).commit();
        }
        else{
            args = new String[0];

            Fragment newFragment = OptionsFragment.newInstance(args);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.textholder, newFragment).commit();
        }
    }
}

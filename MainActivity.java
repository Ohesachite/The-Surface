package games.liu.thesurface;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity implements OptionsFragment.onSomeEventListener {

    String[] args;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Test code
        /*String[] args = new String[2];
        args[0] = "Test1";
        args[1] = "Test2";

        if (savedInstanceState == null) {
            Fragment newFragment = OptionsFragment.newInstance(args);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(R.id.textholder, newFragment).commit();
        }*/

        args = new String[2];
        args[0] = "New Game";
        args[1] = "Credits";

        if (savedInstanceState == null) {
            Fragment newFragment = OptionsFragment.newInstance(args);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(R.id.textholder, newFragment).commit();
        }
    }

    @Override
    public void radioResponse(int n){
        if(n == 0){
            Jimmy jim = new Jimmy();
            Intent intent = new Intent(this, IntroActivity.class);
            startActivity(intent);
        }
        else if(n == 1){
            Toast.makeText(this, "Creator: Alan Liu", Toast.LENGTH_SHORT).show();

        }
    }
}

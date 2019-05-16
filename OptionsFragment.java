package games.liu.thesurface;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link OptionsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OptionsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    RadioGroup rg;
    RadioButton[] rbs;

    //Allows transfer of data between fragment and activity
    public interface onSomeEventListener {
        public void radioResponse(int n);
    }

    onSomeEventListener eventListener;

    // TODO: Rename and change types of parameters
    private static String[] opts;

    //private OnFragmentInteractionListener mListener;

    public OptionsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param optis Parameter 1.
     * @return A new instance of fragment OptionsFragment.
     */
    // TODO: Rename and change types and number of parameters
    //Use this when creating fragment instead of default constructor
    public static OptionsFragment newInstance(String[] optis) {
        opts = optis;
        return new OptionsFragment();
    }

    //Necessary to get data from fragment
    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        try{
            eventListener = (onSomeEventListener) activity;
        }catch(ClassCastException e){
            throw new ClassCastException(activity.toString());
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    //Each one of these fragments contain options depending on data passed from activity and a next button
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_options, container, false);

        rg = view.findViewById(R.id.options);
        rbs = new RadioButton[opts.length];
        for(int i = 0; i < opts.length; i++){
            rbs[i] = new RadioButton(getActivity());
            rbs[i].setText(opts[i]);
            rbs[i].setTextAppearance(getActivity(), android.R.style.TextAppearance_Large);
            rg.addView(rbs[i]);
        }

        Button nextB = (Button) view.findViewById(R.id.next);
        nextB.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //Pass data to activity by calling the method radioResponse
                if(rg.getCheckedRadioButtonId()!=-1){
                    int id = rg.getCheckedRadioButtonId();
                    View radioButton = rg.findViewById(id);
                    int radioId = rg.indexOfChild(radioButton);
                    eventListener.radioResponse(radioId);
                }
                else
                    eventListener.radioResponse(-1);
            }
        });

        return view;

    }
}

package lclark.mapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by larspmayrand on 4/2/16.
 */
public class DialogFragment extends Fragment {

    //public static final String ARG_MARKER = "Marker";

    @Bind(R.id.fragment_title_edit_text)
    EditText mTitle;

    @Bind(R.id.fragment_description_edit_text)
    EditText mDescription;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dialog, container, false);
        ButterKnife.bind(this, rootView);

        //getActivity().setTitle(getActivity().getString(R.string.fragment_search_title));

        return rootView;
    }

}



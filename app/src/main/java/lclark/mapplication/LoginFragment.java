package lclark.mapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginFragment extends Fragment {

    public static final String ARG_USERNAME = "LoginFragment.Username";

    @Bind(R.id.login_main_username_editText)
    EditText mEditText;

    @Bind(R.id.fragment_main_login_button)
    Button mLoginButton;

    @Bind(R.id.fragment_main_add_user_button)
    Button mAddUserButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login_main, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick(R.id.fragment_main_login_button)
    void searchForUser() {
        // TODO: SQL shit
        launchMap();
    }

    @OnClick(R.id.fragment_main_add_user_button)
    void addUser() {
        // TODO: add user to SQL database
        launchMap();
    }

    public void launchMap() {
        Intent intent = new Intent(getActivity(), MapsActivity.class);
//        String message = mEditText.getText().toString();
//        intent.putExtra(ARG_USERNAME, message);
        this.startActivity(intent);
    }

}

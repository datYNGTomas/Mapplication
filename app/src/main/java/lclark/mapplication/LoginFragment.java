package lclark.mapplication;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.support.v4.app.Fragment;

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
        String userName = mEditText.getText().toString().trim();
        if (userName.equals("")) {
            Snackbar snackbar = Snackbar.make(mLoginButton, getString(R.string.null_username_error), Snackbar.LENGTH_LONG);
            snackbar.show();
        } else if(userName.equals("tomas")) { // TODO: username is not found in database
            Snackbar snackbar = Snackbar
                    .make(mLoginButton, "username not found", Snackbar.LENGTH_LONG)
                    .setAction("ADD USER", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar snackbar1 = Snackbar.make(mLoginButton, "Username Added!", Snackbar.LENGTH_SHORT);
                            snackbar1.show();
                            // add new username to SQL
                            launchMap();
                        }
                    });

            snackbar.show();
        } else {
            // SQL
            launchMap();
        }
    }

    @OnClick(R.id.fragment_main_add_user_button)
    void addUser() {
        String userName = mEditText.getText().toString().trim();
        if (userName.equals("")) {
            Snackbar snackbar = Snackbar.make(mLoginButton, getString(R.string.null_username_error), Snackbar.LENGTH_LONG);
            snackbar.show();
        } else {
            // SQL
            launchMap();
        }
    }

    public void launchMap() {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.activity_main_framelayout, new MapsFragment());
        transaction.commit();
    }

}

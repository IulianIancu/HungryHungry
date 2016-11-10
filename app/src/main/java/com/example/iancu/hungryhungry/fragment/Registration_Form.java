package com.example.iancu.hungryhungry.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.codetroopers.betterpickers.datepicker.DatePickerBuilder;
import com.codetroopers.betterpickers.datepicker.DatePickerDialogFragment;
import com.example.iancu.hungryhungry.R;
import com.example.iancu.hungryhungry.model.LoginUser;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmQuery;


/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class Registration_Form extends Fragment implements DatePickerDialogFragment.DatePickerDialogHandler {
    @BindView(R.id.first_name)
    EditText firstName;
    @BindView(R.id.last_name)
    EditText lastName;
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.date_of_birth)
    EditText dateOB;
    @BindView(R.id.allergens_chocolate)
    CheckBox chocolate;
    @BindView(R.id.allergens_dairy)
    CheckBox dairy;
    @BindView(R.id.allergens_peanuts)
    CheckBox peanuts;
    @BindView(R.id.allergens_tuna)
    CheckBox tuna;
    @BindView(R.id.allergens_wheat)
    CheckBox wheat;
    @BindView(R.id.confirm)
    Button confirm;
    @BindView(R.id.reset)
    Button reset;


    public Registration_Form() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_registration__form, container, false);
        ButterKnife.bind(this, v);
//        dateOB.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DatePickerBuilder dpb = new DatePickerBuilder()
//                        .setFragmentManager(getFragmentManager())
//                        .setStyleResId(R.style.BetterPickersDialogFragment);
//                dpb.show();
//            }
//        });

        return v;
    }

    /**
     * On click listener for the Date of Birth field
     */
    @OnClick(R.id.date_of_birth)
    public void DOBlistener(View v) {
        DatePickerBuilder dpb = new DatePickerBuilder()
                .setFragmentManager(getFragmentManager())
                .setStyleResId(R.style.BetterPickersDialogFragment)
                .setTargetFragment(Registration_Form.this);
        dpb.show();
    }

    /**
     * On click listenre for the confirm button
     */
    @OnClick(R.id.confirm)
    public void confirmListener() {
        if (firstName.getText().toString().equals("")) {
            firstName.requestFocus();
            firstName.setError(getString(R.string.error_field_required));
            return;
        }
        if (lastName.getText().toString().equals("")) {
            lastName.requestFocus();
            lastName.setError(getString(R.string.error_field_required));
            return;
        }
        if (email.getText().toString().equals("")) {
            email.requestFocus();
            email.setError(getString(R.string.error_field_required));
            return;
        } else if (!email.getText().toString().contains("@")) {
            email.requestFocus();
            email.setError(getString(R.string.error_invalid_email));
            return;
        }
        if (password.getText().toString().equals("")) {
            password.requestFocus();
            password.setError(getString(R.string.error_field_required));
            return;
        }
        if (dateOB.getText().toString().equals("")) {
            dateOB.requestFocus();
            dateOB.setError(getString(R.string.error_field_required));
            return;

        }
        try {
            Realm.init(getContext());
            Realm realm = Realm.getDefaultInstance();
            // record the user
            LoginUser user = new LoginUser();
            user.setDob(dateOB.getText().toString());
            user.setChocolate(chocolate.isChecked());
            user.setDairy(dairy.isChecked());
            user.setEmail(email.getText().toString());
            user.setfName(firstName.getText().toString());
            user.setlName(lastName.getText().toString());
            user.setPassword(password.getText().toString());
            user.setPeanuts(peanuts.isChecked());
            user.setTuna(tuna.isChecked());
            user.setWheat(wheat.isChecked());
            //commit the user to server (or local DB in this case)
            realm.beginTransaction();
            realm.copyToRealm(user);
            realm.commitTransaction();
            realm.close();

            Toast.makeText(getContext(),"Succesfully added user",Toast.LENGTH_SHORT);
            AppCompatActivity appCompatActivity = (AppCompatActivity) getContext();
            appCompatActivity.onBackPressed();
        } catch (Exception e) {
            Log.e("ERROR", e.toString());
            Toast.makeText(getContext(), "Error while saving user", Toast.LENGTH_SHORT).show();
        }


    }

    /**
     * On click listener for the reset button,
     * Resets the fields
     */
    @OnClick(R.id.reset)
    public void resetListener() {
        firstName.setText("");
        lastName.setText("");
        email.setText("");
        password.setText("");
        dateOB.setText("");
        peanuts.setChecked(false);
        dairy.setChecked(false);
        wheat.setChecked(false);
        chocolate.setChecked(false);
        tuna.setChecked(false);

    }


    @Override
    public void onDialogDateSet(int reference, int year, int monthOfYear, int dayOfMonth) {
        dateOB.setText(""+dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
    }
}

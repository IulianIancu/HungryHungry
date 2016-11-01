package com.example.iancu.hungryhungry;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.codetroopers.betterpickers.datepicker.DatePickerBuilder;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class Registration_Form extends Fragment {
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
        View v= inflater.inflate(R.layout.fragment_registration__form, container, false);
        ButterKnife.bind(this,v);
        dateOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerBuilder dpb = new DatePickerBuilder()
                        .setFragmentManager(getFragmentManager())
                        .setStyleResId(R.style.BetterPickersDialogFragment);
                dpb.show();
            }
        });

        return v;
    }



}

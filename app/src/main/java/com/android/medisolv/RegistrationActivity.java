package com.android.medisolv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        /*code to set custom title bar*/
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        /*set spinner values*/
        Spinner spinner= (Spinner)findViewById(R.id.Spinner1);
        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this,R.array.spinner1_array,R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        /*set gender spinner values*/
        Spinner genderSpinner = (Spinner)findViewById(R.id.genderSpinner);
        ArrayAdapter genderArrayAdapter = ArrayAdapter.createFromResource(this,R.array.gender_array,R.layout.support_simple_spinner_dropdown_item);
        genderSpinner.setAdapter(genderArrayAdapter);

        /* set Registration Type spinner values*/
        Spinner regTypeSpinner = (Spinner)findViewById(R.id.regTypeSpinner);
        ArrayAdapter regTypeArrayAdapter = ArrayAdapter.createFromResource(this,R.array.regType_array,R.layout.support_simple_spinner_dropdown_item);
        regTypeSpinner.setAdapter(regTypeArrayAdapter);
        regTypeSpinner.setOnItemSelectedListener(this);


    }

    /*method to un hide the specialisation and license edit text and to popup message
    to select the registration type when it is not selected*/
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String item;
        if(i>0){
            /*code to un hide the specialisation and license edit text*/
            item = adapterView.getItemAtPosition(i).toString();
            EditText spl = (EditText)findViewById(R.id.reg_spl);
            EditText license = (EditText)findViewById(R.id.reg_license);
            if(item.equals(new String("Doctor"))){

                spl.setVisibility(View.VISIBLE);
                license.setVisibility(View.VISIBLE);
            }else{
                spl.setVisibility(View.INVISIBLE);
                license.setVisibility(View.INVISIBLE);
            }

        }else{
            /*code to popup message to select the registration type when it is not selected*/
           // Toast.makeText(this, "Please select the Registration type", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Toast.makeText(this, "Please select the Registration type", Toast.LENGTH_LONG).show();
    }
}

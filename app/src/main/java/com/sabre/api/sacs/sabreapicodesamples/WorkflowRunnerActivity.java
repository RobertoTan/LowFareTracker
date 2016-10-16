package com.sabre.api.sacs.sabreapicodesamples;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.sabre.api.sacs.configuration.SacsConfiguration;
import com.sabre.api.sacs.rest.AuthenticationCall;
import com.sabre.api.sacs.rest.TokenHolder;
import com.sabre.api.sacs.sabreapicodesamples.activity.LowFareForecastActivity;
import com.sabre.api.sacs.workflow.SharedContext;
import com.sabre.api.sacs.workflow.Workflow;
import com.sabre.api.sacs.sabreapicodesamples.activity.LeadPriceCalendarActivity;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.sabre.api.CommonKey.KEY_DEPARTURE_DATE;
import static com.sabre.api.CommonKey.KEY_DESTINATION;
import static com.sabre.api.CommonKey.KEY_FARE_BAR;
import static com.sabre.api.CommonKey.KEY_LOW_FARE_RESULT;
import static com.sabre.api.CommonKey.KEY_ORIGIN;
import static com.sabre.api.CommonKey.KEY_RETURN_DATE;
import static com.sabre.api.sacs.sabreapicodesamples.R.id.buttonReturnDateDialog;

public class WorkflowRunnerActivity extends AppCompatActivity {

    private int btnID;
    private String origin;
    private String destination;
    private String departureDate;
    private String returnDate;
    private String farebar;

    private AutoCompleteTextView.Validator iataCodeValidator = new AutoCompleteTextView.Validator() {

        @Override
        public boolean isValid(CharSequence text) {
            return (text.length() == 3);
        }

        @Override
        public CharSequence fixText(CharSequence invalidText) {
            return null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workflow_runner);

        String[] airports = getResources().getStringArray(R.array.airports);
        ArrayAdapter<String> originAirportsAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, airports);
        ArrayAdapter<String> destinationAirportsAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, airports);
        AutoCompleteTextView origins = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextViewAirportsOrigin);
        AutoCompleteTextView destinations = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextViewAirportsDestination);
        origins.setAdapter(originAirportsAdapter);
        origins.setValidator(iataCodeValidator);
        destinations.setAdapter(destinationAirportsAdapter);
        destinations.setValidator(iataCodeValidator);

        /*
        The below code is a quick and dirty solution to read the configuration file (authentication, etc.)
        We highly encourage, such information is not being kept in the application package for safety reasons.
         */
        try {
            InputStream rawResource = getResources().openRawResource(R.raw.sacsconfig);
            SacsConfiguration.restConfig.load(rawResource);
            System.out.println("The properties are now loaded");
            System.out.println("properties: " + SacsConfiguration.restConfig);
        } catch (Resources.NotFoundException e) {
            System.err.println("Did not find raw resource: "+e);
        } catch (IOException e) {
            System.err.println("Failed to open DES property file");
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_workflow_runner, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onBook(View v) {
        Intent intent = new Intent(this, BookActivity.class);
        startActivity(intent);
    }

    public void runWorkflow(View view) {
        origin = ((AutoCompleteTextView)findViewById(R.id.autoCompleteTextViewAirportsOrigin)).getText().toString();
        destination = ((AutoCompleteTextView)findViewById(R.id.autoCompleteTextViewAirportsDestination)).getText().toString();
        departureDate = ((EditText)findViewById(R.id.editTextDepartureDate)).getText().toString();
        DateFormat sdf = SimpleDateFormat.getDateInstance();
        try {
            Date depDate = sdf.parse(departureDate);
            departureDate = new SimpleDateFormat("yyyy-MM-dd").format(depDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        returnDate =  ((EditText)findViewById(R.id.editTextReturnDate)).getText().toString();
        try {
            Date depDate = sdf.parse(returnDate);
            returnDate = new SimpleDateFormat("yyyy-MM-dd").format(depDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        farebar = ((EditText)findViewById(R.id.editTextFareBar)).getText().toString();

        if (origin == null || origin.length() != 3
                || destination == null || destination.length() != 3
                || departureDate == null || departureDate.length() < 10
                || returnDate == null || returnDate.length() < 10) {
            Toast.makeText(this, "Invalid input, please check again!", Toast.LENGTH_SHORT);
        } else {
            AuthenticationCall auth = new AuthenticationCall();
            auth.doCall();
            TokenHolder tokenHolder = TokenHolder.getInstance();
            new RetrieveFeedTask().execute(tokenHolder);
        }


    }

    class RetrieveFeedTask extends AsyncTask<TokenHolder, Integer, JSONObject> {

        protected JSONObject doInBackground(TokenHolder... tokenHolders) {
            try {

                LowFareForecastActivity lowFareForecastActivity = new LowFareForecastActivity(origin.toUpperCase(),
                        destination.toUpperCase(), departureDate, returnDate, farebar);

                JSONObject result = lowFareForecastActivity.getLowFareForeCast(tokenHolders[0]);
                return result;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        protected void onPostExecute(JSONObject result) {
            if (result == null) {
                Toast.makeText(WorkflowRunnerActivity.this, "Forecast Low Fare Failure", Toast.LENGTH_LONG).show();
            } else {
                Intent intent = new Intent(WorkflowRunnerActivity.this, ShowResultsActivity.class);
                intent.putExtra(KEY_ORIGIN, origin);
                intent.putExtra(KEY_DESTINATION, destination);
                intent.putExtra(KEY_DEPARTURE_DATE, departureDate);
                intent.putExtra(KEY_RETURN_DATE, returnDate);
                intent.putExtra(KEY_FARE_BAR, farebar);
                intent.putExtra(KEY_LOW_FARE_RESULT, result.toString());
                ShowResultsActivity.bundle = intent.getExtras();
                startActivity(intent);
            }
        }
    }
    public void showDatePickerDialog(View v) {
        Calendar cal = Calendar.getInstance();
        btnID = v.getId();
        AlertDialog newFragment = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Calendar cal = Calendar.getInstance();
                        cal.set(Calendar.YEAR, year);
                        cal.set(Calendar.MONTH, monthOfYear);
                        cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        DateFormat sdf = SimpleDateFormat.getDateInstance();
                        int id = R.id.editTextDepartureDate;

                        switch (btnID) {
                            case R.id.buttonReturnDateDialog:
                                id = R.id.editTextReturnDate;
                                break;
                        }
                        EditText departureDate = (EditText) findViewById(id);
                        departureDate.setText(sdf.format(cal.getTime()));
                    }
                }, cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
        newFragment.show();

    }
}

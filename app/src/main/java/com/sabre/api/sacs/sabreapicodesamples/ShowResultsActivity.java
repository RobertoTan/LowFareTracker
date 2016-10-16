package com.sabre.api.sacs.sabreapicodesamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.sabre.api.des.developeressentials.LowFareService;
import com.sabre.api.des.developeressentials.PollingUtils;
import com.sabre.api.sacs.domain.BaseDomainResponse;
import com.sabre.api.sacs.domain.bargainfindermax_gen.BfmV186Response;
import com.sabre.api.sacs.domain.instaflight_gen.FlightSegment;
import com.sabre.api.sacs.domain.instaflight_gen.InstaFlightResponse;
import com.sabre.api.sacs.domain.leadpricecalendar.FareInfoResponse;
import com.sabre.api.sacs.domain.leadpricecalendar.FareResponse;
import com.sabre.api.sacs.domain.leadpricecalendar.LeadPriceCalendarResponse;
import com.sabre.api.sacs.workflow.SharedContext;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import static com.sabre.api.CommonKey.KEY_DEPARTURE_DATE;
import static com.sabre.api.CommonKey.KEY_DESTINATION;
import static com.sabre.api.CommonKey.KEY_FARE_BAR;
import static com.sabre.api.CommonKey.KEY_LOW_FARE_RESULT;
import static com.sabre.api.CommonKey.KEY_ORIGIN;
import static com.sabre.api.CommonKey.KEY_RETURN_DATE;

public class ShowResultsActivity extends AppCompatActivity {

    //The results should not be public static.
    //It is done, as at the generation time, all the domain classes should be marked as serializable
    //in order to pass them to the activity with the Intent's putExtra() method.
    //The domain classes were copied from the DES Java project, where the Serializable marker
    //was not required.
    public static SharedContext results;

    public static Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_low_fare_result);

        if (getIntent().getExtras() != null) {
            showLowFareResult(getIntent().getExtras());
        }
        //fillResults();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_results, menu);
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

    public void onTracking(View v) {
        Bundle req = getIntent().getExtras();
        if (req != null) {

            PollingUtils.startPollingService(this, 60,LowFareService.class, LowFareService.ACTION, req);
            Toast.makeText(this, "Start Monitor....", Toast.LENGTH_LONG).show();
        }


    }

    private void showLowFareResult(Bundle bundle) {
        String strResult = bundle.getString(KEY_LOW_FARE_RESULT);
        if (strResult != null) {
            try {
//                "OriginLocation": "LAX",
//                 "DestinationLocation": "SEA",
//                 "DepartureDateTime": "2016-10-30T00:00:00",
//                 "ReturnDateTime": "2016-10-30T00:00:00",
//                 "Forecast": {
//                    "HighestPredictedFare": 218,
//                    "CurrencyCode": "USD",
//                    "LowestPredictedFare": 179
//                },
//                "Recommendation": "buy",
//                "LowestFare": 130.2,
//                "CurrencyCode": "USD",
                JSONObject result = new JSONObject(strResult);

                String recommendation = result.getString("Recommendation");
                ((TextView)findViewById(R.id.textViewRecommendation)).setText(recommendation);

                String origin = result.getString("OriginLocation");
                ((TextView)findViewById(R.id.textViewOrigin)).setText(origin);

                String destination = result.getString("DestinationLocation");
                ((TextView)findViewById(R.id.textViewDestination)).setText(destination);

                String departureDate = result.getString("DepartureDateTime");
                ((TextView)findViewById(R.id.textViewDepartureDate)).setText(departureDate);

                String returnDate = result.getString("ReturnDateTime");
                ((TextView)findViewById(R.id.textViewReturnDate)).setText(returnDate);

                String lowFare = result.getString("LowestFare") + result.getString("CurrencyCode");
                ((TextView)findViewById(R.id.textViewLowestFare)).setText(lowFare);

                JSONObject forecast = result.getJSONObject("Forecast");

                if (forecast != null) {
                    String forecastHighFare = forecast.getString("HighestPredictedFare");
                    String forecastLowFare = forecast.getString("LowestPredictedFare");
                    String forecastCurrency = forecast.getString("CurrencyCode");

                    ((TextView)findViewById(R.id.textViewHighestPredictedFare)).setText(forecastHighFare+forecastCurrency);
                    ((TextView)findViewById(R.id.textViewLowestPredictedFare)).setText(forecastLowFare+forecastCurrency);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }

    private void fillResults() {

        TableLayout resultsTable = new TableLayout(this);

        TableRow lpcTitleRow = new TableRow(this);
        lpcTitleRow.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        TextView lpcTitle = new TextView(this);
        lpcTitle.setText("Lead Price Calendar");
        lpcTitleRow.addView(lpcTitle);

        resultsTable.addView(lpcTitleRow);

        resultsTable.addView(createLeadPriceCalendarTable(
                ((BaseDomainResponse<LeadPriceCalendarResponse>) results.getResult("LeadPriceCalendar")).getResult()));
        TableRow spacer1 = new TableRow(this);
        spacer1.addView(new TextView(this));
        resultsTable.addView(spacer1);

        TableRow instaFlightTitleRow = new TableRow(this);
        instaFlightTitleRow.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        TextView instaFlightTitle = new TextView(this);
        instaFlightTitle.setText("InstaFlight");
        instaFlightTitleRow.addView(instaFlightTitle);

        resultsTable.addView(instaFlightTitleRow);


        resultsTable.addView(createInstaFlightRow(
                ((BaseDomainResponse<InstaFlightResponse>) results.getResult("InstaFlight")).getResult()));
        TableRow spacer2 = new TableRow(this);
        spacer2.addView(new TextView(this));
        resultsTable.addView(spacer2);

        TableRow bfmTitleRow = new TableRow(this);
        bfmTitleRow.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        TextView bfmTitle = new TextView(this);
        bfmTitle.setText("Bargain Finder MAX!");
        bfmTitleRow.addView(bfmTitle);

        resultsTable.addView(bfmTitleRow);

        resultsTable.addView(createBargainFinderMaxRow(
                ((BaseDomainResponse<BfmV186Response>) results.getResult("BargainFinderMaxResponse")).getResult()));
        ScrollView view = (ScrollView) findViewById(R.id.resultsView);
        view.addView(resultsTable);
    }

    private TableLayout createLeadPriceCalendarTable(LeadPriceCalendarResponse data) {
        TableLayout lpcLayout = new TableLayout(this);


        FareInfoResponse itinerary = data.getFareInfo().get(0);
        TableRow departureDateTimeRow = createLabelValueRow("Departure Time/Date", itinerary.getDepartureDateTime().toString());

        TableRow returnTimeDateRow = createLabelValueRow("Return Time/Date", itinerary.getReturnDateTime().toString());

        TableRow currencyCodeRow = createLabelValueRow("Currency Code", itinerary.getCurrencyCode());

        FareResponse lowestFare = itinerary.getLowestFare();

        TableRow lowestFareLabelRow = new TableRow(this);
        TextView lowestFareLabel = new TextView(this);
        lowestFareLabel.setText("Lowest Fare");
        lowestFareLabelRow.addView(lowestFareLabel);

        TableRow lowestFareAirlineCodeRow = createLabelValueRow("Airline Code", listToString(lowestFare.getAirlineCodes()));

        TableRow lowestFareFareRow = createLabelValueRow("Fare", lowestFare.getFare().toString());

        FareResponse lowestNonStopFare = itinerary.getLowestNonStopFare();
        TableRow lowestNonStopFareLabelRow = new TableRow(this);
        TextView lowestNonStopFareLabel = new TextView(this);
        lowestNonStopFareLabel.setText("Lowest Non Stop Fare");
        lowestNonStopFareLabelRow.addView(lowestNonStopFareLabel);

        TableRow lowestNonStopFareAirlineCodeRow = createLabelValueRow("Airline Code", listToString(lowestNonStopFare.getAirlineCodes()));

        TableRow lowestNonStopFareFareRow = createLabelValueRow("Fare", lowestNonStopFare.getFare().toString());

        lpcLayout.addView(departureDateTimeRow);
        lpcLayout.addView(returnTimeDateRow);
        lpcLayout.addView(currencyCodeRow);
        lpcLayout.addView(lowestFareLabelRow);
        lpcLayout.addView(lowestFareAirlineCodeRow);
        lpcLayout.addView(lowestFareFareRow);
        lpcLayout.addView(lowestNonStopFareLabelRow);
        lpcLayout.addView(lowestNonStopFareAirlineCodeRow);
        lpcLayout.addView(lowestNonStopFareFareRow);
        return lpcLayout;
    }

    private String listToString(List<String> list) {
        StringBuilder result = new StringBuilder();
        for (String toAppend: list) {
            result.append(toAppend)
                    .append(", ");
        }
        result = result.deleteCharAt(result.length()-1);
        result = result.deleteCharAt(result.length()-1);
        return result.toString();
    }

    private TableRow createLabelValueRow(String label, String value) {
        TableRow labelValueRow = new TableRow(this);
        TextView labelTextView = new TextView(this);
        labelTextView.setText(label);

        TextView valueTextView = new TextView(this);
        valueTextView.setText(value);
        valueTextView.setPadding(60, 0, 0, 0);

        labelValueRow.addView(labelTextView);
        labelValueRow.addView(valueTextView);
        return labelValueRow;
    }

    private TableLayout createInstaFlightRow(InstaFlightResponse data) {
        TableLayout instaFlightTable = new TableLayout(this);

        FlightSegment flightSegment = data.getPricedItineraries().get(0).getAirItinerary().getOriginDestinationOptions().getOriginDestinationOption().get(0).getFlightSegment().get(0);
        TableRow departureDateTime = createLabelValueRow("Departure Date/Time", flightSegment.getDepartureDateTime());
        TableRow departureTimeZone = createLabelValueRow("Departure Time Zone", flightSegment.getDepartureTimeZone().getGMTOffset().toString());
        TableRow departureAirport = createLabelValueRow("Departure Airport", flightSegment.getDepartureAirport().getLocationCode());


        TableRow arrivalDateTime = createLabelValueRow("Arrival Date/Time", flightSegment.getArrivalDateTime());
        TableRow arrivalTimeZone = createLabelValueRow("Arrival Time Zone", flightSegment.getArrivalTimeZone().getGMTOffset().toString());
        TableRow arrivalAirport = createLabelValueRow("Arrival Airport", flightSegment.getArrivalAirport().getLocationCode());

        TableRow elapsedTime = createLabelValueRow("Elapsed Time", flightSegment.getElapsedTime().toString());

        TableRow stopQuantity = createLabelValueRow("Stop Quantity", flightSegment.getStopQuantity().toString());
        TableRow flightNumber = createLabelValueRow("Flight Number", flightSegment.getFlightNumber().toString() + "(" + flightSegment.getOperatingAirline().getFlightNumber() + ")");
        TableRow marketingAirline = createLabelValueRow("Marketing Airline", flightSegment.getMarketingAirline().getCode());
        TableRow operatingAirline = createLabelValueRow("Operating Airline", flightSegment.getOperatingAirline().getCode());

        TableRow marriageGrp = createLabelValueRow("Marriage Grp", flightSegment.getMarriageGrp());
        TableRow equipment = createLabelValueRow("Equipment", flightSegment.getEquipment().getAirEquipType());
        TableRow resBookDesigCode = createLabelValueRow("Res Book Desig Code", flightSegment.getResBookDesigCode());


        instaFlightTable.addView(departureDateTime);
        instaFlightTable.addView(departureTimeZone);
        instaFlightTable.addView(departureAirport);
        instaFlightTable.addView(arrivalDateTime);
        instaFlightTable.addView(arrivalTimeZone);
        instaFlightTable.addView(arrivalAirport);
        instaFlightTable.addView(elapsedTime);
        instaFlightTable.addView(stopQuantity);
        instaFlightTable.addView(flightNumber);
        instaFlightTable.addView(marketingAirline);
        instaFlightTable.addView(operatingAirline);
        instaFlightTable.addView(marriageGrp);
        instaFlightTable.addView(equipment);
        instaFlightTable.addView(resBookDesigCode);

        return instaFlightTable;
    }

    private TableLayout createBargainFinderMaxRow(BfmV186Response data) {
        TableLayout bfmTable = new TableLayout(this);
        com.sabre.api.sacs.domain.bargainfindermax_gen.FlightSegment flightSegment = data.getOTAAirLowFareSearchRS().getPricedItineraries().getPricedItinerary().get(0).getAirItinerary().getOriginDestinationOptions().getOriginDestinationOption().get(0).getFlightSegment().get(0);

        TableRow departureDateTime = createLabelValueRow("Departure Date/Time", flightSegment.getDepartureDateTime());
        TableRow departureTimeZone = createLabelValueRow("Departure Time Zone", flightSegment.getDepartureTimeZone().getGMTOffset().toString());
        TableRow departureAirport = createLabelValueRow("Departure Airport", flightSegment.getDepartureAirport().getLocationCode());


        TableRow arrivalDateTime = createLabelValueRow("Arrival Date/Time", flightSegment.getArrivalDateTime());
        TableRow arrivalTimeZone = createLabelValueRow("Arrival Time Zone", flightSegment.getArrivalTimeZone().getGMTOffset().toString());
        TableRow arrivalAirport = createLabelValueRow("Arrival Airport", flightSegment.getArrivalAirport().getLocationCode());

        TableRow elapsedTime = createLabelValueRow("Elapsed Time", flightSegment.getElapsedTime().toString());

        TableRow stopQuantity = createLabelValueRow("Stop Quantity", flightSegment.getStopQuantity().toString());
        TableRow flightNumber = createLabelValueRow("Flight Number", flightSegment.getFlightNumber().toString() + "(" + flightSegment.getOperatingAirline().getFlightNumber() + ")");
        TableRow marketingAirline = createLabelValueRow("Marketing Airline", flightSegment.getMarketingAirline().getCode());
        TableRow operatingAirline = createLabelValueRow("Operating Airline", flightSegment.getOperatingAirline().getCode());

        TableRow marriageGrp = createLabelValueRow("Marriage Grp", flightSegment.getMarriageGrp());
        TableRow equipment = createLabelValueRow("Equipment", flightSegment.getEquipment().get(0).getAirEquipType());
        TableRow resBookDesigCode = createLabelValueRow("Res Book Desig Code", flightSegment.getResBookDesigCode());


        bfmTable.addView(departureDateTime);
        bfmTable.addView(departureTimeZone);
        bfmTable.addView(departureAirport);
        bfmTable.addView(arrivalDateTime);
        bfmTable.addView(arrivalTimeZone);
        bfmTable.addView(arrivalAirport);
        bfmTable.addView(elapsedTime);
        bfmTable.addView(stopQuantity);
        bfmTable.addView(flightNumber);
        bfmTable.addView(marketingAirline);
        bfmTable.addView(operatingAirline);
        bfmTable.addView(marriageGrp);
        bfmTable.addView(equipment);
        bfmTable.addView(resBookDesigCode);
        return bfmTable;
    }

    public void backToWorkflowRunner(View view) {
        Intent intent = new Intent(this, WorkflowRunnerActivity.class);
        startActivity(intent);
    }

    public void keepTracking(View view) {

    }
}

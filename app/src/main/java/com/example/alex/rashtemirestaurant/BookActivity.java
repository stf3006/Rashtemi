package com.example.alex.rashtemirestaurant;

import android.app.DialogFragment;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.Locale;

public class BookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        Spinner spinner = (Spinner) findViewById(R.id.guests_spinner); // GUEST SPINNER

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.number_of_guests, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        Spinner spinner1 = (Spinner) findViewById(R.id.hour_spinner); // TIME SPINNER
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.hour_schedule, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(adapter1);

        Button bookButton = (Button) findViewById(R.id.addBooking_button);
        bookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    EditText nameEditText = (EditText) (BookActivity.this).findViewById(R.id.name_book_et);
                    EditText phoneEditText = (EditText) (BookActivity.this).findViewById(R.id.phone_book_et);
                    Spinner guestsSpinner = (Spinner) (BookActivity.this).findViewById(R.id.guests_spinner);
                    TextView dateTextView = (TextView) (BookActivity.this).findViewById(R.id.pick_date_id);
                    Spinner timeSpinner = (Spinner) (BookActivity.this).findViewById(R.id.hour_spinner);

                    String name = nameEditText.getText().toString();
                    String phone = phoneEditText.getText().toString();

                    if(name.length() == 0 || phone.length() == 0 || dateTextView.getText().toString().equals("Pick Date")) {
                        Toast.makeText(BookActivity.this, "Please fill the entire form.", Toast.LENGTH_SHORT).show();
                    }

                    int guests = Integer.parseInt(guestsSpinner.getSelectedItem().toString());
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.US);
                    Date date = format.parse(dateTextView.getText().toString() + " " + timeSpinner.getSelectedItem().toString());

                    Booking booking = new Booking(name, phone, guests, date);
                    BookingHelper bookingHelper = new BookingHelper(BookActivity.this);
                    bookingHelper.AddBooking(booking);
                    bookingHelper.SaveBookingsToJSON();

                    Toast.makeText(BookActivity.this, "Table booked successfully!", Toast.LENGTH_LONG).show();
                    BookActivity.this.finish();

                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(), "datePicker");
    }

}

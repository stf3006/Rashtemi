package com.example.alex.rashtemirestaurant;

import android.content.Context;
import android.os.Environment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Rares on 28.11.2016.
 */

public class BookingHelper {
    private String filename;
    private Context context;
    private File file;
    private InputStream inputStream;
    private ArrayList<Booking> bookings;
    private String json;


    public BookingHelper(Context context) throws IOException {
        filename = "bookings.json";
        bookings = new ArrayList<>();
        this.context = context;
        try {
            inputStream = context.openFileInput(filename);

            ReadJSONFile();
            ParseJSONData();
        } catch (FileNotFoundException ex) {
            // Do nothing
        }
    }

    private void ReadJSONFile() {
        try {
            int dataSize = inputStream.available();
            byte[] buff = new byte[dataSize];
            inputStream.read(buff);
            inputStream.close();

            json = new String(buff, "utf-8");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void ParseJSONData() {
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray array = jsonObject.getJSONArray("bookings");

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.US);
            for(int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);

                String name = obj.getString("Name");
                String phone = obj.getString("Phone");
                int guests = obj.getInt("Guests");
                Date date = format.parse(obj.getString("Date"));

                Booking booking = new Booking(name, phone, guests, date);
                bookings.add(booking);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void AddBooking(Booking booking) {
        bookings.add(booking);
    }

    public void SaveBookingsToJSON() {
        JSONArray array = new JSONArray();
        for(Booking booking : bookings) {
            array.put(booking.toJSONObject());
        }

        JSONObject root = new JSONObject();

        try {
            root.put("bookings", array);
            OutputStreamWriter writer = new OutputStreamWriter(context.openFileOutput(filename, Context.MODE_PRIVATE));
            writer.write(root.toString(2));
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

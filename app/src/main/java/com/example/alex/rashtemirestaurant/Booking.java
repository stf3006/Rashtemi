package com.example.alex.rashtemirestaurant;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Rares on 28.11.2016.
 */

public class Booking {
    public String name;
    public String phone;
    public int guests;
    public Date date;

    public Booking(String name, String phone, int guests, Date date) {
        this.name = name;
        this.phone = phone;
        this.guests = guests;
        this.date = date;
    }

    public JSONObject toJSONObject() {
        JSONObject obj = new JSONObject();
        try {
            obj.put("Name", name);
            obj.put("Phone", phone);
            obj.put("Guests", guests);
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            obj.put("Date", format.format(date));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return obj;
    }
}

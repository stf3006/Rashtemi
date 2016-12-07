package com.example.alex.rashtemirestaurant;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button contactBtn = (Button) findViewById(R.id.contact_button);
        contactBtn.setOnClickListener(new View.OnClickListener() { // TRECEREA DE LA O ACTIVITATE LA ALTA PRIN BUTON
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ContactActivity.class);
                startActivity(intent);
            }
        });

        Button myaccBtn = (Button) findViewById(R.id.myacc_button);
        myaccBtn.setOnClickListener(new View.OnClickListener() { // TRECEREA DE LA O ACTIVITATE LA ALTA PRIN BUTON
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, MyAccountActivity.class);
                startActivity(intent1);
            }
        });

        Button menuBtn = (Button) findViewById(R.id.menu_button);
        menuBtn.setOnClickListener(new View.OnClickListener() { // TRECEREA DE LA O ACTIVITATE LA ALTA PRIN BUTON
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent1);
            }
        });
        Button bookBtn = (Button) findViewById(R.id.book_button);
        bookBtn.setOnClickListener(new View.OnClickListener() { // TRECEREA DE LA O ACTIVITATE LA ALTA PRIN BUTON
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, BookActivity.class);
                startActivity(intent1);
            }
        });
        Button downloadButton = (Button) findViewById(R.id.download_menu_button);
        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DownloadTask(MainActivity.this).execute();
            }
        });

    }


}

class DownloadTask extends AsyncTask<Void, Void, Void> {
    Context context;

    public DownloadTask(Context context) {
        this.context = context.getApplicationContext();
    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            URL url = new URL("http://hotel-restaurant-transilvania.ro/include/Meniu-Restaurant-Transilvania.pdf");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setDoOutput(true);
            conn.connect();
            String path = Environment.getExternalStorageDirectory().getAbsolutePath().toString() + "/download/";
            File root = new File(path);
            FileOutputStream file = new FileOutputStream(new File(root, "menu.pdf"));
            InputStream stream = conn.getInputStream();

            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = stream.read(buffer)) > 0) {
                file.write(buffer, 0, len);
            }

            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        File fileToOpen = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/download/menu.pdf");
        Intent target = new Intent(Intent.ACTION_VIEW);
        target.setDataAndType(Uri.fromFile(fileToOpen), "application/pdf");
        target.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        Intent intent = Intent.createChooser(target, "Open File");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            // Instruct the user to install a PDF reader here, or something
            System.out.println("NO PDF READER INSTALLED");
        }
    }
}
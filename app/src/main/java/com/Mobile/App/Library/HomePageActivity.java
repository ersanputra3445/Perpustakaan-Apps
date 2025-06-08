package com.Mobile.App.Library;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page); // Set to your home page layout

        // Initialize buttons
        Button btnBook = findViewById(R.id.btn_book);  // "Reservasi Book" button
        Button btnRoom = findViewById(R.id.btn_room);  // "Reservasi Room" button
        Button btnMap = findViewById(R.id.btn_map);    // "View Maps" button

        // Set up click listeners for each button
        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to navigate to MainActivity (for book reservation)
                Intent intentBook = new Intent(HomePageActivity.this, MainActivity.class);
                startActivity(intentBook);
            }
        });

        btnRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to navigate to ServeRoomActivity (for room reservation)
                Intent intentRoom = new Intent(HomePageActivity.this, ServeRoom.class);
                startActivity(intentRoom);
            }
        });

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to navigate to MapsActivity
                Intent intentMap = new Intent(HomePageActivity.this, MapsActivity.class);
                startActivity(intentMap);
            }
        });
    }
}

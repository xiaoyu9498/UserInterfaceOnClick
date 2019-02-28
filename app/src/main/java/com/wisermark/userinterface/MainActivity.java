package com.wisermark.userinterface;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    TextView quantityTV;
    TextView priceTV;
    ImageView coffeeIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quantityTV = findViewById(R.id.quantity_text_view);
        priceTV = findViewById(R.id.price_text_view);
        coffeeIV = findViewById(R.id.img);

        coffeeIV.setOnTouchListener(new com.wisermark.userinterface.OnSwipeTouchListener(MainActivity.this)); {
            public void onSwipeTop() {
                Toast.makeText(MainActivity.this, "top", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeRight() {
                Toast.makeText(MainActivity.this, "right", Toast.LENGTH_SHORT).show();
            }

            public void onSwipeLeft() {
                Toast.makeText(MainActivity.this, "left", Toast.LENGTH_SHORT).show();
            }

            public void onSwipeBottom() {
                Toast.makeText(MainActivity.this, "bottom", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void increase(View view) {
        quantity++;
        quantityTV.setText("" + quantity);
    }

    public void decrease(View view) {
        quantity--;
        if(quantity>=0) {
            quantityTV.setText("" + quantity);
        }
    }

    public void submitOrder(View view) {
        // send an email
        /*
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Request for coffee");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Number of coffee: " + quantity);
        startActivity(emailIntent);
        */

        //open a new page
        Intent i = new Intent(this, order.class);
        startActivity(i);
    }
}

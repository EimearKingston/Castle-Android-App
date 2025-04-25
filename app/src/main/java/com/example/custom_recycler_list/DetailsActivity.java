package com.example.custom_recycler_list;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
//pastebin = https://pastebin.com/kfYbYL78

public class DetailsActivity extends AppCompatActivity {
    TextView nameTV, descriptionTV;
    ImageView castleIM;
    Castle castle = null;
    Button webInfoBT = null;
    Button mapBT = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        //wire
        nameTV = findViewById(R.id.nameTextView);
        castleIM = findViewById(R.id.imageView);
        descriptionTV = findViewById(R.id.descriptionTextView);


        webInfoBT = findViewById(R.id.button1);
        mapBT = findViewById(R.id.button2);

        //get data
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        castle = (Castle) bundle.getSerializable("castle");

        //populate widgets with data
        nameTV.setText(castle.getName());
//        imageTV.setText(castle.getImage());
        String imageName = castle.getImage();
        imageName = imageName.substring(0, imageName.indexOf(".")); //scrapping '.jpg'
        int imageId = this.getResources().getIdentifier(imageName, "drawable", getPackageName());
        castleIM.setImageResource(imageId);
        descriptionTV.setText(castle.getDescription());
//        urlTV.setText(castle.getUrl());

        //button events
        webInfoBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailsActivity.this, WebActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("url", castle.getUrl());
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
        mapBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailsActivity.this, MapActivity.class);
                Bundle bundle = new Bundle();
                bundle.putDouble("latitude", castle.getLatitude());
                bundle.putDouble("longitude", castle.getLongitude());
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });

    }
}
package com.example.custom_recycler_list;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
//pastebin = https://pastebin.com/3i2hb0u7

public class CastleActivity extends AppCompatActivity {
    TextView castleTV = null;
    ImageView castleIM = null;
    Button moreInfoBT = null;

    Castle castle = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build);

        //wire
        castleIM = findViewById(R.id.imageView);
        castleTV = findViewById(R.id.textView);
        moreInfoBT = findViewById(R.id.button);


        //get data
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        castle = (Castle) bundle.getSerializable("castle");


        //populate object with data
        castleTV.setText(castle.getName());
        String imageName = castle.getImage();
        imageName = imageName.substring(0, imageName.indexOf(".")); //scrapping '.jpg'
        int imageId = this.getResources().getIdentifier(imageName, "drawable", getPackageName());
        castleIM.setImageResource(imageId);

        moreInfoBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //make an explicit intent and a bundle
                Intent intent = new Intent(CastleActivity.this, DetailsActivity.class);
                Bundle bundle = new Bundle();

                //put the data into the bundle and the bundle into the intent
                bundle.putSerializable("castle", castle);
                intent.putExtras(bundle);

                //start Activity
                startActivity(intent);

            }


        });
    }
}
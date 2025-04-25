package com.example.custom_recycler_list;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

//import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity implements RecycleViewInterface {

    RecyclerView list = null;
    CustomRecyclerAdapter adapter = null;
    XMLCastles castles = null;
    Spinner spinner=null;
    ArrayList<Castle> castleList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        list = findViewById(R.id.recyclerView);
        castles = new XMLCastles(this);

        spinner = findViewById(R.id.spinner);
        adapter = new CustomRecyclerAdapter(this, R.layout.row_layout, castles, this);

        list.setLayoutManager(new LinearLayoutManager(this));

        list.setAdapter(adapter);
        setupSpinner();

    }
    private void setupSpinner() {
        // Add sorting option to the spinner
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.provinces, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        // Handle spinner selection
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedOption = parent.getItemAtPosition(position).toString();

                if (selectedOption.equals("Sort by province")) {
                    sortByProvince();
                }else if (selectedOption.equals("Sort by year (oldest to newest)")) { // New option
                    sortByYear();
                }else if (selectedOption.equals("Sort by year (newest to oldest)")) { // New option
                    sortByYearDesc();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });
    }

    // Method to sort and group castles by province
    private void sortByProvince() {
        // Sort castles in XMLCastles by province
        castles.sortProvince();

        // Update adapter with the sorted list
        adapter.updateList(castles.getCastles());
    }

    // Method to sort and group castles by year (newest to oldest)
    private void sortByYear() {
        castles.sortByYear();

        // Update adapter with the sorted list
        adapter.updateList(castles.getCastles());
    }

    // Method to sort and group castles by year (oldest to newest)
    private void sortByYearDesc() {
        castles.sortByYearDesc();

        // Update adapter with the sorted list
        adapter.updateList(castles.getCastles());
    }



    @Override
    public void onItemClick(int position) {
        Toast.makeText(this, castles.getCastle(position).getName(), Toast.LENGTH_SHORT).show();

        //make intent and bundle
        Intent intent = new Intent(MainActivity.this, CastleActivity.class);
        Bundle bundle = new Bundle();


        //crop the data for the intent
        Castle castle = castles.getCastle(position);


        //place data into bundle and bundle into intent
        bundle.putSerializable("castle", castle);
        intent.putExtras(bundle);

        //start activity
        startActivity(intent);
    }
}
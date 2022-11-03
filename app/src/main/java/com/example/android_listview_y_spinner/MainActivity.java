package com.example.android_listview_y_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = this.findViewById(R.id.listView);
        Spinner spinner = this.findViewById(R.id.spinner);
        ImageButton imageButton = this.findViewById(R.id.imageButton);

        final String[] payments = {"Visa", "Master Card", "American Express", "Discover"};

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                spinner.setSelection(i);
                listView.setVisibility(View.GONE);
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listView.setVisibility(View.VISIBLE);
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, payments);

        listView.setAdapter(adapter);
        spinner.setAdapter(adapter);
    }
}
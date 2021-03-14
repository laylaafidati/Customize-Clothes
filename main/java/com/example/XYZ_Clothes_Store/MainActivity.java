package com.example.XYZ_Clothes_Store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView titleCustomize, type, color, size;
    private Spinner spinnerType, spinnerColor, spinnerSize;
    private Button btnView, btnLoad;

    String pickType;
    String pickColor;
    String pickSize;

    ArrayList<String> arrayList_type;
    ArrayAdapter<String> arrayAdapter_type;
    ArrayList<String> arrayList_color;
    ArrayAdapter<String> arrayAdapter_color;
    ArrayList<String> arrayList_size;
    ArrayAdapter<String> arrayAdapter_size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleCustomize = (TextView)findViewById(R.id.textView_customize);
        type = (TextView)findViewById(R.id.textView_type);
        color = (TextView)findViewById(R.id.textView_color);
        size = (TextView)findViewById(R.id.textView_size);
        spinnerType = (Spinner)findViewById(R.id.spinner_type);
        spinnerColor = (Spinner)findViewById(R.id.spinner_color);
        spinnerSize = (Spinner)findViewById(R.id.spinner_size);
        btnView = (Button)findViewById(R.id.button_view);
        btnLoad = (Button)findViewById(R.id.button_load);

        arrayList_type = new ArrayList<>();
        String[] arrayList_type = {"Pick a type", "Shirt", "Pants", "Hat"};

        arrayAdapter_type = new ArrayAdapter<>(getApplicationContext(), R.layout.textview_spinner, arrayList_type);
        spinnerType.setAdapter(arrayAdapter_type);

        arrayList_color = new ArrayList<>();
        String[] arrayList_color = {"Pick a color", "Red", "Green", "Blue"};

        arrayAdapter_color = new ArrayAdapter<>(getApplicationContext(), R.layout.textview_spinner, arrayList_color);
        spinnerColor.setAdapter(arrayAdapter_color);

        arrayList_size = new ArrayList<>();
        String[] arrayList_size = {"Pick a size", "S", "M", "L", "XL"};

        arrayAdapter_size = new ArrayAdapter<>(getApplicationContext(), R.layout.textview_spinner, arrayList_size);
        spinnerSize.setAdapter(arrayAdapter_size);

        spinnerType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0){
                    pickType = spinnerType.getItemAtPosition(position).toString();

                    spinnerColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if (position != 0){
                                pickColor = spinnerColor.getItemAtPosition(position).toString();

                                spinnerSize.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        if (position != 0){
                                            pickSize = spinnerSize.getItemAtPosition(position).toString();

                                            btnView.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                                                    intent.putExtra("pick_type", pickType);
                                                    intent.putExtra("pick_color", pickColor);
                                                    intent.putExtra("pick_size", pickSize);
                                                    startActivity(intent);
                                                }
                                            });
                                        }
                                    }
                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {
                                    }
                                });
                            }
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }
}

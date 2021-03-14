package com.example.XYZ_Clothes_Store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private ImageView imageResult;
    private TextView typeResult, colorResult, sizeResult;
    private Button btnSave;

    int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        imageResult = (ImageView)findViewById(R.id.imageView_preview);
        typeResult = (TextView)findViewById(R.id.textView_typePreview);
        colorResult = (TextView)findViewById(R.id.textView_colorPreview);
        sizeResult = (TextView)findViewById(R.id.textView_sizePreview);
        btnSave = (Button)findViewById(R.id.btnSave);

        final String pickType = getIntent().getStringExtra("pick_type");
        final String pickColor = getIntent().getStringExtra("pick_color");
        final String pickSize = getIntent().getStringExtra("pick_size");

        typeResult.setText("Type  : " + pickType);
        colorResult.setText("Color : " + pickColor);
        sizeResult.setText("Size  : " + pickSize);

        if (pickType.equals("Shirt") && pickColor.equals("Red")) {
            imageResult.setImageResource(R.drawable.red_shirt);
            image = R.drawable.red_shirt;
        } else if (pickType.equals("Shirt") && pickColor.equals("Green")) {
            imageResult.setImageResource(R.drawable.green_shirt);
            image = R.drawable.green_shirt;
        } else if (pickType.equals("Shirt") && pickColor.equals("Blue")) {
            imageResult.setImageResource(R.drawable.blue_shirt);
            image = R.drawable.blue_shirt;
        } else if (pickType.equals("Pants") && pickColor.equals("Red")) {
            imageResult.setImageResource(R.drawable.red_pants);
            image = R.drawable.red_pants;
        } else if (pickType.equals("Pants") && pickColor.equals("Green")) {
            imageResult.setImageResource(R.drawable.green_pants);
            image = R.drawable.green_pants;
        } else if (pickType.equals("Pants") && pickColor.equals("Blue")) {
            imageResult.setImageResource(R.drawable.blue_pants);
            image = R.drawable.blue_pants;
        } else if (pickType.equals("Hat") && pickColor.equals("Red")) {
            imageResult.setImageResource(R.drawable.red_hat);
            image = R.drawable.red_hat;
        } else if (pickType.equals("Hat") && pickColor.equals("Green")) {
            imageResult.setImageResource(R.drawable.green_hat);
            image = R.drawable.green_hat;
        } else {
            imageResult.setImageResource(R.drawable.blue_hat);
            image = R.drawable.blue_hat;
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                final SharedPreferences.Editor mEditor = mPreferences.edit();
                mEditor.putString("savedType", pickType);
                mEditor.putString("savedColor", pickColor);
                mEditor.putString("savedSize", pickSize);
                mEditor.putInt("savedImage", image);

                mEditor.apply();
                finish();
            }
        });
    }
}

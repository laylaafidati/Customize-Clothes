package com.example.XYZ_Clothes_Store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    private ImageView imageSaved;
    private TextView typeSaved, colorSaved, sizeSaved, message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        imageSaved = (ImageView)findViewById(R.id.imageView_saved);
        typeSaved= (TextView)findViewById(R.id.textView_typeSaved);
        colorSaved = (TextView)findViewById(R.id.textView_colorSaved);
        sizeSaved = (TextView)findViewById(R.id.textView_sizeSaved);
        message = (TextView)findViewById(R.id.textView_noData);

        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor mEditor = mPreferences.edit();

        String type = mPreferences.getString("savedType", "");
        String color = mPreferences.getString("savedColor", "");
        String size = mPreferences.getString("savedSize", "");
        int image = mPreferences.getInt("savedImage", 0);

        if (!type.equals("")){
            typeSaved.setText("Type  : " + type);
            colorSaved.setText("Color : " + color);
            sizeSaved.setText("Size  : " + size);
            imageSaved.setImageResource(image);
        } else {
            message.setText("No Data Result");
        }
    }
}

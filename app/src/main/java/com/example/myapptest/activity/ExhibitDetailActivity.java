package com.example.myapptest.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapptest.R;
import com.example.myapptest.model.Exhibit;
import com.squareup.picasso.Picasso;

import static com.example.myapptest.activity.MainActivity.exhibits;

public class ExhibitDetailActivity extends AppCompatActivity {

    private ImageView exhibitImageView;
    private TextView nameTextView;
    private TextView descriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exhibit_detailctivity);

        exhibitImageView = findViewById(R.id.exhibit_imageview);
        nameTextView = findViewById(R.id.name_textview);
        descriptionTextView = findViewById(R.id.description_textview);
        Exhibit exhibit = exhibits.get(getIntent().getIntExtra("position", 0));
        showData(exhibit);
    }
    private void showData(Exhibit exhibit){

        if(exhibit != null){
            Picasso.with(this).load(exhibit.getImage()).into(exhibitImageView);
            nameTextView.setText(exhibit.getName());
            descriptionTextView.setText(exhibit.getDescription());
        }else{
            Toast.makeText(this, "Error showing data", Toast.LENGTH_SHORT).show();
        }
    }
}

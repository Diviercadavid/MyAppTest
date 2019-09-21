package com.example.myapptest.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapptest.R;
import com.example.myapptest.model.Exhibit;
import com.squareup.picasso.Picasso;
import com.willy.ratingbar.BaseRatingBar;
import com.willy.ratingbar.ScaleRatingBar;

import static com.example.myapptest.activity.MainActivity.exhibits;
import static com.example.myapptest.util.Utils.sharedRatingOfExhibit;

public class ExhibitDetailActivity extends AppCompatActivity {

    private ImageView exhibitImageView;
    private TextView nameTextView;
    private TextView descriptionTextView;
    private ScaleRatingBar scaleRatingBar;
    private Exhibit exhibit;
    private int exhibitPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exhibit_detailctivity);

        exhibitPosition = getIntent().getIntExtra("position", 0);
        exhibitImageView = findViewById(R.id.exhibit_imageview);
        nameTextView = findViewById(R.id.name_textview);
        descriptionTextView = findViewById(R.id.description_textview);
        scaleRatingBar = findViewById(R.id.simpleRatingBar);
        scaleRatingBar.setOnRatingChangeListener(setOnRatingListener());
        exhibit = exhibits.get(exhibitPosition);
        showData(exhibit);
    }

    /**
     * Validate and show data existing
     * @param exhibit current exhibit
     */
    private void showData(Exhibit exhibit){

        if(exhibit != null){
            Picasso.with(this).load(exhibit.getImage()).into(exhibitImageView);
            nameTextView.setText(exhibit.getName());
            descriptionTextView.setText(exhibit.getDescription());
            scaleRatingBar.setRating(exhibit.getStars());
        }else{
            Toast.makeText(this, getText(R.string.error_data_message), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Set Listener when when the user change the rating
     * @return OnRatingChangeListener
     */
    private ScaleRatingBar.OnRatingChangeListener setOnRatingListener (){
        return new BaseRatingBar.OnRatingChangeListener() {
            @Override
            public void onRatingChange(BaseRatingBar ratingBar, float rating, boolean fromUser) {
                updateRanting(rating);
            }
        };
    }

    /**
     * Manage and update exhibit with new rating
     * @param newRating new exhibit rating
     */
    private void updateRanting(float newRating){
        Exhibit exhibitWithRating = exhibits.get(exhibitPosition);
        exhibitWithRating.setStars((int) newRating);
        exhibits.remove(exhibitPosition);
        exhibits.add(exhibitPosition, exhibitWithRating);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 0, getString(R.string.share));
        return super.onCreateOptionsMenu(menu);
        }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case 1:
                sharedRatingOfExhibit(this, exhibit);
                return true;
            case android.R.id.home:
                // this takes the user 'back', as if they pressed the left-facing triangle icon on the main android toolbar.
                // if this doesn't work as desired, another possibility is to call `finish()` here.
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

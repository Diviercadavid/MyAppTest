package com.example.myapptest.util;

import android.content.Context;
import android.content.Intent;

import com.example.myapptest.R;
import com.example.myapptest.model.Exhibit;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    /**
     * Generate a Exhibit List with 3 items
     * @param context of the current Activity
     * @return List loaded
     */
    public static List<Exhibit> getCurrentExhibits(Context context) {
        List<Exhibit> exhibits = new ArrayList<>(3);

        exhibits.add(new Exhibit("https://www2.todayshipit.com/img/products/265584-12-roma-emperador-julio-cesar-augustus-pure-cobre-bronce-arte-estatua-escultura.jpg",
                4, "Emperor head", context.getString(R.string.exhibit_description), new String[]{"It's awesome", "I don't like"}));

        exhibits.add(new Exhibit("https://previews.123rf.com/images/sedmak/sedmak1211/sedmak121100112/16356515-bruselas-21-de-junio-estatua-de-sumo-sacerdote-de-la-iglesia-de-san-nicol%C3%A1s-el-21-de-junio-en-bruselas.jpg"
                , 4, "Priest statue", context.getString(R.string.exhibit_description), new String[]{"It's awesome", "I don't like"}));

        exhibits.add(new Exhibit("https://ae01.alicdn.com/kf/HTB1BdWpJXXXXXaKXpXXq6xXFXXXV/Sunsun00418-la-enorme-cabeza-de-le-n-escultura-de-bronce-plana-estatua-el-arte-colgante.jpg"
                , 4, "Lion head", context.getString(R.string.exhibit_description), new String[]{"It's awesome", "I don't like"}));

        return exhibits;
    }

    /**
     * Shared a exhibit with another apps
     * @param context context of the current activity
     * @param exhibit exhibit object to share
     */
    public static void sharedRatingOfExhibit(Context context, Exhibit exhibit){
        String shareBody = "Name: " + exhibit.getName() + " Stars: " + exhibit.getStars();
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Rating of museum exhibit");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        context.startActivity(Intent.createChooser(sharingIntent, context.getResources().getString(R.string.share_using)));
    }
}

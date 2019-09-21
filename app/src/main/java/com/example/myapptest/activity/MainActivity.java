package com.example.myapptest.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapptest.R;
import com.example.myapptest.adapter.ItemRecyclerViewAdapter;
import com.example.myapptest.model.Exhibit;

import java.util.List;

import static com.example.myapptest.util.Utils.getCurrentExhibits;

public class MainActivity extends AppCompatActivity {

    private RecyclerView itemsRecyclerView;
    public static List<Exhibit> exhibits;
    private ItemRecyclerViewAdapter itemsRecyclerViewcAdapter;
    private ItemRecyclerViewAdapter.OnItemClickListener onItemClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemsRecyclerView = findViewById(R.id.my_recycler_view);
        exhibits = getCurrentExhibits(this);

        onItemClickListener = setClickListenerOnItem();
        initializeRecyclerView();

    }

    /**
     * Initialize recyclerView and adapter to manage it
     */
    private void initializeRecyclerView(){
        itemsRecyclerViewcAdapter = new ItemRecyclerViewAdapter(exhibits, this, onItemClickListener);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        itemsRecyclerView.setLayoutManager(layoutManager);
        itemsRecyclerView.setAdapter(itemsRecyclerViewcAdapter);
    }

    /**
     * ItemClickListener when the user tap a Item of RecyclerView and open new Activity
     * @return OnItemClickListener
     */
    private ItemRecyclerViewAdapter.OnItemClickListener setClickListenerOnItem(){
        return new ItemRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Exhibit exhibit, int position) {
                startActivity(new Intent(MainActivity.this, ExhibitDetailActivity.class).putExtra("position", position));
            }

        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        itemsRecyclerViewcAdapter.notifyDataSetChanged();
    }
}

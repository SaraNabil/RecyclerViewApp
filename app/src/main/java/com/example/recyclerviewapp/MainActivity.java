package com.example.recyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.itemsRv)
    RecyclerView itemsRv;

    RecyclerAdapter adapter;
    ArrayList<RecyclerModel> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ButterKnife
        ButterKnife.bind(this);
        items = new ArrayList<>();
        items.add(new RecyclerModel(R.drawable.banana,"Banana Juice","$ 10"));
        items.add(new RecyclerModel(R.drawable.strawberry,"Strawberry Juice","$ 15"));
        items.add(new RecyclerModel(R.drawable.orange,"Orange Juice","$ 10"));
        items.add(new RecyclerModel(R.drawable.lemon,"Lemon Juice","$ 8"));
        items.add(new RecyclerModel(R.drawable.watermelon,"Watermelon Juice","$ 20"));

        adapter = new RecyclerAdapter(this, items);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        itemsRv.setAdapter(adapter);
        itemsRv.setLayoutManager(layoutManager);
    }
}

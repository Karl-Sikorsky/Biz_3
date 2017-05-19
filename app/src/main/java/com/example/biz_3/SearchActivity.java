package com.example.biz_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private List<Category> categoriesList;
    private RecyclerView rvc, rvc2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        rvc=(RecyclerView)findViewById(R.id.rvc);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rvc.setLayoutManager(llm);
        rvc.setHasFixedSize(true);

        rvc2=(RecyclerView)findViewById(R.id.rvc2);

        LinearLayoutManager llm2 = new LinearLayoutManager(this);
        rvc2.setLayoutManager(llm2);
        rvc2.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }
    public boolean onCreateOptionsMenu(Menu menu) {

        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.place_search_head));
        return super.onCreateOptionsMenu(menu);

    }
    private void initializeData() {
        categoriesList = new ArrayList<>();
        for(int i=0;i<20;i++){

            categoriesList.add(new Category("category "+String.valueOf(i)));

        }
    }
    private void initializeAdapter(){
        CategoryAdapter adapter = new CategoryAdapter(categoriesList, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                Toast.makeText(getApplicationContext(), "item "+String.valueOf(position), Toast.LENGTH_SHORT).show();
            }
        });
        rvc.setAdapter(adapter);
        rvc2.setAdapter(adapter);
    }
}

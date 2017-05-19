package com.example.biz_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {
    private List<Enterprise> enterpriseList;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        rv=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(getApplicationContext(), enterpriseList, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                 Toast.makeText(getApplicationContext(), "item "+String.valueOf(position), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                intent.putExtra("enterprise", position);
                startActivity(intent);
            }
        });
        rv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.bgmenu));
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(MainActivity.this, SearchActivity.class);
        startActivity(intent);
        return true;
    }

    private void initializeData() {
        enterpriseList = new ArrayList<>();
        for(int i=0;i<20;i++){
            
            enterpriseList.add(new Enterprise("Enterprise "+String.valueOf(i), "description "+String.valueOf(i),"telephon "+String.valueOf(i),"city "+String.valueOf(i),"category "+String.valueOf(i)));
           
        }
    }
}

package com.example.biz_3.View;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Toast;

import com.example.biz_3.Model.CustomItemClickListener;
import com.example.biz_3.Model.Enterprise;

import com.example.biz_3.Model.retrofit_package.BizGidApi;

import com.example.biz_3.Presenter.AllPresenter;
import com.example.biz_3.Presenter.MainPresenter;
import com.example.biz_3.Presenter.RVAdapter;
import com.example.biz_3.R;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements AllView{
    private List<Enterprise> enterpriseList;
    private RecyclerView rv;

    private AllPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        rv=(RecyclerView)findViewById(R.id.rv);



        presenter = new MainPresenter(this, getApplicationContext());

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);
        int resId = R.anim.layout_fall_down_anim;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(this, resId);
        rv.setLayoutAnimation(animation);


        enterpriseList = new ArrayList<Enterprise>();

       enterpriseList = presenter.initData();


    }

    public void initializeAdapter(){
        for(int i=0;i<enterpriseList.size();i++){
            Log.d("onAdapter", "before constructor list is "+enterpriseList.get(i).getName()+enterpriseList.get(i).getDescription());
        }
        RVAdapter adapter = new RVAdapter(getApplicationContext(), enterpriseList, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                 Toast.makeText(getApplicationContext(), "name is "+enterpriseList.get(position).getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                intent.putExtra("enterprise", enterpriseList.get(position).getName());
                intent.putExtra("slug",enterpriseList.get(position).getSlug());
                startActivity(intent);
            }
        });
        rv.setAdapter(adapter);
        runLayoutAnimation(rv);

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






    private void runLayoutAnimation(final RecyclerView recyclerView) {
        final Context context = recyclerView.getContext();
        final LayoutAnimationController controller =
                AnimationUtils.loadLayoutAnimation(context, R.anim.layout_fall_down_anim);

        recyclerView.setLayoutAnimation(controller);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }
}

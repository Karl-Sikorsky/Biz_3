package com.example.biz_3.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.biz_3.Model.CustomItemClickListener;
import com.example.biz_3.Model.Product;
import com.example.biz_3.Model.retrofit_package.ApiUtils;
import com.example.biz_3.Model.retrofit_package.BizGidApi;
import com.example.biz_3.Model.retrofit_package.CompanyObject;
import com.example.biz_3.Presenter.AllPresenter;
import com.example.biz_3.Presenter.InfoPresenter;
import com.example.biz_3.Presenter.ProductAdapter;
import com.example.biz_3.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InfoActivity extends AppCompatActivity implements FragmentInfoProduct.MyInterface, FragmentAllProducts.ListInterface, AllView {
    private List<Product> productList;
    private RecyclerView rv;
    private final int ALL_FRAGMENT = 456, FRAGMENT_PRODUCT = 228;
    Button buttonAll;
    FragmentInfoProduct fragmentProduct;
    OrderFragment fragmentOrder;
    FragmentAllProducts fragmentAll;
    String enterpriseName;
    TextView ent_name;
    String slug;
    int currentProduct;


    private AllPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_info);
      getSupportActionBar().hide();

        Intent intent = getIntent();
        enterpriseName = intent.getStringExtra("enterprise");
        slug = intent.getStringExtra("slug");
        ent_name = (TextView)findViewById(R.id.textView2);
        ent_name.setText(enterpriseName);
        productList = new ArrayList<Product>();
        presenter = new InfoPresenter(this,getApplicationContext());

        fragmentProduct = new FragmentInfoProduct();
        fragmentOrder = new OrderFragment();
        fragmentAll = new FragmentAllProducts();
        rv=(RecyclerView)findViewById(R.id.recycle_products);

        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);



        productList = presenter.initDataProducts();


        buttonAll = (Button)findViewById(R.id.buttonAll);
        buttonAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentAll.setTargetFragment(fragmentAll,ALL_FRAGMENT);
                fragmentAll.show(getFragmentManager(),"Все продукты");
            }
        });
    }



    public void initializeAdapter(){
        ProductAdapter adapter = new ProductAdapter(productList, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                Toast.makeText(getApplicationContext(), "item "+String.valueOf(position), Toast.LENGTH_SHORT).show();
                fragmentProduct.setTargetFragment(fragmentProduct, FRAGMENT_PRODUCT);
                fragmentProduct.show(getFragmentManager(), "Имя продукта");

            }
        });
        rv.setAdapter(adapter);
    }
    private void initializeData() {

    }

    @Override
    public void onChoose(String tag) {
        Log.d("TAG_TAG","ok, onChoose()");
        Toast.makeText(getApplicationContext(),"GET ON CHOOSE", Toast.LENGTH_SHORT).show();
        fragmentOrder.setTargetFragment(fragmentOrder, 0);
        fragmentOrder.show(getFragmentManager(), "Заказ продукта");

    }

    @Override
    public void onChooseList(int tag) {
        currentProduct = tag;
        Toast.makeText(getApplicationContext(),"GET ON CHOOSELIST", Toast.LENGTH_SHORT).show();
        fragmentProduct.setTargetFragment(fragmentProduct, FRAGMENT_PRODUCT);
        fragmentProduct.show(getFragmentManager(), "Продукт номер "+tag);


    }
    public List<Product> getProductList(){
        return productList;
    }
    public int getCurrentProduct(){
        return currentProduct;
    }

}

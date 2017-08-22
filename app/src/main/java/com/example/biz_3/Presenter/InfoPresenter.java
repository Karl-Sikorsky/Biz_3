package com.example.biz_3.Presenter;

import android.content.Context;
import android.util.Log;

import com.example.biz_3.Model.Enterprise;
import com.example.biz_3.Model.Product;
import com.example.biz_3.Model.retrofit_package.ApiUtils;
import com.example.biz_3.Model.retrofit_package.BizGidApi;
import com.example.biz_3.Model.retrofit_package.CompanyObject;
import com.example.biz_3.View.AllView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Karl on 22.08.2017.
 */

public class InfoPresenter implements AllPresenter {
    AllView view;
    Context context;
    private BizGidApi mServise;
    private List<Product> productList;
    String slug;

  public InfoPresenter(AllView view, Context context){
      this.view = view;
      this.context = context;
      mServise = ApiUtils.getApi();
  }

    @Override
    public List<Enterprise> initData() {
        return null;
    }

    @Override
    public List<Product> initDataProducts() {
        productList = new ArrayList<>();
        mServise.getDataCompany(slug).enqueue(new Callback<CompanyObject>(){
            @Override
            public void onResponse(Call<CompanyObject> call, Response<CompanyObject> response) {

                if(response.isSuccessful()) {
                    for(int i=0;i<response.body().getProducts().size();i++) {

                        productList.add(new Product(response.body().getProducts().get(i).getImage(), response.body().getProducts().get(i).getName(), 0));
                    }
                    for(int i=0;i<productList.size();i++){
                        Log.d("onAdapter", "wtf after we parse list he is "+productList.get(i).getName());}
                    Log.d("onAdapter","creating list size is: "+productList.size());
                    Log.d("MainActivity", "posts loaded from API");
                    initAdapter();
                }else {
                    int statusCode  = response.code();

                }
            }

            @Override
            public void onFailure(Call<CompanyObject> call, Throwable t) {
                Log.d("MainActivity", call.toString());
                Log.d("MainActivity", "error loading from API");
                Log.d("MainActivity", t.toString());
                Log.d("MainActivity", mServise.getData().toString());

            }
        });




        initAdapter();
        return productList;
    }

    @Override
    public void initAdapter() {
    view.initializeAdapter();
    }

    @Override
    public List<Enterprise> createDatafromDB() {
        return null;
    }

    @Override
    public void saveToDB(List<Enterprise> list) {

    }
}

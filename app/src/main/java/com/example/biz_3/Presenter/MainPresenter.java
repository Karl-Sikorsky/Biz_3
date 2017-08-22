package com.example.biz_3.Presenter;

import android.content.Context;
import android.util.Log;

import com.example.biz_3.Model.Enterprise;
import com.example.biz_3.Model.Product;
import com.example.biz_3.Model.retrofit_package.ApiUtils;
import com.example.biz_3.Model.retrofit_package.BizGidApi;
import com.example.biz_3.Model.retrofit_package.EnterpriseObject;
import com.example.biz_3.View.AllView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ПОДАРУНКОВИЙ on 22.08.2017.
 */

public class MainPresenter implements AllPresenter {
    AllView view;
    Context context;
    private List<Enterprise> enterpriseList;
    private BizGidApi mServise;

    public MainPresenter(AllView view, Context context) {
        this.view = view;
        this.context = context;
        mServise = ApiUtils.getApi();
    }

    @Override
    public List<Enterprise> initData() {


        enterpriseList = new ArrayList<>();
        Log.d("realmLOG", "start");
        mServise.getData().enqueue(new Callback<List<EnterpriseObject>>() {
            @Override
            public void onResponse(Call<List<EnterpriseObject>> call, Response<List<EnterpriseObject>> response) {

                if (response.isSuccessful()) {
                    Log.d("realmLOG", "response sucsess");
                    for (int i = 0; i < response.body().size(); i++) {
                        Log.d("MainActivity", response.body().get(i).getName() + response.body().get(i).getId());
                        enterpriseList.add(new Enterprise(response.body().get(i).getName(), response.body().get(i).getId(), response.body().get(i).getPhones().get(0), response.body().get(i).getRegionName(), response.body().get(i).getSlug(), response.body().get(i).getSlug()));
                    }
                    for (int i = 0; i < enterpriseList.size(); i++) {
                        Log.d("onAdapter", "wtf after we parse list he is " + enterpriseList.get(i).getDescription());
                    }
                    Log.d("onAdapter", "creating list size is: " + enterpriseList.size());
                    Log.d("MainActivity", "posts loaded from API");
                    saveToDB(enterpriseList);

                    initAdapter();
                } else {
                    int statusCode = response.code();
                    Log.d("realmLOG", "response not ok");
                    enterpriseList = new ArrayList<Enterprise>(createDatafromDB());
                    Log.d("realmLOG", "data created");
                    initAdapter();
                }
            }

            @Override
            public void onFailure(Call<List<EnterpriseObject>> call, Throwable t) {
                Log.d("MainActivity", call.toString());
                Log.d("MainActivity", "error loading from API");
                Log.d("MainActivity", t.toString());
                Log.d("MainActivity", mServise.getData().toString());
                Log.d("realmLOG", "failure");
                enterpriseList = new ArrayList<Enterprise>(createDatafromDB());
                Log.d("realmLOG", "but data created");
                for (int i = 0; i < enterpriseList.size(); i++) {
                    Log.d("realmLOG", enterpriseList.get(i).getName());
                }
                initAdapter();
            }
        });

        return enterpriseList;
    }

    @Override
    public List<Product> initDataProducts() {
        return null;
    }

    @Override
    public void initAdapter() {
        view.initializeAdapter();

    }

    @Override
    public List<Enterprise> createDatafromDB() {
        List<Enterprise> enterprisesfromDB = new ArrayList<>();

        Realm myRealm =  Realm.getInstance(context);
        myRealm.beginTransaction();
        RealmResults<Enterprise> results1 =
                myRealm.where(Enterprise.class).findAll();
        for(Enterprise i : results1){
            enterprisesfromDB.add(new Enterprise(i.getName(),i.getDescription(),i.getTelephon(),i.getCity(),i.getSlug(),i.getSlug()));
            Log.d("realmLOG",i.getName());
        }
        myRealm.commitTransaction();
        myRealm.close();
        return enterprisesfromDB;

    }

    @Override
    public void saveToDB(List<Enterprise> list) {
        Realm myRealm = Realm.getInstance(context);

        myRealm.beginTransaction();
        myRealm.clear(Enterprise.class);
        myRealm.commitTransaction();
        for (int i = 0; i < enterpriseList.size(); i++) {
            myRealm.beginTransaction();

            Enterprise enterpriseRealm = myRealm.createObject(Enterprise.class);
            enterpriseRealm.setName(enterpriseList.get(i).getName());
            enterpriseRealm.setCategory(enterpriseList.get(i).getCategory());
            enterpriseRealm.setDescription(enterpriseList.get(i).getDescription());
            enterpriseRealm.setTelephon(enterpriseList.get(i).getTelephon());
            enterpriseRealm.setCity(enterpriseList.get(i).getCity());
            myRealm.commitTransaction();
        }
        Log.d("realmLOG", "save to DB ok");
        myRealm.close();
    }
}

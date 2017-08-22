package com.example.biz_3.Presenter;

import com.example.biz_3.Model.Enterprise;
import com.example.biz_3.Model.Product;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Karl on 22.08.2017.
 */

public interface AllPresenter {
    List<Enterprise> initData();
    List<Product> initDataProducts();
    void initAdapter();
    List<Enterprise> createDatafromDB();
    void saveToDB(List<Enterprise> list);
}

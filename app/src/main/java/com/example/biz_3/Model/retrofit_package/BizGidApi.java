package com.example.biz_3.Model.retrofit_package;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Karl on 26.07.2017.
 */

public interface BizGidApi {
    @GET("api/companies")
    Call<List<EnterpriseObject>> getData();

    @GET("api/companies/{name}")
    Call<CompanyObject> getDataCompany(@Path("name") String name);
}

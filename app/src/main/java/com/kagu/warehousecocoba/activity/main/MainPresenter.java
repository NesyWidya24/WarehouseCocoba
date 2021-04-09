package com.kagu.warehousecocoba.activity.main;

import androidx.annotation.NonNull;

import com.kagu.warehousecocoba.api.ApiClient;
import com.kagu.warehousecocoba.api.ApiInterface;
import com.kagu.warehousecocoba.model.Warehouse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {
    private MainView view;

    public MainPresenter(MainView view) {
        this.view = view;
    }

    void getData(){
        view.showLoading();

        //Request to server
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<Warehouse>> call = apiInterface.getWarehouse();
        call.enqueue(new Callback<List<Warehouse>>() {
            @Override
            public void onResponse(@NonNull Call<List<Warehouse>> call,@NonNull Response<List<Warehouse>> response) {
                view.hideLoading();
                if (response.isSuccessful() && response.body() != null){
                    view.onGetResult(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Warehouse>> call,@NonNull  Throwable t) {
                view.hideLoading();
                view.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }
}

package com.kagu.warehousecocoba.activity.main;

import com.kagu.warehousecocoba.model.Warehouse;

import java.util.List;

public interface MainView {
    void showLoading();
    void hideLoading();
    void onGetResult(List<Warehouse> warehouses);
    void onErrorLoading(String message);
}

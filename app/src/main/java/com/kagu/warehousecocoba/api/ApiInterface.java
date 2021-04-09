package com.kagu.warehousecocoba.api;

import com.kagu.warehousecocoba.model.Warehouse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("postDataBarang.php")
    Call<Warehouse> saveItem(
            @Field("Kode Gudang") String codeWarehouse,
            @Field("Kode Barang") String codeItem,
            @Field("Nama Barang") String nameItem,
            @Field("Jenis Barang") String typeOfItem,
            @Field("Jumlah Stok") String totalItems,
            @Field("Satuan") String unit
    );

    @GET("https://api.cocobadev.com/getAllDataGudang.php")
    Call<List<Warehouse>> getWarehouse();
}

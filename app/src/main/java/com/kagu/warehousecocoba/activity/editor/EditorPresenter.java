package com.kagu.warehousecocoba.activity.editor;

import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.kagu.warehousecocoba.api.ApiClient;
import com.kagu.warehousecocoba.api.ApiInterface;
import com.kagu.warehousecocoba.model.Warehouse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditorPresenter {

    private EditorView view;

    public EditorPresenter(EditorView view) {
        this.view = view;
    }

    void saveAllDataWarehouse(final String codeWarehouse, final String codeItem, final String nameItem, final String typeOfItem, final String totalItems, final String unit) {

        view.showProgress();

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<Warehouse> call = apiInterface.saveItem(codeWarehouse, codeItem, nameItem, typeOfItem, totalItems, unit);

        call.enqueue(new Callback<Warehouse>() {
            @Override
            public void onResponse(Call<Warehouse> call, Response<Warehouse> response) {
                view.hideProgress();

                if (response.isSuccessful() && response.body() != null) {
                    Boolean success = response.body().getSuccess();
                    if (success) {
                        view.onAddSuccess(response.body().getMessage());
                    } else {
                        view.onAddError(response.body().getMessage());
//                        Toast.makeText(EditorActivity.this,
//                                response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    } //if error, still in this activity
                }
            }

            @Override
            public void onFailure(@NonNull Call<Warehouse> call, @NonNull Throwable t) {
                view.hideProgress();
                view.onAddError(t.getLocalizedMessage());
            }
        });
    }
}

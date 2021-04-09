package com.kagu.warehousecocoba.activity.editor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.kagu.warehousecocoba.R;
import com.kagu.warehousecocoba.api.ApiClient;
import com.kagu.warehousecocoba.api.ApiInterface;
import com.kagu.warehousecocoba.model.Warehouse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditorActivity extends AppCompatActivity implements EditorView{
    EditText etCodeWarehouse,
            etCodeItem,
            etNameItem,
            etTypeOfItem,
            etTotalItems,
            etUnit;

    ProgressDialog progressDialog;

    EditorPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        etCodeWarehouse = findViewById(R.id.codeWarehouse);
        etCodeItem = findViewById(R.id.codeItem);
        etNameItem = findViewById(R.id.nameItem);
        etTypeOfItem = findViewById(R.id.typeOfItem);
        etTotalItems = findViewById(R.id.totalItems);
        etUnit = findViewById(R.id.unit);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait..");
        progressDialog.setCanceledOnTouchOutside(false);

        presenter = new EditorPresenter(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save:
                String codeWarehouse = etCodeWarehouse.getText().toString().trim();
                String codeItem = etCodeItem.getText().toString().trim();
                String nameItem = etNameItem.getText().toString().trim();
                String typeOfItem = etTypeOfItem.getText().toString().trim();
                String totalItems = etTotalItems.getText().toString().trim();
                String unit = etUnit.getText().toString().trim();

                if (codeWarehouse.isEmpty()) {
                    etCodeWarehouse.setError("Please enter the field");
                } else if (codeItem.isEmpty()) {
                    etCodeItem.setError("Please enter the field");
                } else if (nameItem.isEmpty()) {
                    etNameItem.setError("Please enter the field");
                } else if (typeOfItem.isEmpty()) {
                    etTypeOfItem.setError("Please enter the field");
                } else if (totalItems.isEmpty()) {
                    etTotalItems.setError("Please enter the field");
                } else if (unit.isEmpty()) {
                    etUnit.setError("Please enter the field");
                } else {
                    presenter.saveAllDataWarehouse(codeWarehouse,
                            codeItem,
                            nameItem,
                            typeOfItem,
                            totalItems,
                            unit);
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.hide();
    }

    @Override
    public void onAddSuccess(String message) {
        Toast.makeText(EditorActivity.this,
                message, Toast.LENGTH_SHORT).show();
        finish(); //back to main activity
    }

    @Override
    public void onAddError(String message) {
        Toast.makeText(EditorActivity.this,
                message, Toast.LENGTH_SHORT).show();
        finish(); //back to main activity
    }
}
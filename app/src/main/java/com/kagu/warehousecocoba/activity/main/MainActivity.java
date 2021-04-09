package com.kagu.warehousecocoba.activity.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.kagu.warehousecocoba.R;
import com.kagu.warehousecocoba.activity.editor.EditorActivity;
import com.kagu.warehousecocoba.model.Warehouse;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView{
    FloatingActionButton fab;
    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefresh;

    MainPresenter presenter;
    MainAdapter adapter;
    MainAdapter.ItemClickListener itemClickListener;

    List<Warehouse> warehouse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.add);
        recyclerView = findViewById(R.id.recycler_view);
        swipeRefresh = findViewById(R.id.swipe_refresh);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fab.setOnClickListener(v -> {
            startActivity(new Intent(this, EditorActivity.class));
        });

        presenter = new MainPresenter(this);
        presenter.getData();

        swipeRefresh.setOnRefreshListener(
                ()-> presenter.getData()
        );

        itemClickListener = ((view, position) -> {
            String codeWarehouse = warehouse.get(position).getCodeWarehouse();
            Toast.makeText(this, codeWarehouse, Toast.LENGTH_SHORT).show();
//            String nameItem = warehouse.get(position).getNameItem();
        });
    }

    @Override
    public void showLoading() {
        swipeRefresh.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        swipeRefresh.setRefreshing(false);
    }

    @Override
    public void onGetResult(List<Warehouse> warehouses) {
        adapter = new MainAdapter(this, warehouses, itemClickListener);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

        warehouse = warehouses;
    }

    @Override
    public void onErrorLoading(String message) {
        Toast.makeText(this, message,Toast.LENGTH_SHORT).show();
    }
}
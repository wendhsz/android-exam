package com.example.androidexam;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.androidexam.databinding.ActivityMainBinding;
import com.example.androidexam.model.Person;
import com.example.androidexam.view.PersonAdapter;
import com.example.androidexam.viewmodel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Person> person = new ArrayList<>();
    private RecyclerView recyclerView;
    private PersonAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ActivityMainBinding binding;
    private MainActivityViewModel viewModel;

    ProgressDialog progressDialog;

    private int page = 1;

    boolean isLoading = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.swipe_layout), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        binding = DataBindingUtil.setContentView(this,
                R.layout.activity_main);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Loading Data");

        viewModel = new ViewModelProvider(this)
                .get(MainActivityViewModel.class);
        getPersons(page, false);
        displayInRecyclerView();
        initializeScrollListener();

        swipeRefreshLayout = binding.swipeLayout;
        swipeRefreshLayout.setColorSchemeResources(R.color.black);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPersons(page, true);
                swipeRefreshLayout.setRefreshing(false);
                isLoading = false;
            }
        });
    }

    private void getPersons(int page,boolean forceUpdate){
        viewModel.getAllPerson(page,forceUpdate).observe(this, new Observer<List<Person>>() {
            @Override
            public void onChanged(List<Person> people) {
                ArrayList< Person> result = (ArrayList<Person>) people;
                if(isLoading)
                {
                    person.addAll(result);
                    Log.d("wendy", "person: " + (person.size()-1));
                    adapter.setData(person);
                    return;
                }
                else {
                    person = result;
                    adapter.setData(person);
                }
                isLoading = false;

            }
        });
    }



    private void displayInRecyclerView()
    {

        recyclerView = binding.recyclerview;
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));

        adapter = new PersonAdapter(this, person);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        adapter.notifyItemChanged(0, person.size()-1);
        adapter.notifyDataSetChanged();
    }

    private void initializeScrollListener(){

        //TODO: FIX THIS - IMPLEMENT PAGING LIBRARY

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

                Log.d("wendy", "last visible item position: " +linearLayoutManager.findLastCompletelyVisibleItemPosition() + " person size - 1: " + (recyclerView.getAdapter().getItemCount()-1) );


                if (!isLoading && linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == recyclerView.getAdapter().getItemCount()-1) {
                    Log.d("WENDY", "Load more!");
//                    page++;
//                    scrolledDown = true;
//                    getPersons(page, true);
                    isLoading = true;
                    loadMore();
                }
            }
        });
    }

    private void loadMore() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                page++;
                getPersons(page, false);

            }
        },1000);

    }
}
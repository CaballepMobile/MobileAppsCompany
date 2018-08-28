package com.example.admin.mvvmarchitecturecomp.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.mvvmarchitecturecomp.AppController;
import com.example.admin.mvvmarchitecturecomp.R;
import com.example.admin.mvvmarchitecturecomp.adapters.rvMain_WeatherAdapter;
import com.example.admin.mvvmarchitecturecomp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setupViewModels();
        setUpObservers();
        binding.setViewModel(mainViewModel);
        binding.setLifecycleOwner(this);
        //binding.set(mainViewModel);
    }

    private void setupViewModels() {
        //Survives the orientation changes -> stored in a viewmodel store in a hashmap
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
    }

    private void setUpObservers() {
        mainViewModel.getWeatherForcast().observe(this, weatherList -> {
            binding.rvMain.setLayoutManager(new LinearLayoutManager(this));
            binding.rvMain.setAdapter(new rvMain_WeatherAdapter(weatherList, this));
            binding.rvMain.setItemAnimator(new DefaultItemAnimator());
        });
    }

    private void injectDependencies(){
        ((AppController) getApplication()).getAppComponent().Inject(this);
    }
}

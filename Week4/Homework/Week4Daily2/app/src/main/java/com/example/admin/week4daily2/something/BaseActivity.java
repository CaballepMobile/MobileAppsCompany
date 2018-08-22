package com.example.admin.week4daily2.something;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity<T extends ViewDataBinding, V extends BaseViewModel> extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind();
    }

    private T binding;
    private V viewModel;

    public abstract @IdRes
    int getVariable();

    public abstract @LayoutRes
    int getLayoutId();

    public void bind(){
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        this.viewModel = viewModel == null? onCreate() : viewModel; //Ternary operator
        binding.setVariable(getVariable(), viewModel);
        binding.executePendingBindings();
    }

    public abstract V onCreate();

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.onResume();
    }
}

package com.example.admin.codechallengekotlin.utils

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer

class SingleEventLiveData<T> : MutableLiveData<T>() {


    override fun observe(owner: LifecycleOwner, observer: Observer<T>) {

        super.observe(owner, Observer { t ->

            if (t == null) {
                return@Observer
            }

            observer.onChanged(t)
            setValue(null)
        })
    }

}
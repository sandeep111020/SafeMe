package com.example.safeme.ui.web;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WebViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public WebViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("No exposures found");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
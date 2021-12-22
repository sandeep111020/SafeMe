package com.example.safeme.ui.home;

import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.safeme.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        TextView lock=root.findViewById(R.id.lock);
        TextView osversion=root.findViewById(R.id.version);
        String myVersion = android.os.Build.VERSION.RELEASE;
        int sdkVersion = android.os.Build.VERSION.SDK_INT;
        if (Integer.parseInt(myVersion)>8){
            osversion.setText("Latest");
            osversion.setTextColor(Color.GREEN);
        }else{
            osversion.setText("Old");
            osversion.setTextColor(Color.RED);
        }

        KeyguardManager myKM = (KeyguardManager) getContext().getSystemService(Context.KEYGUARD_SERVICE);
        if( myKM.inKeyguardRestrictedInputMode() ) {
            // it is locked

            lock.setText("notlocked" );
            lock.setTextColor(Color.RED);


        } else {
            //it is not locked
            lock.setText("locked" );

            lock.setTextColor(Color.GREEN);

        }

        return root;
    }
}
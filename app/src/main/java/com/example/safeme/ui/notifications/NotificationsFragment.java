package com.example.safeme.ui.notifications;

import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Color;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
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

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);
        TextView lock=root.findViewById(R.id.lockid);
        TextView locktime= root.findViewById(R.id.locktime);
        TextView encrypt=root.findViewById(R.id.devencrypt);
        TextView devopt=root.findViewById(R.id.devoption);
        TextView location=root.findViewById(R.id.location);
        TextView osversion= root.findViewById(R.id.osversion);
        boolean gps_enabled = false;
        String myVersion = android.os.Build.VERSION.RELEASE;
        int sdkVersion = android.os.Build.VERSION.SDK_INT;
        if (Integer.parseInt(myVersion)>8){
            osversion.setText("Latest");
            osversion.setTextColor(Color.GREEN);
        }else{
            osversion.setText("Old");
            osversion.setTextColor(Color.RED);
        }
        osversion.setText(myVersion);
        LocationManager lm = (LocationManager)getContext().getSystemService(Context.LOCATION_SERVICE); ;

        try {
            gps_enabled = lm.isProviderEnabled(LocationManager. GPS_PROVIDER ) ;
            if (gps_enabled==false){
                location.setText("Disabled");
                location.setTextColor(Color.GREEN);
            }else{
                location.setText("Enabled");
                location.setTextColor(Color.RED);
            }

        } catch (Exception e) {
            e.printStackTrace() ;
        }
        KeyguardManager myKM = (KeyguardManager) getContext().getSystemService(Context.KEYGUARD_SERVICE);
        if( myKM.inKeyguardRestrictedInputMode() ) {
            // it is locked
            encrypt.setText("Disabled");
            lock.setText("notlocked" );
            lock.setTextColor(Color.RED);
            encrypt.setTextColor(Color.RED);

        } else {
            //it is not locked
            lock.setText("locked" );
            encrypt.setText("Enabled");
            lock.setTextColor(Color.GREEN);
            encrypt.setTextColor(Color.GREEN);

        }
        try {
            int mSystemScreenOffTimeOut = Settings.System.getInt(getContext().getContentResolver(), Settings.System.SCREEN_OFF_TIMEOUT);

            locktime.setText(mSystemScreenOffTimeOut+"");
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
        int adb = Settings.Secure.getInt(this.getContext().getContentResolver(),
                Settings.Global.DEVELOPMENT_SETTINGS_ENABLED , 0);
        if (adb ==1){
            devopt.setText("Enabled");
            devopt.setTextColor(Color.RED);
        }else{
            devopt.setText("Disabled");
            devopt.setTextColor(Color.GREEN);
        }

     /*   notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }
}
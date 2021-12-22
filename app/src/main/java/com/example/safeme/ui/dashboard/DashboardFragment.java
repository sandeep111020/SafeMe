package com.example.safeme.ui.dashboard;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.safeme.CourseAdapter;
import com.example.safeme.CourseModel;
import com.example.safeme.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    RecyclerView recyclerView;
    private CourseAdapter adapter;
    private DatabaseReference databaseRef6;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        recyclerView = root.findViewById(R.id.idRVItems);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

     /*   CourseModel statusModel = new CourseModel("random text from the app","Order placed within 3 days");
        databaseRef6 = FirebaseDatabase.getInstance().getReference().child("Courses");
        String uploadid=databaseRef6.push().getKey();

        databaseRef6.child(uploadid).setValue(statusModel);*/
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        FirebaseRecyclerOptions<CourseModel> options =
                new FirebaseRecyclerOptions.Builder<CourseModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference("Courses"), CourseModel.class)
                        .build();

        adapter = new CourseAdapter(options,getActivity().getApplicationContext());
        recyclerView.setAdapter(adapter);
        return root;
    }
    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
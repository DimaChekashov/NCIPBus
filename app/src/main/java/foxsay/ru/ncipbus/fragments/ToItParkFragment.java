package foxsay.ru.ncipbus.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import foxsay.ru.ncipbus.R;
import foxsay.ru.ncipbus.TimeItem;
import foxsay.ru.ncipbus.adapters.ListAdapter;

public class ToItParkFragment extends Fragment {

    private List<TimeItem> timesList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ListAdapter tAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_to_itpark, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recycler_view_to);

        tAdapter = new ListAdapter(timesList);
        RecyclerView.LayoutManager tLayoutManager = new LinearLayoutManager(Objects.requireNonNull(getContext()).getApplicationContext());
        recyclerView.setLayoutManager(tLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(tAdapter);

        prepareTimesData();
        setHandler();
    }

    public void setHandler(){
        final Handler handler = new Handler();
        final int delay = 1000 ; //1000 milliseconds = 1 sec

        handler.postDelayed(new Runnable(){
            public void run(){
                tAdapter.timer(); // call our adapter method here
                handler.postDelayed(this, delay);
            }
        }, delay);
    }

    private void prepareTimesData() {
        TimeItem timeItem = new TimeItem("7:05", true);
        timesList.add(timeItem);

        timeItem = new TimeItem("7:35", true);
        timesList.add(timeItem);

        timeItem = new TimeItem("8:05", false);
        timesList.add(timeItem);

        timeItem = new TimeItem("8:35", false);
        timesList.add(timeItem);

        timeItem = new TimeItem("11:15", true);
        timesList.add(timeItem);

        timeItem = new TimeItem("12:15", false);
        timesList.add(timeItem);

        timeItem = new TimeItem("12:45", false);
        timesList.add(timeItem);

        timeItem = new TimeItem("13:15", false);
        timesList.add(timeItem);

        timeItem = new TimeItem("14:45", false);
        timesList.add(timeItem);

        timeItem = new TimeItem("15:15", false);
        timesList.add(timeItem);

        timeItem = new TimeItem("16:15", false);
        timesList.add(timeItem);
    }
}

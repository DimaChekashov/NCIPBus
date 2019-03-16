package foxsay.ru.ncipbus.fragments;

import android.os.Bundle;
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

public class FromItParkFragment extends Fragment {

    private List<TimeItem> timesList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ListAdapter tAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_from_itpark, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recycler_view_from);

        tAdapter = new ListAdapter(timesList);
        RecyclerView.LayoutManager tLayoutManager = new LinearLayoutManager(Objects.requireNonNull(getContext()).getApplicationContext());
        recyclerView.setLayoutManager(tLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(tAdapter);

        prepareTimesData();
    }

    private void prepareTimesData() {
        TimeItem timeItem = new TimeItem(11, 0);
        timesList.add(timeItem);

        timeItem = new TimeItem(12, 0);
        timesList.add(timeItem);

        timeItem = new TimeItem(12, 30);
        timesList.add(timeItem);

        timeItem = new TimeItem(13, 0);
        timesList.add(timeItem);

        timeItem = new TimeItem(14, 30);
        timesList.add(timeItem);

        timeItem = new TimeItem(15, 0);
        timesList.add(timeItem);

        timeItem = new TimeItem(16, 0);
        timesList.add(timeItem);

        timeItem = new TimeItem(17, 5);
        timesList.add(timeItem);

        timeItem = new TimeItem(17, 40);
        timesList.add(timeItem);

        timeItem = new TimeItem(18, 10);
        timesList.add(timeItem);
    }
}

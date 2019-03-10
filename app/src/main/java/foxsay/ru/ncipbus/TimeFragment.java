package foxsay.ru.ncipbus;

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

public class TimeFragment extends Fragment {

    private List<TimeItem> timesList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ListAdapter tAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_time, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recycler_view);

        tAdapter = new ListAdapter(timesList);
        RecyclerView.LayoutManager tLayoutManager = new LinearLayoutManager(Objects.requireNonNull(getContext()).getApplicationContext());
        recyclerView.setLayoutManager(tLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(tAdapter);

        prepareTimesData();
    }

    private void prepareTimesData() {
        TimeItem timeItem = new TimeItem("10:00", true);
        timesList.add(timeItem);

        timeItem = new TimeItem("13:00", true);
        timesList.add(timeItem);

        timeItem = new TimeItem("05:43", false);
        timesList.add(timeItem);

        timeItem = new TimeItem("14:60", false);
        timesList.add(timeItem);

        timeItem = new TimeItem("17:00", true);
        timesList.add(timeItem);

        timeItem = new TimeItem("16:00", false);
        timesList.add(timeItem);
    }
}

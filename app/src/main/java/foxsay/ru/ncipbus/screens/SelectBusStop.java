package foxsay.ru.ncipbus.screens;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import foxsay.ru.ncipbus.R;
import foxsay.ru.ncipbus.SelectItem;
import foxsay.ru.ncipbus.adapters.SelectListAdapter;

public class SelectBusStop extends AppCompatActivity {

    private List<SelectItem> selectsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter selectAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_bus_stop);

        recyclerView = findViewById(R.id.select_recycler);
        RecyclerView.LayoutManager tLayoutManager = new LinearLayoutManager(this.getApplicationContext());
        recyclerView.setLayoutManager(tLayoutManager);

        selectAdapter = new SelectListAdapter(selectsList);
        recyclerView.setAdapter(selectAdapter);


        SelectItem selectItem = new SelectItem("6 комплекс");
        selectsList.add(selectItem);


        SelectItem selectItemTwo = new SelectItem("7 комплекс");
        selectsList.add(selectItemTwo);
    }

}

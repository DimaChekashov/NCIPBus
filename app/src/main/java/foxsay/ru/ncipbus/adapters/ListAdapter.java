package foxsay.ru.ncipbus.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import foxsay.ru.ncipbus.R;
import foxsay.ru.ncipbus.TimeItem;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private List<TimeItem> timesList;

    public class ListViewHolder extends RecyclerView.ViewHolder {
        public TextView time, isArrived;

        public ListViewHolder(@NonNull View view) {
            super(view);
            time = view.findViewById(R.id.item_time);
            isArrived = view.findViewById(R.id.item_message);
        }
    }

    public ListAdapter(List<TimeItem> timesList) {
        this.timesList = timesList;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);

        return new ListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String currentDateandTime = new SimpleDateFormat("HH:mm:ss").format(new Date());
        Log.d("ListAdapter", "currentDateandTime " + currentDateandTime);
        TimeItem timeItem = timesList.get(position);
        holder.time.setText(currentDateandTime);
    }

    public void timer() {
        for(int i = 0; i < timesList.size(); i++) {
            //change data depending on time

            //set new data to the deadline field
            timesList.get(i).setTime("" + i);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        return timesList.size();
    }
}

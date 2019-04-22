package foxsay.ru.ncipbus.adapters;

import android.annotation.SuppressLint;
import android.graphics.Color;
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
        public TextView time, message;

        public ListViewHolder(@NonNull View view) {
            super(view);
            time = view.findViewById(R.id.item_time);
            message = view.findViewById(R.id.item_message);
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

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        TimeItem timeItem = timesList.get(position);
        holder.time.setText(String.format("%02d", timeItem.getHourse())
                + ":" + String.format("%02d", timeItem.getMinute()));

        if(isArrive(timeItem.getHourse(), timeItem.getMinute())) {
            holder.message.setText(geLastTime(timeItem.getHourse(), timeItem.getMinute()));
            holder.message.setTextColor(Color.BLUE);
        }

        if (getLastMin(getTotalMin(timeItem.getHourse(), timeItem.getMinute()), getTotalCurrentMin()) < 15 && getLastMin(getTotalMin(timeItem.getHourse(), timeItem.getMinute()), getTotalCurrentMin()) >= 0) {
            holder.itemView.setBackgroundColor(0xFF1976D2);
            holder.time.setTextColor(Color.WHITE);
            holder.message.setTextColor(0xFFFF9800);
        }
    }

    private boolean isArrive(int hour, int min) {
        int total = getTotalMin(hour, min);
        int totalCurrent = getTotalCurrentMin();
        int res = getLastMin(total, totalCurrent);

        return res > 0;
    }

    @SuppressLint("DefaultLocale")
    private String geLastTime(int hour, int min) {
        int total = getTotalMin(hour, min);
        int totalCurrent = getTotalCurrentMin();
        int res = getLastMin(total, totalCurrent);

        return "Автобус приедет через: " + String.format("%02d", Math.round(res / 60)) + ":" + String.format("%02d", res % 60);
    }

    private int getTotalMin(int hour, int min) {
        return (hour * 60) + min;
    }

    private int getLastMin(int total, int totalCurrent) {
        return total - totalCurrent;
    }

    @SuppressLint("SimpleDateFormat")
    private int getTotalCurrentMin() {
        return (Integer.valueOf(new SimpleDateFormat("HH").format(new Date())) * 60) + Integer.valueOf(new SimpleDateFormat("mm").format(new Date()));
    }

    public void timer() {
        for(int i = 0; i < timesList.size(); i++) {
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        return timesList.size();
    }
}

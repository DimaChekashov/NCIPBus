package foxsay.ru.ncipbus;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        TimeItem timeItem = timesList.get(position);
        holder.time.setText(timeItem.getTime());
    }

    @Override
    public int getItemCount() {
        return timesList.size();
    }
}

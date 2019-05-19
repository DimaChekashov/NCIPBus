package foxsay.ru.ncipbus.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import foxsay.ru.ncipbus.R;
import foxsay.ru.ncipbus.SelectItem;

public class SelectListAdapter extends RecyclerView.Adapter<SelectListAdapter.SelectViewHolder> {


    private List<SelectItem> busStops;

    public class SelectViewHolder extends RecyclerView.ViewHolder {

        public TextView name;

        public SelectViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.select_name);
        }
    }


    public SelectListAdapter(List<SelectItem> busStops) {
        this.busStops = busStops;
    }

    @Override
    public SelectListAdapter.SelectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.select_item, parent, false);


        return new SelectViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SelectViewHolder holder, int position) {
        SelectItem selectItem = busStops.get(position);
        holder.name.setText(selectItem.getName());
    }

    @Override
    public int getItemCount() {
        return busStops.size();
    }

}

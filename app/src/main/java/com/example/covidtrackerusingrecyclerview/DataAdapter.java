package com.example.covidtrackerusingrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private Context mCtx;
    private List<Tested> testedList;

    public DataAdapter(Context mCtx, List<Tested> testedList) {
        this.mCtx = mCtx;
        this.testedList = testedList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.card, parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tested item = testedList.get(position);
        holder.tested.setText(item.getTotalindividualstested());
        holder.date.setText(item.getTestedasof());
        holder.positive.setText(item.getTotalpositivecases());
    }

    @Override
    public int getItemCount() {
        return testedList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView date,tested,positive;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.date);
            tested = itemView.findViewById(R.id.tested);
            positive = itemView.findViewById(R.id.positive);

        }
    }

}

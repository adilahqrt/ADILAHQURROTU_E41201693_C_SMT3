package com.example.myrecyclerview;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ScheduleRecyclerViewAdapter extends RecyclerView.Adapter<ScheduleRecyclerViewAdapter.ScheduleViewHolder> {
    ArrayList<Schedule> arrayListSchedule;

    public ScheduleRecyclerViewAdapter(ArrayList<Schedule> arrayListSchedule) {
        this.arrayListSchedule = arrayListSchedule;
    }

//    Menampilkan layout
    @NonNull
    @Override
    public ScheduleRecyclerViewAdapter.ScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ScheduleViewHolder(view);
    }

//    Mengambil data dari setiap item
    @Override
    public void onBindViewHolder(@NonNull ScheduleRecyclerViewAdapter.ScheduleViewHolder holder, int position) {
        final Schedule schedule = arrayListSchedule.get(position);

        holder.textViewLesson.setText(schedule.getTitle());
        holder.textViewSKS.setText(schedule.getSks());
        holder.textViewSchedule.setText(schedule.getSchedule());

//        Menambahkan aksi klik
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Berpindah ke DetailScheduleActivity
                Intent intent = new Intent(holder.itemView.getContext(), DetailScheduleActivity.class);
//                Menyimpan data didalam memori terleih dahulu kemudian diterima oleh DetailScheduleActivity
                intent.putExtra(DetailScheduleActivity.EXTRA_SCHEDULE, schedule);
//                Mengirimkan data
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

//    Menentukan urutan item
    @Override
    public int getItemCount() {
        return arrayListSchedule.size();
    }

    public class ScheduleViewHolder extends RecyclerView.ViewHolder {
//        Menambahkan property
        TextView textViewLesson, textViewSKS, textViewSchedule;

//        Membuat konstruktor class viewholder
        public ScheduleViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewLesson = itemView.findViewById(R.id.tvLesson);
            textViewSKS = itemView.findViewById(R.id.tvSKS);
            textViewSchedule = itemView.findViewById(R.id.tvSchedule);
        }
    }
}

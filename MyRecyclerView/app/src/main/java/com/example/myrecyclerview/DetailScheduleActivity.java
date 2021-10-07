package com.example.myrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.concurrent.Semaphore;

public class DetailScheduleActivity extends AppCompatActivity {

    public static final String EXTRA_SCHEDULE = "extra_schedule";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_schedule);

//        Mendeklarasikan objek yang akan menampilkan data setelah diisikan
        TextView textViewLesson = findViewById(R.id.tvLesson);
        TextView textViewSKS = findViewById(R.id.tvSKS);
        TextView textViewSchedule = findViewById(R.id.tvSchedule);
        TextView textViewSemester = findViewById(R.id.tvSemester);
        TextView textViewGroup = findViewById(R.id.tvGroup);
        TextView textViewLecture = findViewById(R.id.tvLecture);
        TextView textViewDescription = findViewById(R.id.tvDescription);

//        Memasukkan dan mengambil data  yang diinputkan
        Schedule schedule = getIntent().getParcelableExtra(EXTRA_SCHEDULE);
        textViewLesson.setText(schedule.getTitle());
        textViewSKS.setText(schedule.getSks());
        textViewSchedule.setText(schedule.getSchedule());
        textViewSemester.setText(schedule.getSemester());
        textViewGroup.setText(schedule.getGroup());
        textViewLecture.setText(schedule.getDosen());
        textViewDescription.setText(schedule.getDeskripsi());
    }
}
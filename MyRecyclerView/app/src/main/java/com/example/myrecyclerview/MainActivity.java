package com.example.myrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ScheduleRecyclerViewAdapter adapter;
    private ArrayList<Schedule> objSchedule = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.myRecyclerView);

//        Memasukkan data berdasarkan objek yang telah dibuat
        objSchedule.add(new Schedule("WORKSHOP MOBILE APPLICATION", "REGULAR", "Selasa 08.00 & Rabu 13.00", "4 SKS", "SEMESTER 3", "Ery Jullev Setya Atmadji, Mudafiq",
                "Materi :\n1. Pengenalan, Instalasi dan Setting Up Graddle di Android Studio\n2. Layout(Material Design dan Scroll View\n3. Activity(Recycler View)"));
        objSchedule.add(new Schedule("STRUKTUR DATA", "REGULAR", "Senin 13.00", "2 SKS", "SEMESTER 3", "I Gede Wiryawan", "Materi :\n1. Tipe Data Turunan\n2. Array 1 Dimensi dan Multidimensi" +
                "\n3. Single Linked List\n4. Double Linked List"));
        objSchedule.add(new Schedule("WSI BERBASIS WEB", "REGULAR", "Selasa 13.00 & Jumat 07.00", "2 SKS", "SEMESTER 3",
                "Lukman Hakim, Andri Permana", "Materi :\n1. Dasar Web (HTML)\n2. Dasar Web (CSS)\n3. Dasar Web (Javascript & jQuery)"));

        adapter = new ScheduleRecyclerViewAdapter(objSchedule);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
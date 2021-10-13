package com.example.fragmentku;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LessonFragment extends Fragment implements AdapterView.OnItemClickListener {

    public LessonFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lesson, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /**
         * Menambahkan item yang dimasukkan dalam listview
         */
        String[] listmatkul = {"Intermediate English", "Interaksi Manusia dan Komputer", "Struktur Data", "Perencanaan Perangkat Lunak",
                "Workshop Kualitas Perangkat Lunak", "Workshop Mobile Application", "Workshop Sistem Informasi Berbasis Web"};

        /**
         * Untuk memanggil listview
         * */
        ListView listViewLesson = (ListView) view.findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, listmatkul);

        /**
         * Untuk membuat layout
         * */
        listViewLesson.setAdapter(adapter);
        listViewLesson.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        /**
         * Untuk membuat toast yang akan ditampilkan saat memilih item list view
         * */
        if (position == 0) return;
        Toast.makeText(getActivity(), "" + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
    }
}
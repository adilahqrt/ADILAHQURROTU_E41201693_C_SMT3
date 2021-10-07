package com.example.widget;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.widget.fragmen.DatePickerFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {
//    Membuat list array yang akan diakan digunakan pada autocomplete
    private static final String[] GROUP = new String[] {"A - Regular", "B - Regular", "C - Regular", "D - Regular", "A - Bondowoso", "B - Bondowowso", "Internasional"};

    private TextView tvBirthday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Date Picker
         * */
        tvBirthday = findViewById(R.id.tv_birthday);

        LinearLayout birthdayView = findViewById(R.id.birthday_view);
        birthdayView.setOnClickListener(this);

        /**
         * Autocomplete
         * */
        AutoCompleteTextView autoCompleteGroup = findViewById(R.id.autocompleteGroup);
        ArrayAdapter<String> adapterr = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, GROUP);
        autoCompleteGroup.setAdapter(adapterr);

        /**
         * Spinner
         * */
        Spinner spinner = findViewById(R.id.spinner_study_program);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Prodi, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            /**
             * Menampilkan toast saat item dipilih
             * */
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) return;
                Toast.makeText(parent.getContext(), "Anda mahasiswa " + parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    /**
     * Untuk menampilkan kalender (Date Picker)
     * */
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        final Calendar choosenDate = Calendar.getInstance();
        choosenDate.set(year, month, dayOfMonth);

        @SuppressLint("SimpleDateFormat")
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        final Date date = choosenDate.getTime();
        final String strDate = simpleDateFormat.format(date);

        tvBirthday.setText(strDate);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.birthday_view) {
            DatePickerFragment datePickerFragment = new DatePickerFragment();
            datePickerFragment.show(getSupportFragmentManager(), datePickerFragment.getClass().getSimpleName());
        }
    }
}
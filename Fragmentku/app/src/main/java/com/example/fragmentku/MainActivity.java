package com.example.fragmentku;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    /**
     * Membuat variabel berjenis BottomNavigationView
     * */
    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Action yang diberikan untuk menampilkan listview pada fragment lesson
         * */
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LessonFragment()).commit();
        }

        /**
         * Action yang diberikan untuk memanggil bottom navigation yang aaa pada activity_main.xml
         * */
        bottomNav = findViewById(R.id.bottom_nav);

        /**
         * Digunakaan saat pertama kali run agar tampil default menu fragment home
         * */
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                 /**
                  * Membuat objek fragment yang diinisialisasi dengan nilai null
                  * */
                Fragment selectedFragment = null;

                /**
                 * Kondisi percabangan saat kita memilih item home, lesson atau account lalu akan menampilkan fragmentnya masing - masing
                 * sesuai dengan itemnya */
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.nav_lesson:
                        selectedFragment = new LessonFragment();
                        break;
                    case R.id.nav_account:
                        selectedFragment = new AccountFragment();
                        break;
                }

                /**
                 * Action yang diberikan saat memilih item pada bottom navigation
                 * */
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

                return true;
            }
        });
    }
}
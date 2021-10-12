package com.example.navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    //pendeklarasian bottom navigation
    BottomNavigationView menu_bawah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //membuat layout menu_bawah untuk menjadi objek
        menu_bawah = findViewById(R.id.menu_bawah);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new fragment_1()).commit();
        //membuat action pada bottom navigation
        menu_bawah.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //membuat objek fragment
                Fragment selectedFragment = null;

                //memberikan switch case (percabangan) untuk tiap-tiap navigasi
                switch (item.getItemId()) {
                    //case untuk navigasi beranda
                    case R.id.beranda:
                        selectedFragment = new fragment_1();
                        break;
                    //case untuk navigasi cari
                    case R.id.cari:
                        selectedFragment = new fragment_2();
                        break;
                    //case untuk navigasi notif
                    case R.id.notif:
                        selectedFragment = new fragment_3();
                        break;
                    //case untuk navigasi profil
                    case R.id.profil:
                        selectedFragment = new fragment_4();
                        break;
                }
                //memanggil fungsi dari tiap-tiap fragment
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                return true;
            }
        });
    }
}



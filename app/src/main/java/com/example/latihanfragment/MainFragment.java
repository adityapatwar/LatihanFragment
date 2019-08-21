package com.example.latihanfragment;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.MenuItem;
import android.widget.TextView;

public class MainFragment extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private TextView mTextMessage;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate (savedInstanceState);
            setContentView (R.layout.activity_main_fragment);
            BottomNavigationView navView = findViewById (R.id.nav_view);
            mTextMessage = findViewById (R.id.message);
            navView.setOnNavigationItemSelectedListener (this);

            loadFragment (new Fragment_home ());
        }

        private boolean loadFragment(Fragment fragment) {
            if (fragment != null) {
                getSupportFragmentManager ()
                        .beginTransaction ()
                        .replace (R.id.fragment_container, fragment)
                        .commit ();
                return true;
            }
            return false;
        }

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId ()) {
                case R.id.navigation_home:
                    mTextMessage.setText (R.string.title_home);
                    fragment = new Fragment_home ();
                    break;
                case R.id.navigation_dashboard:
                    mTextMessage.setText (R.string.title_dashboard);
                    fragment = new Fragment_dashboard ();
                    break;
                case R.id.navigation_notifications:
                    mTextMessage.setText (R.string.title_notifications);
                    fragment = new Fragment_notificaions ();
                    break;
                case R.id.navigation_profile:
                    mTextMessage.setText (R.string.title_profile);
                    fragment = new Fragment_profile ();
                    break;
            }
            return loadFragment (fragment);
        }

    }


package com.example.embeddedf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class InterfaceActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    FirebaseAuth mAuth;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface);

        mAuth = FirebaseAuth.getInstance();
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.menu_Open,R.string.close_menu);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,new homefragment()).commit();
        navigationView.setCheckedItem(R.id.nav_home);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            Fragment temp;
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.nav_home:

                        temp = new homefragment();

                        //Log.i("MENU_DRAWER_TAG","Home item is clicked");
                        //drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_search:
                        temp = new searchfragment();


                        //Log.i("MENU_DRAWER_TAG","Search item is clicked");
                        //drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_profile:
                        temp = new profilefragment();

                        //Log.i("MENU_DRAWER_TAG","Profile item is clicked");
                        //drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_settings:
                        temp = new settingsfragment();


                        //Log.i("MENU_DRAWER_TAG","Settings item is clicked");
                        //drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_AboutUs:
                        temp = new about_usfragment();

                        //Log.i("MENU_DRAWER_TAG","About Us item is clicked");
                        //drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_share:
                        temp = new sharefragment();

                        //Log.i("MENU_DRAWER_TAG","Share item is clicked");
                        //drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_logOut:
                        FirebaseAuth.getInstance().signOut();
                        finish();
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);

                        //Log.i("MENU_DRAWER_TAG","log Out item is clicked");
                        //drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                }
                drawerLayout.closeDrawer(GravityCompat.START);
                getSupportFragmentManager().beginTransaction().replace(R.id.container,temp).commit();
                return true;
            }
        });
    }
}
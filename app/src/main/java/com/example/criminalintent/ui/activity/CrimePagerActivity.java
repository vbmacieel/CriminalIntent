package com.example.criminalintent.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.criminalintent.R;
import com.example.criminalintent.adapter.CrimeViewPagerAdapter;

import java.util.UUID;

public class CrimePagerActivity extends AppCompatActivity {

    private static final String EXTRA_CRIME_ID = "criminalintent.crime_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_pager);
        UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);
        ViewPager2 viewPager = findViewById(R.id.crime_view_pager);

        FragmentManager supportFragmentManager = getSupportFragmentManager();
        CrimeViewPagerAdapter crimeViewPagerAdapter =
                new CrimeViewPagerAdapter(supportFragmentManager, getLifecycle(), getApplicationContext());
        viewPager.setAdapter(crimeViewPagerAdapter);
        crimeViewPagerAdapter.setInitialPagerItem(viewPager, crimeId);
    }

    public static Intent newIntent(Context packageContext, UUID crimeId) {
        return new Intent(packageContext, CrimePagerActivity.class)
                .putExtra(EXTRA_CRIME_ID, crimeId);
    }
}
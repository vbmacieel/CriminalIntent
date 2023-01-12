package com.example.criminalintent.ui.activity;

import androidx.fragment.app.Fragment;

import com.example.criminalintent.ui.fragments.CrimeListFragment;

public class CrimeListActivity extends SingleFragmentActivity{

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}

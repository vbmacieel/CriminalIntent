package com.example.criminalintent;

import androidx.fragment.app.Fragment;

import com.example.criminalintent.fragments.CrimeListFragment;

public class CrimeListActivity extends SingleFragmentActivity{

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}

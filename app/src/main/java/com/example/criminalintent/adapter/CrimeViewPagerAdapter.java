package com.example.criminalintent.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.criminalintent.repository.CrimeLab;
import com.example.criminalintent.ui.fragments.CrimeFragment;
import com.example.criminalintent.model.Crime;

import java.util.List;
import java.util.UUID;

public class CrimeViewPagerAdapter extends FragmentStateAdapter {

    private final List<Crime> mCrimes;

    public CrimeViewPagerAdapter(@NonNull FragmentManager fragmentManager,
                                 @NonNull Lifecycle lifecycle, Context context) {
        super(fragmentManager, lifecycle);
        mCrimes = CrimeLab.getInstance(context).getCrimes();
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Crime crime = mCrimes.get(position);
        return CrimeFragment.newInstance(crime.getId());
    }

    @Override
    public int getItemCount() {
        return mCrimes.size();
    }

    public void setInitialPagerItem(ViewPager2 viewPager, UUID id) {
        for (int i = 0; i < mCrimes.size(); i++) {
            if (mCrimes.get(i).getId().equals(id)) {
                viewPager.setCurrentItem(i);
                break;
            }
        }
    }
}

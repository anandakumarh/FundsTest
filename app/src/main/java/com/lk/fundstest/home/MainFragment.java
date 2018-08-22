package com.lk.fundstest.home;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lk.fundstest.R;
import com.lk.fundstest.base.OnBackPressListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    private TabLayout tabView;
    private ViewPager pager;
    private ViewPagerAdapter adapter;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_base, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabView = view.findViewById(R.id.tpi_header);
        pager = view.findViewById(R.id.vp_pages);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        adapter = new ViewPagerAdapter(getResources(), getChildFragmentManager());

        pager.setAdapter(adapter);
        tabView.setupWithViewPager(pager);
    }

    public boolean onBackPressed() {
        OnBackPressListener currentFragment = (OnBackPressListener) adapter.getRegisteredFragment(pager.getCurrentItem());

        if (currentFragment != null) {
            return currentFragment.onBackPressed();
        }

        return false;
    }
}

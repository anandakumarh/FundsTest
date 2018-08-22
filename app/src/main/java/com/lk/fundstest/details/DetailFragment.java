package com.lk.fundstest.details;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lk.fundstest.utils.Constants;
import com.lk.fundstest.R;
import com.lk.fundstest.base.RootFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends RootFragment {

    private static final String KEY_TYPE = "type";
    private Constants.FragmentType mType;

    public static DetailFragment getInstance(Constants.FragmentType fragmentType) {
        DetailFragment listFragment = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_TYPE, fragmentType);
        listFragment.setArguments(bundle);
        return listFragment;
    }

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null && getArguments().getSerializable(KEY_TYPE) != null) {
            mType = (Constants.FragmentType) getArguments().getSerializable(KEY_TYPE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AppCompatTextView labelView = view.findViewById(R.id.label);
        switch (mType) {
            case SONG_DETAIL_FRAGMENT:
                labelView.setText("Song Detail");
                break;
            case VIDEO_DETAIL_FRAGMENT:
                labelView.setText("Video Detail");
                break;
            default:
                break;
        }
    }
}

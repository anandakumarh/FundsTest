package com.lk.fundstest.list;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lk.fundstest.utils.Constants;
import com.lk.fundstest.R;
import com.lk.fundstest.base.RootFragment;
import com.lk.fundstest.details.DetailFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends RootFragment implements View.OnClickListener {

    private static final String KEY_TYPE = "type";

    private Constants.FragmentType mType;

    public static ListFragment getInstance(Constants.FragmentType fragmentType) {
        ListFragment listFragment = new ListFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_TYPE, fragmentType);
        listFragment.setArguments(bundle);
        return listFragment;
    }

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
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
        return inflater.inflate(R.layout.fragment_song_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AppCompatTextView labelView = view.findViewById(R.id.label);
        switch (mType) {
            case SONG_LIST_FRAGMENT:
                labelView.setText("Song List");
                break;
            case VIDEO_LIST_FRAGMENT:
                labelView.setText("Video List");
                break;
            default:
                break;
        }

        view.findViewById(R.id.detail_btn).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.detail_btn:
                if (mType == Constants.FragmentType.SONG_LIST_FRAGMENT)
                    replaceFragment(DetailFragment.getInstance(Constants.FragmentType.SONG_DETAIL_FRAGMENT));
                else if (mType == Constants.FragmentType.VIDEO_LIST_FRAGMENT)
                    replaceFragment(DetailFragment.getInstance(Constants.FragmentType.VIDEO_DETAIL_FRAGMENT));

                break;
            default:
                break;
        }
    }

    private void replaceFragment(RootFragment fragment) {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        transaction.addToBackStack(null);
        transaction.replace(R.id.fragment_mainLayout, fragment).commit();
    }
}

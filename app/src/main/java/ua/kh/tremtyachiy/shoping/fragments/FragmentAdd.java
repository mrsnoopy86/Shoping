package ua.kh.tremtyachiy.shoping.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ua.kh.tremtyachiy.shoping.R;

/**
 * Created by Admin on 10.06.2015.
 */
public class FragmentAdd extends Fragment{


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragmentadd, container, false);
        return fragmentView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}

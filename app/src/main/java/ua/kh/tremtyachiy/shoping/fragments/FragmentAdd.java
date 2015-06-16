package ua.kh.tremtyachiy.shoping.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ua.kh.tremtyachiy.shoping.R;

/**
 * Created by Admin on 10.06.2015.
 */
public class FragmentAdd extends Fragment{
    private View fragmentView;
    TextView tvDate;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.fragmentadd, container, false);
        tvDate =(TextView) fragmentView.findViewById(R.id.textView2);
        return fragmentView;
    }
}
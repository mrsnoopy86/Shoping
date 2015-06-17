package ua.kh.tremtyachiy.shoping.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import info.hoang8f.android.segmented.SegmentedGroup;
import ua.kh.tremtyachiy.shoping.R;
import ua.kh.tremtyachiy.shoping.adapter.AdapterContent;
import ua.kh.tremtyachiy.shoping.util.ProductContent;

/**
 * Created by Admin on 10.06.2015.
 */
public class FragmentAdd extends Fragment implements View.OnClickListener{
    private View fragmentView;
    private TextView tvDate;
    private ListView listView;
    private AdapterContent adapterContent;
    private ArrayList<ProductContent> list = new ArrayList<>();
    private EditText etProduct;
    private EditText etValue;
    private SegmentedGroup unitOfMeasure;
    private Button btnAdd;
    private Button btnClear;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.fragmentadd, container, false);
        initView();
        adapterContent = new AdapterContent(getActivity(), list, AdapterContent.Mode.CREATE);
        listView.setAdapter(adapterContent);
        return fragmentView;
    }

    private void initView(){
        tvDate =(TextView) fragmentView.findViewById(R.id.textView2);
        etProduct = (EditText) fragmentView.findViewById(R.id.etProduct);
        etValue = (EditText) fragmentView.findViewById(R.id.etValue);
        unitOfMeasure = (SegmentedGroup) fragmentView.findViewById(R.id.unitOfMeasure);
        btnAdd = (Button) fragmentView.findViewById(R.id.btnAddFragmentAdd);
        btnClear = (Button) fragmentView.findViewById(R.id.btnClearFragmentAdd);
        listView = (ListView) fragmentView.findViewById(R.id.listViewAddFragment);
        btnAdd.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAddFragmentAdd:
                if(TextUtils.isEmpty(etProduct.getText().toString()) || TextUtils.isEmpty(etValue.getText().toString())){
                    Toast.makeText(getActivity(), "Заполните пожалуйста все поля", Toast.LENGTH_SHORT).show();
                } else {
                    list.add(new ProductContent(etProduct.getText().toString(), "шт", Integer.parseInt(etValue.getText().toString())));
                    etProduct.setText("");
                    etValue.setText("");
                    setListViewHeightBasedOnChildren(listView);
                    adapterContent.notifyDataSetChanged();
                }
                break;
            case R.id.btnClearFragmentAdd:
                etProduct.setText("");
                etValue.setText("");
                break;
        }
    }

    private void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null)
            return;

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (i == 0)
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, ViewGroup.LayoutParams.WRAP_CONTENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }
}
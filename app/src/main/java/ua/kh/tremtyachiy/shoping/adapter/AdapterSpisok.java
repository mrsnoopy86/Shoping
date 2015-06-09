package ua.kh.tremtyachiy.shoping.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.nhaarman.listviewanimations.itemmanipulation.expandablelistitem.ExpandableListItemAdapter;

import java.util.ArrayList;

import ua.kh.tremtyachiy.shoping.R;
import ua.kh.tremtyachiy.shoping.util.Product;

/**
 * Created by User on 09.06.2015.
 */
public class AdapterSpisok extends ExpandableListItemAdapter<Integer> {
    private Context context;
    ArrayList<Product> products = new ArrayList<>();

    protected AdapterSpisok(@NonNull Context context, ArrayList<Product> list) {
        super(context, R.layout.adapter, R.layout.adapter_title, R.layout.adapter_content);
        this.context = context;
        products = list;

        for (int i = 0; i < 100; i++){
            add(i);
        }
    }

    @NonNull
    @Override
    public View getTitleView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    @NonNull
    @Override
    public View getContentView(int i, View view, @NonNull ViewGroup viewGroup) {
        return null;
    }
}

package ua.kh.tremtyachiy.shoping.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

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
    LayoutInflater inflater;

    protected AdapterSpisok(@NonNull Context context, ArrayList<Product> list) {
        super(context, R.layout.adapter, R.layout.adapter_title, R.layout.adapter_content);
        this.context = context;
        products = list;

        for (int i = 0; i < 100; i++){
            add(i);
        }
    }

    class ViewHolderTitle {
        TextView tvTitle;
        TextView tvAbout;
        TextView tvDateofCreate;
        TextView tvDateofEnd;
        TextView tvTypeOf;
        TextView tvTagImportant;
        TextView tvTagToDay;
        TextView tvTagRememberThat;
        ImageButton ibLocation;
    }
    class ViewHolderContent {

    }


    @NonNull
    @Override
    public View getTitleView(int i, View view, @NonNull ViewGroup viewGroup) {
        View viewTitle = view;
        ViewHolderTitle holder = new ViewHolderTitle();
        if(viewTitle == null){
            viewTitle = inflater.inflate(R.layout.adapter_title, viewGroup, false);
            holder.tvTitle = (TextView) viewTitle.findViewById(R.id.tvTitle);
            holder.tvAbout = (TextView) viewTitle.findViewById(R.id.tvAbout);
            holder.tvDateofCreate = (TextView) viewTitle.findViewById(R.id.tvDateofCreate);
            holder.tvDateofEnd = (TextView) viewTitle.findViewById(R.id.tvDateofEnd);
            holder.tvTagImportant = (TextView) viewTitle.findViewById(R.id.tvTagImportant);
            holder.tvTypeOf = (TextView) viewTitle.findViewById(R.id.tvTypeOf);
            holder.tvTagToDay = (TextView) viewTitle.findViewById(R.id.tvTagToDay);
            holder.tvTagRememberThat = (TextView) viewTitle.findViewById(R.id.tvTagRememberThat);
            holder.ibLocation = (ImageButton) viewTitle.findViewById(R.id.ibLocation);
            viewTitle.setTag(holder);
        } else {
            holder = (ViewHolderTitle) viewTitle.getTag();
        }
        return viewTitle;
    }

    @NonNull
    @Override
    public View getContentView(int i, View view, @NonNull ViewGroup viewGroup) {
        return null;
    }
}

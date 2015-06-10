package ua.kh.tremtyachiy.shoping.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.nhaarman.listviewanimations.itemmanipulation.expandablelistitem.ExpandableListItemAdapter;

import java.util.ArrayList;

import ua.kh.tremtyachiy.shoping.R;
import ua.kh.tremtyachiy.shoping.util.Product;
import ua.kh.tremtyachiy.shoping.util.ProductContent;

/**
 * Created by User on 09.06.2015.
 */

public class AdapterSpisok extends ExpandableListItemAdapter<Integer> {
    private Context context;
    private ArrayList<Product> products = new ArrayList<>();
    LayoutInflater inflater;

    public AdapterSpisok(@NonNull Context context, ArrayList<Product> list) {
        super(context, R.layout.adapter, R.layout.adapter_title, R.layout.adapter_content);
        this.context = context;
        products = list;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        for (int i = 0; i < products.size(); i++){
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
        ListView listView;
    }


    @NonNull
    @Override
    public View getTitleView(int i, View view, @NonNull ViewGroup viewGroup) {
        View viewTitle = view;
        ViewHolderTitle holder;

        if(viewTitle == null){
            holder = new ViewHolderTitle();
            viewTitle = inflater.inflate(R.layout.adapter, viewGroup, false);
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
        holder.tvTitle.setText(products.get(i).getTitle());
        holder.tvAbout.setText(products.get(i).getAbout());
        holder.tvDateofCreate.setText(products.get(i).getDateStart());
        holder.tvDateofEnd.setText(products.get(i).getDateEnd());
        holder.tvTypeOf.setText(products.get(i).getType());
        holder.tvTagImportant.setVisibility(products.get(i).getVisibilityOfImportant());
        holder.tvTagToDay.setVisibility(products.get(i).getVisibilityOfToDay());
        holder.tvTagRememberThat.setVisibility(products.get(i).getVisibilityOfRemember());

        return viewTitle;
    }

    @NonNull
    @Override
    public View getContentView(int i, View view, @NonNull ViewGroup viewGroup) {
        ArrayList<ProductContent> productContents = new ArrayList<>();
        AdapterContent adapterContent = new AdapterContent(context, productContents);
        View viewContent = view;
        ViewHolderContent viewHolderContent;
        if(viewContent == null){
            viewHolderContent = new ViewHolderContent();
            viewContent = inflater.inflate(R.layout.adapter, viewGroup, false);
            viewHolderContent.listView = (ListView) viewContent.findViewById(R.id.lvOfProduct);
            view.setTag(viewHolderContent);
        } else {
            viewHolderContent = (ViewHolderContent) viewContent.getTag();
        }
        viewHolderContent.listView.setAdapter(adapterContent);
        adapterContent.notifyDataSetChanged();
        return viewContent;
    }
}

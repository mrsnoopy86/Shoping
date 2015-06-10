package ua.kh.tremtyachiy.shoping.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
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
    private ArrayList<ProductContent> productContents = new ArrayList<>();
    LayoutInflater inflater;

    public AdapterSpisok(@NonNull Context context, ArrayList<Product> list) {
        super(context, R.layout.adapter, R.id.adapter_title, R.id.adapter_content);
        this.context = context;
        products = list;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        for (int i = 0; i < products.size(); i++){
            add(i);
        }
    }

    class ViewHolder {
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
        Product product = products.get(i);
        ViewHolder holder;

        if(view == null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.adapter, viewGroup, false);

            holder.tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            holder.tvAbout = (TextView) view.findViewById(R.id.tvAbout);
            holder.tvDateofCreate = (TextView) view.findViewById(R.id.tvDateofCreate);
            holder.tvDateofEnd = (TextView) view.findViewById(R.id.tvDateofEnd);
            holder.tvTagImportant = (TextView) view.findViewById(R.id.tvTagImportant);
            holder.tvTypeOf = (TextView) view.findViewById(R.id.tvTypeOf);
            holder.tvTagToDay = (TextView) view.findViewById(R.id.tvTagToDay);
            holder.tvTagRememberThat = (TextView) view.findViewById(R.id.tvTagRememberThat);
            holder.ibLocation = (ImageButton) view.findViewById(R.id.ibLocation);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.tvTitle.setText(product.getTitle());
        holder.tvAbout.setText(product.getAbout());
        holder.tvDateofCreate.setText(product.getDateStart());
        holder.tvDateofEnd.setText(product.getDateEnd());
        holder.tvTypeOf.setText(product.getType());
        holder.tvTagImportant.setVisibility(product.getVisibilityOfImportant());
        holder.tvTagToDay.setVisibility(product.getVisibilityOfToDay());
        holder.tvTagRememberThat.setVisibility(product.getVisibilityOfRemember());

        return view;
    }

    @NonNull
    @Override
    public View getContentView(int i, View view, @NonNull ViewGroup viewGroup) {
        initProductContent();
        AdapterContent adapterContent = new AdapterContent(context, productContents);
        ViewHolderContent viewHolderContent;
        if(view == null){
            viewHolderContent = new ViewHolderContent();
            view = inflater.inflate(R.layout.adapter, viewGroup, false);
            viewHolderContent.listView = (ListView) view.findViewById(R.id.lvOfProduct);
            view.setTag(viewHolderContent);
        } else {
            viewHolderContent = (ViewHolderContent) view.getTag();
        }
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.adapter_title);
        relativeLayout.setVisibility(View.GONE);
        viewHolderContent.listView.setAdapter(adapterContent);
        return view;
    }

    private void initProductContent() {
        productContents.add(new ProductContent("Молоко", "литр", 2));
        productContents.add(new ProductContent("Кефир", "литр", 2));
        productContents.add(new ProductContent("Вода", "литр", 2));
        productContents.add(new ProductContent("Картофель", "кг", 2));
        productContents.add(new ProductContent("Чай", "шт", 2));
        productContents.add(new ProductContent("Пиво", "литр", 2));
        productContents.add(new ProductContent("Сметана", "шт", 2));
        productContents.add(new ProductContent("Батон", "шт", 2));
        productContents.add(new ProductContent("Помидоры", "кг", 2));
    }
}

package ua.kh.tremtyachiy.shoping.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ua.kh.tremtyachiy.shoping.R;
import ua.kh.tremtyachiy.shoping.util.ProductContent;

/**
 * Created by Admin on 10.06.2015.
 */
public class AdapterContent extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ArrayList<ProductContent> productContents = new ArrayList<>();

    public AdapterContent(Context context, ArrayList<ProductContent> productContents) {
        this.context = context;
        this.productContents = productContents;
    }

    @Override
    public int getCount() {
        return productContents.size();
    }

    @Override
    public Object getItem(int position) {
        return productContents.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ViewHolder{
        TextView tvPosition;
        TextView tvProductName;
        TextView tvCount;
        TextView tvUnitOfMeasure;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.adapter_second_content, parent, false);
            holder.tvPosition = (TextView) view.findViewById(R.id.tvPosition);
            holder.tvProductName = (TextView) view.findViewById(R.id.tvProductName);
            holder.tvCount = (TextView) view.findViewById(R.id.tvCount);
            holder.tvUnitOfMeasure = (TextView) view.findViewById(R.id.tvUnitOfMeasure);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.tvPosition.setText(productContents.get(position).getProduct() + ". ");
        holder.tvProductName.setText(productContents.get(position).getProduct());
        holder.tvCount.setText(" - " + productContents.get(position).getValue());
        holder.tvUnitOfMeasure.setText(" " + productContents.get(position).getUnitOfMeasure());
        return view;
    }
}

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
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.adapter_second_content, parent, false);
            holder.tvPosition = (TextView) convertView.findViewById(R.id.tvPosition);
            holder.tvProductName = (TextView) convertView.findViewById(R.id.tvProductName);
            holder.tvCount = (TextView) convertView.findViewById(R.id.tvCount);
            holder.tvUnitOfMeasure = (TextView) convertView.findViewById(R.id.tvUnitOfMeasure);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvPosition.setText((position + 1) + ". ");
        holder.tvProductName.setText(productContents.get(position).getProduct());
        holder.tvCount.setText(" - " + productContents.get(position).getValue());
        holder.tvUnitOfMeasure.setText(" " + productContents.get(position).getUnitOfMeasure());
        return convertView;
    }
}

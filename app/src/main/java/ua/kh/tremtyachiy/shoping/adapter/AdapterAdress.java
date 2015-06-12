package ua.kh.tremtyachiy.shoping.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ua.kh.tremtyachiy.shoping.R;
import ua.kh.tremtyachiy.shoping.util.Adress;

/**
 * Created by User on 12.06.2015.
 */
public class AdapterAdress extends BaseAdapter {
    Context context;
    ArrayList<Adress> list = new ArrayList<>();
    LayoutInflater inflater;

    public AdapterAdress(Context context, ArrayList<Adress> list) {
        this.context = context;
        this.list = list;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ViewHolder{
        TextView nameCompany;
        TextView adres;
        TextView phone;
        TextView fullTime;
        ImageView logo;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.adapteradress, parent, false);
            holder.nameCompany = (TextView) convertView.findViewById(R.id.tvnameOfCompany);
            holder.adres = (TextView) convertView.findViewById(R.id.tvAdress);
            holder.phone = (TextView) convertView.findViewById(R.id.tvPhoneNumber);
            holder.fullTime = (TextView) convertView.findViewById(R.id.tvFullTime);
            holder.logo = (ImageView) convertView.findViewById(R.id.ivLogo);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.nameCompany.setText(list.get(position).getNameCompany());
        holder.adres.setText(list.get(position).getAdres());
        holder.phone.setText(list.get(position).getPhone());
        holder.fullTime.setText(list.get(position).getFullTimeOfCompany());
        holder.logo.setBackground(list.get(position).getPictureCompany());
        switch (list.get(position).getNameCompany()){
            case "супермаркет Класс":
                holder.nameCompany.setTextColor(context.getResources().getColor(R.color.colorPrimary));
                break;
            case "супермаркет РОСТ":
                holder.nameCompany.setTextColor(context.getResources().getColor(R.color.color_type_of_buildmaterials));
                break;
            default:
                holder.nameCompany.setTextColor(context.getResources().getColor(R.color.colorPrimary));
                break;
        }
        return convertView;
    }
}

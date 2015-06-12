package ua.kh.tremtyachiy.shoping.fragments;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import ua.kh.tremtyachiy.shoping.R;
import ua.kh.tremtyachiy.shoping.adapter.AdapterAdress;
import ua.kh.tremtyachiy.shoping.util.Adress;

/**
 * Created by Admin on 10.06.2015.
 */
public class FragmentAdress extends Fragment{
    private ListView listView;
    ArrayList<Adress> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initList();
        View fragmentView = inflater.inflate(R.layout.fragmentadres, container, false);
        listView = (ListView) fragmentView.findViewById(R.id.listViewAdress);
        AdapterAdress adapter = new AdapterAdress(getActivity(), list);
        listView.setAdapter(adapter);
        return fragmentView;
    }

    private void initList() {
        list.add(new Adress("супермаркет Класс", "г. Харьков пр. Московский 259", getResources().getDrawable(R.raw.logo_klass),
                "Телефон: (057) 758-62-61",  "круглосуточно\nтехнологический перерыв с 2:00 до 5:00"));

        list.add(new Adress("супермаркет РОСТ", "г. Харьков ул. Клочковская 65 ", getResources().getDrawable(R.raw.logo_rost),
                "Телефон: (057) 7-142-143",  "1 этаж 8:00 - 23:00\n2 и 3 этаж 9:00 - 22:00"));

        list.add(new Adress("супермаркет РОСТ", "г. Харьков пр-т Маршала Жукова 18-В", getResources().getDrawable(R.raw.logo_rost),
                "Телефон: (057) 730-66-56",  "8:00 - 23:00"));

        list.add(new Adress("супермаркет Класс", "г. Харьков Салтовское Шоссе 248", getResources().getDrawable(R.raw.logo_klass),
                "Телефон: (057) 778-06-63",  "круглосуточно\nтехнологический перерыв с 2:00 до 5:00"));

        list.add(new Adress("супермаркет Класс", "г. Харьков пр. Людвига Свободы 43", getResources().getDrawable(R.raw.logo_klass),
                "Телефон: (057) 773-24-69",  "круглосуточно\nтехнологический перерыв с 2:00 до 5:00"));

        list.add(new Adress("супермаркет РОСТ", "г. Харьков ул. Шевченко 142-А", getResources().getDrawable(R.raw.logo_rost),
                "Телефон: (057) 730-65-20",  "1 этаж 8:00 - 4:00\n2 и 3 этаж 9:00 - 22:00"));

        list.add(new Adress("супермаркет Класс", "г. Харьков, пр. Героев Сталинграда, 136/8", getResources().getDrawable(R.raw.logo_klass),
                "Телефон: (057) 357-00-23",  "круглосуточно\nтехнологический перерыв с 2:00 до 5:00"));

    }


}

package ua.kh.tremtyachiy.shoping;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.nhaarman.listviewanimations.itemmanipulation.DynamicListView;

import java.util.ArrayList;
import java.util.Date;

import ua.kh.tremtyachiy.shoping.adapter.AdapterSpisok;
import ua.kh.tremtyachiy.shoping.util.DrawerMyMenu;
import ua.kh.tremtyachiy.shoping.util.Product;
import ua.kh.tremtyachiy.shoping.util.ProductContent;

/**
 * Created by User on 09.06.2015.
 */

public class MainScreen extends AppCompatActivity {
    private GoogleMap mMap;
    private Toolbar toolbar;
    ArrayList<Product> products = new ArrayList<Product>();
    private ArrayList<ProductContent> productContents = new ArrayList<>();
    DrawerMyMenu drawerMyMenu = new DrawerMyMenu();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen_activity);
        initView();
        drawerMyMenu.initDrawerMenu(this, toolbar);
        initMap();

    }

    private void initMap() {
        if (mMap != null) {
            return;
        }
        mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
    }

    public GoogleMap getmMap() {
        return mMap;
    }

    private void initView() {
        /*
        ListView
         */
        initProductsList();
        DynamicListView dynamicListView = (DynamicListView) findViewById(R.id.dynamicListView);
        AdapterSpisok adapterSpisok = new AdapterSpisok(this, products, productContents);
        dynamicListView.setAdapter(adapterSpisok);
        /*
        Tabs
         */
        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();
        TabHost.TabSpec tabSpec;
        tabSpec = tabHost.newTabSpec("tag1");
        tabSpec.setIndicator(getString(R.string.spisok_tab));
        tabSpec.setContent(R.id.tab1);
        tabHost.addTab(tabSpec);
        tabSpec = tabHost.newTabSpec("tag2");
        tabSpec.setIndicator(getString(R.string.spisok_tab2));
        tabSpec.setContent(R.id.tab2);
        tabHost.addTab(tabSpec);
        tabSpec = tabHost.newTabSpec("tag3");
        tabSpec.setIndicator(getString(R.string.spisok_tab3));
        tabSpec.setContent(R.id.tab3);
        tabHost.addTab(tabSpec);
        tabSpec = tabHost.newTabSpec("tag4");
        tabSpec.setIndicator(getString(R.string.spisok_tab4));
        tabSpec.setContent(R.id.tab4);
        tabHost.addTab(tabSpec);
        tabHost.setCurrentTabByTag("tag1");
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
            }
        });
        /*
        Toolbar
         */
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
        toolbar.inflateMenu(R.menu.menu);
        toolbar.setNavigationIcon(R.drawable.ic_menu_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerMyMenu.getDrawerMenu().openDrawer();
            }
        });
    }
    /*
    Временная база данных :) для проверки работоспособности
     */
    private void initProductsList() {
        products.add(new Product("Я хочу купить продукты", "Жена зараза заставила сходить скупиться", "Продукты",
                DateFormat.format("dd-MM-yyyy", new Date()), DateFormat.format("dd-MM-yyyy", new Date())));
        products.add(new Product("Ремонт в ванной", "Необходимо быстро скупиться", "Стройматериалы",
                DateFormat.format("dd-MM-yyyy", new Date()), DateFormat.format("dd-MM-yyyy", new Date()), View.INVISIBLE, View.VISIBLE, View.INVISIBLE));
        products.add(new Product("Ремонт в кухне", "Недорого но качественно", "Стройматериалы",
                DateFormat.format("dd-MM-yyyy", new Date()), DateFormat.format("dd-MM-yyyy", new Date()), View.VISIBLE, View.VISIBLE, View.INVISIBLE));
        products.add(new Product("Телевизор", "Большой и с интернетом", "Техника",
                DateFormat.format("dd-MM-yyyy", new Date()), DateFormat.format("dd-MM-yyyy", new Date()), View.VISIBLE, View.INVISIBLE, View.INVISIBLE));
        products.add(new Product("Купить продукты", "Скоро отмечать день рождение", "Продукты",
                DateFormat.format("dd-MM-yyyy", new Date()), DateFormat.format("dd-MM-yyyy", new Date()), View.INVISIBLE, View.INVISIBLE, View.VISIBLE));

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

    @Override
    public void onBackPressed() {
        if(drawerMyMenu.getDrawerMenu() != null && drawerMyMenu.getDrawerMenu().isDrawerOpen()){
            drawerMyMenu.getDrawerMenu().closeDrawer();
        } else {
            super.onBackPressed();
        }
    }
}

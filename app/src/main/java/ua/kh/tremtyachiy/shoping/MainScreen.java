package ua.kh.tremtyachiy.shoping;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.nhaarman.listviewanimations.itemmanipulation.DynamicListView;

import java.util.ArrayList;
import java.util.Date;

import ua.kh.tremtyachiy.shoping.adapter.AdapterContent;
import ua.kh.tremtyachiy.shoping.adapter.AdapterSpisok;
import ua.kh.tremtyachiy.shoping.util.Product;
import ua.kh.tremtyachiy.shoping.util.ProductContent;

/**
 * Created by User on 09.06.2015.
 */

public class MainScreen extends AppCompatActivity {
    private Toolbar toolbar;
    private Drawer drawerMenu;
    private DynamicListView dynamicListView;
    ArrayList<Product> products = new ArrayList<Product>();
    private ArrayList<ProductContent> productContents = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen_activity);

        initToolbar();
        initTabs();
        initDrawerMenu();
        initDynamic();
        initTabList();
    }

    private void initTabList() {
        ListView listView = (ListView) findViewById(R.id.listTest);
        AdapterContent aaa = new AdapterContent(this, productContents);
        listView.setAdapter(aaa);
    }

    private void initDynamic() {
        initProductsList();
        dynamicListView = (DynamicListView) findViewById(R.id.dynamicListView);
        AdapterSpisok adapterSpisok = new AdapterSpisok(this, products, productContents);
        dynamicListView.setAdapter(adapterSpisok);
    }

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
        if(drawerMenu != null && drawerMenu.isDrawerOpen()){
            drawerMenu.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }

    private void initDrawerMenu() {
        AccountHeader accountHeader = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.raw.shopinghelper_drawer_header)
                .withHeightDp(230)
                .build();

        drawerMenu = new DrawerBuilder()
                .withAccountHeader(accountHeader)
                .withToolbar(toolbar)
                .withDisplayBelowToolbar(true)
                .withActionBarDrawerToggleAnimated(true)
                .withActivity(this)
                .addDrawerItems(
                        new SecondaryDrawerItem()
                                .withIcon(R.drawable.ic_settings_black_24dp)
                                .withName(R.string.nav_menu_item1)
                                .withIdentifier(1),
                        new DividerDrawerItem(),
                        new SecondaryDrawerItem()
                                .withName(R.string.nav_menu_item2)
                                .withIcon(R.drawable.ic_announcement_black_24dp)
                                .withIdentifier(2),
                        new SecondaryDrawerItem()
                                .withName(R.string.nav_menu_item3)
                                .withIcon(R.drawable.ic_supervisor_account_black_24dp)
                                .withIdentifier(3),
                        new SecondaryDrawerItem()
                                .withName(R.string.nav_menu_item4)
                                .withIcon(R.drawable.ic_live_help_black_24dp)
                                .withIdentifier(4),
                        new DividerDrawerItem(),
                        new SecondaryDrawerItem()
                                .withName(R.string.nav_menu_item5)
                                .withIcon(R.drawable.ic_exit_to_app_black_24dp)
                                .withIdentifier(5))
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(AdapterView<?> adapterView, View view, int i, long l, IDrawerItem iDrawerItem) {
                        return true;
                    }
                })
                                .build();
    }

    private void initTabs() {
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
    }

    private void initToolbar() {
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
                drawerMenu.openDrawer();
            }
        });
    }
}

package ua.kh.tremtyachiy.shoping.util;

import android.app.Activity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import ua.kh.tremtyachiy.shoping.R;

/**
 * Created by Admin on 11.06.2015.
 */
public class DrawerMyMenu {
    private Drawer drawerMenu;

    public Drawer getDrawerMenu() {
        return drawerMenu;
    }

    public void initDrawerMenu(Activity activity, Toolbar toolbar){
        AccountHeader accountHeader = new AccountHeaderBuilder()
                .withActivity(activity)
                .withHeaderBackground(R.raw.shopinghelper_drawer_header)
                .withHeightDp(230)
                .build();

        drawerMenu = new DrawerBuilder()
                .withAccountHeader(accountHeader)
                .withToolbar(toolbar)
                .withDisplayBelowToolbar(true)
                .withActionBarDrawerToggleAnimated(true)
                .withActivity(activity)
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
}

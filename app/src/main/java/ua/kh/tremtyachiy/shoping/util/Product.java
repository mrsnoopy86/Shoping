package ua.kh.tremtyachiy.shoping.util;

import android.view.View;

import java.util.Date;

/**
 * Created by User on 09.06.2015.
 */
public class Product {
    private String title;
    private String about;
    private String type;
    private Date dateStart;
    private Date dateEnd;
    private int visibilityOfRemember = View.VISIBLE;
    private int visibilityOfToDay = View.VISIBLE;
    private int visibilityOfImportant = View.VISIBLE;

    public Product(String title, String about, String type, Date dateStart, Date dateEnd) {
        this.title = title;
        this.about = about;
        this.type = type;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public Product(String title, String about, String type, Date dateStart, Date dateEnd, int visibilityOfRemember, int visibilityOfToDay, int visibilityOfImportant) {
        this.title = title;
        this.about = about;
        this.type = type;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.visibilityOfRemember = visibilityOfRemember;
        this.visibilityOfToDay = visibilityOfToDay;
        this.visibilityOfImportant = visibilityOfImportant;
    }

    public String getTitle() {
        return title;
    }

    public String getAbout() {
        return about;
    }

    public String getType() {
        return type;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public int getVisibilityOfRemember() {
        return visibilityOfRemember;
    }

    public int getVisibilityOfToDay() {
        return visibilityOfToDay;
    }

    public int getVisibilityOfImportant() {
        return visibilityOfImportant;
    }
}

package ua.kh.tremtyachiy.shoping.util;

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

    public Product(String title, String about, String type, Date dateStart, Date dateEnd) {
        this.title = title;
        this.about = about;
        this.type = type;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
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
}

package lv.javaguru.java2.services;

import java.sql.Date;

/**
 * Created by NightStranger on 6/7/2016.
 */
public class Utilities {

    public static Date getDateFromString(String str) {
        if (str == null) {
            return null;
        }
        String formattedStr = str.trim();
        if (formattedStr.length() == 0) {
            return null;
        }
        return Date.valueOf(str.trim());
    }

}

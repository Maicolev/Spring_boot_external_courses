package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversions {
    private final static String DATE_FORMAT = "dd-MM";

    public static String format(Date date){

        SimpleDateFormat formater = new SimpleDateFormat(DATE_FORMAT);
        return formater.format(date);
    }

}
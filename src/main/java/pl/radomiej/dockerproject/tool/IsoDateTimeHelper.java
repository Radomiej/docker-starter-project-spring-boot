package pl.radomiej.dockerproject.tool;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public class IsoDateTimeHelper {
    private static DateTimeFormatter formatter = ISODateTimeFormat.dateTime();

    public static String getStringDateSinceNow(int millisFromNow) {
        DateTime dt = new DateTime(DateTimeZone.UTC);
        dt.plus(millisFromNow);
        String textDate = formatter.print(dt);
        return  textDate;

    }
}

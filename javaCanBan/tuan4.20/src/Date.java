import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Date {
    private String stringDate;
    public String dayOfWeek(String stringDate) throws ParseException{
        final DateFormat df1 = new SimpleDateFormat("MM/dd/yyyy");
        java.util.Date date1 = df1.parse(stringDate);
        final DateFormat df2 = new SimpleDateFormat("EEE");
        String dateString2 = df2.format(date1);
        return "(" + dateString2 + ")";
    }
}

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class ContactDobComparator implements Comparator<ContactBean> {
    @Override
    public int compare(ContactBean o1, ContactBean o2) {
        // TODO Auto-generated method stub
        String s1 = o1.getDob();
        String s2 = o2.getDob();
        try {
            return convertToDate(s1).compareTo(convertToDate(s2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static Date convertToDate(String s) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d = sdf.parse(s);

return d;
    }
}

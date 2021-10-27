import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Mai {
public static void main(String[] args) throws ParseException {
	
	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	Date d= new Date();
	Calendar calendar = Calendar.getInstance();
	calendar.setTime(d);
	System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
	System.out.println(calendar.get(Calendar.MONTH));
	LocalDate  date = LocalDate.now();
	System.out.println(date.getDayOfMonth());
	System.out.println(date.getMonthValue());
	System.out.println(d);
	Date h=sdf.parse("26/10/1995");
	System.out.println(h);
	System.out.println(d.compareTo(h));
	System.out.println(d.getDay());
}
}

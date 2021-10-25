import java.util.Comparator;

public class ContactTagComparator implements Comparator<ContactBean> {
@Override
public int compare(ContactBean o1, ContactBean o2) {
	// TODO Auto-generated method stub
	return o1.getTags().compareTo(o2.getTags());
}
}

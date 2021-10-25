import java.util.Comparator;

public class ContactDobComparator implements Comparator<ContactBean> {
	@Override
	public int compare(ContactBean o1, ContactBean o2) {
		// TODO Auto-generated method stub
		return o1.getDob().compareTo(o2.getDob());
	}
}
}

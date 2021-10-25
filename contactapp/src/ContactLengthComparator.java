import java.util.Comparator;

public class ContactLengthComparator implements Comparator<ContactBean> {
	public static int findLength(ContactBean bean)
	{
		return  bean.getContactName().length()+bean.getAddress().length()+bean.getDob().length()+bean.getPetName().length()+bean.getTags().length()+bean.getEmail().toString().length()+bean.getPhoneNo().toString().length();
	}
@Override
public int compare(ContactBean o1, ContactBean o2) {
	// TODO Auto-generated method stub
	int n1=findLength(o1);
	int n2=findLength(o2);
	return n1-n2;
}
}

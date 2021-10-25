import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class SubMenuTasks {

    public static String addContactTask(String contactBookName) throws ParseException {
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        System.out.println("adding contact");
        System.out.println("enter the contact name");
        String contactName = sc2.nextLine();
        System.out.println("enter the date of birth(dd/MM/yyyy)");
        String d = sc2.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dob1 = sdf.parse(d);
        String dob = sdf.format(dob1);

        System.out.println(dob);
        System.out.println("enter tags for the contact(comma seperated)");
        String tags = sc2.nextLine();
        System.out.println("enter the petname");
        String petName = sc2.nextLine();
        System.out.println("enter the address");
        String address = sc2.nextLine();
        System.out.println("enter number of emails you are going to add");
        int count1 = sc1.nextInt();
        List<String> email = new ArrayList<String>();
        while (count1 > 0) {
            System.out.println("enter the email address");
            String mail = sc2.nextLine();
            email.add(mail);
            count1--;
        }
        System.out.println("enter no of phone numbers you are going to add ");
        int count2 = sc1.nextInt();
        List<String> phoneNo = new ArrayList<String>();
        while (count2 > 0) {
            System.out.println("enter the phone number");
            String num = sc2.nextLine();
            phoneNo.add(num);
            count2--;
        }
        ContactBean bean = new ContactBean(contactName, tags, address, petName, dob, email,
                phoneNo);
        ContactModel model = new ContactModel();
        String result1 = model.addContact(bean, contactBookName);
        return result1;
    }
}

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ContactsApp {
    public static void main(String[] args) throws ParseException {
        try {
            Scanner sc1 = new Scanner(System.in);
            Scanner sc2 = new Scanner(System.in);
            int ch1 = 0, ch2 = 0;
            String contactBookName, contactName, address, tags, petName, dob;
            ContactBean bean = new ContactBean();
            List<String> email = new ArrayList<String>();

            List<String> phoneNo = new ArrayList<String>();
            ContactModel model = new ContactModel();
            while (ch1 != 6) {
                Menu.loadMenu();
                ch1 = sc1.nextInt();
                // TODO: 25/10/21 Validation
                switch (ch1) {
                    case 1:
                        System.out.println("creating contactbook");
                        System.out.println("enter name for the contactbook");
                        contactBookName = sc2.nextLine();
                        String result = ContactUtil.validateName(contactBookName);
                        while (!result.equals(Constants.SUCCESS)) {
                            System.out.println(result);
                            System.out.println("creating contactbook");
                            System.out.println("enter name for the contactbook");
                            contactBookName = sc2.nextLine();
                            result = ContactUtil.validateName(contactBookName);
                        }
                        if (model.checkContactBooknameExists(contactBookName))
                            System.out.println("contactbook name is already exists please give other name");
                        else {
                            model.createContactBook(contactBookName);
                            SubMenuTasks.allSubMenuTasks(contactBookName);
                        }
                        break;
                    case 2:
                        System.out.println("loading contacts");
                        List<String> list = model.loadContactBook();
                        for (String d : list)
                            System.out.println(d);

                        System.out.println("enter the contactBook name you are going load");
                        contactBookName = sc2.nextLine();
                        while (!model.checkContactBooknameExists(contactBookName)) {
                            System.out.println("contact book does not exist please first create the contact book");
                            System.out.println("enter the contactBook name you are going load");
                            contactBookName = sc2.nextLine();

                        }
                        SubMenuTasks.allSubMenuTasks(contactBookName);
                        break;
                    case 3:
                    	System.out.println("Searching contact");
                    	List<String> l1= model.loadContactBook();
                    	for(String h:l1)
                    	{
                    		System.out.println(h);
                    	}
                    	System.out.println("enter the contactBookname to list");
                    	contactBookName=sc2.nextLine();
                    	System.out.println("enter the word your are going to search");
                    	String word=sc2.nextLine();
                    	SubMenuTasks.searchWord(word,contactBookName);
                    	
                    	break;
                    case 4:
                    	System.out.println("listing contact");
                    	List<String> l= model.loadContactBook();
                    	for(String h:l)
                    	{
                    		System.out.println(h);
                    	}
                    	System.out.println("enter the contactBookname to list");
                    	contactBookName=sc2.nextLine();
                    	SubMenuTasks.listContacts(contactBookName);
                    	break;

                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }
}

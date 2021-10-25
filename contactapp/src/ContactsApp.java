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
            List<String> email = new ArrayList<String>();

            List<String> phoneNo = new ArrayList<String>();
            ContactModel model = new ContactModel();
            while (ch1 != 6) {
                System.out.println("press 1 to create contact book");
                System.out.println("press 2 to load contact book");
                System.out.println("press 3 to search contacts ");
                System.out.println("press 4 to list contacts");
                System.out.println("press 5 to Birthday Reminders");
                System.out.println("press 6 to exit");
                System.out.println("enter your choice");
                ch1 = sc1.nextInt();
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
                            int ch7 = 0;
                            outer:
                            while (ch7 != 3) {
                                System.out.println("press 1 adding");
                                System.out.println("press 2 loading");
                                System.out.println("press 3 to exit");
                                System.out.println("enter your choice");
                                ch7 = sc1.nextInt();
                                switch (ch7) {
                                    case 1:
                                        while (ch2 != 6) {
                                            System.out.println("press 1 to add contact");
                                            System.out.println("press 2 to edit contact");
                                            System.out.println("press 3 to remove contact");
                                            System.out.println("press 4 to list contact");
                                            System.out.println("press 5 to search contact");
                                            System.out.println("press 6 to go back");
                                            System.out.println("enter your choice");
                                            ch2 = sc1.nextInt();
                                            switch (ch2) {
                                                case 1:
                                                    System.out.println("adding contact");
                                                    System.out.println("enter the contact name");
                                                    contactName = sc2.nextLine();
                                                    System.out.println("enter the date of birth(dd/MM/yyyy)");
                                                    String d = sc2.nextLine();
                                                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                                    Date dob1 = sdf.parse(d);
                                                    dob = sdf.format(dob1);

                                                    System.out.println(dob);
                                                    System.out.println("enter tags for the contact(comma seperated)");
                                                    tags = sc2.nextLine();
                                                    System.out.println("enter the petname");
                                                    petName = sc2.nextLine();
                                                    System.out.println("enter the address");
                                                    address = sc2.nextLine();
                                                    System.out.println("enter number of emails you are going to add");
                                                    int count1 = sc1.nextInt();
                                                    email = new ArrayList<String>();
                                                    while (count1 > 0) {
                                                        System.out.println("enter the email address");
                                                        String mail = sc2.nextLine();
                                                        email.add(mail);
                                                        count1--;
                                                    }
                                                    System.out.println("enter no of phone numbers you are going to add ");
                                                    int count2 = sc1.nextInt();
                                                    phoneNo = new ArrayList<String>();
                                                    while (count2 > 0) {
                                                        System.out.println("enter the phone number");
                                                        String num = sc2.nextLine();
                                                        phoneNo.add(num);
                                                        count2--;
                                                    }
                                                    ContactBean bean = new ContactBean(contactName, tags, address, petName, dob, email,
                                                            phoneNo);
                                                    String result1 = model.addContact(bean, contactBookName);
                                                    if (result1.equals(Constants.SUCCESS))
                                                        System.out.println("contact is successfuly added");
                                                    else
                                                        System.out.println(result1);
                                                    break;
                                                case 2:
                                                    System.out.println("editing contact");
                                                    System.out.println("enter the contact name you are going to edit");
                                                    contactName = sc2.nextLine();
                                                    if (!model.checkContactNameExists(contactName, contactBookName)) {
                                                        System.out.println("contact name does not exist");
                                                        break;
                                                    } else {

                                                        int ch = 0;
                                                        while (ch != 3) {
                                                            System.out.println("press 1 to edit or remove contact");
                                                            System.out.println("press 2 to add email or phone no");
                                                            System.out.println("enter your choice");
                                                            ch = sc1.nextInt();
                                                            switch (ch) {
                                                                case 1:
                                                                    System.out.println("editing or removing contact");
                                                                    int c = 0;
                                                                    while (c != 3) {
                                                                        System.out.println("press 1 edit contact");
                                                                        System.out.println("press 2 remove contact");
                                                                        System.out.println("press 3 to go back");
                                                                        System.out.println("entr your choice");
                                                                        c = sc1.nextInt();
                                                                        switch (c) {
                                                                            case 1:
                                                                                System.out.println("editing contact");
                                                                                int ch3 = 0;
                                                                                while (ch3 != 5) {
                                                                                    bean = model.getOneContact(contactName, contactBookName);
                                                                                    System.out.println(bean);
                                                                                    System.out.println("press 1 to change address");
                                                                                    System.out.println("press 2 to change tags");
                                                                                    System.out.println("press 3 to change petname");
                                                                                    System.out.println("press 4 to change dob");
                                                                                    System.out.println("press 5 to exit");
                                                                                    System.out.println("enterr your choice");
                                                                                    ch3 = sc1.nextInt();
                                                                                    switch (ch3) {
                                                                                        case 1:
                                                                                            System.out.println("editing contact address");
                                                                                            bean = model.getOneContact(contactName, contactBookName);
                                                                                            model.removeContact(contactName, contactBookName);

                                                                                            System.out.println("enter the new adress");
                                                                                            bean.setAddress(sc2.nextLine());
                                                                                            model.addContact(bean, contactBookName);
                                                                                            break;
                                                                                        case 2:
                                                                                            System.out.println("editing contact tags");
                                                                                            bean = model.getOneContact(contactName, contactBookName);
                                                                                            model.removeContact(contactName, contactBookName);
                                                                                            System.out.println("enter the new tags(comma seperated)");
                                                                                            bean.setTags(sc2.nextLine());
                                                                                            model.addContact(bean, contactBookName);
                                                                                            break;
                                                                                        case 3:
                                                                                            System.out.println("editing petname");
                                                                                            bean = model.getOneContact(contactName, contactBookName);
                                                                                            model.removeContact(contactName, contactBookName);
                                                                                            System.out.println("enter new petname");
                                                                                            bean.setPetName(sc2.nextLine());
                                                                                            model.addContact(bean, contactBookName);
                                                                                            break;
                                                                                        case 4:
                                                                                            System.out.println("editing dob");
                                                                                            bean = model.getOneContact(contactName, contactBookName);
                                                                                            model.removeContact(contactName, contactBookName);
                                                                                            System.out.println("enter the new date of birth");
                                                                                            String r = sc2.nextLine();
                                                                                            SimpleDateFormat ad = new SimpleDateFormat("dd/MM/yyyy");
                                                                                            Date g = ad.parse(r);
                                                                                            bean.setDob(ad.format(g));
                                                                                            model.addContact(bean, contactBookName);
                                                                                            break;
                                                                                        case 5:
                                                                                            System.out.println("going back");
                                                                                            break;

                                                                                        default:
                                                                                            throw new IllegalStateException("Unexpected value: " + ch3);
                                                                                    }

                                                                                }
                                                                                break;
                                                                            case 2:
                                                                                System.out.println("removing contact");
                                                                                model.removeContact(contactName, contactBookName);
                                                                                break;

                                                                        }
                                                                    }
                                                                case 2:

                                                                    System.out.println("adding email or phone no");
                                                                    int ch4 = 0;
                                                                    while (ch4 != 3) {
                                                                        bean = model.getOneContact(contactName, contactBookName);
                                                                        System.out.println(bean);

                                                                        System.out.println("press 1 to add email");
                                                                        System.out.println("press 2 to add phone no");
                                                                        System.out.println("press 3 to exit");
                                                                        System.out.println("enter your choice");
                                                                        ch4 = sc1.nextInt();
                                                                        switch (ch4) {
                                                                            case 1:
                                                                                System.out.println("adding email");
                                                                                bean = model.getOneContact(contactName, contactBookName);
                                                                                model.removeContact(contactName, contactBookName);
                                                                                List<String> temp = new ArrayList<String>();
                                                                                temp = bean.getEmail();
                                                                                System.out.println("enter number of emails you are going to add");
                                                                                int count3 = sc1.nextInt();
                                                                                while (count3 > 0) {
                                                                                    System.out.println("enter the email address");
                                                                                    String mail = sc2.nextLine();
                                                                                    temp.add(mail);
                                                                                    count3--;
                                                                                }
                                                                                bean.setEmail(temp);
                                                                                model.addContact(bean, contactBookName);
                                                                                break;
                                                                            case 2:
                                                                                System.out.println("adding Phone number");
                                                                                bean = model.getOneContact(contactName, contactBookName);
                                                                                model.removeContact(contactName, contactBookName);
                                                                                List<String> temp1 = new ArrayList<String>();
                                                                                temp = bean.getPhoneNo();
                                                                                System.out.println(
                                                                                        "enter number of phone numbers you are going to add");
                                                                                int count4 = sc1.nextInt();
                                                                                while (count4 > 0) {
                                                                                    System.out.println("enter the phone number");
                                                                                    String mail = sc2.nextLine();
                                                                                    temp.add(mail);
                                                                                    count4--;
                                                                                }
                                                                                bean.setPhoneNo(temp);
                                                                                model.addContact(bean, contactBookName);
                                                                                break;
                                                                        }
                                                                    }
                                                                    break;
                                                                case 3:
                                                                    System.out.println("removing contact");
                                                                    System.out.println("enter the contact name to remove");
                                                                    contactName = sc2.nextLine();
                                                                    if (model.checkContactNameExists(contactName, contactBookName))
                                                                        model.removeContact(contactName, contactBookName);
                                                                    else
                                                                        System.out.println(
                                                                                "the you have given is not in the book first add the contact");
                                                                    break;
                                                                case 4:
                                                                    System.out.println("listing contacts");
                                                                    List<ContactBean> list = new ArrayList<ContactBean>();
                                                                    Set<ContactBean> list1;

                                                                    int ch5 = 0;
                                                                    while (ch5 != 5) {
                                                                        System.out.println("press 1 to list by name");
                                                                        System.out.println("press 2 to list by tags");
                                                                        System.out.println("press 3 to list by date");
                                                                        System.out
                                                                                .println("press 4 to list by string length of entire contact");
                                                                        System.out.println("press 5 to go back");
                                                                        System.out.println("enter your choice");
                                                                        ch5 = sc1.nextInt();
                                                                        switch (ch5) {
                                                                            case 1:
                                                                                System.out.println("listing by name");
                                                                                list = model.listContacts(contactBookName);
                                                                                list1 = new TreeSet<ContactBean>(list);
                                                                                for (ContactBean b : list1) {
                                                                                    System.out.println(b);
                                                                                    System.out.println();
                                                                                }
                                                                                break;

                                                                            case 2:
                                                                                System.out.println("listing by tags");
                                                                                ContactTagComparator tc = new ContactTagComparator();
                                                                                list = model.listContacts(contactBookName);
                                                                                list1 = new TreeSet<ContactBean>(tc);
                                                                                for (ContactBean g : list) {
                                                                                    list1.add(g);
                                                                                }
                                                                                for (ContactBean b : list1) {
                                                                                    System.out.println(b);
                                                                                    System.out.println();
                                                                                }
                                                                                break;
                                                                            case 3:
                                                                                System.out.println("listing by dob comparator");
                                                                                ContactDobComparator dc = new ContactDobComparator();
                                                                                list = model.listContacts(contactBookName);
                                                                                list1 = new TreeSet<ContactBean>(list);
                                                                                list1 = new TreeSet<ContactBean>(dc);
                                                                                for (ContactBean g : list) {
                                                                                    list1.add(g);
                                                                                }
                                                                                for (ContactBean b : list1) {
                                                                                    System.out.println(b);
                                                                                    System.out.println();
                                                                                }
                                                                                break;
                                                                            case 4:
                                                                                System.out.println("listing by ContactLength");
                                                                                ContactLengthComparator lc = new ContactLengthComparator();
                                                                                list = model.listContacts(contactBookName);
                                                                                list1 = new TreeSet<ContactBean>(list);
                                                                                list1 = new TreeSet<ContactBean>(lc);
                                                                                for (ContactBean g : list) {
                                                                                    list1.add(g);
                                                                                }
                                                                                for (ContactBean b : list1) {
                                                                                    System.out.println(b);
                                                                                    System.out.println();
                                                                                }
                                                                                break;

                                                                            case 5:
                                                                                System.out.println("going back");
                                                                                break;

                                                                        }

                                                                    }
                                                                case 5:
                                                                    System.out.println("searching contacts");
                                                                    System.out.println("enter the word you are going to search");
                                                                    String search = sc2.nextLine();
                                                                    model.findOccurance(search, contactBookName);
                                                            }
                                                        }

                                                    }

                                            }

                                        }
                                }
                            }
                        }
                    case 2:
                        System.out.println("loading contacts");
                        System.out.println("enter the contactBook name you are going load");
                        contactBookName = sc2.nextLine();
                        while (!model.checkContactBooknameExists(contactBookName)) {
                            System.out.println("contactbook does not exist pease first create the contact book");
                            System.out.println("enter the contactBook name you are going load");
                            contactBookName = sc2.nextLine();

                        }
                        String result5 = model.loadContactBook(contactBookName);
                        inner:
                        while (result5.equals(Constants.SUCCESS)) {
                        }

                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }
}

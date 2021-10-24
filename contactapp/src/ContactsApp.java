import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ContactsApp {
    public static void main(String[] args) {
        try {
            Scanner sc1 = new Scanner(System.in);
            Scanner sc2 = new Scanner(System.in);
            int ch1 = 0, ch2 = 0;
            String contactBookName, contactName, address, tags, petName;
            List<String> email = new ArrayList<String>();
            Date dob;

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
                                        dob = sdf.parse(d);
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
                                        ContactBean bean = new ContactBean(contactName, tags, address, petName, dob, email, phoneNo);
                                        String result1 = model.addContact(bean, contactBookName);
                                        if (result1.equals(Constants.SUCCESS))
                                            System.out.println("contact is successfuly added");
                                        else
                                            System.out.println(result1);
                                        break;
                                    case 2:
                                        System.out.println("editing contact");
                                        System.out.println("enter the contactbookname you are going to edit");
                                        contactBookName=sc2.nextLine();
                                        if(!model.checkContactBooknameExists(contactBookName))
                                        {
                                            System.out.println("contactBookname does not exist first create contactbook");
                                            break;
                                        }else {
                                            System.out.println("enter the contact name you are going to edit");
                                            contactName = sc2.nextLine();
                                            if (!model.checkContactNameExists(contactName,
                                                    contactBookName)) {
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

                                                    }
                                                }
                                            }
                                        }

                                }
                            }
                        }


                }
            }

        } catch (Throwable e) {
            e.printStackTrace();
        }

    }
}

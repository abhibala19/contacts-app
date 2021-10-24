import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContactModel {

    public boolean checkContactBooknameExists(String contactBookName) {
        return new File(contactBookName + ".tocall").exists();

    }
public void removeContact(String contactName,String contactBookName)
{
    BufferedReader br=null;
    BufferedWriter bw=null;
    List<String> l=new ArrayList<String>();
    try{
        br=new BufferedReader(new FileReader(contactBookName+".tocall"));
        String line;
        bw=new BufferedWriter(new FileWriter(contactBookName+".tocall"));
        while((line=br.readLine())!=null)
        {
            String[] a=line.split(":");
            if(!a[0].equals(contactName))
                l.add(line);
        }
        for(String s:l)
        {
            bw.write(s);
            bw.newLine();
        }

    }catch(Throwable e)
    {
        e.printStackTrace();
    }finally {
        if(bw!=null)
        {
            try{bw.close();}
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        if(br!=null)
        {
            try{ br.close();}catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

}
    public ContactBean getOneContact(String contactName, String
            contactBookName) {

        ContactBean contact = null;
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader(contactBookName + ".tocall"));
            while ((line = br.readLine()) != null) {
                String[] a = line.split(":");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                List<String> mail = new ArrayList<String>();
                List<String> phNo = new ArrayList<String>();
                System.out.println(a.length);
                String f=a[5];
                String g=a[6];

                mail = ContactUtil.convertToList(f.substring(1,f.length()-1));
                phNo = ContactUtil.convertToList(g.substring(1,g.length()-1));
                if (a[0].equals(contactName)) {


                    contact = new ContactBean(a[0], a[1], a[2], a[3], sdf.parse(a[4]), mail, phNo);


                }
            }
            return contact;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }
        return null;
    }

    public boolean checkContactNameExists(String contactName, String contactBookName) {
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader(contactBookName + ".tocall"));
            while ((line = br.readLine()) != null) {
                String[] a = line.split(":");
                if (a[0].equals(contactName))
                    return true;
            }
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }

            }
        }
    }

    public String addContact(ContactBean contact, String contactBookName) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(contactBookName + ".tocall", true));
            bw.write(contact.getContactName() + ":" + contact.getDob() + ":" + contact.getAddress() + ":"
                    + contact.getTags() + ":" + contact.getPetName() + ":" + contact.getEmail() + ":" + contact.getPhoneNo());
            bw.newLine();
            return Constants.SUCCESS;

        } catch (IOException e) {
            e.printStackTrace();
            return "something bad happened" + e.getMessage();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {

                    e.printStackTrace();
                    return "error occurs" + e.getMessage();
                }
            }
        }
    }

    public String createContactBook(String contactBookName) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(contactBookName + ".tocall", true));
            bw.newLine();
            return Constants.SUCCESS;

        } catch (IOException e) {
            e.printStackTrace();
            return "something bad happened" + e.getMessage();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {

                    e.printStackTrace();
                    return "error occurs" + e.getMessage();
                }
            }
        }
    }
}

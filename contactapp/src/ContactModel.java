import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ContactModel {

    public boolean checkContactBooknameExists(String contactBookName) {
        return new File(contactBookName + ".tocall").exists();

    }
    public ContactBean getOneContact(String contactName,String
            contactBookName)
    {

    ContactBean contact;
        BufferedReader br=null;
        try{
            String line;
            br=new BufferedReader(new FileReader(contactBookName+".tocall"));
            while((line=br.readLine())!=null)
            {
                String[] a=line.split(":");
                SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
                if(a[0].equals(contactName))
                {
                    contact = new ContactBean(a[0], a[1], a[2], a[3],sdf.parse(a[4]),s );


                }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        finally {
            if(br!=null)
            {
                try{
                    br.close();
                }catch(IOException e)
                {
                    e.printStackTrace();
                }


            }

    public boolean checkContactNameExists(String contactName,String
                                       contactBookName)
{
    BufferedReader br=null;
    try{
        String line;
        br=new BufferedReader(new FileReader(contactBookName+".tocall"));
        while((line=br.readLine())!=null)
        {
            String[] a=line.split(":");
            if(a[0].equals(contactName))
                return true;
        }
        return false;
    }
    catch(IOException e)
    {
        e.printStackTrace();
        return false;
    }
    finally {
        if(br!=null)
        {
            try{
                br.close();
            }catch(IOException e)
            {
                e.printStackTrace();
                return  false;
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
}

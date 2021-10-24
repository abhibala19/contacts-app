import com.sun.xml.internal.ws.util.StringUtils;
import sun.text.normalizer.UCharacter;

import java.util.ArrayList;
import java.util.List;

public class ContactUtil {
    public static List convertToList(String s)
    {List<String> l=new ArrayList<String >();
        String[] a=s.split(",");
        for(String d:a)
        {
            l.add(d);

        }
        return l;
    }
    public static String validateName(String name)
    {
        if(name==null)
            return "name cannot be null";
        if(name.trim().equals(""))
            return "emptyString";
        String[] strings=name.split(" ");
        if(strings.length>1)
            return "name should be a single word";
        for(int i=0;i<name.length();i++)
        {
            char c=name.charAt(i);
            if(!Character.isLetter(c) || Character.isDigit(c))
                return "digits and special characters not allowed";
        }
        return Constants.SUCCESS;
    }
}

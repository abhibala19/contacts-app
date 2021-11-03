import java.util.*;

public class Luck {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        System.out.println("enter the no of rounds you want to play");
        int round=sc1.nextInt();
        System.out.println("enter the no of person");
       int noOfPerson = sc1.nextInt();
        System.out.println("enter the no of places you want result");
       int places = sc1.nextInt();
       int sum=0;
        Set<Map.Entry<String, Integer>> result1=null;

        Map<String, Integer> map = new HashMap<String, Integer>();

        while(round>0) {
            int i = 0, temp = noOfPerson;
            while (noOfPerson != 0) {
                int n = (int) (Math.random() * 50);

                map.put("person " + i, (map.get("person "+i) == null) ? n : (map.get("person "+i) + n));
                noOfPerson--;
                i++;
            }
            round--;
            noOfPerson = temp;
        }
        System.out.println(map.toString());
        Set<Map.Entry<String, Integer>> result = map.entrySet();
        RandomValueComparator rc=new RandomValueComparator();
         result1 =new TreeSet<>(rc);


        for (Map.Entry m : result) {
            result1.add(m);

        }
        for(Map.Entry t:result1) {
            if (places != 0) {
                System.out.println(t);
                places--;

            }
        }
        if(!result1.isEmpty()) {
            System.out.println("Leader " + result1.iterator().next());
        }
    }
}

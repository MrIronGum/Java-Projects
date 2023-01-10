
import java.util.Arrays;
public class switchPair {
    public static void main (String[] args)
    {
        String[] a = {"a", "bb", "c", "ddd", "ee", "f", "g"};
        switchPairs(a);
    }

    public static void switchPairs(String[] a){
        for(int i = 0; i < a.length-1; i=i+2){
            String temp = a[i];
            a[i] = a[i+1];
            a[i+1] = temp;
        }
        System.out.println(Arrays.toString(a));
    }
}
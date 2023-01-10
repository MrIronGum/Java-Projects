import java.util.Arrays;
public class Collapse {
    public static void main(String[] args){
        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] b = collapse(a);
        System.out.println(Arrays.toString(b));
    }

    public static int[] collapse(int[] a){
        int n = a.length;
        int i = 0;
        int[] b =  new int[(n+1)/2];
        for (int j = 0; j < n-1; j = j+2){
            b[i] = a[j] + a[j+1];
            i++;  
        }

        if(i != b.length)
            b[i] = a[a.length-1];
        return b;
    }

}

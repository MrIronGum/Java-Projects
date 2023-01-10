import java.util.Arrays;
public class reverse{
    public static void main(String[] args) {
        int[] a = new int[]{10, 30, 20, 40, 60, 50};
        reverseFirstK(a, 7);
    }

    public static void reverseFirstK(int[] a, int k){
        if (k < 1 || k <= a.length){
        for(int i = 0; i < k/2; i++){
            int temp = a[i];
            a[i] = a[k-i-1];
            a[k-i-1] = temp;
        }
            System.out.println(Arrays.toString(a));
        }
        else{
            System.out.println(Arrays.toString(a));
        }
    }
}
import java.util.ArrayList;
public class countInRange_Problem{
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(28);
        list.add(1);
        list.add(17);
        list.add(4);
        list.add(41);
        list.add(9);
        list.add(59);
        list.add(8);
        list.add(31);
        list.add(30);
        list.add(25);
        countInRange(list, 10, 30);
    }

    public static int countInRange(ArrayList<Integer> list, int min, int max){
        int counter = 0;
        for (int i = 0; i < list.size(); i++){
            int element = list.get(i);
            if (element >= min && element <= max)
                 counter++;
        }
        return counter;
    } 
}
import java.util.ArrayList;
public class removeAll_SmallProblem{
    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");

        removeAll(list, "a");
        System.out.println(list);
    }

    public static void removeAll(ArrayList<String> list, String element){
            while(list.contains(element)){
                list.remove(element);
            }
    }
}
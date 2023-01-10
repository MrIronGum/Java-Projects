import java.util.ArrayList;
public class mirror_SmallProblem{
    public static void main(String[] args){
        ArrayList<String> list= new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");

        mirror(list);
        System.out.println(list);
    }

    public static void mirror(ArrayList<String> list)
    {
        int size = list.size();
        for(int i = 1; i < size*2; i++){
            String element = list.get(i);
            list.add(size+1, element);
        }
        
    }
}
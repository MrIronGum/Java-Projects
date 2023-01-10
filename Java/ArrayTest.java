
public class ArrayTest{
    public static void main(String[] args){
        ArrayIntList list = new ArrayIntList();
        list.add(5);
        list.add(4);
        list.add(2);
        list.add(7);
        list.add(3);
        list.add(2);

        int index = list.indexOf(7);
        System.out.println(index);
        String str = list.toString();
        System.out.println(str);

        list.stutter();
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
    }
}
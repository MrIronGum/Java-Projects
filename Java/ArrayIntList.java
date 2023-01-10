import java.util.Arrays;
public class ArrayIntList {
    private int[] elementData;
    private int size; 

    public ArrayIntList(){
        elementData = new int[10];
        size = 0;
    }

    public void add(int value) {
        ensureCapacity(size + 1);
        elementData[size] = value;
        size++;
    }

    public int indexOf(int index){
        for (int i = 0; i < size; i++){
            if(elementData[i] == index){
                return i;
            }
        }
        return -1;
    }

    public void stutter(){
        ensureCapacity(size * 2);
        for(int i = size - 1; i >= 0; i--){
            elementData[2*i] = elementData[i];
            elementData[2*i+1] = elementData[i];
        }
        size *= 2;
    }

    public void remove(int index){
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException();
        }
        for(int i = index; i < size - 1; i++){
            elementData[i] = elementData[i+1];
        }
        size --;
    }

    private void ensureCapacity(int capacity) {
        if (capacity > elementData.length) {
            int newCapacity = elementData.length * 2 + 1;
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }



    public String toString() {
        if (size == 0) {
            return "[]";
        }
        String result = "[" + elementData[0];
        for (int i = 1; i < size; i++) {
            result += ", " + elementData[i];
        }
        result += "]";
        return result;
    }

}

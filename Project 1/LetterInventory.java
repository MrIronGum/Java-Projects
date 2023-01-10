public class LetterInventory{
    private int[] elementData;
    private int size;
    private static final int ALPHABET_SIZE = 26;

    //Constructor letterInventory 
    public LetterInventory(String data)
    {
        //initializing the data array 
        elementData = new int[ALPHABET_SIZE];
        data = data.toLowerCase();
        size = 0;
        // counts letters and writes them into array
        for (int i = 0; i < data.length(); i++){
            if(Character.isLetter(data.charAt(i))){
                elementData[data.charAt(i) - 'a']++;
                size++;
            }
        }

    }

    // return the total number of characters in the inventory
    public int size()
    {
        int size = 0;
        for (int count : elementData){
            size += count;
        }
        return size;
    }

    // return true if the inventory is empty, if not then false
    public boolean isEmpty(){
        return size == 0;
    }

    //Returns a count of how many of this letter are in the inventory. Letter might be lowercase or uppercase
    // checks if the letter argument is a non-alphabetic character, if it's then throws exception 
    // checks if index in a right interval, if not throws an exception
    public int get(char letter){
         if(!Character.isLetter(letter)){
            throw new IllegalArgumentException("The invalid letter: " + letter);
         }
         int index = Character.toLowerCase(letter) - 'a';
         if(index < 0 || index >= ALPHABET_SIZE){
            throw new IllegalArgumentException("The invalid letter: " + letter);
         }
         return elementData[index];
    }

    public String toString() {
        String string = "[";
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            for (int j = 0; j < elementData[i]; j++) {
                string += (char)('a' + i);
            }
        }
        return string + "]";
    }


}


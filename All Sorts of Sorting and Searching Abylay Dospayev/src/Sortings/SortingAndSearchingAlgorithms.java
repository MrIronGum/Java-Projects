package Sortings;
/**------------------------------------------------------------
 * <pre>
 * File             SortingAndSearchingAlgorithms.java
 * Description      A class encapsulating six sorting and searching algorithms 
 * Project          All sorts of sorting and searching
 * Platform         jdk 1.8.0_214; NetBeans IDE 11.3; Windows 10
 * Course           CS 142, Edmonds Community College
 * Hours            12 hours and 45 minutes
 * Date             10/14/2022
 * History log         
 * </pre>
 *  @author          <i>Abylay Dospayev</i>
 -------------------------------------------------------------*/
public class SortingAndSearchingAlgorithms {
    private static int heapSize;
 /**------------------------------------------------------------
 * <pre>
 * Method           linearSearch()
 * Description      Linear search algorithm search for a specified key linearly
 *                  Return index of where key is found and -1 if not found
 * Date             10/14/2022
 * History log         
 * </pre>
 * @author          <i>Abylay Dospayev</i>
 * @param           array int[]
 * @param           key int
 * @return          index int 0 based position of where found in the array
 -------------------------------------------------------------*/
    public static int linearSearch(int array[], int key)
    {
        for(int n = 0; n < array.length; n++)
        {
            if (array[n] == key)
            {
                return n;
            }
        }
        return -1;
    }
    
/**------------------------------------------------------------
 * <pre>
 * Method           binarySearch()
 * Description      binarySearch search algorithm search for a specified key linearly
 *                  Return index of where key is found and -1 if not found
 * Date             10/14/2022
 * History log         
 * </pre>
 * @author          <i>Abylay Dospayev</i>
 * @param           array int[]
 * @param           key int
 * @return          index int 0 based position of where found in the array
 -------------------------------------------------------------*/
    public static int binarySearch(int array[], int key){
        int low = 0;                //low subscript 
        int high = array.length-1;  //high subscript
        int middle;                 //middle subscript
        while(low <= high)
        {
            middle = (low + high)/2;
            if (key == array[middle])   // match
                return middle;
            else if (key < array[middle])
                high = middle - 1; //search low end of array
            else 
                low = middle + 1;  //search high end of array
        }
        return -1;  //searchKey not found
        
    }
    
/**------------------------------------------------------------
 * <pre>
 * Method           bubbleSort()
 * Description      sorts the int array using the Bubble Sort algorithm
 * Date             10/14/2022
 * History log         
 * </pre>
 * @author          <i>Abylay Dospayev</i>
 * @param           array int[]
 -------------------------------------------------------------*/
    public static void bubbleSort(int[] array){
        int i,j;
        int temp;
        int highestSubscript = array.length-1;
        for(i = 0; i < highestSubscript; i++)
            for(j = 0; j<highestSubscript-i;j++)
                if(array[j]>array[j+1])             //swap
                {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
                
    }//end of bubbleSort 
    
 /**------------------------------------------------------------
 * <pre>
 * Method           selectionSort()
 * Description      sorts the int array using the Selection Sort algorithm
 * Date             10/14/2022
 * History log         
 * </pre>
 * @author          <i>Abylay Dospayev</i>
 * @param           array int[]
 -------------------------------------------------------------*/
    public static void selectionSort(int[] array){
        int i,j;
        for(i = 0; i < array.length; i++){
            int min = findMinimum(array, i);
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }
    
 /**------------------------------------------------------------
 * <pre>
 * Method           findMinimum()
 * Description      Finds and returns the index of the smallest integer in the 
 *                  array starting from position i
 * @param           array int[]
 * @param           i int
 * @author          <i>Abylay Dospayev</i>
 -------------------------------------------------------------*/
    public static int findMinimum(int[] array, int i){
        int j, min = i;
        for(j = i + 1; j < array.length; j++)
            if(array[j] < array[min]) min = j;
        return min;
        
    }
    
 /**------------------------------------------------------------
 * <pre>
 * Method           swap()
 * Description      Exchanges the integers of the array at positions i and j
 * @param           array int[]
 * @param           i int
 * @param           j int
 * @author          <i>Abylay Dospayev</i>
 * Date             10/14/2022
 * History log
 -------------------------------------------------------------*/
    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
/**------------------------------------------------------------
 * <pre>
 * Method           insertionSort()
 * Description      Sorts the int array using the Insertion Sort algorithm
 * @param           array int[]
 * @author          <i>Abylay Dospayev</i>
 * Date             10/14/2022
 * History log
 -------------------------------------------------------------*/
    public static void insertionSort(int[] array)
    {
        int i, j;
        for(i = 0; i < array.length; i++)
        {
            int a = array[i];
            j = i - 1;
            while (j>=0 && array[j] > a)
            {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = a;
        }
    }
    
    /**------------------------------------------------------------
 * <pre>
 * Method           quickSort()
 * Description      Sorts the int array using the Quick Sort algorithm
 * @param           array int[]
 * @author          <i>Abylay Dospayev</i>
 * Date             10/14/2022
 * History log
 * </pre>
 -------------------------------------------------------------*/
    public static void quickSort(int[] array)
    {
        if (array == null || array.length <= 1)
        {
            return;
        }
        quick(array, 0, array.length-1);
    }
    /**------------------------------------------------------------
 * <pre>
 * Method           quick()
 * Description      Sorts the int array using the Quick Sort algorithm
 * @param           array int[]
 * @param           low int
 * @param           high int
 * @author          <i>Abylay Dospayev</i>
 * Date             10/14/2022
 * History log
 * </pre>
 -------------------------------------------------------------*/
    public static void quick(int[] array, int low, int high)
    {
        int i = low, j = high;
        //get the pivot element from the middle of the list
        int pivot  = array[low + (high-low)/2];
        
        //Divide into two lists
        while(i <= j)
        {
            
            while (array[i] < pivot)
                {
                    i++;
                }
            
            while (array[j] > pivot)
            {
                j--;
            }
            
            if (i <= j)
            {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        
        //Recursion 
        if (low < j)
            quick(array, low, j);
        if (i < high)
            quick(array, i, high);
        
    }
    
    /**------------------------------------------------------------
 * <pre>
 * Method           mergeSort()
 * Description      Sorts the int array using the Merge Sort algorithm
 * @param           array int[]
 * @author          <i>Abylay Dospayev</i>
 * Date             10/14/2022
 * History log
 * </pre>
 -------------------------------------------------------------*/
    public static void mergeSort(int[] array)
    {
        if (array == null || array.length == 0)
            return;
        merge(array, 0, array.length-1);
    }
    
    /**------------------------------------------------------------
 * <pre>
 * Method           merge()
 * Description      Sorts the int array using the Merge Sort algorithm
 * @param           low int
 * @param           high int
 * @param           array int[]
 * @author          <i>Abylay Dospayev</i>
 * Date             10/14/2022
 * History log
 * </pre>
 -------------------------------------------------------------*/
    public static void merge(int[] array, int low, int high)
    {
        if (low < high)
        {
            int middle = (low+high)/2;
            merge(array, low, middle);
            merge(array, middle + 1, high);
            mergedata(array, low, middle, high);
        }
    }
  /**------------------------------------------------------------
 * <pre>
 * Method           mergedata()
 * Description      Merges data from two arrays. Calls the mergedata method to do sorting
 * @param           low int
 * @param           high int
 * @param           middle int
 * @param           array int[]
 * @author          <i>Abylay Dospayev</i>
 * Date             10/14/2022
 * History log
 * </pre>
 -------------------------------------------------------------*/ 
  public static void mergedata(int[] array, int low, int middle, int high)
  {
      int[] helper;
      helper = new int[array.length];
      for(int i = low; i <= high; i++)
          helper[i] = array[i];
      int i = low;
      int j = middle + 1;
      int k = low;
      
      while(i <= middle && j <= high)
      {
          if (helper[i] <= helper[j])
          {
              array[k] = helper[i];
              i++;
          } 
          else
          {
            array[k] = helper[j];
            j++;
          }
          k++;
      }
      while(i<=middle)
      {
          array[k] = helper[i];
          k++;
          i++;
      }
  }
  
  /**------------------------------------------------------------
 * <pre>
 * Method           heapSort()
 * Description      Sorts the int array using the HeapSort algorithm
 * @author          <i>Abylay Dospayev</i>
 * Date             10/14/2022
 * @param           array int[]
 * History log
 * </pre>
 ------------------------------------------------------------- 
  */ 
  public static void heapSort(int[] array){
      if (array.length == 0) {
        return;
    }

      int length = array.length;
      
      //Moving from the first element that isn't a leaf towards the root
      for(int i = length/2-1; i>=0 ;i--){
          heapify(array, length, i);
      }
      
      for(int i = length - 1; i>=0;i--){
          int temp = array[0];
          array[0] = array[i];
          array[i] = temp;
          heapify(array,i,0);
      }
      
  }
  
  /**------------------------------------------------------------
 * <pre>
 * Method           heapify()
 * Description      Method for creating a heap data structure from a binary tree
 * @author          <i>Abylay Dospayev</i>
 * Date             10/14/2022
 * @param           array int[]
 * @param           length int
 * @param           i int
 * History log
 * </pre>
 ------------------------------------------------------------- **/
  public static void heapify(int[] array, int length, int i){
      int left = 2 * i + 1;
      int right = 2 * i + 2;
      int largest = i;
      
      if(left < length && array[left] > array[largest]){
          largest = left;
      }
      
      if (right < length && array[right] > array[largest]){
          largest = right;
      }
      if(largest!=i){
          int temp = array[i];
          array[i] = array[largest];
          array[largest] = temp;
          heapify(array, length, largest);
      }
  }
}

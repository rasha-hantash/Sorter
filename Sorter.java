/**
 * This class takes an unsorted array and sorts the values in the array from
 * smallest to largest value in an integer array.
 *
 * @author Rasha Abuhantash
 * @version 03.04.18
 */
public class Sorter {

    private static int[] counters;

    /**
     * This main method runs the sortIntArrayMethod
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[] originalArray = {1,2,6,9,0};

        int[] newArray = Sorter.sortIntArray(originalArray);

        for (Integer i : newArray) {
            System.out.print(i);
        }
        System.out.println();
    }

    /**
     * This method takes in an unsorted array and sorts the array from smallest integer value to
     * largest.
     *
     * @param unsortedArray the unsorted array that is passed into the method to be sorted
     * @return a sorted integer array
     * @throws IllegalArgumentException if there is a negative number found in the unsorted integer
     * array or if the array is null.
     */
    public static int[] sortIntArray(int[] unsortedArray) throws IllegalArgumentException {
        int max = 0;

        if(unsortedArray == null)
        {
            throw new IllegalArgumentException("Cannot sort a null array");
        }
            
        //makes the size of the counters array max number found in the  unsorted array
        for (int i = 0; i < unsortedArray.length; i++) {
            if (unsortedArray[i] > max) {

                max = unsortedArray[i];
            }

            if (unsortedArray[i] < 0) {
                throw new IllegalArgumentException("Unable to sort negative values in the array");
            }
        }

        counters = new int[++max];
        

        //if a number found in the unsortedArray is the same as the index in the counters array,
        //then the index in the counter array's value is increased by one
        for (int i = 0; i < counters.length; i++) {
            for (int j = 0; j < unsortedArray.length; j++) {
                if (i == unsortedArray[j]) {
                    counters[i] += 1;
                }

            }
        }
        System.out.println();
        for (Integer i : counters) {
            System.out.print(i);
        }

        System.out.println();
        System.out.println();
        int sortedArray[] = new int[unsortedArray.length];
        

        //sorts the unsorted array from smallest to largest value
        int indexOfSortedArray = 0;
        for (int i = 0; i < counters.length; i++) {

            int count = 0;

            while (counters[i] != count) {
                sortedArray[indexOfSortedArray] = i;
                indexOfSortedArray++;

                count++;

            }
        }

        return sortedArray;
    }

}

/*

1.The algorithm for the sortIntArray method is O(2) because when I sort through the int array
I first go through the length of the counters array and then i go through the length of the 
unsortedArray to resort the array. (although i do know that this algorithm is supposed to be O(1)


2. Had I firgured out how ot make this algorithm O(1) then yes this counter sort would be more 
efficient than the insertion sort since insertion sort is O(2).


3. Yes this algorithm is quite efficient if you want to sort integers from beginning to end or end to 
beginning 

*/

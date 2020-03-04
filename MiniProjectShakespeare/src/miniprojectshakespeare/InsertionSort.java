/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojectshakespeare;

import java.util.ArrayList;

/**
 *
 * @author strom
 */
public class InsertionSort {
    
       public ArrayList<String> sort(ArrayList unsortedArray) {

        long startTime = System.nanoTime();

        int n = unsortedArray.size();

        for (int i = 1; i < n; i++) {

            int j = i - 1;

            String indexValue = (String) unsortedArray.get(i);
            String compareValue = (String) unsortedArray.get(j);

            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (indexValue.compareTo(compareValue) < 0 && j >= 0) {
                unsortedArray.set(j + 1, unsortedArray.get(j));
                if (j > 0) {
                    j = j - 1;
                } else {
                    break;
                }
                compareValue = (String) unsortedArray.get(j);
            }
            unsortedArray.set(j, indexValue);

        }
        long endTime = System.nanoTime() - startTime;
        System.out.println("Insertion Sort : " + endTime / 1000000 + " ms" + " || " + endTime + " ns");
        return unsortedArray;
    }
    
}

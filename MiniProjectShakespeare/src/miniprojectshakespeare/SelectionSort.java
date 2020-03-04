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
public class SelectionSort {
    
       public ArrayList<String> sort(ArrayList unsortedArray) {

        long startTime = System.nanoTime();

        int n = unsortedArray.size();
        //Running through full array
        for (int i = 0; i < n - 1; i++) {
            // Finding the minimum string (we start with index i)
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                String lowestString = (String) unsortedArray.get(min_idx);
                String compareString = (String) unsortedArray.get(j);
                //Comparing the two strings to find the lowest string and setting that as the min_idx = lowest String index
                if (compareString.compareTo(lowestString) <= 0) {
                    min_idx = j;
                }
            }

            // Swap the found minimum element with the first 
            // element 
            String temp = (String) unsortedArray.get(min_idx);
            unsortedArray.set(min_idx, unsortedArray.get(i));
            unsortedArray.set(i, temp);
        }
        long endTime = System.nanoTime() - startTime;
        System.out.println("Selection Sort : " + endTime / 1000000 + " ms" + " || " + endTime + " ns");
        return unsortedArray;

    }
    
    
}

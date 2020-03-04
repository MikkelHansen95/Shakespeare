/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojectshakespeare;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;

/**
 * @author Mikkel & Mathias
 */
public class MiniProjectShakespeare {

    public static ArrayList<String> SelectionSort(ArrayList unsortedArray) {

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

    public static ArrayList<String> InsertionSort(ArrayList unsortedArray) {

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




    public static ArrayList<String> mergeSort(ArrayList unsortedArray) {
        return unsortedArray;
    }

    public static ArrayList<String> readAndCleanFile(File myfile) throws FileNotFoundException, IOException {
        File file = myfile;
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> resultSorted = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (br.ready()) {
                String data = br.readLine();
                if (data.isEmpty()) {
                    continue;
                } else {
                    String lowercaseData = data.toLowerCase();
                    String noCharacterData = lowercaseData.replaceAll("[^a-zA Z]+", "");
                    String[] words = noCharacterData.split(" ");
                    for (int i = 0; i < words.length; i++) {
                        if (words[i].isEmpty()) {
                            continue;
                        } else {
                            result.add(words[i]);
                        }

                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {

        File file = new File("/Users/sofie/Desktop/Software Development/Shakespeare/MiniProjectShakespeare/src/miniprojectshakespeare/shakespeare.txt");
        ArrayList<String> cleanedFile = readAndCleanFile(file);
        ArrayList<String> SelectionSortArray = SelectionSort(cleanedFile);
        ArrayList<String> insertionSortArray = InsertionSort(cleanedFile);

        HeapSort heap = new HeapSort();
        heap.sort(cleanedFile);

        MergeSort ms = new MergeSort();
        ms.sort(cleanedFile);

        TrieSort ts = new TrieSort();
        ts.sort(cleanedFile);

        String ses = "a";
        String ses1 = "b";
       // System.out.println(ses1.compareTo(ses));

    }
}

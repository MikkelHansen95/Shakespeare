package miniprojectshakespeare;

import java.util.ArrayList;
import java.util.Collections;

public class HeapSort {
    public void maxHeap(ArrayList<String> array, int index, int size) {
        int largest = index; // Root Node
        int left = 2 * index + 1; // Left Child node
        int right = 2 * index + 2; // Right Child node

        if (left < size && array.get(left).compareTo(array.get(largest)) > 0) {
            largest = left;
        }
        if (right < size && array.get(right).compareTo(array.get(largest)) > 0) {
            largest = right;
        }

        if (largest != index) {
            Collections.swap(array, index, largest); // Swap the indexes not the values
            maxHeap(array, largest, size);
        }

    }


    public void sort(ArrayList<String> array) {
        long startTime = System.nanoTime();
        // Arrays are automatically resized, no need to make an empty array, etc.
        int size = array.size();
        // Prerequisites for max heap sorting.

        for (int i = size / 2 - 1; i >= 0; i--) {
            maxHeap(array, i, size);
        }

        for (int i = size - 1; i >= 0; i--) {
            Collections.swap(array, i, 0);
            maxHeap(array, 0, i);
        }


        long endTime = System.nanoTime() - startTime;
        System.out.println("Heap Sort : " + endTime / 1000000 + " ms" + " || " + endTime + " ns");
        // Output: [-2, 7, 10, 16, 17, 19, 30, 50, 70, 86]
        // Time: 284549 nanoseconds

    }
}


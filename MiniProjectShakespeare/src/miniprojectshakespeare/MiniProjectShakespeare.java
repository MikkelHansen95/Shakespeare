package miniprojectshakespeare;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;

/**
 * @author Mikkel & Mathias
 */
public class MiniProjectShakespeare {

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
        String path = "/Users/sofie/Desktop/Software Development/Shakespeare/MiniProjectShakespeare/src/miniprojectshakespeare/shakes.txt";
        File file = new File(path);
        ArrayList<String> cleanedFile = readAndCleanFile(file);
            
        SelectionSort selectionsort = new SelectionSort();
       // selectionsort.sort(cleanedFile);
        
        InsertionSort insertionsort = new InsertionSort();
        insertionsort.sort(cleanedFile);
        

        HeapSort heap = new HeapSort();
        heap.sort(cleanedFile);

        MergeSort ms = new MergeSort();
        ms.sort(cleanedFile);

        TrieSort ts = new TrieSort();
        ts.sort(cleanedFile);
        System.out.println("Size of our test text file: "+ cleanedFile.size());


    }
}

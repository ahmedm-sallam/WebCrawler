/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package invertedIndex;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import static invertedIndex.Index5.printPosIndex;

/**
 *
 * @author ehab
 */
public class Test {

    public static void main(String args[]) throws IOException {
        Index5 index = new Index5();
        //|**  change it to your collection directory 
        //|**  in windows "C:\\tmp11\\rl\\collection\\"       
        String files = "tmp11\\rl\\collection\\";

        File file = new File(files);
        //|** String[] 	list()
        //|**  Returns an array of strings naming the files and directories in the directory denoted by this abstract pathname.
        String[] fileList = file.list();

        fileList = index.sort(fileList);
        index.N = fileList.length;

        for (int i = 0; i < fileList.length; i++) {
            fileList[i] = files + fileList[i];
        }
        System.out.println("-------------------------POSITIONAL INDEX-------------------------------------------------");
        Index5.buildPositional(fileList);
        printPosIndex();

        System.out.println("-------------------------BI WORD-------------------------------------------------");
        index.buildIndex(fileList);
        index.store("index");
        index.printDictionary();

        String test3 = "data  should plain greatest comif"; // data  should plain greatest comif
        System.out.println("Boo0lean Model result = \n" + index.find_24_01(test3));

        String phrase = "";

        do {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter 1 for BI Word Index or 2 for Positional Index");
            String option =in.readLine();
            if(option.equals("1")) {
                System.out.println("Enter search phrase: ");

                phrase = in.readLine();

                // Split the input string by space outside of quotes
                String[] words = phrase.split(" (?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                // Replace spaces with underscores between words in quotes
                for (int i = 0; i < words.length; i++) {
                    if (words[i].startsWith("\"") && words[i].endsWith("\"")) {
                        words[i] = words[i].substring(1, words[i].length() - 1).replace(" ", "_");
                    }
                }

                // Join the modified words back into a single string
                String output = String.join(" ", words);

                // Print the modified string
                System.out.println(output);
                // automated specific_info
/// -3- **** complete here ****
                String res = index.find_24_01(output);
                System.out.println(res);
            }
            else {
                System.out.println("Enter search phrase: ");
                phrase = in.readLine();
                Index5.searchQuery(phrase);
            }
        } while (!phrase.isEmpty());

    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package invertedIndex;

import java.util.*;
import java.io.*;
/**
 *
 * @author ehab
 */
 
public class Posting {

    public Posting next = null;
    int docId;
    int dtf = 1;
    //List<Integer> positions = new ArrayList<Integer>();
    Posting(int id, int t) {
        docId = id;
        dtf=t;
    }
    
    Posting(int id) {
        docId = id;
    }
}
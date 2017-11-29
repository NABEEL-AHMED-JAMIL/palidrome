package com.ballistic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by Nabeel on 11/27/2017.
 */
public class ReadWriteFile {

    private String filePath = "src/file/text.txt";
    private Scanner input;
    private List<String> lines;

    public ReadWriteFile() {
        this.lines = new ArrayList<String>();
    }

    public void openFile(){
        try {
            this.input = new Scanner(new File(this.filePath));
            System.out.println("File Process");
        }catch (FileNotFoundException e){
            System.out.println("File Not Found");
            this.closeFile();
            System.exit(1);
        }
    }

    public List<String> readFile(){
        try {
            while (this.input.hasNext()){ this.lines.add(this.input.nextLine()); }
        }catch (NoSuchElementException e) {
            System.out.println("Element not found Related Object");
            System.exit(1);
        }
        this.closeFile();

        return this.lines;
    }

    public void closeFile(){
        if(input != null){ input.close(); }
    }

}

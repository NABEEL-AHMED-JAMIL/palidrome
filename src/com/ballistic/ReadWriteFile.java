package com.ballistic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author  by Nabeel on 11/27/2017.
 */
/**************************************************************************
 * @class ReadWriteFile that help us to open and readFile and close file
 * @method's openFile(), readFile(), closeFile()
 * @variable filePath help the attribute for access the file
 * @variable input instance of Scanner class
 * @variable lines used the instance of list<String> tha store the file info
 *
 **************************************************************************/
public class ReadWriteFile {

    private String filePath = "src/file/text.txt";
    private Scanner input;
    private List<String> lines;

    public ReadWriteFile() {
        this.lines = new ArrayList<String>();
    }


    /****************************************************************
     * A property group for {@link @method openFile()}
     *
     * help the method for open the file if the file not thre error
     * @exception FileNotFoundException
     *
     ****************************************************************/
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


    /************************************************************
     * A property group for {@link @method readFile()}
     *
     * help the method read file using
     * @loop While
     *
     * @exception NoSuchElementException thorw if the file empty
     *
     * @return {@link @variable lines}
     *
     *
     **************************************************************/
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

    /************************************************************
     * A property group for {@link @method closeFile() }
     *
     * help the method close file using {@link @variable input }
     *
     **************************************************************/
    public void closeFile(){
        if(input != null){ input.close(); }
    }

}

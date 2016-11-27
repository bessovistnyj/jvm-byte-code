package ru.napadovskiu.sortFile;

import java.io.*;
import java.util.ArrayList;


/**
 * Created by program on 17.11.2016.
 */
public class SortBigTextFile implements SortFile {

    final private static File dirForTempFile = new File("D:\\tempforTest");

    private ArrayList <File> list  = new ArrayList<File>();

    private RandomAccessFile fileSorce;

    private RandomAccessFile fileDistance;

    private void createDirectory() throws IOException{
        if (!dirForTempFile.exists()) {
            dirForTempFile.mkdir();
        }
    }

    public void sort(File source,File distance) throws IOException{
        initFiles(source,distance);
        splitSourceFile();
        mergeToDistanceFile();

    }

    public void writeToFile(String line, RandomAccessFile raf) throws IOException {
        raf.writeBytes(String.format("%s\r\n", line));
    }

    private void initFiles(File source, File distance) {

       try{
           createDirectory();
       }
       catch (IOException exception){
           exception.printStackTrace();
       }

       try {
           this.fileSorce = new RandomAccessFile(source.getAbsolutePath(), "r");
           this.fileDistance = new RandomAccessFile(distance.getAbsolutePath(), "rw");
       }
       catch (FileNotFoundException exception){
           exception.printStackTrace();
       }

    }

    private File createTmpFile() throws IOException{
        File tmpFile = null;
        try {
            tmpFile = File.createTempFile("tmpFile",".txt",dirForTempFile);

        }
        catch (IOException exc){
            exc.printStackTrace();
        }
        return tmpFile;
    }

    private void sortTmpFile(RandomAccessFile tmp) throws IOException{
        String msg = null;
        ArrayList <String> strList  = new ArrayList<String>();

        tmp.seek(0);
        while ((msg= tmp.readLine()) !=null){
            strList.add(msg);
        }
        for (int i = strList.size()- 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (strList.get(j).length() > strList.get(j + 1).length()) {
                    String t = strList.get(j);
                    strList.set(j,strList.get(j + 1));
                    strList.set(j + 1,t);
                }
            }
            tmp.seek(0);
            for (String tmpMsg : strList){
                writeToFile(tmpMsg,tmp);
            }
        }
        tmp.close();
    }

    private void splitSourceFile() throws  IOException{
        String msg = null;
        ArrayList <RandomAccessFile>  rafList = new ArrayList<RandomAccessFile>();
        int countFile = 2;
        int count =0;
        for (int i=0; i<countFile; ++i){
            File tmpFile = createTmpFile();
            tmpFile.deleteOnExit();
            list.add(tmpFile);
            rafList.add(new RandomAccessFile(tmpFile,"rw"));
        }

        while ((msg= this.fileSorce.readLine()) != null){
            writeToFile(msg,rafList.get(count));
            if (count ==1){
                count =0;
            }
            else {
                count++;
            }

        }
        for (RandomAccessFile fileFromList : rafList){
            sortTmpFile(fileFromList);
        }

    }

    private void mergeToDistanceFile() throws IOException {

        boolean unsortedFile = true;

        String firstMsg = null;
        String secondMsg = null;
        int i=0,j =1;

        for (; j<list.size();){
            File tmpFirstFile  =  list.get(i);
            tmpFirstFile.deleteOnExit();
            File tmpSecondFile = list.get(j);
            tmpSecondFile.deleteOnExit();
            RandomAccessFile tempFileFirst  = new RandomAccessFile(list.get(i),"rw");
            RandomAccessFile tempFileSecond = new RandomAccessFile(list.get(j),"rw");
            tempFileFirst.seek(0);
            tempFileSecond.seek(0);

            while (unsortedFile){
                if (firstMsg == null){
                    firstMsg = tempFileFirst.readLine();
                }
                if (secondMsg == null){
                    secondMsg = tempFileSecond.readLine();
                }
                if (firstMsg == null && secondMsg !=null){
                    this.writeToFile(secondMsg,fileDistance);
                    secondMsg =null;
                }
                else if(firstMsg != null && secondMsg ==null){
                    this.writeToFile(firstMsg,fileDistance);
                    firstMsg = null;
                }
                if(firstMsg !=null && secondMsg !=null){
                    if (firstMsg.length() <= secondMsg.length()){
                        this.writeToFile(firstMsg,fileDistance);
                        firstMsg =null;
                    }
                    else {
                        this.writeToFile(secondMsg,fileDistance);
                        secondMsg =null;
                    }
                }
                if (firstMsg ==null && secondMsg ==null){
                    unsortedFile = false;
                }

            }
            unsortedFile = true;
            i = j+1;
            j = i+1;

            tempFileFirst.close();
            tempFileSecond.close();
            tmpFirstFile.deleteOnExit();
            tmpSecondFile.deleteOnExit();
        }

    }


}

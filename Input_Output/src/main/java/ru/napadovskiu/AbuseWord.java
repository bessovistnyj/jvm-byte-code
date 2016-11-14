package ru.napadovskiu;

import java.io.*;


/**
 * Created by program on 10.11.2016.
 */
public class AbuseWord {

    public void dropAbuses(InputStream in, OutputStream out, String[] abuse) throws IOException {

        int ch;

        int counter = 0;

        InputStreamReader inputStreamReader     = new InputStreamReader(in);
        OutputStreamWriter outputStreamWriter   = new OutputStreamWriter(out);

        StringBuilder stringBuilder = new StringBuilder();

        while((ch = inputStreamReader.read()) != -1){
            stringBuilder.append((char)ch);
            for (String abuseString : abuse){
                if(stringBuilder.toString().equalsIgnoreCase(abuseString)){
                    stringBuilder.delete(0, stringBuilder.length());
                }
                else if(abuseString.toUpperCase().startsWith(stringBuilder.toString().toUpperCase())){
                    counter++;
                }
            }
            if (counter == 0) {
                outputStreamWriter.write(stringBuilder.toString());
                stringBuilder.delete(0, stringBuilder.length());
            }
            counter = 0;
            outputStreamWriter.flush();
        }
        inputStreamReader.close();
        outputStreamWriter.close();
    }
}

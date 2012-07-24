/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Danny
 */
public class IO {
    private String datei;
    private String[] zeilen;

    IO(String name){
        datei=name;
//        try {
//              //  read();
//        } catch (IOException ex) {
//                System.out.println("Problem beim erstellen, Falsche Datei?");
//        }
    }

    IO(File file){
         datei=file.getAbsolutePath();
        try {
                read();
        } catch (IOException ex) {
                System.out.println("Problem beim erstellen, Falsche Datei?");
        }
    }

    public String[] read() throws FileNotFoundException, IOException {
        int i = 0;
        BufferedReader reader = new BufferedReader(new FileReader(datei));
        while(reader.ready()){
            reader.readLine();
            i++;
        }
        reader.close();
        reader = new BufferedReader(new FileReader(datei));
        zeilen = new String[i];
        int j=0;
        while(reader.ready()){
            zeilen[j]= reader.readLine();
            j++;
        }
        reader.close();
        return zeilen;
    }

    public void write() throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(datei));
        for(String x:zeilen){
            writer.write(x);
            writer.newLine();
        }
        writer.close();
    }
    
    public void write(String[] output) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(datei));
        for(String x:output){
            writer.write(x);
            writer.newLine();
        }
        writer.close();
    }

    int availableLines(){
        return zeilen.length;
    }
    String[] getLines(){
        return zeilen;
    }
    String getLine(int i){
        return zeilen[i-1];
    }
    void setLine(int i, String s){
        zeilen[i-1]=s;
    }
    void replaceAll(String regexp, String ersatz){
        for(int i= 0; i<zeilen.length; i++){
            zeilen[i]=zeilen[i].replaceAll(regexp, ersatz);
        }
    }
    void close() throws IOException{
        write();
    }
}

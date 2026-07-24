import java.io.*;
import java.util.*;

class Mainq{
    public static void main(String[] args) {
        try{
            FileWriter w = new FileWriter("mainw.txt");
            FileReader r = new FileReader("mainr.txt");
            int ch;
            while((ch=r.read())!=-1){
                w.write((char)ch);
            }
             r.close();
            w.close();

            System.out.println("File copied successfully.");
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
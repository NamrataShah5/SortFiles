import java.io.*;
import java.util.Scanner;

public class Lex {
        public static void main(String[]args) throws IOException {
                Scanner in = null;
                PrintWriter out = null;
                String line = null;
                String[]token = null;
                int i, n, lineNumber=0;
                if(args.length<2) {
                        System.err.println("Usage: FileIO infile outfile");
                        System.exit(1);
                }

                in = new Scanner(new File(args[0]));
                out=new PrintWriter(new FileWriter(args[1]));   //count line numbers
                while(in.hasNextLine()) {
                        lineNumber++;
                        line = in.nextLine(); //add extra space so split works right
                }
                in.close();
                in= new Scanner(new File(args[0]));
                int p =0;
                String[] st = new String[lineNumber];
                while(in.hasNextLine()) {       // copy each line into array
                        st[p]=in.nextLine();
                        p++;
                }
                List L = new List();
                L.append(0);
                for(int j = 1; j<st.length;j++) {     // performs insertion sort style method to add indices to List
                        L.moveFront();
                        while(L.index()>=0 && (st[j].compareTo(st[L.get()])>0)) {
                                L.moveNext();
                        }
                        if(L.index()>=0) { L.insertBefore(j); }
                        else { L.append(j); }
                }
                L.moveFront();
                while(L.index()>=0 && L.index()<=L.length()-1) {   // writes all elements to outfile 
                        out.println(st[L.get()]);
                        L.moveNext();
                }
                in.close();
                out.close();
        }
}

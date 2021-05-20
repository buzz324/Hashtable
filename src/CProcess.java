import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class CProcess {


    public static void main(String[] args) throws IOException {


//args[2] == index of keystim


            String file ="src/AU.csv";
            BufferedReader br = new BufferedReader(new FileReader(file));

            String s=br.readLine();
            String delims = ",\n";

            CHashtable hs = new CHashtable(1000);

            while(s!=null){

                int i = 0;
                String [] array = new String[3];
                StringTokenizer st = new StringTokenizer(s,delims);

                while(st.hasMoreTokens()){
                    String t = st.nextToken();
                    array[i]=t;
                   // System.out.print(" "+t);
                    i++;

                }
                CData cd = new CData(array[0],array[1],array[2],0);//k is Integer.parseInt(args[2])

                hs.put(cd.getKey(),cd);


                s=br.readLine();
                //System.out.println();
            }
           /* for (int j = 0; j<hs.arry().length;j++){
                System.out.println(hs.arry()[j].toString());
            }*/

    }
}

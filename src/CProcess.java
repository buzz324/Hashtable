import java.io.FileReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;


public class CProcess {


    public static void main(String[] args) {

        CKey ck= new CKey("hello");


//args[2] == index of keystim

        try{

            CHashtable hs = new CHashtable();
            String file ="src/AU.csv";
            BufferedReader br = new BufferedReader(new FileReader(file));

            String s=br.readLine();
            String delims = ",\n";
            while(s!=null){
                StringTokenizer st = new StringTokenizer(s,delims);
                while(st.hasMoreTokens()){
                    String t = st.nextToken();
                    System.out.print(" "+t);

                }
                s=br.readLine();
                //System.out.println();
            }
        }catch(Exception e){
            System.err.println("Trouble!");
        }
    }
}

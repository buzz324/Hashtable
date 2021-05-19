import java.io.FileReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;


public class CProcess {

    public static void main(String[] args) {

        try{

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
                System.out.println();
            }
        }catch(Exception e){
            System.err.println("Trouble!");
        }
    }


}

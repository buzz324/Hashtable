import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class CKey {

    private String keystring;

    //Receive a new keystring
    public CKey(String key){
        keystring= key;
    }

    //save it to read, so just call when needed
    public String getKeyString(){
        return keystring;
    }


    //Generate hashCode based on input string
    public int hashCode(){
        int hashCode = 0;
    for (int i = 0; i<getKeyString().length();i++){
         hashCode += getKeyString().charAt(i);
    }
    hashCode=hashCode/getKeyString().length();
      return hashCode;
}

//NEED IMPROVEMENT
public boolean equals(Object obj) {

        //check if the  location is same (default condition)
    if (this == obj) {
        System.out.println("SAME MEMORY LOCATION");
        return true;
    }

    //Cast to Ckey for the super class obj
    CKey other = (CKey) obj;

    //System.out.println(this.keystring+" "+other.keystring);
    //Checking their actucal cKeystyring

    //see if the new Ckey hascode is the same as hashcode in hashtable
    //true: found same hashcode-->synonym
    return this.hashCode() == (other.hashCode());
}

    public static void main(String[] args) throws IOException {


        String file ="src/AU.csv";
        BufferedReader br = new BufferedReader(new FileReader(file));

        String s=br.readLine();
        String delims = ",\n";

        while(s!=null){

            int i = 0;
            String [] array = new String[3];
            StringTokenizer st = new StringTokenizer(s,delims);

            while(st.hasMoreTokens()){
                String t = st.nextToken();
                array[i]=t;
                i++;

            }
            CData cd = new CData(array[0],array[1],array[2],0);//k is Integer.parseInt(args[2])

            s=br.readLine();
            CKey ck = new CKey(array[0]);
            System.out.println(ck.hashCode());
        }
        }

         /*   public static void main(String[] args) {
        String st = new String("mayra.bena@gmail.com");
        CKey ck = new CKey(st);
        System.out.println(ck.hashCode());

    }*/


}





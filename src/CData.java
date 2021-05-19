import java.io.FileReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;


public class CData {
    private String name, phone, email;

    int i= 0;//for default selection

    //Key string selected
    String indexChar=indexSelection(i); // this 'i' INDEX SHOULD BE REPLACE WITH args[2] LATER FOR THE TEST@@

    private CKey key = new CKey(indexChar);

    String[] data = new String[3];

    //Constructor
    public  CData(String _name, String _phone, String _email, int k){

        name = _name;
        phone= _phone;
        email= _email;

    }

    //Decide which data to use a keystring
    public String indexSelection(int index){

        if(index==1){
            indexChar=phone;
        }else if(index==0){
            indexChar=email;
        }else {
            indexChar=name;
        }
        return indexChar.toString();
    }

    public CKey getKey(){
        return key;
    }


    public String ToString(){
        String threeElements = name +" "+ phone +" "+ email+" ";

        return threeElements;
    }


    public static void main(String[] args) {

  /*      String s = new String("Didio,03-8174-9123,rebbecca.didio@didio.com.au");
        String delims = ",\n";
        StringTokenizer st = new StringTokenizer(s,delims);
      String [] data;
        while(st.hasMoreTokens()){
            String t = st.nextToken();

            System.out.print(" "+t);

        }*/

    }
}

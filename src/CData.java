import java.io.FileReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;


public class CData {
    private  String name;
    private String phone;
    private String email;

    String br = "Didio,03-8174-9123,rebbecca.didio@didio.com.au";



    private CKey key;

    //Constructor
    public  CData(String _name, String _phone, String _email, int k){

        name = _name;
        phone= _phone;
        email= _email;
        if (k==1){
            key=new CKey(phone);
        }else if(k==2){
            key= new CKey(email);
        }else {
            key=new CKey(name);
        }
    }


    public CKey getKey(){
        return key;
    }


    public String ToString(){
        String threeElements = name +" "+ phone +" "+ email+" ";

        return threeElements;
    }





    public static void main(String [] args){
        try{

            String br = "Didio,03-8174-9123,rebbecca.didio@didio.com.au";
            String delims = ",\n";
                StringTokenizer st = new StringTokenizer(br,delims);
                while(st.hasMoreTokens()){
                    String t = st.nextToken();
                    System.out.print(" "+t);

                }
                //System.out.println();
        }catch(Exception e){
            System.err.println("Trouble!");
        }
    }


}

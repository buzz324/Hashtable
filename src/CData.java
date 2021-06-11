//Name: Buzz Kho
//ID: 117421

public class CData {

    private  String name;
    private String phone;
    private String email;

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


}

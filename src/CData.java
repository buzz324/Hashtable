public class CData {
    private String name, phone, email;

    private CKey key;
    private int selection;
    public  CData(String _name, String _phone, String _email, int k){

        name = _name;
        phone= _phone;
        email= _email;
        this.selection= k;
    }
    public CKey getKey(){
        return key;
    }
}

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
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    CKey other = (CKey) obj;
    if (keystring != other.keystring)
        return false;
    return true;
}

   /* public static void main(String[] args) {
        String st = new String("Didio");
        CKey ck = new CKey(st);
        System.out.println(ck.hashCode());

    }*/

}

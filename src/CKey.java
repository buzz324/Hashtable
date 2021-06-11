//Name: Buzz Kho
//ID: 117421

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
        int hashCode=0 ;
    for (int i = 0; i<getKeyString().length();i++){
         hashCode += getKeyString().charAt(i);
    }
    hashCode=hashCode/getKeyString().length();
      return hashCode;


/* Mid-Square method
        double newDigit;
        int start = getKeyString().length()/4;
        int end = getKeyString().length()/4*3;

      for (int i = start;i<=end;i++){

          newDigit=Math.pow(10,start);
          newDigit=newDigit*start;
          hashCode=hashCode+(int)newDigit;
      }

      hashCode=hashCode*hashCode;
      return hashCode;*/
}

//NEED IMPROVEMENT
public boolean equals(Object obj) {

        //check if the  location is same (default condition)
    if (this == obj) {
        return true;
    }

    //Cast to Ckey for the super class obj
    CKey other = (CKey) obj;

    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;


    //see if the new Ckey hascode is the same as hashcode in hashtable
    return this.hashCode() == (other.hashCode());
}

}





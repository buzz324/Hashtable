import java.util.StringTokenizer;

public class CHashtable {

    private CData[] table;//array of CData


    //CData cd = new CData()

    private int capacity;
    private int numberOfCData;
    private int probe;

    public CHashtable(int cap) {
        capacity = cap;
        table = new CData[capacity];
    }

    //getter for the array
    public CData[] arry(){
        return table;
    }


    //put data in the following key
    //NEED ROBUSTNESS FOR FULL ARRAY
    public void put(CKey key, CData data) {

        int uniqueCode;

        //Hashtable is empty
        if(get(key)==null){
            //Empty so generate one
            uniqueCode = key.hashCode();
            System.out.println(uniqueCode);
            table[uniqueCode] = data;

        }
        //new 'key' hash code is compared to the keystring inside the hashtable
        else if(key.equals(get(key).getKey())) {

            //Collision resolution for synonym implementation@@@@@@@@@
            System.out.println("Synynom");
        }

    }

    //find a data in the hashtable or empty space and return that value
    public CData get(CKey key){

        int hashcode= key.hashCode();
        if (table[hashcode]==null){
            return null;
        }else {
            return table[hashcode];
        }
 }

   /* public static void main(String[] args) {


        CHashtable hs = new CHashtable(100);


            String br = "Didio,03-8174-9123,rebbecca.didio@didio.com.au";
            String delims = ",\n";
            StringTokenizer st = new StringTokenizer(br, delims);
            String[] array = new String[3];
            int i = 0;

            while (st.hasMoreTokens()) {
                String t = st.nextToken();

                array[i]=t;
                System.out.print(" " + t);

                i++;
            }
            CData cd = new CData(array[0],array[1],array[2],0);//k is Integer.parseInt(args[2])
            hs.put(cd.getKey(),cd);
            for (int index=0; i<hs.arry().length;index++){
                System.out.println(hs.arry()[index]);

            }


    }*/




}
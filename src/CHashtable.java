public class CHashtable {

    private CData[] table;//array of CData


    //CData cd = new CData()

    private int capacity;
    private int numberOfCData;
    private int probes;

    public CHashtable(int cap) {
        capacity = cap;
        table = new CData[capacity];
    }

    //getter for the array
    public CData[] array() {
        return table;
    }



    //put data in the following key
    //NEED ROBUSTNESS FOR REDUNDANT CODING!!!!!!!!!!!!!
    public void put(CKey key, CData data) {

        getProbes();
        if(capacity==numberOfCData)return;;

        int newKeyHashCode = key.hashCode();

        //Make sure the hashcode to stay within the index of the capacity array
        if (newKeyHashCode>(capacity-1)){
            newKeyHashCode=newKeyHashCode%(capacity);
        }

        if(table[newKeyHashCode]==null){

            table[newKeyHashCode]=data;
            numberOfCData++;


        }else {


            //Found a synonym
            if (key.equals(table[newKeyHashCode].getKey())){
                newKeyHashCode++;//increment to see next space availability

            // Look for null space to add
            while (table[newKeyHashCode]!=null){

                newKeyHashCode++;
                getProbes();//Increase probes by each time found a synonym

                //check the hashcode hasn't exceed the max index and start prob from the start
                if(newKeyHashCode>(capacity-1)){
                    newKeyHashCode=0;
                }

            }
                table[newKeyHashCode]=data; //Found a null spot to add
                numberOfCData++;


            }else {
                while (table[newKeyHashCode]!=null){

                    newKeyHashCode++;
                    getProbes();//Increase probes by each time found a synonym


                    //check the hashcode hasn't exceed the max index and start prob from the start
                    if(newKeyHashCode>(capacity-1)){
                        newKeyHashCode=0;
                    }
                }
            }


            table[newKeyHashCode]=data; //Found a null spot to add
            numberOfCData++;


        }
    }





    //find a data in the hashtable or empty space and return that value
    public CData get(CKey ck) {

        int hashcode = ck.hashCode();
        getProbes();//Increase probes by one search of the hashtable

        if (table[hashcode] == null) {
            return null;
        } else {
            return table[hashcode];
        }
    }

    //Tells how many times memory has been looked up
    public int getProbes() {
        probes++;
        return probes;
    }

    public double getLoad(){
        double loadFactor;
        loadFactor=numberOfCData/capacity;
        return loadFactor;

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
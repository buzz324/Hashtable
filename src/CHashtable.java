//Name: Buzz Kho
//ID: 117421


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
    public CData[] array() {
        return table;
    }


    //put data in the following key
    //NEED ROBUSTNESS FOR FULL ARRAY
    public void put(CKey key, CData data) {

        int uniqueCode;
        uniqueCode = key.hashCode();

        //Table is full
      if(capacity==numberOfCData-1)return;

      //Make sure the hashcode to stay withing the index of table size
      if (uniqueCode>(capacity-1)){
          uniqueCode=uniqueCode%capacity;
      }

        //Synonym
        if (get(key) != null) {
            uniqueCode = get(key).getKey().hashCode();

            //Make sure the hashcode to stay withing the index of table size

            if (uniqueCode>(capacity-1)){
                uniqueCode=uniqueCode%capacity;
            }
            //Linear probing
            while(table[uniqueCode]!=null) {

                if (uniqueCode == capacity - 1) {
                    uniqueCode = 0;
                }
                getProbe();
                uniqueCode++;

            }
            table[uniqueCode] = data;
            numberOfCData++;

        }

        //null value case
        else {

            getProbe();

            //Empty space so generate one
            table[uniqueCode] = data;
            numberOfCData++;
        }

    }

    //find a data in the hashtable or empty space and return that value
    public CData get(CKey key) {

        //Make a hashcode based on the key passed
        int hashcode = key.hashCode();

        //Make sure the hashcode to stay withing the index of table size
        if (hashcode>(capacity-1)){
            hashcode=hashcode%capacity;
        }
                //Look for an empty spot, linear probing
            while(table[hashcode]!=null){

                //Found a CData in the table
                if (key.equals(table[hashcode].getKey()))return table[hashcode];

                if (hashcode == capacity - 1) {
                    hashcode = 0;
                }

                //Increment to see if we have matched Cdata or null
                hashcode++;

            }
            //Whether array element is empty or no CData found in the table
            return null;

        }


    public int getProbe() {
        probe++;
        return probe;
    }

    public double getLoad(){
        double loadFactor;
        loadFactor=numberOfCData/(double)capacity;
        return loadFactor;
    }

    //Expected performance
    public double expectedPerformance (){
      return (1+getLoad()/2);
    }


    public int actualPerformance(){
        return getProbe()/capacity;
    }
}
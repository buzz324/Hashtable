public class tester {



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
        public CData[] arry() {
            return table;
        }


        //put data in the following key
        //NEED ROBUSTNESS FOR FULL ARRAY
        public void put(CKey key, CData data) {

            //The capacity is already full
            if(numberOfCData ==capacity)return;

            int uniqueCode= key.hashCode();

            //Make sure the hashcode to stay within the index of the capacity array
            if (uniqueCode>(capacity-1)){
                uniqueCode=uniqueCode%(capacity);
            }

            //Hashtable is empty
            if (get(key) == null) {
                //Empty so generate one
                table[uniqueCode] = data;
                numberOfCData++;

            }
            //new 'key' hash code is compared to the keystring inside the hashtable
            else if (key.equals(get(key).getKey())) {

                //There is more than one space to linear probing
                if(numberOfCData<capacity-1){

                    //Linear probing for collision resolution
                    while(table[uniqueCode]!=null){

                        uniqueCode++;
                        //check the hashcode hasn't exceed the max index and start prob from the start
                        if(uniqueCode>(capacity-1)){
                            uniqueCode=0;
                        }
                    }

                    table[uniqueCode]=data; //Found a null spot to add
                    numberOfCData++;
                }
            }

            //System.out.println(numberOfCData);
        }

        //find a data in the hashtable or empty space and return that value
        public CData get(CKey ck) {

            int hashcode = ck.hashCode();
            if (table[hashcode] == null) {
                return null;
            } else {
                return table[hashcode];
            }
        }

        //Tells how many data is stored in the hashtable
        public int getProbes() {
            for (int i = 0;i<table.length;i++){
                if(table[i]!=null){
                    probes++;
                }
            }
            return probes;
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
}

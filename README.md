# Hashtable


**Description**:
a key class called CKey,
a data class called CData,
a hashtable class called CHashtable that can store CData objects using open-addressing (i.e. a finite array of CData objects).

**CKey**:

-  has a private String member variable called keystring  -
-  has a contructor that accepts a String argument and stores a copy in keystring
-  has a public method called getKeystring() that returns a reference to keystring
-  overwrites the default hashCode() method to create and return a hashcode based on the value of the string in keystring
-  overwrites the default equals method to include equality based on the value held within the keystring

**CData**:
-  has three private String member variables: name, phone and email
-  has a private CKey member variable called key
-  its constructor takes four arguments: three String parameters, one for each data member (in the above order), plus an int whose value will select which of these strings to use as the key
the constructor creates and saves (in the variable key) a new CKey using either the name, phone or email string, based on the value of the selection parameter (0 name, 1 phone, 2 email) using 0 by default if the argument value is not one of the three allowed
has a public method called getKey() that returns a reference to the private CKey object
overwrites the default toString() method to return a String that is the concatenation of the three values in the String member variables, separated with spaces

**CHashtable**:
-  has a private member variable called table that is an array of CData references (this is your hash table)
-  has three private member ints: one that stores the hashtable capacity (how many CData it can store), another that keeps track of how many CData have been put in the table, and one to count how many probes into the table have occurred for all puts and gets of CData
-  its constructor takes an int parameter whose value is the size of hashtable to create; then it creates the array
-  define a public method called put(CKey, CData) that adds the CData into your table at a location determined by the hashCode of CKey, possibly after collision resolution
collision resolution is done with linear probing

Public method called get(CKey) that finds and returns a reference to the CData stored in the table with that key, or null if the item is not found
put() should do nothing if it would completely fill the table at its current capacity, so there will always be at least one null element to stop a get() probe that should fail 
define a public method called getProbes() that returns the value of the private member variable that has been counting all probes since the table was created
define a public method called getLoad() that returns the load factor as a double (i.e. double precision floating point number)

Effectively, CHashtable should be able to honour the following interface:
```
public interface CHashInterface {

    public void put(CKey k, CData d);

    public CData get(CKey k);

    public int getProbes();

    public double getLoad();
}   
```


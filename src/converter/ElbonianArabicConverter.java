package converter;

import converter.exceptions.MalformedNumberException;
import converter.exceptions.ValueOutOfBoundsException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;

/**
 * This class implements a converter that takes a string that represents a number in either the
 * Elbonian or Arabic numeral form. This class has methods that will return a value in the chosen form.
 *
 * @version 3/18/17
 */
public class ElbonianArabicConverter {

    // A string that holds the number (Elbonian or Arabic) you would like to convert
    private final String number;
    HashMap<String, Integer> hash_map = new HashMap();
    HashMap<String, Integer> count = new HashMap<>();  //a string and a number of appearance

    /**
     * Constructor for the ElbonianArabic class that takes a string. The string should contain a valid
     * Elbonian or Arabic numeral. The String can have leading or trailing spaces. But there should be no
     * spaces within the actual number (ie. "9 9" is not ok, but " 99 " is ok). If the String is an Arabic
     * number it should be checked to make sure it is within the Elbonian number systems bounds. If the
     * number is Elbonian, it must be a valid Elbonian representation of a number.
     *
     * @param number A string that represents either a Elbonian or Arabic number.
     * @throws MalformedNumberException Thrown if the value is an Elbonian number that does not conform
     * to the rules of the Elbonian number system. Leading and trailing spaces should not throw an error.
     * @throws ValueOutOfBoundsException Thrown if the value is an Arabic number that cannot be represented
     * in the Elbonian number system.
     */
    public ElbonianArabicConverter(String number) throws MalformedNumberException, ValueOutOfBoundsException {

        hash_map.put("M", 1000);
        hash_map.put("C", 100);
        hash_map.put("D", 300);
        hash_map.put("E", 600);
        hash_map.put("X", 10);
        hash_map.put("Y", 30);
        hash_map.put("Z", 60);
        hash_map.put("I", 1);
        hash_map.put("J", 3);
        hash_map.put("K", 6);

        // TODO check to see if the number is valid, then set it equal to the string
        //check if arabic or elbonian
        int arabic = 0;
        String elbonian = null;
        String[] arr;

        count.put("M",0);
        count.put("E",0);
        count.put("D",0);
        count.put("C",0);
        count.put("Z",0);
        count.put("Y",0);
        count.put("X",0);
        count.put("K",0);
        count.put("J",0);
        count.put("I",0);   //in order



        try {
            arabic = parseInt(number);
        }
        catch(Exception e)
        {
            elbonian = number;
        }

        if (elbonian == null)   //the number is arabic
        {
            if (arabic <1 || arabic>2999)
            {
                throw new ValueOutOfBoundsException(" value " + arabic + " is out of bound");
            }
        }
        else {  //the number is letter or a mix of number and letter
            //check is Uppercase
            if (!(elbonian.equals(elbonian.toUpperCase())))
                throw new MalformedNumberException("value " + elbonian + " is malformed");

            //check is contain  number
            arr = elbonian.split("");
            boolean numeric = false;
            int counter;
            int max = 0;
            for (int i = 0; i < arr.length; i++)
            {
                numeric = false;
                try {
                     int a = parseInt(arr[i]);
                     numeric = true;
                }
                catch(Exception e)
                {
                }
                if (numeric == true)
                    throw new MalformedNumberException("value " + elbonian + " is malformed");

                //check if contain letter other than M,C,D,E,X,Y,Z,I,J,K
                if (arr[i].equals("M")||arr[i].equals("C")||arr[i].equals("X")||arr[i].equals("I"))
                {
                    counter = count.get(arr[i]);
                    counter+=1;
                    count.replace(arr[i], counter);
                    if (counter >2) throw new MalformedNumberException("value " + elbonian + " is malformed");

                }
                else if (arr[i].equals("D")||arr[i].equals("E")||arr[i].equals("Y")||arr[i].equals("Z")|| arr[i].equals("J")||arr[i].equals("K"))
                {
                    counter = count.get(arr[i]);
                    counter+=1;
                    count.replace(arr[i], counter);
                    if (counter >1) throw new MalformedNumberException("value " + elbonian + " is malformed");
                }
                else
                {
                    throw new MalformedNumberException("value " + elbonian + " is malformed");
                }
                //check if follow the rule
                //check if out of order

                if (i == 0)
                {
                    max = hash_map.get(arr[i]);
                } else if (hash_map.get(arr[i]) > max)
                    {
                        throw new MalformedNumberException("value " + elbonian + " is malformed");
                } else {
                    max = hash_map.get(arr[i]);
                }

            }

            if(elbonian.contains("D") && elbonian.contains("E") && elbonian.contains("C")) throw new MalformedNumberException("value " + elbonian + " is malformed");

            if(elbonian.contains("Y") && elbonian.contains("Z") && elbonian.contains("X")) throw new MalformedNumberException("value " + elbonian + " is malformed");

            if(elbonian.contains("J") && elbonian.contains("I") && elbonian.contains("K")) throw new MalformedNumberException("value " + elbonian + " is malformed");

            //check if contain letter other than M,C,D,E,X,Y,Z,I,J,K
            //check if follow the rule
            //check if out of order

        }
        //check for bound (should be smaller than 3000 (max is 2999))max of arabic
        //base on rule ()
        this.number = number;
    }

    /**
     * Converts the number to an Arabic numeral or returns the current value as an int if it is already
     * in the Arabic form.
     *
     * @return An arabic value
     */
    public int toArabic() {
        // TODO Fill in the method's body
        //break it down to array by using split
        //for loop
        //hash_map.get(arr[i])

        String[] arr = number.split("");
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + hash_map.get(arr[i]);
        }
        return sum;
    }

    /**
     * Converts the number to an Elbonian numeral or returns the current value if it is already in the Elbonian form.
     *
     * @return An Elbonian value
     */
    public String toElbonian() {
        // TODO Fill in the method's body
        //we know it is a number in a right range

        //go from biggest to smallest
        int[] elbonianArr = new int[10];
        int remain, m, c, d,e ,x ,y ,z ,i ,j ,k;
        int num = parseInt(number);

        m = (num/1000);   //0, 1 or 2 //m
        remain = num - 1000*m;
        count.replace("M", m);
        e = remain/600;  //either 1 or 0
        remain = remain - e*600;
        count.replace("E", e);
        d = remain/300;//either 1 or 0
        remain = remain - d*300;
        count.replace("D", d);
        c = (remain/100);//either 0, or 2  (will be 0 if d and e == 1)
        remain = remain - c*100;
        count.replace("C", c);
        z = remain/60;
        remain = remain - z*60;
        count.replace("Z", z);
        y = remain/30;
        remain = remain - y*30;
        count.replace("Y", y);
        x = (remain/10);
        remain = remain - x*10;
        count.replace("X", x);
        k = remain/6;
        remain = remain - k*6;
        count.replace("K", k);
        j = remain/3;
        remain = remain - j*3;
        count.replace("J", j);
        i = remain;
        count.replace("I", i);

        String str ="";
        String[] order = {"M", "E", "D", "C", "Z", "Y", "X", "K", "J", "I"};
        for (String s : order) {
            for (int cnt =0; cnt < count.get(s); cnt++)
            {
                str += s;
            }
        }

        return str;

    }

}

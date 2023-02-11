package lesson2.DecToBin;

public class BinToDec {
    public static void main (String args[]){
        String numberBin = "1111111";
        char[] symbol = numberBin.toCharArray();
        int numberDec = 0;
        int mult = 1;
        for (int i = numberBin.length()-1; i>=0; i--){
            if (symbol[i]=='1'){
                numberDec += mult;
            }
            mult *= 2;
        }
        System.out.println(numberDec);
    }

}

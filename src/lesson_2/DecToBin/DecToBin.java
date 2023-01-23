package lesson_2.DecToBin;

public class DecToBin {
    public static void  main (String args[]){
        int numberDec = 127;
        int i = 1;
        int numberBin[] = new int[100];
        while (numberDec != 0){
            numberBin[i++] = numberDec%2;
            numberDec /= 2;
        }
        for (int j=i-1; j>0; j--){
            System.out.print(numberBin[j]);
        }
    }
}

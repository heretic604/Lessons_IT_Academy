package lesson2.HomeWork_2;

public class runner {
    static String glStr;
    static byte glByte;
    static short glShort;
    static int glInt;
    static long glLong;
    static float glFloat;
    static double glDouble;
    static char glChar;
    static boolean glBoolean;
    static Byte wrapperGlByte;
    static Short wrapperGlShort;
    static Integer wrapperGlInt;
    static Long wrapperGlLong;
    static Float wrapperGlFloat;
    static Double wrapperGlDouble;
    static Character wrapperGlChar;
    static final Boolean WRAPPER_GL_BOOL = true;

    public static void main(String args[]) {
        byte locByte = (byte) Math.acos(45);
        short locShort = (short) Math.min(-2, 2);
        int locInt = (int) Math.divideExact(1, 2);
        long locLong = (long) Math.max(4, 8);
        float locFloat = 1.5f;
        double locDouble = 10.55;
        char locChar = 'q';
        boolean locBool = true;
        var locVar = 3;
        String locStr = String.valueOf(locInt);
        Byte wrapperLocByte = 127;
        car car = new car();
        Short wrapperLocShort = car.getSh();
        Integer wrapperLocInt = 200;
        Long wrapperLocLong = 2000L;
        Float wrapperLocFl = 2.6f;
        Double wrapperLocDouble = 20.66;
        Character wrapperLocChar = 'h';
        Boolean wrapperLocBool = false;
        glStr = String.valueOf(locByte);
        glByte = (byte) locShort;
        wrapperGlByte = (byte) locInt;
        glShort = locByte;
        wrapperGlShort = (short) locInt;
        glInt = locChar;
        wrapperGlInt = (int) locLong;
        glLong = locInt;
        wrapperGlLong = (long) locFloat;
        glFloat = (float) locDouble;
        wrapperGlFloat = (float) locInt;
        glDouble = locFloat;
        wrapperGlDouble = (double) locInt;
        glChar = (char) locByte;
        wrapperGlChar = (char) locVar;
        glBoolean = locBool;
        car.setName("mustang");
        car.setNumber((byte) 1);
        car.setYear((short) 1950);
        car.setSerial((int) 0234_6364);
        car.setPrice((long) 1_000_000);
        car.setIsDomestic(false);
        car.setClassAuto('S');
        car.setCapacity((float) 6.6);
        car.setMileage((double) 25034.746);
        car.setB((byte) locShort);
        car.setSh((short) locByte);
        car.setI(5);
        car.setL((long) wrapperLocInt);
        car.setF((float) locDouble);
        car.setD(8.99);
        car.setCh('E');
        car.setBool(true);

        System.out.println("Your choice is: " + car.getName() + "; # " + car.getNumber() + "; Year: " + car.getYear() +
                "; Serial number: " + car.getSerial() + "; Price: " + car.getPrice() + "; Domestic: " +
                car.getIsDomestic() + "; Class: " + car.getClassAuto() + "; Engine Capacity: " + car.getCapacity() +
                "; Mileage: " + car.getMileage());
        System.out.println("Other variables from class \"car\" (wrappers): " + car.getB() + "; " + car.getSh() + "; " +
                car.getI() + "; " + car.getL() + "; " + car.getF() + "; " + car.getD() + "; " + car.getCh() + "; " +
                car.getCh() + "; " + car.getBool() + ";");
        System.out.println("Global variables from class \"runner\": " + glStr + "; " + glByte + "; " + glShort + "; " +
                glInt + "; " + glLong + "; " + glFloat + "; " + glDouble + "; " + glChar + "; " + glBoolean + ".");
        System.out.println("Global wrappers from class \"runner\": " + wrapperGlByte + "; " + wrapperGlShort + "; " +
                wrapperGlInt + "; " + wrapperGlLong + "; " + wrapperGlFloat + "; " + wrapperGlDouble + "; " +
                wrapperGlChar + "; " + WRAPPER_GL_BOOL + ".");
        System.out.println("Local variables from class \"runner\": " + locStr + "; " + locByte + "; " + locShort + "; "
                + locInt + "; " + locLong + "; " + locFloat + "; " + locDouble + "; " + locChar + "; " + locBool + ".");
        System.out.println("Local wrappers from this class \"runner\": " + wrapperLocByte + "; " + wrapperLocShort +
                "; " + wrapperLocInt + "; " + wrapperLocLong + "; " + wrapperLocFl + "; " + wrapperLocDouble + "; " +
                wrapperLocChar + "; " + wrapperLocBool + ".");
    }
}

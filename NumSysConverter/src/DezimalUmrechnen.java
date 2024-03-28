public class DezimalUmrechnen {

    // Methode zur Umrechnung von Dezimal zu Binär
    public static String decimalToBinary(int decimal) {
        StringBuilder binary = new StringBuilder();
        if (decimal == 0) {
            return "0";
        }
        while (decimal > 0) {
            binary.insert(0, decimal % 2);
            decimal /= 2;
        }
        return binary.toString();
    }

    // Methode zur Umrechnung von Dezimal zu Hexadezimal
    public static String decimalToHex(int decimal) {
        StringBuilder hex = new StringBuilder();
        if (decimal == 0) {
            return "0";
        }
        while (decimal > 0) {
            int remainder = decimal % 16;
            if (remainder < 10) {
                hex.insert(0, (char) ('0' + remainder));
            } else {
                hex.insert(0, (char) ('A' + remainder - 10));
            }
            decimal /= 16;
        }
        return hex.toString();
    }


}

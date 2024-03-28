public class BinearUmrechenen {

    // Methode zur Umrechnung von Binär zu Dezimal
    public static int binaryToDecimal(String binary) {
        int decimal = 0;
        int power = 0;
        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                decimal += Math.pow(2, power);
            }
            power++;
        }
        return decimal;
    }

    // Methode zur Umrechnung von Binär zu Hexadezimal
    public static String binaryToHex(String binary) {
        int decimal = binaryToDecimal(binary);
        return DezimalUmrechnen.decimalToHex(decimal);
    }

    // Methode zur Umrechnung von Hexadezimal zu Binär
    public static String hexToBinary(String hex) {
        int decimal = HexaUmrechnen.hexToDecimal(hex);
        return decimalToBinary(decimal);
    }

    // Hilfsmethode zur Umrechnung von Dezimal zu Binär
    private static String decimalToBinary(int decimal) {
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
}




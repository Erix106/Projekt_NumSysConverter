public class HexaUmrechnen {

        // Methode zur Umrechnung von Hexadezimal zu Dezimal
        public static int hexToDecimal(String hex) {
            int decimal = 0;
            int power = 0;
            for (int i = hex.length() - 1; i >= 0; i--) {
                char digit = hex.charAt(i);
                int digitValue;
                if (Character.isDigit(digit)) {
                    digitValue = digit - '0';
                } else {
                    digitValue = Character.toUpperCase(digit) - 'A' + 10;
                }
                decimal += digitValue * Math.pow(16, power);
                power++;
            }
            return decimal;
        }

        // Methode zur Umrechnung von Hexadezimal zu Binär
        public static String hexToBinary(String hex) {
            int decimal = hexToDecimal(hex);
            return DezimalUmrechnen.decimalToBinary(decimal);
        }

    }


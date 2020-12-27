public class ArmstrongNumbers {
    public static boolean isArmstrongNumber(int n) {
        int armStrongNumber = 0;
        String stringN = Integer.toString(n);
        for (int i = 0; i < stringN.length(); i++) {
            armStrongNumber += Math.pow(Integer.parseInt(stringN.substring(i, i + 1)), stringN.length());
        }
        return armStrongNumber == n;
    }
}

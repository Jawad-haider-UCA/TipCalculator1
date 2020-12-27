import java.util.Arrays;

public class IsbnVerifier {

    /*
    The ISBN-10 verification process is used to validate book identification numbers.
     These normally contain dashes and look like: 3-598-21508-8

    ISBN
    The ISBN-10 format is 9 digits (0 to 9) plus one check character (either a digit or an X only).
    In the case the check character is an X, this represents the value '10'. These may be communicated with or without hyphens,
     and can be checked for their validity by the following formula:

    (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9 * 2 + x10 * 1) mod 11 == 0
    If the result is 0, then it is a valid ISBN-10, otherwise it is invalid.
    Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula, and get:

    (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 * 1) mod 11 == 0
    Since the result is 0, this proves that our ISBN is valid.
         */

    public static boolean isValid(String number){

        String[] numbers= number.split("-");
        //System.out.println(Arrays.toString(numbers));
        String allNumbers="";
        for (String n:numbers ) {
            allNumbers+=n;
        }

        //System.out.println(allNumbers);
        String[] separate= allNumbers.split("");
        int[] isbn=new int[allNumbers.length()];
        //System.out.println(Arrays.toString(separate));
        for (int i = 0; i <separate.length ; i++) {
            isbn[i]=Integer.parseInt(separate[i]);
        }

        int sumMultiples=0;
        int multiple=10;
        for (int i = 0; i <10 ; i++) {
            sumMultiples+=(isbn[i]*multiple);
            multiple--;
        }
        return sumMultiples%11==0;
//        if(sumMultiples%11==0){
//            //System.out.println("Checked ");
//            return "ISBN is Valid";
//        }
//
//        else{
//            //System.out.println("Not checked");
//            return "ISBN not a Valid";
//        }
//       // System.out.println(Arrays.toString(isbn));
    }

    public static void main(String[] args) {

        isValid("3-598-21508-8");
        isValid("3-598-21508-9");
        //isValid("3-598-21508-8");

    }
}

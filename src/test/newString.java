package test;

/**
 * Created by sbt-palamar-iy on 03.07.2018.
 */
public class newString {

    public static void main(String args[]) {
        String str1 = "12345", str2 = "abcde";
        if (str1.length()==str2.length()) {
            for (int i = str1.length() - 1, n = 0; i >= 0; i--, n++) {
                System.out.print(str1.charAt(i));
                System.out.print(str2.charAt(n));
            }
        }
        if (str1.length() < str2.length()) {
            for (int i = str1.length() - 1, n = 0; i >= 0; i--, n++) {
                System.out.print(str1.charAt(i));
                System.out.print(str2.charAt(n));
            }
            for (int i = str1.length(); i < str2.length(); i++) {
                System.out.print(str2.charAt(i));
            }
        }
        if (str1.length() > str2.length()) {
            for (int i = str2.length() - 1, n = 0; i >= 0; i--, n++) {
                System.out.print(str1.charAt(i));
                System.out.print(str2.charAt(n));
            }
            for (int i = str2.length(); i < str1.length(); i++) {
                System.out.print(str1.charAt(i));
            }
        }
    }
}


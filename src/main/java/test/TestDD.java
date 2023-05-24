package test;

import java.io.InputStream;
import java.util.Scanner;

public class TestDD {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        Scanner scanner = new Scanner(inputStream);
        int r1 = Integer.parseInt(scanner.next());
        int r2 = Integer.parseInt(scanner.next());
        String sInput = scanner.next();

        String s1 = String.valueOf(r1);
        String s2 = String.valueOf(r2);
        int s1L = s1.length();
        int s2L = s2.length();
        String[] sInputList = sInput.split(",");
        StringBuffer Sbf = new StringBuffer();

        if (s1L == s2L) {
            for (String s : sInputList) {
                int sL = s.length();

                if (sL > s2L) {
                    Sbf.append("INVALID,");
                } else {
                    for (int i = 0;i < sL - 1;i++) {
                        if (s.charAt(i) < s1.charAt(i) || s.charAt(i) > s2.charAt(i)) {
                            Sbf.append("INVALID,");
                            break;
                        }
                    }

                    int tempS = Integer.parseInt(s);
                    int temp1 = r1%10 + (r1/10)%10 * 10;
                    int temp2 = r2%10 + (r2/10)%10 * 10;
                    tempS = tempS%10 + (tempS/10)%10 * 10;
                    if(tempS < temp1 || tempS > temp2) {
                        Sbf.append("INVALID,");
                    } else {
                        Sbf.append("VALID,");
                    }
                }
            }
        } else {
            for (String s : sInputList) {
                int sL = s.length();

                if (sL > s2L) {
                    Sbf.append("INVALID,");
                } else {
                    for (int i = 0;i < sL;i++) {
                        if (s.charAt(i) < s1.charAt(i)) {
                            Sbf.append("INVALID,");
                            break;
                        } else {

                        }
                    }
                }
            }
        }


        for (String s : sInputList) {
            int sL = s.length();

            if (sL < s1L) {
                int index = 0;
                for (int i = 0;i < sL;i++) {
                    if (s.charAt(i) < s1.charAt(i)) {
                        Sbf.append("INVALID,");
                        break;
                    } else if (s.charAt(i) > s2.charAt(i) && s1L == s2L) {
                        Sbf.append("INVALID,");
                        break;
                    }
                    index++;
                }

                if (index == sL) {
                    Sbf.append("VALID,");
                }
            } else if (sL == s1L || sL == s2L){
                for (int i = 0;i < sL - 1;i++) {
                    if (s.charAt(i) < s1.charAt(i) || s.charAt(i) > s2.charAt(i)) {
                        Sbf.append("INVALID,");
                        break;
                    }
                }

                int tempS = Integer.parseInt(s);
                int temp1 = r1%10 + (r1/10)%10 * 10;
                int temp2 = r2%10 + (r2/10)%10 * 10;
                tempS = tempS%10 + (tempS/10)%10 * 10;
                if(tempS < temp1 || tempS > temp2) {
                    Sbf.append("INVALID,");
                } else {
                    Sbf.append("VALID,");
                }
            } else if (sL < s2L){
                Sbf.append("VALID,");
            } else {
                Sbf.append("INVALID,");
            }
        }

        String newS = Sbf.toString();
        System.out.println(newS.substring(0, newS.length()-1));
    }
}

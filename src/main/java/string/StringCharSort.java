package string;

public class StringCharSort {
    public static void main(String[] args) {
        String s = "FGHhdiahfaoGBuUIghhGGGYgYGjJQJdjqffa";
        System.out.println(stringCharSort(s));
    }

    public static String stringCharSort(String s) {
        char[] sList = s.toCharArray();
        int len = sList.length;

        for (int i = 0;i < len-1;i++) {
            for (int j = 0;j < len-1-i;j++) {
                if (sList[j] > sList[j+1]) {
                    char temp = sList[j+1];
                    sList[j+1] = sList[j];
                    sList[j] = temp;
                }
            }
        }

        return String.valueOf(sList);
    }
}

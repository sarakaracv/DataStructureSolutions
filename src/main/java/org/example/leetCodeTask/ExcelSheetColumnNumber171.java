package org.example.leetCodeTask;

public class ExcelSheetColumnNumber171 {
    public static void main(String[] args) {

    }
    public int titleToNumber(String columnTitle){
        int result=0;
        for (int i = 0; i < columnTitle.length(); i++) {
            int digit=columnTitle.charAt(i)-'A'+1;
            result=result*26+digit;
        }
        return result;
    }
}

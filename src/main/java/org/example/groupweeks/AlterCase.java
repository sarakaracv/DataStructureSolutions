package org.example.groupweeks;

public class AlterCase {
    public static void main(String[] args) {
        String txt = "this is some code";
        int p1 = 0;
        int p2 = 1;
        String output = "";

        for (int i = 0; i < txt.length(); i += 2) {

            if (p1 >= txt.length()) {
                break;
            }
            if (p2 >= txt.length()) {
                break;
            }
            if (txt.charAt(p1) == ' ') {
                output += ' ';
                p1++;
                p2++;
            }
            output += (txt.charAt(p1) + "").toUpperCase();
            if (p2 >= txt.length()) {
                break;
            }
            output += (txt.charAt(p2) + "").toLowerCase();
            p1 += 2;
            p2 += 2;

        }
        System.out.println(output);
    }
    public static String camelCase(String line){

        String[] ar = line.split("");
        StringBuilder sb = new StringBuilder();
        int numAlphabetic = 0;
        for (String str : ar) {
            if (Character.isAlphabetic(str.charAt(0))) {
                if (numAlphabetic % 2 == 0) {
                    sb.append(str.toUpperCase());
                } else {
                    sb.append(str.toLowerCase());
                }
                numAlphabetic++;
            } else {
                sb.append(str);
            }
        }
        return sb.toString();

    }
}

package org.example.Task28;

public class LengthOfLastWord {
    public static void main(String[] args) {
        String name = "Gulcin Saran  kara ";

        System.out.println(new LengthOfLastWord().nameFind(name));
        System.out.println(new LengthOfLastWord().nameFindWithoutTrim(name));
        System.out.println(new LengthOfLastWord().lengthOfLastWord(name));
        System.out.println(new LengthOfLastWord().lengthOfLastWord2(name));
        System.out.println("********************");

    }

    public int nameFind(String name) {
        int len = 0;
        String c = name.trim();

        for (int i = 0; i < c.length(); i++) {
            if (c.charAt(i) == ' ') len = 0;
            else len++;
        }
        return len;
    }

    public int nameFindWithoutTrim(String name) {// double blank useless
        boolean crc = false;
        int lent = 0;
        for (int i = name.length() - 1; i >= 0; i--) {
            if (Character.isLetter(name.charAt(i))) {
                crc = true;
                lent++;
            } else return lent;
        }
        return lent;
    }

    public int lengthOfLastWord(String name) {
        String[] str = name.split(" ");
        return str[str.length - 1].length();
    }
    public int lengthOfLastWord2(String name) {
        name=name.trim();
        String last= name.substring(name.lastIndexOf(" ")+1);
        return last.length();
    }
//    public int lengthOfLastWord3(String name) {// double empty useless
//        int lent=0;
//        boolean c= name.chars().takeWhile(Character::isLetter).findAny().isEmpty();
//        String last= name.substring(name.lastIndexOf(" ")-1);
//        for (int i = name.length()-1; i > 0; i--) {
//            if (name.charAt(i)==' '&& c==false) break;
//            if (last==" ") continue;
//            lent++;
//            }
//        return lent;
//    }
}


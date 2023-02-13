package org.example.leetCodeTask;

import java.util.*;

public class ZigzagConversion6 {
    public static void main(String[] args) {

        String str= "paypalmakap";
        int nums=3;
        System.out.println(convert1(str,nums));
    }
    public static String convert1(String s, int nums) {
        if(nums ==1) return s;
        int x = 2 * (nums-1); // distance between pipes |/|/|...
        char[] c = new char[s.length()];
        int k =0;
        for(int i=0; i < nums; i++)
        {
            for(int j=i;j<s.length();j=j+x)
            {
                c[k++] = s.charAt(j);
                if(i>0 && i<nums-1 && j+x-2*i < s.length())
                {
                    c[k++] = s.charAt(j+x-2*i); // extra character between pipes
                }
            }
        }
        return new String(c);
    }
    public static String convert2(String s, int numRows) {
        if(numRows == 1) return s;
        char[] str = s.toCharArray();
        int jump = (numRows - 1) * 2;
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < numRows; i++) {
            if(i == 0 || i == numRows - 1) {
                for(int j = i; j < str.length; j += jump) {
                    result.append(str[j]);
                }
            } else {
                for(int j = i, k = jump - i; j < str.length; j += jump, k += jump) {
                    result.append(str[j]);
                    if(k < str.length) result.append(str[k]);
                }
            }
        }
        return result.toString();
    }
    public static String convert3(String s, int numRows) {
        if(numRows == 1) return s;
        StringBuilder sb = new StringBuilder();
        int totalLeap = (numRows - 1) * 2;
        for(int i = 0; i < numRows; i++){
            int leap = (numRows - 1 - i) * 2;
            if(leap == 0) leap = totalLeap;
            for(int j = i, count = 0; j < s.length(); j += leap, count++){
                sb.append(s.charAt(j));
                if(i != 0 && i != numRows - 1 && count > 0) leap = totalLeap - leap;
            }
        }
        return sb.toString();
    }
    public static String convert4(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;
        int pass = 2 * (numRows - 1);
        char[] c = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int inside = i, outside = i * 2;
            while (inside < c.length) {
                sb.append(c[inside]);
                if (outside != pass) outside = pass - outside;
                inside += outside;
            }
        }

        return sb.toString();
    }
    public String convert5(String s, int numRows) {
        if (numRows <= 1 || s.length() <= numRows) {
            return s;
        }
        if (numRows == 2) {
            return sizeTwo(s);
        }

        int zigzagLength = numRows - 2;
        char finalString[] = new char[s.length()];

        List<String> verticals = new LinkedList<>();
        List<String> zigzags = new LinkedList<>();

        for (int i = 0; i < s.length(); i += (numRows + zigzagLength)) {
            StringBuilder temp = new StringBuilder();
            for (int j = i; j < i + numRows && j < s.length(); j++) {
                temp.append(s.charAt(j));
            }
            verticals.add(temp.toString());

            temp = new StringBuilder();
            for (int j = i + numRows; j < i + numRows + zigzagLength && j < s.length(); j++) {
                temp.append(s.charAt(j));
            }
            zigzags.add(temp.toString());

        }

        int maxWidth = verticals.get(0).length();

        int vi = 0;
        int zi = zigzags.get(0).length() - 1;
        int i = 0;

        while (vi < maxWidth) {
            if (vi == 0 || vi == numRows - 1) {
                for (int k = 0; k < verticals.size(); k++) {
                    if (vi < verticals.get(k).length()) {
                        finalString[i++] = verticals.get(k).charAt(vi);
                    }
                }
            } else {
                boolean zigzagOp = false;
                for (int k = 0; k < verticals.size(); k++) {
                    if (vi < verticals.get(k).length()) {
                        finalString[i++] = verticals.get(k).charAt(vi);
                    }
                    if (numRows - 1 - vi == zi + 1 && k < zigzags.size() && zi < zigzags.get(k).length()) {
                        finalString[i++] = zigzags.get(k).charAt(zi);
                        zigzagOp = true;
                    }
                }
                if (zigzagOp) {
                    zi--;
                }
            }
            vi++;

        }

        return new String(finalString);
    }

    public static String sizeTwo(String s) {
        char finalStr[] = new char[s.length()];
        int index = 0;
        int i = 0;
        while (index < finalStr.length) {
            finalStr[i++] = s.charAt(index);
            index += 2;

        }
        index = 1;
        while (index < finalStr.length) {
            finalStr[i++] = s.charAt(index);
            index += 2;
        }
        return new String(finalStr);

    }
    public String convert6(String s, int numRows){
        int index=0 ;
        int row = 0, n = s.length();
        StringBuffer[] zigzag = new StringBuffer[numRows];
        //edge case
        if (s.length() < numRows || numRows < 2){
            return s;
        }
        while (row < numRows){
            zigzag[row++] = new StringBuffer().append(s.charAt(index++));
        }
        row--;
        boolean down = false;// moving down
        while (index < n){
            if (row == numRows-1){
                down = false;
            }
            if (row == 0){
                down = true;
            }

            if (down){
                row++;
            }else {
                row--;
            }
            zigzag[row].append(s.charAt(index++)) ;
        }
        for (int i = 1 ; i < zigzag.length ; i ++){
            zigzag[0].append(zigzag[i]);
        }
        return String.valueOf(zigzag[0]);
    }
    public String convert7(String s, int numRows) {
        if(numRows<=1)return s;
        StringBuilder[] sb=new StringBuilder[numRows];
        for(int i=0;i<sb.length;i++){
            sb[i]=new StringBuilder("");//init every sb element *important steps!!!
        }
        int incre=1;
        int index=0;
        for(int i=0;i<s.length();i++){
            sb[index].append(s.charAt(i));
            if(index==0){incre=1;}
            if(index==numRows-1){incre=-1;}
            index+=incre;
        }
        String re="";
        for(int i=0;i<sb.length;i++){
            re+=sb[i];
        }
        return re.toString();
    }
    public String convert8(String s, int n) {
        if(s.length()<n)return s;
        if(n==1) return s;
        String arr[]=new String[n];
        int x=0;
        int c=0;
        for(int i=0;i<s.length();i++){
            arr[x]=arr[x]+String.valueOf(s.charAt(i));
            //System.out.println(c+" "+x);
            if(c==0){
                if(x<n-1){
                    x++;
                }
                else{
                    c++;
                    x--;
                }
            }
            else{
                if(x>0){
                    x--;
                }
                else{
                    c--;
                    x++;
                }
            }
        }
        String z="";
        for(int i=0;i<n;i++){
            z=z+arr[i].substring(4);
        }
        return z;
    }
    public String convert9(String s, int n) {
        if(s.length()<n || n==1)return s;

        String arr[]=new String[n];
        int x=0;
        int c=0;
        for(int i=0;i<s.length();i++){
            arr[x]=arr[x]+String.valueOf(s.charAt(i));
            if(c==0){
                if(x<n-1){
                    x++;
                }
                else{
                    c++;
                    x--;
                }
            }
            else{
                if(x>0){
                    x--;
                }
                else{
                    c--;
                    x++;
                }
            }
        }
        String z="";
        for(int i=0;i<n;i++){
            z=z+arr[i].substring(4);
        }
        return z;
    }
    public String convert10(String s, int numRows) {
        String finalstring = "";
        Map map = new HashMap<Integer,String>();
        int rownumber = 1;
        boolean direction = false;
        for(int i=0;i<s.length();i++){
            map.put(rownumber,map.getOrDefault(rownumber,"")+String.valueOf(s.charAt(i)));
            if(rownumber==numRows || rownumber==1){
                direction = !direction;
            }
            if(direction){
                rownumber++;
            }else{
                rownumber--;
            }
        }
        Collection arr = map.values();
        Iterator i = arr.iterator();
        while(i.hasNext()){
            finalstring += i.next();
        }
        return finalstring;
    }
    public String convert11(String s, int numRows) {

        String ans="";
        if(numRows==1) return s;
        for (int i=0;i<numRows;i++) {
            int incr=2*(numRows-1);
            for (int j=i;j<s.length();j+=incr) {
                ans+=s.charAt(j);
                if(i>0 && i<numRows-1 && j+incr-(2*i)<s.length()) ans+=s.charAt(j+incr-(2*i));
            }
        }
        return ans;

    }
    public String convert12(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        List<String> rows = new ArrayList<>(numRows);
        for (int i=0; i<numRows; i++) {
            rows.add(i, "");
        }

        boolean backward = true;
        int index = 0;

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            String row = rows.get(index) + "" + c;
            rows.set(index, row);
            if (index == 0 || index == numRows - 1) {
                backward = !backward;
            }
            if (backward) {
                --index;
            } else {
                ++index;
            }
        }

        return String.join("", rows);

    }
    public String convert13(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        int jump1 = numRows*2-2;
        int jump2 =0;
        String result ="";
        for(int i=0;i<numRows && i<s.length();i++){
            result+=s.charAt(i);
            //System.out.println(result);
            int j=i;
            while(j<s.length()){
                if(jump1==0||jump2==0){
                    j+=jump1+jump2;
                    if(j>s.length()-1)
                        break;
                    result+=s.charAt(j);

                }
                else{
                    j+=jump1;
                    if(j>s.length()-1)
                        break;
                    result+=s.charAt(j);

                    j+=jump2;
                    if(j>s.length()-1)
                        break;
                    result+=s.charAt(j);

                }
            }
            jump1-=2;jump2+=2;
        }
        System.out.println("hi "+result);
        return result;
    }
    public String convert14(String s, int numRows) {
        if(numRows==1){return s;}
        List<StringBuilder> li = new ArrayList<>();
        for(int i=0;i<Math.min(numRows,s.length());i++){
            li.add(new StringBuilder());
        }

        int currRow = 0;
        boolean gngDown = false;
        for(char c: s.toCharArray()){
            li.get(currRow).append(c);
            if(currRow==0||currRow==numRows-1){gngDown=!gngDown;}
            currRow += gngDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for(StringBuilder r: li){
            ret.append(r);
        }
        return ret.toString();
    }
    public String convert15(String s, int numRows) {
        if (numRows == 1)
            return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
    public String convert16(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder result = new StringBuilder();
        int baseDistance = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            int operatingIndex = i;
            boolean isEdgeCase = i == 0 || i == numRows - 1;
            int jump = isEdgeCase ? baseDistance : baseDistance - 2 * i;
            while (operatingIndex < s.length()) {
                result.append(s.charAt(operatingIndex));
                operatingIndex += jump;
                jump = isEdgeCase ? baseDistance : baseDistance - jump;
            }
        }
        return result.toString();
    }
}

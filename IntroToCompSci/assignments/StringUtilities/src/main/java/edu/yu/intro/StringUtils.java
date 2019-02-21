package edu.yu.intro;

public class StringUtils {

    public static boolean isPalindrome(final String s) {
        if (s == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }

        if (s.equals("")) {
            return true;
        }

        for (int i = 0; i < (s.length() / 2); i++) {
            if (s.charAt(i) != s.charAt(s.length() - (i + 1))) {
                return false;
            }
        }
        return true;
    }

    public static String extractExtension(final String filename){
        if(filename == null){
            throw new RuntimeException("Input cannot be null");
        }
        String[] split = filename.split("\\.");
        if(split.length > 2){
            throw new RuntimeException("Mulitiple \"dots\" found");
        }
        if(split.length == 1){
            return "";
        }
        return split[1];
    }

    public static boolean isNotEmpty(final String str){
        if(str == null){
            return false;
        }
        if(str.length() == 0){
            return false;
        }
        return true;
    }
    public static boolean isBlank(final String str){
        if(str == null){
            return true;
        }
        String s = str.trim();
        if(s.isEmpty()){
            return true;
        }
        return false;
    }
    public static boolean equals(final String str1, final String str2){
        if(str1 == null && str2 == null){
            return true;
        }
        else if((str1 == null && str2 != null) || (str1 != null && str2 == null)){
            return false;
        }
        else{
            return str1.equals(str2);
        }
    }

    public static String join(Object[] array){
        if(array == null){
            throw new RuntimeException("Input cannot be null");
        }
        String s = "";
        for(int i = 0; i < array.length; i++){
            Object o = array[i];
            if(o == null || o.toString().equals("")){
                continue;
            }
            s = s + o.toString();
        }
        return s;
    }

    public static String leftPad(final String str, int len){
        if(len > 20){
            len = 20;
        }
        if(str == null){
            return null;
        }
        if(len < str.length()){
            return str;
        }
        String padding = "";
        int numPad = len - str.length();
        for(int i = 0; i < numPad; i++){
            padding = padding + " ";
        }
        return padding + str;
    }

    public static String trimWhitespaceTillEmpty(final String str){
        if(str == null){
            return "";
        }
        return str.trim();
    }

    public static String remove(final String str, final char removeIt){
        if(str == null){
            return null;
        }
        if(str.equals("")){
            return "";
        }
        String s = "";
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != removeIt){
                s = s + str.charAt(i);
            }
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(StringUtils.isPalindrome("aqbba"));
        System.out.println(StringUtils.extractExtension("example.txt"));
        System.out.println(StringUtils.isNotEmpty("hello"));
        System.out.println(StringUtils.isBlank("ghjc"));
        System.out.println(StringUtils.equals("hello", "hello"));
        Object[] array = {"Hi", "", null, new Object()};
        System.out.println(StringUtils.join(array));
        String s = StringUtils.leftPad("hello", -3);
        System.out.println(s + "      " + s.length());
        System.out.println(StringUtils.trimWhitespaceTillEmpty("    "));
        System.out.println(StringUtils.remove("mirror", 'r'));
    }


}
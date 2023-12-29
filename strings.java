import java.util.Arrays;
public class strings {

    public static String upperCase(String st){
        StringBuilder stb = new StringBuilder("");                      //string builder and its functions
        stb.append(Character.toUpperCase(st.charAt(0)));

        for(int i=1; i<st.length()-1; i++){
            if(st.charAt(i) == ' '){
                stb.append(st.charAt(i));
                i++;
                stb.append(Character.toUpperCase(st.charAt(i)));
            }
            else {
                stb.append(st.charAt(i));
            }
        }

        return stb.toString();
    }

    public static String compress(String st){
        StringBuilder stb = new StringBuilder("");

        for(int i=0; i<st.length(); i++){
            Integer count = 1;
            while(i<st.length()-1 && st.charAt(i) == st.charAt(i+1)){
                i++;
                count++;
            }

            stb.append(st.charAt(i));
            if(count > 1)
                stb.append(count.toString());
        }
        return stb.toString();
    }

    public static void CheckAnagram(String st, String str){
        st = st.toLowerCase();
        str = str.toLowerCase();

        if(st.length() == str.length()){
            char[] stA = st.toCharArray();                      //converting string to character array
            char[] strA = str.toCharArray();

            Arrays.sort(stA);                                   //sorting character array using in-built array function
            Arrays.sort(strA);

            if(Arrays.equals(stA, strA)){                       //equating character arrays using in-built array function
                System.out.println("Anagrams.");
            }
            else{
                System.out.println("Not Anagrams!");
            }
        }
        else{
            System.out.println("Not Anagrams!");
        }

    }

    public static void main(String[] args){
        System.out.println(upperCase("hi, my name is ajay %"));
        System.out.println(compress("aaaabbbbbhhhhddddduuupeeooooo"));
        CheckAnagram("earth", "HEART");
    }
    
}

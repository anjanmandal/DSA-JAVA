import java.util.ArrayList;
public class Permutation {
    public static void main(String[] args) {
        permutation("", "abc");
        ArrayList<String> list =permutationList("", "abc");
        System.out.println(list);
        int count=permutationCount("", "abc");
        System.out.println(count);
    }

    static void permutation(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }


        char firstChar = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            // Insert the character at every possible position
            String left=p.substring(0, i); // Left part of processed string
            String right=p.substring(i);  // Right part of processed string
            // Pass the rest of the string (excluding the first character) to the recursive call
            permutation(left+firstChar+right, up.substring(1));
        }
    }
    static ArrayList<String> permutationList(String p,String up){
        if(up.isEmpty()){
            ArrayList<String> list= new ArrayList<>();
            list.add(p);
            return list;
        }
        char firstChar = up.charAt(0);
        ArrayList<String> ans= new ArrayList<>();
        for (int i = 0; i <= p.length(); i++) {
            // Insert the character at every possible position
            String left=p.substring(0, i); // Left part of processed string
            String right=p.substring(i);  // Right part of processed string
            // Pass the rest of the string (excluding the first character) to the recursive call
            
            ans.addAll(permutationList(left+firstChar+right, up.substring(1)));
        }
        return ans;

    }
    static int permutationCount(String p,String up){
        if(up.isEmpty()){
           return 1;
        }
        char firstChar = up.charAt(0);
       int count=0;
        for (int i = 0; i <= p.length(); i++) {
            // Insert the character at every possible position
            String left=p.substring(0, i); // Left part of processed string
            String right=p.substring(i);  // Right part of processed string
            // Pass the rest of the string (excluding the first character) to the recursive call
            
            count+=permutationCount(left+firstChar+right, up.substring(1));
        }
        return count;
       

    }
}

public class StringQuestion {
    public static void main(String[] args){
       String aless= removeA("baccad");
       System.out.println(aless);


    }
    static String removeA(String str){
        if(str.isEmpty()){
            return str;
        }
        char firstChar= str.charAt(0);
        if(firstChar=='a'){
            return ""+removeA(str.substring(1));
        }
        return firstChar+removeA(str.substring(1));
    }
};

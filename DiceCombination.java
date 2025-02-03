import java.util.ArrayList;
import java.util.List;

public class DiceCombination {
    public static void main(String[] args){
        System.out.println(getDiceCombination("", 4));

    }
    static List<String> getDiceCombination(String p,int up){
        if(up==0){
            List<String> ans=new ArrayList<>();
            ans.add(p);
            return ans;
        }
        List<String> list=new ArrayList<>();
        for(int i=1;i<=6 && i<=up;i++){
            list.addAll(getDiceCombination(p+i, up-i));

        }
        return list;


    }
    
}

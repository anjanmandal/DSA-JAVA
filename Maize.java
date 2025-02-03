import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Maize {
    public static void main(String[] args) {
        System.out.println(maizePathRD("", 3, 3));
        System.out.println(maizePathRDD("", 3, 3));
        boolean [][]maize={
            {true,true,true},
            {true,true,true},
            {true,true,true}
        };
        int [][]path={
            {0,0,0},
            {0,0,0},
            {0,0,0}
        };
        maizeWithObstacle("",maize,0,0);
        maizeWithPath("",maize,path,0,0,0);
    }
//Moving only in Down and Right...
    static List<String> maizePathRD(String p, int row, int col) {
        if (row == 1 && col == 1) {
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> ans = new ArrayList<>();

        // Move Right
        if (col > 1) {
            List<String> left = maizePathRD(p + "R", row, col - 1);
            ans.addAll(left);
        }

        // Move Down
        if (row > 1) {
            List<String> right = maizePathRD(p + "D", row - 1, col);
            ans.addAll(right);
        }

        return ans;
    }
// Moving Down, Right, and Digonally..
 static List<String> maizePathRDD(String p,int row,int col){

    if(row==1 && col==1){
        List<String> list=new ArrayList<>();
        list.add(p);
        return list;
    }
    List<String> ans=new ArrayList<>();
    if(row>1 && col>1){
        ans.addAll(maizePathRDD(p+'G', row-1, col-1));
    }
    if(row>1){
        ans.addAll(maizePathRDD(p+'D', row-1, col));

    }if(col>1){
        ans.addAll(maizePathRDD(p+'R', row, col-1));
    }
return ans;

}
static  void maizeWithObstacle(String p, boolean [][] maize,int row,int col){
    if(row==maize.length-1 && col==maize[0].length-1){
        System.out.println(p);
        return;
    }
    if(!maize[row][col]){
        return;
    }
    maize[row][col]=false;
       // Move Right
       if (col<maize[0].length-1) {
       maizeWithObstacle(p + "R",maize, row, col + 1);
       
    }
    // Move Down
    if (row < maize.length-1) {
       maizeWithObstacle(p + "D",maize, row + 1, col);
       
    }
    if(row>0){
        maizeWithObstacle(p+'U',maize,row-1,col);
    }
    if(col>0){
        maizeWithObstacle(p+'L',maize,row,col-1);
    }
    maize[row][col]=true;
}

static  void maizeWithPath(String p, boolean [][] maize,int [][] ans, int row,int col,int count){
    if(row==maize.length-1 && col==maize[0].length-1){
        ans[row][col]=count;
        for(int []arr:ans){
            System.out.println(Arrays.toString(arr));
        };
        System.out.println(p);
        System.out.println();
        return;
    }
    if(!maize[row][col]){
        return;
    }
    ans[row][col]=count;

    maize[row][col]=false;
       // Move Right
       if (col<maize[0].length-1) {
       maizeWithPath(p + "R",maize,ans, row, col + 1,count+1);
       
    }
    // Move Down
    if (row < maize.length-1) {
       maizeWithPath(p + "D",maize,ans, row + 1, col,count+1);
       
    }
    if(row>0){
        maizeWithPath(p+'U',maize,ans,row-1,col,count+1);
    }
    if(col>0){
        maizeWithPath(p+'L',maize,ans,row,col-1,count+1);
    }
    maize[row][col]=true;
    ans[row][col]=0;
}
}

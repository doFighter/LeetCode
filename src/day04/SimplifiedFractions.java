/**
 * @Description
 * @author Fighter
 * @create 2022-02-10 16:05
 */


package day04;

import java.util.ArrayList;
import java.util.List;

public class SimplifiedFractions {
    public List<String> simplifiedFractions(int n){
        List<String> res = new ArrayList<>();
        for (int i=1;i < n;i++){
            for (int j=i+1;j<=n;j++){
                if (i==1){
                    res.add(""+i+"/"+j);
                }else {
                    if (j%i==0){
                        continue;
                    }
                    boolean flag = true;
                    for (int k=2;k<=i/2;k++){
                        if (i%k==0&&j%k==0){
                            flag = false;
                            break;
                        }
                    }
                    if (flag){
                        res.add(""+i+"/"+j);
                    }
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        SimplifiedFractions sf = new SimplifiedFractions();
        List<String> list = sf.simplifiedFractions(6);
        System.out.println(list);
    }
}

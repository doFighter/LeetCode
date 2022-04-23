/**
 * @Description
 * @author Fighter
 * @create 2022-02-20 16:08
 */


package day13;

/**
 * 717. 1比特与2比特字符
 * 有两种特殊字符：
 *
 * 第一种字符可以用一个比特 0 来表示
 * 第二种字符可以用两个比特(10 或 11)来表示、
 * 给定一个以 0 结尾的二进制数组 bits ，如果最后一个字符必须是一位字符，则返回 true 。
 *
 * 示例 1:
 *
 * 输入: bits = [1, 0, 0]
 * 输出: true
 * 解释: 唯一的编码方式是一个两比特字符和一个一比特字符。
 * 所以最后一个字符是一比特字符。
 * 示例 2:
 *
 * 输入: bits = [1, 1, 1, 0]
 * 输出: false
 * 解释: 唯一的编码方式是两比特字符和两比特字符。
 * 所以最后一个字符不是一比特字符。
 *
 * 提示:
 *
 * 1 <= bits.length <= 1000
 * bits[i] == 0 or 1
 */

public class IsOneBitCharacter {
    public boolean isOneBitCharacter1(int[] bits) {
        int num = 0;
        for (int i=0;i<bits.length;i++){
            if (bits[i]==0){
                num++;
            }else {
                num--;
            }
        }
        if (num>0 || num==-1 || num%2==1){
            return true;
        }
        return false;
    }

    public boolean isOneBitCharacter(int[] bits) {
        if (bits[bits.length-1]==0){
            int num=0;
            for (int i=bits.length-2;i>=0;i--){
                if (bits[i]==1){
                    num++;
                }else {
                    break;
                }
            }
            if (num%2==0){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] bits = {1, 0, 0};
//        int[] bits = {1, 1, 1, 0};
        IsOneBitCharacter bitCharacter = new IsOneBitCharacter();
        boolean oneBitCharacter = bitCharacter.isOneBitCharacter(bits);
        System.out.println(oneBitCharacter);
    }
}

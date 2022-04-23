/**
 * @Description
 * @author Fighter
 * @create 2022-02-26 11:10
 */


package day15;

/**
 * 838. 推多米诺
 * n 张多米诺骨牌排成一行，将每张多米诺骨牌垂直竖立。在开始时，同时把一些多米诺骨牌向左或向右推。
 *
 * 每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。
 *
 * 如果一张垂直竖立的多米诺骨牌的两侧同时有多米诺骨牌倒下时，由于受力平衡， 该骨牌仍然保持不变。
 *
 * 就这个问题而言，我们会认为一张正在倒下的多米诺骨牌不会对其它正在倒下或已经倒下的多米诺骨牌施加额外的力。
 *
 * 给你一个字符串 dominoes 表示这一行多米诺骨牌的初始状态，其中：
 *
 * dominoes[i] = 'L'，表示第 i 张多米诺骨牌被推向左侧，
 * dominoes[i] = 'R'，表示第 i 张多米诺骨牌被推向右侧，
 * dominoes[i] = '.'，表示没有推动第 i 张多米诺骨牌。
 * 返回表示最终状态的字符串。
 *
 *
 * 示例 1：
 *
 * 输入：dominoes = "RR.L"
 * 输出："RR.L"
 * 解释：第一张多米诺骨牌没有给第二张施加额外的力。
 * 示例 2：
 *
 *
 * 输入：dominoes = ".L.R...LR..L.."
 * 输出："LL.RR.LLRRLL.."
 *
 *
 * 提示：
 *
 * n == dominoes.length
 * 1 <= n <= 105
 * dominoes[i] 为 'L'、'R' 或 '.'
 */
public class PushDominoes {
    /**
     * 暴力解法
     * @param dominoes
     * @return
     */
    public String pushDominoes(String dominoes) {
        StringBuilder builder = new StringBuilder(dominoes);
        for (int i=0;i<dominoes.length();++i){
            if (dominoes.charAt(i)=='.'){
                continue;
            }else if (dominoes.charAt(i)=='R'){
                int tick = 0;
                while (++i < dominoes.length() && (dominoes.charAt(i) == '.' || dominoes.charAt(i) == 'R')) {
                    builder.setCharAt(i, 'R');
                    ++tick;
                    if (dominoes.charAt(i) == 'R') {
                        tick = 0;
                    }
                }
                if (i > dominoes.length() -1){
                    break;
                }
                if (tick%2==0){
                    tick /= 2;
                    int j = i;
                    while (tick>0){
                        builder.setCharAt(--j, 'L');
                        tick--;
                    }
                }else {
                    tick /= 2;
                    int j = i;
                    while (tick>0){
                        builder.setCharAt(--j, 'L');
                        tick--;
                    }
                    builder.setCharAt(--j, '.');
                }
            }else {
                int j = i;
                while (--j>=0 && dominoes.charAt(j) == '.'){
                    builder.setCharAt(j, 'L');
                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String dominoes = "RR.L";
//        String dominoes = ".L.R...LR..L..";
//        String dominoes = ".L.R.";
//        String dominoes = ".L";
        PushDominoes dominoes1 = new PushDominoes();
        String s = dominoes1.pushDominoes(dominoes);
        System.out.println(s);
    }
}

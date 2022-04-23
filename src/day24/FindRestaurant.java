/**
 * @Description
 * @author Fighter
 * @create 2022-03-14 20:26
 */


package day24;

import java.util.*;

/**
 * 599. 两个列表的最小索引总和
 * 假设 Andy 和 Doris 想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 *
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设答案总是存在。
 *
 *
 *
 * 示例 1:
 *
 * 输入: list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * 输出: ["Shogun"]
 * 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
 * 示例 2:
 *
 * 输入:list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = ["KFC", "Shogun", "Burger King"]
 * 输出: ["Shogun"]
 * 解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
 *
 *
 * 提示:
 *
 * 1 <= list1.length, list2.length <= 1000
 * 1 <= list1[i].length, list2[i].length <= 30
 * list1[i] 和 list2[i] 由空格 ' ' 和英文字母组成。
 * list1 的所有字符串都是 唯一 的。
 * list2 中的所有字符串都是 唯一 的。
 */

public class FindRestaurant {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (int i=0; i<list1.length; i++){
            map.put(list1[i], map.getOrDefault(list1[i], i));
        }

        int scord = 2001;
        for (int i=0; i<list2.length; i++){
            int index = map.getOrDefault(list2[i], -1);
            if (index>=0){
                if (index + i < scord){
                    scord = index + i;
                    list.clear();
                    list.add(list2[i]);
                }else if (index + i == scord){
                    list.add(list2[i]);
                }

            }
        }
        return list.toArray(new String[list.size()]);
    }

    public static void main(String[] args) {
//        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
//        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
//        String[] list1 = {"KFC", "Shogun", "Tapioca Express", "Burger King"};
//        String[] list2 = {"KFC", "Shogun", "Burger King"};
        String[] list1 = {"jrjhvnxwqvobhjd","ttpfrxmsrzieutzsdwtbgfauxo","kjrqcaeffuzbjh","ysaubzjz","jgwkwmkbuofvkdqpyjdrfafcx","rbozloptrpa","uooearonblulfzndlla","jjxnijjahijkvget","biwsliifaecdgweftexcjqzlldfsb","jnutkminsmnjgz","djge","gjham","nzurg","ekwrlodnvztlnmppqfu","xch","ejmfxwqpnxbmdpiufmguio","uzwuzehgylsojwgktqnscppjkgiy","rlnf","vrhppbefyxs","ljwxvqimtohihgjkdmpqpuqctrsj","wqj","ulorrrvg","oylbgfg","xipyr","enefqpswqwcomsu","kyqsmpqhmcvi","mquiuskrugn","gvfynijqqxszeeaan","mqbszlbzoopwlxne","iabhd","jzutovltkftaotjwc","tbirfmqnnvkfdk","hnvga","lvdqrhwsdollljjxq","othkpfckfnaldcepkijtedalrcg","gcht","yhhqthxajkvdhyfipcoc","gpvgdqxolqa","dzjach","zitkpolmnzhfsocredgtlhjzo","cevfxlwaxsgnssyszrnlnkkatkjig","tr","ulwrxgwngrmdkvyxgbijqoys","bxsnhqynnykpythlgxpx","vqucjixktht","yvwpuoxqhnmtmyosyxiiiuevj","ihsli","uxhmsdvvhqehroxmrrgjv","aww","dqcqg","kch","abmnvdzexihikmua","hedituiywi","fuomgvblgmqm","eatedzneghdhwlzprkqcnygboba","au","m","juyqyettrhfbfgjirhkfbusyofssag","uccsbhbshugpureqpdv","afznkrubcrcpgvqiyhcjsssfrknumk","de","juhfwmaqtmqlwxbmgzvrljkmnw","jjlbxruomlolskdlwocyukjeplesu","vrcbadfr","pvrudlew","hvccmwumvhqmhxnrqdoirqdfssrxjm","uzimrdpvx","sqekxfpcwrsov","guypqfxrzfsvcuujtox","qhoniolcpmebk","zsgt","cgwnqajp","skh","cflbincydwp","jshcmynzkjmtivzpyrhvakkczc","izlktksnhvzmpgu","mfsvckklutxywplfdbhrqlvsegbmtw","eyhyrnmbnc","ickifvler","mdera","olmmlob","natfahp","epxbdscyxubvbbuoeyac","mnzobfzcyhcsk","bdeovhytxmlqntjelqyrryywtpo","w","bjdbrpsyuvmuoexsjpxybf","qpvjaac","bcblopvcafflyybg","uzrbenlgezzsbicpgmbtecxkfw","jsxszdwpg","zvxifkfvzzxkzicfmq","jdwbxhzkqdfbrhhnu","bpxbprwhtxkioqfygivcfzpbexy","jkcauzxgteyykynngr","nfhvz","hcrowr","wzsjxt","ultflwodzigdxyxspoaqr","ypazzkyaffwxratmi","ioyvvaylxi","vvwvtqchpjnkulaukurlmuvnjfvwi","nqg","eywgtnvmulcxfjwfhjpknruxgb","qpxwjkyjjtgxenwbzwh","xbjwtm","qbzii","boul","qwakmqtnnwlxq","amfzjkjfkugaizypqw","sbzrztdefab","aaxdyhrqvsnzijxflbuvfrudmx","cimowwuokd","ngdtqvl","jgqgtrr","kksxzqpg","sknxwy","esoodtqjrq","ofmupjfmuoxogjdnfmzrtg","doategwfpsbbvuhufvcv","mzwrplvletymynmwcmyfmxlwc","xmqhwcpiycecuh","knkji","tjghfhrulzbshffjmhenbabcn","bjmxdszwjclkgazlhqc","rzyorislf","sngrfwpkimw","iuibnpmrwtmakzkkylwn","dhvhnlgfcwidyqphnpsmmldpm","jnsfzbbyhnhalxznm","fhlc","y","vxgjmfmpjzcdqinsmjarf","zgzyidgejzyroovvkbwzewybsh","muuwmpispozajuao","axwzk","zkedjieprvvpgoitsgbaipltd","mmhgfxcpjbhhlkrle","jfqobkbjrrzbaintfhfalmtb","akjqtik","cqmdy","lhgudsqlujtuns","yusfrcemduttyytmyphzhlhjf","ywyzurbml","fcqjxintdrxnurmhwmzwpglzseew","ntokeizdxolmhrbycvpixepap","jilda","anuwfynwkcoleab","fqbjexbbby","bqzlqbofop","rnxzeqhvkyqrftojndql","qjsixihvqgueqfughfmwmrdyvhrk","kenoerinujgqqlochd","dxzuvrspntbrjtkjfonijskqhake","fv","wwpttedupokwgqsbtcstvlipoxknm","sxgamictyvpzkzejkqfmory","oszhalwkftezlifgxcydxfdizet","apndhtaha","otujzfdxqhwgohm","thfjyveyrw","laqqekuxyehcjvhfgvos","jysjiklbnmqmqlgkppohh","trwpxwiukmfvqfuvgu","nrharueqmjdexmkrwygqqr","zydcadskqozjqtagcnseyjjmkfmuvb","fvacblqegrdghjfuehz","qhlbkc","gxghcfqdcmmb","ezxabd","jfnrzpyktvrjgysuhxedzoow","aczmbvzzocidtaruhqnea","qlwxcqtcsconbkhlfefaovgeeiz","lpqlu","fqva","jtmhyijcpdjlg","kfavdwhogwyaurxdzdgq","dxuggtcsmeey","fylwcz","ayosodkkaih","zyzsyp","mnopwisfizvgpwswoljqjajtacwv","epbwabudervxwkqqb","tff","xekjxvooqkdacwrpxdxamp","xjhtlmmsazvgjnxsxn","pfxdewgzsztylmxkigwopftfpudrb","mpfigiou","rlt","c","jlmi","rbiqmeehpbqjodlznasdi","ixhzmsxpbyfehmuxsmalwiaspzaq","cmsderlbbufxkkuiuzytipmd","paelznmsgfnljwabydcrqzegd","egf","zjijruezanbldqmkjcjxcjgj","hnosym","ctlaukuwycytpme","pppqdajgqs","rzmkqngh","mxqhuqysniwqasf","dmmmuqstenctho","ttyzczap","ynf","xgrjdecyb","qdmirfzgu","mfrziymyazeemyzknyexy","cikfxibareideypgidtyr","blijpqiyqxfphhrgkn","omwbjmntax","lauvaye","rbrhmyxexraubqiavyiluyjlyqg","xopr","uhoctnakqefoayhana","vjf","ofkr","ivrqmirhhfqdobcmr","cnerajddoaczs","emaguohbnqwoskitjgogq","bbfzuajpefsud","hrkdnnbglgvllphirgxyhtexahtig","avperipszneidsazgsajbflv","qzjwhzs","nxmftvwe","uwgieclbvrlqykfeelomk","eoivfztiryskakljp","xat","ohvpyxpbdali","lbhcltcuayf","l","maoueqdnisc","rtqtzr","nqwtwua","wadgecxsc","hagtnbkhtc","bm","xag","podmmvmgvsjeldefguau","jdrpzbdxtxjmlhxkfdlgbkxg","nswxlsmxfiyf","arkkqckwjhhxshx","xcbrsphbwgfnztxgwmpdkbq","itprhjljar","hr","jnajcwexxrrfjr","nqoy","occpvsdztkaaxed","ompbnndrz","hrvlcxhdivzsfczr","kdrifgbzedjkgebmkncaf","nusanfxojc","bqqocfqlfqb","setpahrutcb","ieaydeokkyeponfgektkrbzmqbu","j","deauhiggasqlakj","wdvdwsftvpjgnnzdwlyrifc","xnnnqkoiufokndojrltxlvdzyuvl","hysbvdbzpxkynlytbyzigpghl"};
        String[] list2 = {"rrrxhwzrcwnhziqacxnaqkclhc","skffqmoeigtmbhjorowpg","watjbcislbqxtsdjjynesmjcr","qhekkllakoxowhxtkumdlqah","tanojzphedpveartpatuviytdz","wptswdlxgevpwvxcvgca","ebozyzltyyvso","ytgqrbrcfmtssxwuoge","cwhprmnslqrg","dcrvukliimirqlatbcnycamk","bcykllcdnxq","gcgfnvpygejxeufwzakqk","tuuyyqbvnzgpndzlgofpgn","liqhky","vpzujnnbg","tqbyy","fuwy","ehetcpieebtwpfhwwquxgym","rbwmxxkkackgwdphacwjxgklpg","wuh","bltuzvqovcpqkvkdpjdxlqjngvitt","itazdaycmdhmgcwdvbujc","mlldlzrhnkvn","fxnntxuvtzjrxj","hoycvarfxorryglxwqpoqacydxf","tsxdkbwkeemefphxt","fgbdskgwwlqsachtdxulyeu","ikfrenvyncezi","ufqbqkvftzxpdimbosnevpvioegyxo","fhttwbxhyhsvlcgttqwsqsyk","zqwjmh","mmdmugyenivvvjnxdroom","yhsjgwmjllsrudfukbnxsdl","osnqbnjthsrj","brfiank","wiucubzrmyrxzlawxmjancojode","njbwvgtdglqxsqqaqtbprdnljiu","qarmu","yzifrlsosgbmislwajscskev","rhblxmyvcvqtfjxvxcwfgenz","vhrilo","cqcvqmjjg","zdvsg","kvswexebaauwh","fqeoxaios","uyfzpdscueavwiscedkxw","obsaevyejmtqmlkmkl","kdidyuaxaucosmrswknh","niy","xcdbmnxjhvjtnpwdm","uzrevywuq","luwhgcep","yalxzwhtggtbuaqbwuuaetgnrait","xshwgxnirpqj","ntwfjeeswehcivvuidzqy","navfmxvtqjkjzhsaapdwtisc","cazxdzxoyrdysmy","nrwhervird","tddxvl","ueotplwn","acbwxkk","xyciagxozjwlpfgy","aktuxhgmm","haicnxjqxcmnoslpmrmonoeestz","bmxhyvhdujiccsfkkzbnn","mskyhldvglmzded","yyddi","qmtjolovfw","ihqfcxudusgz","ljdcb","wmkulptxrf","oxntdg","wupdcmvhfdvuyhqjgwhgs","ooulhgmtwlcdjspwjhbgcjjj","moszzezpisgryrzgc","pzjzmspa","cszxtfhbdqsgqlgpykbtknzcjkks","bgltkuiarbhdb","nhozjevsuvlqqnehgzevo","fjxem","cndaozvfekxnnubftc","lnisecfutfgnzqycvugq","ttxjranrrjxcz","hzafnftftzpmukngugnteajmyu","zfs","djm","yvpxvpxkpbsohuwdyadl","hnvimppu","tacjlxsjatbivoqwcevuith","rslmwclfvb","bdabrjqizqnqyikoezvvism","lbwpmxlu","pxbsbjrqgkrfcyqrvurdimoik","mdhpmjpdygxooibkz","ybxqedvccxuecmkkrpepydfydnxc","qkclsskytakdevfpygitwwegcigagb","ppgddkpyl","jpnnvtsgqqzaf","pslrbmbzwfoutyjmehuhmgqmytpj","snfpvacxpenjkctbs","fwufpltgqwsrchetfknwbxvm","fikwhfjoswmowtmxbtv","hmzvwqjuemt","ffltzsnozsvyeukhdqlhxzpaab","mxzcdbimgjpfd","jkkkzfnjsialiyklnksikq","pmpytolckrgwabxluy","trwlohnouze","joaobcrjovryhoufwisu","buwimoyqugaakxqkjqwibpoiht","anltkrafhejphtqiqw","sitwuyog","cylnzu","wkgnxwtsninkho","izrqgltfzyqhvglzbfz","phqgixaccoibqc","znh","iqhoocadkydrgegopbnu","ftp","lwnjmonjqnkmxzw","uqevedymqvtfqrnmsprjbdgkgccu","otbxfh","wydgxjyvsrodwxwfh","hfragmddmouytht","zkwqmtnplgauouozsgyebkpmjteci","yxoyhcptzggrzmyu","sfmsrghezfuoz","jyollfcvsmtgpozeufvpdbxc","xctmropxkwiuytfgqsvwjajkd","pocivhvvujb","qnwosildwmcevrqonmiddlqsehe","avzxjlema","nbtmgzzgx","hjgiqnvgvqomvylmmcsx","cxzccxomgrsynektvuslsyqbqudy","qmvkhndpglcaqproxgaierrcou","fkts","mkcecti","guqwagshmdfmi","otisali","pzpjofsto","byplzduhwdkxk","eh","bhfhppfvwwbabqpnwhpfmhsgfttmvo","awhdnlvbgtfmtyjmjhqanattabq","bjxlyyem","fdtyuii","tohpppvyhrnfsgenzkcyuhrchipu","xlnawcf","mpwcchzmwltjzwlzugvp","jaqhvrrcmkbjkniwb","hpbfnc","alnovitn","eschfntmiyzizha","fpfldwykwzijsalrhieziyuehyvrpe","kjasvtqectf","luyklsfviumoeeqru","fpivruscece","sqiksa","ikt","trdsm","ptxcckitsmvuijydvpoynzsrzp","zavb","vzwernunydzbo","abqcpszzuqlnkpppkhoorp","oipwtanacy","comwoy","dpfydlddkbnatclczppyw","paa","wdrdq","nrgdiqgxlrso","hlkqnsbtuelpryvusfvyygcwmud","rmxptpepkjicbywuymnvxs","hz","ewxhoyzwzqxjshtaoryy","cxlnbdvc","atpfcgrhfpxeihkqncibo","mz","hhyibvkdyuagxwyuimxztyr","dnzemkmqcvzskjouumzgqvilea","cdanixtwtflxk","sgvx","vtbxvswgdienmqnf","re","moqgrxislwlanrjizovxvzwapbxuz","oyfhhv","yvpqfu","zfldwkstrgorpc","attyxyextwzlj","eemnjvrjdxoanjb","ghdln","rdpmtypffhfowhqeyubqwbpuvziovw","xzbyqtkmc","ifgrocvnyfsrnkyhowwfhkbzb","cqltzevqadchidajxctf","acidqfbbb","rzpapb","oeqywylzmlnlmhscofrl","rtdonwwyqvlgflykuwxlwdnw","ltdjahxwczkdodphlgufrkw","ppsnbsbvsrrwctluajnxgdwslc","hjwbpbfindwvqnbehqtwkxiabk","dgsbvybw","czjhdmistyuy","zejg","kfjylqvusojuolroiracdt","bysgsemvopnorpotcjlhqcnh","ggsvazmeg","oinppuzvjyormujxzvfvrppbjyn","spwthjrsjh","pgwewdntziklmwrpjumvahunhqc","yhhrnzijqelnx","qhedtojghefacw","dykpmowtpwsqalp","ahknmkpnzuxbrnvck","ft","buxnmcgznlhpvbuh","lej","djzibdgbfpwnbjinc","qatyhdqnyninixvrpraw","tyzsuebbckskhctvfj","fjwnvzgn","eifmowxolektexeihpjbcpbqqaznd","jauhsgomoozvlgablktplhxjawi","jnkopotquicybhdxqbkkgfisjrlv","ymzxaebzcdsa","mewcps","btehbwlcfmarlpl","tdkbctmnjhtdmnmlskfaay","fzntnnabzmlugvemfkwwus","gl","jcjxetg","mglvkesccwaaaqa","iwlzpeb","obratnpixhujeuabzfivuwsfp","qcxsyzotyhxc","ccyvr","nnxrem","kpjhhpxflwxzc","wdctqqxciwxyumrshhyczvmb","tcpoqcgwzi","engezwexncztzdy","hsvbveukevuv","bpobal","ujveggtyxojmnwddaqihrc","sloc","vunlgcfqtbiakyqgu","bxanhd","gbp","mujkunzypmbtzvqtqi","agvjgnu","zxkb","lrfdxgrunsokyeocxmexy","maiovvnf","efc","xlmloganmowvpqxppdyecfz","rjogfjcynnpxbarecesy","bjuupvcblwldttnzqyeap","mznaafxyrqsyhckbmzqdkxgfcsiui","osdqjaszmpucuhwjxzeszve","tilijej","lelrgutogwzsmpyvt","joah","robmunpotcbyhvlnjltmiythdx","wgcqurlsqgxgjgauceqetmyvq","fslzqncuhzjzlieasqhkpznrmkh","leeqgvpr","mqzbuhimuyipob","effrkkwjwjsvnja","ularwtwgzi","et","tibttiomxmyhmevjeqorf","pqdyjogdimhnyolejh","yyiqlst","zfjjhgoozynwddzgd","cundckoxfuiissmvgv","nhqbmxuzlhzxevp","dfpvgbioagcdhl","bbsckfoyuxcik","zcohk","aayccgqbrrkzzno","xj","rnryhziim","lisrnfqctwukuzmbfpe","gauljxfsqvdzsvzfhqluki","obcmrfmkzqbpjuca","jwzjtvphjweodtd","csshbiyg","ciatyjinyf","js","gghuyafezh","tzpvetdkclid","tqunekuplwwy","btiuocmuqzdoladrgrdlbvtijcc","ikjxsopkhi","gkevp","nojdmsywgcfbmbmxlhabtn","aiefgqlvnzbbfhkgc","bmklzebhaptrtzcyqivib","acanttziyjgt","twbbtzciecbosenkznq"};
        FindRestaurant restaurant = new FindRestaurant();
        String[] restaurant1 = restaurant.findRestaurant(list1, list2);
        System.out.println(Arrays.toString(restaurant1));


    }
}

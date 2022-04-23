package day03;

import com.sun.corba.se.impl.orbutil.graph.GraphImpl;

import java.util.*;

/**
 * 版本一：空间复杂度高
 */
//
//public class GridIllumination {
//    /**
//     * 对lamps去重
//     * @param matric
//     * @return
//     */
//    public int[][] Deduplication(int[][] matric){
//        //用来记录去除重复之后的数组长度和给临时数组作为下标索引
//        int t = 0;
//        //临时数组
//        int[][] tempArr = new int[matric.length][matric[0].length];
//        //遍历原数组
//        for(int i = 0; i < matric.length; i++){
//            //声明一个标记，并每次重置
//            boolean isTrue = true;
//            //内层循环将原数组的元素逐个对比
//            for(int j=i+1;j<matric.length;j++){
//                //如果发现有重复元素，改变标记状态并结束当次内层循环
//                if(Arrays.equals(matric[i],matric[j])){
//                    isTrue = false;
//                    break;
//                }
//            }
//            //判断标记是否被改变，如果没被改变就是没有重复元素
//            if(isTrue){
//                //没有元素就将原数组的元素赋给临时数组
//                tempArr[t] = matric[i];
//                //走到这里证明当前元素没有重复，那么记录自增
//                t++;
//            }
//        }
//        //声明需要返回的数组，这个才是去重后的数组
//        int[][]  newArr = new int[t][matric[0].length];
//        //用arraycopy方法将刚才去重的数组拷贝到新数组并返回
//        System.arraycopy(tempArr,0,newArr,0,t);
//        return newArr;
//    }
//    /**
//     * 判断二维数组是否含有某个一维数组
//     * @param matric
//     * @param query
//     * @return
//     */
//    public boolean MatricContainList(int[][] matric, int[] query){
//        for (int[] list: matric){
//            if (Arrays.equals(list, query)){
//                return true;
//            }
//        }
//        return false;
//    }
//
//    /**
//     * 关闭已经被查询的灯
//     * @param matric
//     * @param query
//     * @return
//     */
//    public int[][] MatricDelete(int[][] matric, int[] query){
//        int[][] newMatric = new int[matric.length-1][matric[0].length];
//        int i = 0;
//        for (int[] list: matric){
//            if (Arrays.equals(list, query)){
//                continue;
//            }
//            newMatric[i] = list;
//            i++;
//        }
//        return newMatric;
//    }
//
//    /**
//     * 开灯函数
//     * @param n
//     * @param ground
//     * @param site
//     * @return
//     */
//    public int[][] OpenLmap(int n, int[][] ground, int[] site){
//        ground[site[0]][site[1]] = ground[site[0]][site[1]] + 1;
//        for (int i = 1; i < n; i++) {
//            boolean flag = false;
//            if (site[0]+i<n && site[1]-i>=0){
//                ground[site[0]+i][site[1]-i] = ground[site[0]+i][site[1]-i] + 1;
//                flag = true;
//            }
//            if (site[0]-i>=0 && site[1]+i<n){
//                ground[site[0]-i][site[1]+i] = ground[site[0]-i][site[1]+i] + 1;
//                flag = true;
//            }
//            if (site[0]-i>=0 && site[1]-i>=0){
//                ground[site[0]-i][site[1]-i] = ground[site[0]-i][site[1]-i] + 1;
//                flag = true;
//            }
//            if (site[0]+i<n && site[1]+i<n){
//                ground[site[0]+i][site[1]+i] = ground[site[0]+i][site[1]+i] + 1;
//                flag = true;
//            }
//            if (site[0]+i<n){
//                ground[site[0]+i][site[1]] = ground[site[0]+i][site[1]] + 1;
//                flag = true;
//            }
//            if (site[0]-i>=0){
//                ground[site[0]-i][site[1]] = ground[site[0]-i][site[1]] + 1;
//                flag = true;
//            }
//            if (site[1]-i>=0){
//                ground[site[0]][site[1]-i] = ground[site[0]][site[1]-i] + 1;
//                flag = true;
//            }
//            if (site[1]+i<n){
//                ground[site[0]][site[1]+i] = ground[site[0]][site[1]+i] + 1;
//                flag = true;
//            }
//            if (!flag){
//                break;
//            }
//        }
//        return ground;
//    }
//
//    /**
//     * 关灯函数
//     * @param n
//     * @param ground
//     * @param site
//     * @return
//     */
//    public int[][] CloserLmap(int n, int[][] ground, int[] site){
//        ground[site[0]][site[1]] = ground[site[0]][site[1]] - 1;
//        for (int i = 1; i < n; i++) {
//            boolean flag = false;
//            if (site[0]+i<n && site[1]-i>=0){
//                ground[site[0]+i][site[1]-i] = ground[site[0]+i][site[1]-i] - 1;
//                flag = true;
//            }
//            if (site[0]-i>=0 && site[1]+i<n){
//                ground[site[0]-i][site[1]+i] = ground[site[0]-i][site[1]+i] - 1;
//                flag = true;
//            }
//            if (site[0]-i>=0 && site[1]-i>=0){
//                ground[site[0]-i][site[1]-i] = ground[site[0]-i][site[1]-i] - 1;
//                flag = true;
//            }
//            if (site[0]+i<n && site[1]+i<n){
//                ground[site[0]+i][site[1]+i] = ground[site[0]+i][site[1]+i] - 1;
//                flag = true;
//            }
//            if (site[0]+i<n){
//                ground[site[0]+i][site[1]] = ground[site[0]+i][site[1]] - 1;
//                flag = true;
//            }
//            if (site[0]-i>=0){
//                ground[site[0]-i][site[1]] = ground[site[0]-i][site[1]] - 1;
//                flag = true;
//            }
//            if (site[1]-i>=0){
//                ground[site[0]][site[1]-i] = ground[site[0]][site[1]-i] - 1;
//                flag = true;
//            }
//            if (site[1]+i<n){
//                ground[site[0]][site[1]+i] = ground[site[0]][site[1]+i] - 1;
//                flag = true;
//            }
//            if (!flag){
//                break;
//            }
//        }
//        return ground;
//    }
//
//    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
//        // 初始化空点
//        int[] res = new int[queries.length];
//        int[][] ground = new int[n][n];
//        // 对lamps去重
//        lamps = Deduplication(lamps);
//        // 点燃灯
//        for(int[] lamp: lamps){
//            ground = OpenLmap(n, ground, lamp);
//        }
//        // 查询
//        int i =0;
//        for (int[] query: queries){
//            if (ground[query[0]][query[1]] > 0){
//                res[i] = 1;
//            }else {
//                res[i] = 0;
//            }
//            // 对于关灯操作，倘若四周没有点燃的灯，那么就不需要对四周关灯
//            if (MatricContainList(lamps, query)){
//                lamps = MatricDelete(lamps, query);
//                ground = CloserLmap(n, ground, query);
//            }
//            // 其他八个方向
//            if (query[0]+1<n && query[1]-1>=0 && MatricContainList(lamps, new int[]{query[0]+1,query[1]-1})){
//                lamps = MatricDelete(lamps, new int[]{query[0]+1,query[1]-1});
//                ground = CloserLmap(n, ground, new int[]{query[0]+1,query[1]-1});
//            }
//            if (query[0]-1>=0 && query[1]+1<n && MatricContainList(lamps, new int[]{query[0]-1,query[1]+1})){
//                lamps = MatricDelete(lamps, new int[]{query[0]-1,query[1]+1});
//                ground = CloserLmap(n, ground, new int[]{query[0]-1,query[1]+1});
//            }
//            if (query[0]-1>=0 && query[1]-1>=0 && MatricContainList(lamps, new int[]{query[0]-1,query[1]-1})){
//                lamps = MatricDelete(lamps, new int[]{query[0]-1,query[1]-1});
//                ground = CloserLmap(n, ground, new int[]{query[0]-1,query[1]-1});
//            }
//            if (query[0]+1<n && query[1]+1<n && MatricContainList(lamps, new int[]{query[0]+1,query[1]+1})){
//                lamps = MatricDelete(lamps, new int[]{query[0]+1,query[1]+1});
//                ground = CloserLmap(n, ground, new int[]{query[0]+1,query[1]+1});
//            }
//            if (query[0]+1<n && MatricContainList(lamps, new int[]{query[0]+1,query[1]})){
//                lamps = MatricDelete(lamps, new int[]{query[0]+1,query[1]});
//                ground = CloserLmap(n, ground, new int[]{query[0]+1,query[1]});
//            }
//            if (query[0]-1>=0 && MatricContainList(lamps, new int[]{query[0]-1,query[1]})){
//                lamps = MatricDelete(lamps, new int[]{query[0]-1,query[1]});
//                ground = CloserLmap(n, ground, new int[]{query[0]-1,query[1]});
//            }
//            if (query[1]-1>=0 && MatricContainList(lamps, new int[]{query[0],query[1]-1})){
//                lamps = MatricDelete(lamps, new int[]{query[0],query[1]-1});
//                ground = CloserLmap(n, ground, new int[]{query[0],query[1]-1});
//            }
//            if (query[1]+1<n && MatricContainList(lamps, new int[]{query[0],query[1]+1})){
//                lamps = MatricDelete(lamps, new int[]{query[0],query[1]+1});
//                ground = CloserLmap(n, ground, new int[]{query[0],query[1]+1});
//            }
//            i++;
//        }
//        return res;
//    }
//
//    public static void main(String[] args) {
//        int n = 6;
//        int[][] lamps = {{2,5},{4,2},{0,3},{0,5},{1,4},{4,2},{3,3},{1,0}};
//        int[][] queries = {{4,3},{3,1},{5,3},{0,5},{4,4},{3,3}};
////        int n = 5;
////        int[][] lamps = {{0,0},{0,1},{0,4}};
////        int[][] queries = {{0,0},{0,1},{0,2}};
//        GridIllumination g = new GridIllumination();
//        int[] result = g.gridIllumination(n, lamps, queries);
//        System.out.println(Arrays.toString(result));
//    }
//}

public class GridIllumination {
    /**
     * 生成hash数
     * @param x
     * @param y
     * @return
     */
    public long hash(int x, int y){
        return (long) x + ((long) y<<32);
    }

    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        Map<Integer,Integer> row = new HashMap<>();
        Map<Integer,Integer> col = new HashMap<>();
        Map<Integer,Integer> mainDiagonal = new HashMap<>();
        Map<Integer,Integer> subDiagonal = new HashMap<>();
        Set<Long> lampsSet = new HashSet<>();
        // 点灯
        for (int[] lamp: lamps){
            if (!lampsSet.add(hash(lamp[0], lamp[1]))){
                continue;
            }
            row.put(lamp[0], row.getOrDefault(lamp[0], 0) + 1);
            col.put(lamp[1], col.getOrDefault(lamp[1], 0) + 1);
            mainDiagonal.put(lamp[0]-lamp[1], mainDiagonal.getOrDefault(lamp[0]-lamp[1], 0) + 1);
            subDiagonal.put(lamp[0]+lamp[1],subDiagonal.getOrDefault(lamp[0]+lamp[1], 0)+1);
        }

        // 查询
        int[] res = new int[queries.length];
        for (int i=0; i < queries.length; i++){
            int r = queries[i][0];
            int c = queries[i][1];
            if (row.getOrDefault(r, 0)>0){
                res[i] = 1;
            }else if (col.getOrDefault(c, 0)>0){
                res[i] = 1;
            }else if (mainDiagonal.getOrDefault(r - c, 0)>0){
                res[i] = 1;
            }else if (subDiagonal.getOrDefault(r + c, 0)>0){
                res[i] = 1;
            }

            for (int s=r-1;s<r+2;s++){
                for (int k=c-1;k<c+2;k++){
                    if (s<0 || k<0 || s>=n || k>=n){
                        continue;
                    }
                    if (lampsSet.remove(hash(s,k))){
                        row.put(s, row.get(s)-1);
                        if (row.get(s)<=0){
                            row.remove(s);
                        }
                        col.put(k, col.get(k)-1);
                        if (col.get(k)<=0){
                            col.remove(k);
                        }
                        mainDiagonal.put(s-k,mainDiagonal.get(s-k)-1);
                        if (mainDiagonal.get(s-k)<=0){
                            mainDiagonal.remove(s-k);
                        }
                        subDiagonal.put(s+k,subDiagonal.get(s+k)-1);
                        if (subDiagonal.get(s+k)<=0){
                            subDiagonal.remove(s+k);
                        }
                    }

                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] lamps = {{2,5},{4,2},{0,3},{0,5},{1,4},{4,2},{3,3},{1,0}};
        int[][] queries = {{4,3},{3,1},{5,3},{0,5},{4,4},{3,3}};
//        int n = 5;
//        int[][] lamps = {{0,0},{0,1},{0,4}};
//        int[][] queries = {{0,0},{0,1},{0,2}};
        GridIllumination g = new GridIllumination();
        int[] result = g.gridIllumination(n, lamps, queries);
        System.out.println(Arrays.toString(result));
    }
}

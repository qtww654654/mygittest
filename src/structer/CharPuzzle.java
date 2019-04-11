package structer;

/**
 * Created by Administrator on 2019/3/23.
 */
/**
 * 输入时一些字母和单次，输出是找出这些单次
 * 可以横竖斜，方向任意
 **/
public class CharPuzzle {
    public static void main(String[] args) {
        char[][]a=createTwoDimensionalArray();
        String[] d=dictionary();
        findWord(d, a);
    }

    /**
      * 生成row行，col列的二维数组
      *
     **/
    public static char[][] createTwoDimensionalArray(){
        char[][] a = {{'t','h','i','s'},{'w','a','t','s'},{'o','a','h','g'},{'f','g','d','t'}};
        return a;
    }

    /**
     * 字典
     * @return 字典表
     */
    public static String[] dictionary(){
        String [] d={"this","two","fat","that"};
        return d;
    }

    /**
     *
     * @param d 字典表
     * @param a 字谜数组
     */
    public static void findWord(String[] d,char[][] a){
        ////挨个循环查找词板里的单词
        for (int i = 0; i < d.length ; i++) {
            String word = d[i];
            //确定每个单词长度
            int len = word.length();
            //单词的第一个字符
            char firstc = word.charAt(0);
            //遍历二维数组
            for (int j = 0; j < a.length ; j++) {
                for (int k = 0; k < a[j].length ; k++) {
                    //比较首字母，相等则继续判断，否则退出本次循环
                    if(a[j][k] == firstc){
                        compareLength(len,a,j,k,word,len);
                    }else{
                        continue;
                    }
                }
            }
        }
    }

    /**
     *
     * @param lenth 字典表单词长度
     * @param a 字谜二维数组
     * @param j 二维数组行下表
     * @param k 二维数组列下表
     * @param word 字典表单词
     * @param len 字典表单词长度
     * 二维数组中
     * 数组名.length指示数组的行数。
     * 数组名[行下标] .length指示该行中的元素个数。
     */
    public static void compareLength(int lenth,char[][]a,int j,int k,String word,int len){
        //正横，负横，正竖，负竖，斜右上，斜右下，斜左上，斜左下
        // 加上当前字母，往不同方向可以组成的字母串的最大长度
        int [] lenths = new int[8];
        //a[0].length 表示第一行元素个数
        //向右 每一行的长度减去列下标
        lenths[0] = a[0].length - k;
        //向左 为列下标+1
        lenths[1] = k + 1;
        //向上 为行下标+1
        lenths[2] = j + 1;
        //a.length 表示二维数组行数
        //向下 数组行数 - 行下标
        lenths[3] = a.length - j;
        // 斜右上  长度要么是行下标+1 要么是a[0].lemgth-k
        //判断 行下标+1 与 a[0].lemgth-k 的大小即可
        lenths[4] = j + 1 < a[0].length - k ? j + 1:a[0].length - k;
        // 斜右下  长度为a.length - j 或者是 a[0].length - k
        //比较 a.length - j 与 a[0].length - k 长度即可
        lenths[5] = a.length - j < a[0].length - k ? a.length - j : a[0].length - k;
        //斜左上 长度为j+1 或者 k+1
        lenths[6] = j + 1 < k + 1 ? j + 1: k + 1;
        // 斜左下  长度为k+1 或者 a.length-i
        //比较 k+1 和 a.length-j 大小即可
        lenths[7] = k + 1 < a.length - j ? k + 1:a.length - j;
        //单词的长度和各个方向的最大长度进行比较
        for (int i = 0; i <lenths.length ; i++) {
            //如果单词长度小于等于方向上最大长度，继续进行比较
            //否则，退出本次循环
            if(lenths[i] >= lenth){
                compareWord(i,a,j,k,word,len);
            }else{
                continue;
            }
        }
    }

    /**
     *
     * @param x 方向
     * @param a 二维数组字谜
     * @param j 二维数组行下表
     * @param k 二维数组列下表
     * @param word 字典表单词
     * @param len 单词长度
     */
    public static void  compareWord(int x,char[][] a,int j ,int k, String word,int len){
        String newStr = "";
        switch (x){
            //向右
            case 0:
                for (int i = 0; i < len; i++) {
                   newStr += String.valueOf(a[j][k + i]);
                }
                if(word.equals(newStr)){
                    System.out.println(word+"位置：（"+j + "," + k + ")至("+ j + "," + (k + len -1) + ")");
                }
                break;
            //向左
            case 1:
                for (int i = 0; i < len; i++) {
                    newStr += String.valueOf(a[j][k - i]);
                }
                if(word.equals(newStr)){
                    System.out.println(word+"位置：("+j+","+ k+")至("+j+","+(k-len+1)+")");
                }
                break;
            //向上
            case 2:
                for (int i = 0; i < len ; i++) {
                    newStr += String.valueOf(a[j-k][k]);
                }
                if(word.equals(newStr)){
                    System.out.println(word+"位置：("+j+","+ k+")至("+(j-len+1)+","+k+")");
                }
                break;
            //向下
            case 3:
                for (int i = 0; i < len; i++) {
                    newStr+=String.valueOf(a[j+i][k]);
                }
                if(word.equals(newStr)){
                    System.out.println(word+"位置：("+j+","+ k+")至("+(j+len-1)+","+k+")");
                }
                break;
            // 斜右上
            case 4:
                for (int i = 0; i < len; i++) {
                    newStr+=String.valueOf(a[j-i][k+i]);
                }
                if(word.equals(newStr)){
                    System.out.println(word+"位置：("+j+","+ k+")至("+(j-len+1)+","+(k+len-1)+")");
                }
                break;
            // 斜右下
            case 5:
                for (int i = 0; i < len; i++) {
                    newStr+=String.valueOf(a[j+i][k+i]);
                }
                if(word.equals(newStr)){
                    System.out.println(word+"位置：("+j+","+ k+")至("+(j+len-1)+","+(k+len-1)+")");
                }
                break;
            // 斜左上
            case 6:
                for (int i = 0; i < len; i++) {
                    newStr+=String.valueOf(a[j-i][k-i]);
                }
                if(word.equals(newStr)){
                    System.out.println(word+"位置：("+j+","+ k+")至("+(j-len+1)+","+(k-len+1)+")");
                }
                break;
            //斜左下
            case 7:
                for (int i = 0; i < len; i++) {
                    newStr+=String.valueOf(a[j+1][k-i]);
                }
                if(word.equals(newStr)){
                    System.out.println(word+"位置：("+j+","+ k+")至("+(j+len-1)+","+(k-len+1)+")");
                }
                break;
            default:
                break;
        }
    }

}

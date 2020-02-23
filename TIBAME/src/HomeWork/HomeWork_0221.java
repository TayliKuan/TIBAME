package HomeWork;

public class HomeWork_0221 {

    public static void main(String[] args) {
        even1to1000Sum();
        for1to10Multiply();
        while1to10Multiply();
        printLineNum();
        lottoExclude4();
        printTriangleNum();
        printEnglishWords();
    }

    public static void even1to1000Sum() {
        System.out.println("Q1.計算1～1000的偶數和 (2+4+6+8+…+1000)");
        int sum = 0;
        for (int i = 0; i <= 1000; i += 2) {
            sum = sum + i;
        }
        System.out.println("Ans=" + sum);
        System.out.println("===========================================");
    }

    public static void for1to10Multiply() {
        System.out.println("Q2.計算1～10的連乘積 (1*2*3*…*10) (用for迴圈)");
        int ans = 1;
        for (int i = 1; i <= 10; i++) {
            ans = ans * i;
        }
        System.out.println("Ans=" + ans);
        System.out.println("===========================================");
    }

    public static void while1to10Multiply() {
        System.out.println("Q3.計算1～10的連乘積 (1*2*3*…*10) (用while迴圈)");
        int i = 1;
        int ans = 1;
        while (i <= 10) {
            ans = ans * i;
            i++;
        }
        System.out.println("Ans=" + ans);
        System.out.println("===========================================");
    }

    public static void printLineNum() {
        System.out.println("Q4.輸出結果為以下：1 4 9 16 25 36 49 64 81 100");
        int num = 0;
        System.out.print("Ans=");
        for (int i = 1; i <= 20; i += 2) {//要印出10個數 每次加2 所以<=20
            num = num + i;
            System.out.print(num + " ");
        }
        System.out.println("\n" + "===========================================");
    }

    public static void lottoExclude4() {
        System.out.println("Q5.大樂透 (1 ～ 49)，不要4個位十位數字，可以選擇的數字有哪些？總共有幾個？");
        //要 1-39數字 跟扣掉4.14.24.34
        int num = 1;
        int count = 0;
        for (int i = 1; i < 40; i++) {
            if (i == 4 || i == 14 || i == 24 || i == 34) {
                continue;
            }
            num = i;
            count++;
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("總共有" + count + "個");
        System.out.println("===========================================");
    }

    public static void printTriangleNum() {
        System.out.println("Q6.輸出數字倒三角");
        int i, j;
        for (i = 10; i > 0; i--) {//次數
            for (j = 1; j <= i; j++) {//值
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println("===========================================");
    }

    public static void printEnglishWords() {
        System.out.println("Q7.輸出結果為以下：");
//        int A = 'A';
//        System.out.println(A); //65
//        int F = 'F';
//        System.out.println(F); //70
        int i, j;
        for (i = 65; i <= 70; i++) {//值
            for (j = 65; j <= i; j++) {//次數
                System.out.print((char) i);
            }
            System.out.println();
        }
    }
}

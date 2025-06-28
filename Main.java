import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * 0から9までのカウントダウン中に「STOP」を入力すると、カウントダウンを停止する
 */
class Main {
    public static void main(String[] args) {
        // singleThreadProcess();
        multiThreadProcessProcess();
    }

    /**
     * カウントダウン中に入力はできない処理
     */
    private static void singleThreadProcess() {
        System.out.println("止めるには「STOP」を入力してください");
        System.out.println("カウントダウンを開始します");

        // 9から0までカウントする
        for (int i = 9; i >= 0; i--) {
            System.out.print(i + "..");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                ;
            }
        }
        // カウントダウン後にしか入力が可能にならない
        String input = new Scanner(System.in).nextLine();
        System.out.println("入力文字列：" + input);
    }

    /**
     * カウントダウン中に入力はできない処理
     */
    private static void multiThreadProcessProcess() {
        System.out.println("止めるには「STOP」を入力してください");
        System.out.println("カウントダウンを開始します");

        // カウントダウンする別スレッドのインスタンス化
        Thread t = new PrintingThread();
        // 別スレッドをstartし、runを呼び出す
        t.start();

        String input = new Scanner(System.in).nextLine();
        System.out.println("入力文字列：" + input);
        System.out.println("※停止処理は未作成です");
    }
}
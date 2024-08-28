import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Numeron {

  public static void main(String[] args) {
    // ランダムに3桁の数字を生成する
    List<Integer> answer = new ArrayList<>();
    Random rand = new Random();
    while (answer.size() < 3) {
      int num = rand.nextInt(10);
      if (!answer.contains(num)) {
        answer.add(num);
      }
    }

    int turn = 0;

    // 入力を受け付ける
    Scanner scanner = new Scanner(System.in);
    System.out.println("3桁の数字を入力してください");

    while (turn<7) {
      // 入力された数字をリストに変換する
      List<Integer> input = new ArrayList<>();
      String inputStr = scanner.next();
      for (int i = 0; i < inputStr.length(); i++) {
        int num = Character.getNumericValue(inputStr.charAt(i));
        input.add(num);
      }

      // eat, biteを計算する
      int eat = 0;
      int bite = 0;
      for (int i = 0; i < answer.size(); i++) {
        if (answer.get(i).equals(input.get(i))) {//位置と数字が完全一致
          eat++;
        } else if (answer.contains(input.get(i))) { // 数字のみ一致
          bite++;
        }
      }

      // eat, biteを表示する
      if (eat == 3) { // 正解の場合
        System.out.println("おめでとうございます！正解です！");
        break;
      } else { // 不正解の場合
        System.out.println("eat：" + eat + " bite：" + bite);
        turn++;
      }

      
    }
    // 答えを表示する
      System.out.println("答え：" + answer.get(0) + answer.get(1) + answer.get(2));
  }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//숫자는 최대 10까지만 있다고 가정..
public class Main2 {
    public static void main(String[] args) {
        int[] arr = new int[] {1 ,4 ,6 ,9 , 3, 4, 4, 1, 9, 8, 7, 2};
        List<Integer> list = new ArrayList<>();
        int[] ch = new int[11];

        for (int i = 0; i < arr.length; i++) {
            if (ch[arr[i]] != 1) {
                ch[arr[i]] = 1;
                list.add(arr[i]);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) > list.get(j)) {
                    int tmp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, tmp);
                }
            }
        }

        for (int i : list) System.out.print(i + " ");
    }
}

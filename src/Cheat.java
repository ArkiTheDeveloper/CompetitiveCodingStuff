import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cheat {

    static ArrayList<Integer> performOps(ArrayList<Integer> A) {
        ArrayList<Integer> B = new ArrayList<Integer>();
        for (int i = 0; i < 2 * A.size(); i++) B.add(0);
        for (int i = 0; i < A.size(); i++) {
            B.set(i, A.get(i));
            B.set(i + A.size(), A.get((A.size() - i) % A.size()));
        }
        return B;
    }


    public static void main(String[] args) {

        List<Integer> a = Arrays.asList(1,2,3,4);
        List<Integer> b = Arrays.asList(5,6,7,8);
        List<Integer> c = Arrays.asList(9,10,11,12);

        List<List<Integer>> x = new ArrayList<>();
        x.add(a);
        x.add(b);
        x.add(c);
        //ArrayList<Integer> B = performOps();
       /* for (int i = 0; i < B.size(); i++) {
            System.out.print(B.get(i) + " ");
        }*/

    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrixPrinting {

    public static ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {

        ArrayList<Integer> x = new ArrayList<>();

        int rowSize = A.size();
        int colSize = A.get(0).size();

        int dir = 0;

        int T = 0, B = rowSize - 1, L = 0, R = colSize - 1;

        while (T <= B || L <= R) {
            //L --> R
            if (dir == 0 && T<=B) {
                for (int k=L; k<=R; k++) {
                    x.add(A.get(T).get(k));
                }
                    T++;
            }
            if (dir == 1) {
                for (int k=T; k<=B; k++) {
                    x.add(A.get(k).get(R));
                }
                    R--;
            }
            if (dir == 2 && B >= T) {
                for (int k=R; k>=L; k--) {
                    x.add(A.get(B).get(k));
                }
                    B--;
            }
            if (dir == 3) {
                for (int k=B; B>=T; B--) {
                    x.add(A.get(k).get(L));
                }
                    L++;
            }

            dir = (dir + 1) % 4;
        }
        return x;
    }

    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        ArrayList<Integer> arrayList3 = new ArrayList<>();
        arrayList.add(2);
        arrayList.add(3);
        arrayList2.add(4);
        arrayList2.add(5);
        arrayList3.add(6);
        arrayList3.add(7);


        List<ArrayList<Integer>> x = new ArrayList<>();
        x.add(arrayList);
        x.add(arrayList2);
        x.add(arrayList3);
        ArrayList<Integer> B = spiralOrder(x);
        for (Integer aB : B) {
            System.out.print(aB + " ");
        }

    }
}

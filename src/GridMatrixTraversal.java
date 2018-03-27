import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GridMatrixTraversal {

    public static int coverPoints(List<Integer> a, List<Integer> b) {
        int cpx = a.get(0);
        int cpy = b.get(0);

        int totalMoves = 0;
        int i = 1;

        int iI = a.size() -1;

        while(i <= iI) {
            int npx = a.get(i);
            int npy = b.get(i);

            int xd = Math.abs(npx - cpx);
            int yd = Math.abs(npy - cpy);

            int rd = Math.max(xd, yd);
            totalMoves += rd;

            cpx = npx;
            cpy = npy;

            i++;

            System.out.println(cpx +" "+ cpy);
        }


        return totalMoves;
    }

    public static void main(String[] args) {

        List<Integer> a = Arrays.asList(1,2);
        List<Integer> b = Arrays.asList(5,6);
        List<Integer> c = Arrays.asList(9,10,11,12);

        List<Integer> A = Arrays.asList(4, 8, -7, -5, -13, 9, -7, 8);
        List<Integer> B = Arrays.asList(4, -15, -10, -3, -13, 12, 8, -8);


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
        int result = coverPoints(A, B);
        System.out.println(result);
    }
}

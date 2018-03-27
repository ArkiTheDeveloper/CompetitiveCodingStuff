public class AllPossibleBST {

    public static void compute(int a[]) {
        int sum = 0;
        for (int i=0; i<a.length; i++) {
            sum += computeBST(a, i);
        }
        System.out.println(sum);
    }

    private static int computeBST(int[] a, int elIn) {
        if (a.length == 0 || a.length == 1)
            return a.length;

        int la[] = buildArray(a, elIn, true);
        int ra[] = buildArray(a, elIn, false);

        int ls = 0; int rs = 0;
        for (int i=0; i< la.length; i++) {
            int x =computeBST(la, i);
            //System.out.println("Received LA sum="+ x + " for element=" + la[i]);
            ls += x;
        }
        for (int i=0; i<ra.length; i++) {
            int x = computeBST(ra, i);
            //System.out.println("Received RA sum="+ x + " for element=" + ra[i]);
            rs += x;
        }

        if (ls == 0) {
            return rs;
        } else if (rs == 0){
            return ls;
        }
        return ls * rs;
    }

    private static int[] buildArray(int[] a, int elIn, boolean isLeft) {
        if (isLeft) {
            if (elIn == 0) {
                return new int[0];
            }
            int arrayToReturn[] = new int[elIn];
            for (int i=0; i<elIn; i++) {
                arrayToReturn[i] = a[i];
            }
            return arrayToReturn;
        } else {
            if (elIn == a.length -1) {
                return new int[0];
            }
            int arrayToReturn[] = new int[(a.length -1) - elIn];
            int counter =0;
            for (int i=elIn + 1; i<a.length; i++) {
                arrayToReturn[counter++] = a[i];
            }
            return arrayToReturn;
        }
    }

    public static void main(String[] args) {
        int a[] = new int[] {1, 2, 3, 4, 6, 7, 8, 9, 5};
        compute(a);
    }
}

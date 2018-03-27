import java.util.ArrayList;
import java.util.List;

public class MaxSubArray {

    public static List<Integer> getMaxSubArray(List<Integer> list) {
        List<List<Integer>> subArrays = new ArrayList<>();
        List<Integer> preList = new ArrayList<>();
        for (Integer num : list) {
           if (num < 0) {
                subArrays.add(getAllItems(preList));
           } else {
               addToList(num, preList);
           }
        }
        subArrays.add(preList);

        List<List<Integer>> maxSubList = new ArrayList<>();

        Long maxSum = 0L;

        for (List<Integer> subList : subArrays) {
            Long sum = 0L;
            for (Integer value : subList) {
                sum += value;
            }
            if (sum > maxSum) {
                maxSum = sum;
                maxSubList.clear();
                maxSubList.add(subList);
            } else if (sum.equals(maxSum)) {
                maxSum = sum;
                maxSubList.add(subList);
            }
        }

        List<List<Integer>> maxSubList2 = new ArrayList<>();
        int maxSize = 0;
        if (maxSubList.size() == 1) {
            return maxSubList.get(0);
        } else {
            for (List<Integer> subList : maxSubList) {
                if (maxSize < subList.size()) {
                    maxSize = subList.size();
                    maxSubList2.clear();
                    maxSubList2.add(subList);
                } else if (maxSize == subList.size()) {
                    maxSubList2.add(subList);
                }
            }
        }

        if (maxSubList2.size() == 1) {
            return maxSubList2.get(0);
        } else {
             return maxSubList2.get(0);
        }
    }

    private static List<Integer> getAllItems(List<Integer> preList) {
        List<Integer> newList = new ArrayList<>(preList);
        preList.clear();
        return newList;
    }

    private static void addToList(Integer num, List<Integer> preList) {
        preList.add(num);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1967513926);
        arrayList.add(1540383426);
        arrayList.add(-1303455736);
        arrayList.add(-521595368);
        List<Integer> maxSubArray = getMaxSubArray(arrayList);
        for (Integer max : maxSubArray) {
            System.out.println(max);
        }
    }
}

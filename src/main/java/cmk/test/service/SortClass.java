package cmk.test.service;

import java.util.HashSet;
import java.util.Set;

public class SortClass {
    public void sortArray() {
        int[] intArray = new int[]{12,45,223,56,77,14,55,33};
        int min = 0;
        Set<Integer> integerSet = new HashSet<Integer>();
        for (int i : intArray) {
            integerSet.add(i);
        }
        System.out.print(integerSet.toArray(new Integer[0]));
    }

}

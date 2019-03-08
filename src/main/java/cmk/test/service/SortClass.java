package cmk.test.service;

import com.sun.deploy.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

public class SortClass {


    public static void main(String[] args) {
        SortClass sortClass = new SortClass();
        sortClass.sortArray();
    }

    public void sortArray() {
        int[] intArray = new int[]{12,45,223,56,77,14,55,33};
        String [] strings = new String[]{"1", "2", "3"};
        int min = 0;
        Set<Integer> integerSet = new HashSet<Integer>();
        Set<String> stringSet = new HashSet<String>();
        for (int i : intArray) {
            integerSet.add(i);
        }
        for (String string : strings) {
            stringSet.add(string);
        }
        System.out.print(StringUtils.join(stringSet, ","));
    }

}

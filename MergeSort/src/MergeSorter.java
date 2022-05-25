import java.util.ArrayList;
import java.util.Scanner;

public class MergeSorter {
    public int[] createList() {
        Scanner scan = new Scanner(System.in);
        System.out.println("List length:");
        int listLength = scan.nextInt();
        int[] list = new int[listLength];
        while (listLength>0) {
            list[listLength-1]= (int) (Math.random() * 100);
            listLength--;
        }
        return list;
    }

    public static int[] mergeSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int midPoint = array.length/2;
        int[] leftList = new int[midPoint];
        int[] rightList = new int[array.length-midPoint];
        System.arraycopy(array,0,leftList,0,midPoint);
        System.arraycopy(array,midPoint,rightList,0,array.length-midPoint);

        int[] result= new int[array.length];

        leftList = mergeSort(leftList);
        rightList = mergeSort(rightList);

        return result = merge(leftList,rightList);
    }

    public static int[] merge(int[] listA, int[] listB) {
        int i=0;
        int j=0;
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        int[] merged = new int[listA.length+ listB.length];

        while (listA.length + listB.length >= merged.length) {
            if (i == listA.length) {
                for (int q = j ; q<listB.length;q++) {
                    tempList.add(listB[q]);
                }
                break;
            } else if (j == listB.length) {
                for (int q = i ; q<listA.length;q++) {
                    tempList.add(listA[q]);
                }
                break;
            } else if (listA[i] > listB[j]) {
                tempList.add(listB[j]);
                j++;
            } else if (listA[i] < listB[j]) {
                tempList.add(listA[i]);
                i++;
            } else {
                tempList.add(listA[i]);
                i++;
            }
        }
        for (int temp = 0; temp < tempList.size(); temp++) {
            merged[temp] = tempList.get(temp);
        }
        return merged;
    }
}

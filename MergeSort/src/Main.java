import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MergeSorter merge = new MergeSorter();
        System.out.println(Arrays.toString(MergeSorter.mergeSort(merge.createList())));
    }
}


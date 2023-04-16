package pro.sky;

import pro.sky.exceptions.ElementsNotFoundException;
import pro.sky.exceptions.NullParamExceptions;

import java.util.Arrays;
import java.util.Random;

public class IntegerArrayListImpl implements IntegerList {
    Integer[] integerArray = new Integer[0];

    @Override
    public Integer add(Integer item) {
        if (item == null)
            throw new NullParamExceptions("Null Param Accrued");

        integerArray = Arrays.copyOf(integerArray, integerArray.length + 1);
        integerArray[integerArray.length - 1] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        if (item == null)
            throw new NullParamExceptions("Null Param Accrued");
        if (this.integerArray.length < 1) {
            throw new IndexOutOfBoundsException("Empty List");
        }
        if (index > integerArray.length)
            throw new IndexOutOfBoundsException("Index out of bounds");

        integerArray = Arrays.copyOf(integerArray, integerArray.length + 1);
        for (int i = integerArray.length - 1; i > index; i--) {
            integerArray[i] = integerArray[i - 1];
        }
        integerArray[index] = item;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        if (item == null)
            throw new NullParamExceptions("Null Param Occurred");
        if (index >= integerArray.length)
            throw new IndexOutOfBoundsException("Index out of bounds");

        integerArray[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {

        if (this.integerArray.length < 1)
            throw new ElementsNotFoundException("No such element");

        if (!isInArray(item)) {
            throw new ElementsNotFoundException("No such element");
        }
        Integer[] newArray = new Integer[this.integerArray.length - 1];
        for (int i = 0, k = 0; i < this.integerArray.length; i++) {
            if (!this.integerArray[i].equals(item)) {
                newArray[k] = this.integerArray[i];
                k++;
            }
        }
        this.integerArray = newArray;
        return item;
    }

    @Override
    public Integer remove(int index) {

        if (this.integerArray.length < 1)
            throw new IndexOutOfBoundsException("Index out of bounds, list is empty");

        if (index >= this.integerArray.length)
            throw new IndexOutOfBoundsException("Out of bounds");

        Integer result = 0;

        Integer[] newArray = new Integer[this.integerArray.length - 1];
        for (int i = 0, k = 0; i < this.integerArray.length; i++) {
            if (i != index) {
                newArray[k] = this.integerArray[i];
                k++;
            } else {
                result = this.integerArray[i];
            }
        }
        this.integerArray = newArray;
        return result;
    }


    @Override
    public boolean contains(Integer item) {
        return binarySearch(insertionSort(integerArray), item) != -1;
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < this.integerArray.length; i++) {
            if (this.integerArray[i].equals(item))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = this.integerArray.length - 1; i >= 0; i--) {
            if (this.integerArray[i].equals(item))
                return i;
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        if (this.integerArray.length < 1 || this.integerArray.length < index)
            throw new IndexOutOfBoundsException("Index out of bounds");
        return this.integerArray[index];
    }

    @Override
    public boolean equals(IntegerArrayListImpl otherList) {
        if (otherList == null)
            throw new NullParamExceptions("Null param occurred");
        if (this.integerArray.length != otherList.size())
            return false;

        Integer[] tmpArray = otherList.toArray();

        for (int i = 0; i < this.integerArray.length; i++) {
            if (!this.integerArray[i].equals(tmpArray[i]))
                return false;
        }
        return true;
    }

    @Override
    public int size() {
        return this.integerArray.length;
    }

    @Override
    public boolean isEmpty() {
        return this.integerArray.length == 0;
    }

    @Override
    public void clear() {
        this.integerArray = new Integer[0];
    }

    @Override
    public Integer[] toArray() {
        Integer[] result = new Integer[this.integerArray.length];
        System.arraycopy(this.integerArray, 0, result, 0, result.length);
        return result;
    }

    private boolean isInArray(Integer item) {
        for (Integer s : this.integerArray) {
            if (item.equals(s))
                return true;
        }
        return false;
    }


    public static void arraySortComparator() {

        Random rd = new Random();
        Integer[] nums = new Integer[100000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rd.nextInt();
        }

        //Integer[] nums = new Integer[]{5, 15, 48, 7, 1, 64, 8, 1, 24, 64, 8, 3164, 484, 2, 45, 131};


        selectionSort(nums.clone());

        //System.out.println(Arrays.toString(sortedArray));

        actualSelectionSort(nums.clone());

        insertionSort(nums.clone());
        //  System.out.println(Arrays.toString(sortedArray));

        long start = System.nanoTime();
        mergeSort(nums.clone());
        long end = System.nanoTime();
        System.out.println("Merge sort - " + (end - start));
        //  System.out.println(Arrays.toString(mergeSortArray));

        bubbleSort(nums.clone());
        // System.out.println(Arrays.toString(sortedArray));

        actualBubbleSort(nums.clone());
        //System.out.println(Arrays.toString(sortedArray));

    }

    private static Integer[] selectionSort(Integer[] nums) {

        long start = System.nanoTime();
        for (int i = 0; i < nums.length; i++) {
            int minPos = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[minPos] > nums[j]) {
                    minPos = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[minPos];
            nums[minPos] = tmp;
        }
        long end = System.nanoTime();
        System.out.println("Selection Sort - " + (end - start));
        return nums;
    }

    private static Integer[] actualSelectionSort(Integer[] nums) {
        long start = System.nanoTime();
        for (int i = 0; i < nums.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minPos]) {
                    minPos = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minPos];
            nums[minPos] = temp;
        }
        long end = System.nanoTime();
        System.out.println("Actual Selection Sort - " + (end - start));
        return nums;
    }

    private static Integer[] bubbleSort(Integer[] nums) {
        int k = 1;
        long start = System.nanoTime();
        while (k < nums.length) {
            for (int i = 0; i < nums.length - k; i++) {
                if (nums[i] > nums[i + 1]) {
                    int tmp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = tmp;
                }
            }
            k++;
        }
        long end = System.nanoTime();
        System.out.println("Bubble Sort - " + (end - start));
        return nums;
    }

    private static Integer[] actualBubbleSort(Integer[] nums) {
        long start = System.nanoTime();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        long end = System.nanoTime();
        System.out.println("ActualBubble Sort - " + (end - start));
        return nums;
    }

    private static Integer[] insertionSort(Integer[] nums) {
        long start = System.nanoTime();
        for (int i = 1; i < nums.length - 1; i++) {
            int j = i;
            while (j > 0 && nums[j - 1] > nums[j]) {
                int tmp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = tmp;
                j--;
            }
        }
        long end = System.nanoTime();
        System.out.println("Insertion sort - " + (end - start));
        return nums;
    }

    private static Integer[] mergeSort(Integer[] nums) {
        if (nums.length == 1)
            return nums;

        Integer[] arrayOne = new Integer[(nums.length + 1) / 2];
        Integer[] arrayTwo = new Integer[nums.length - arrayOne.length];

        for (int i = 0; i < nums.length; i++) {
            if (i < arrayOne.length) {
                arrayOne[i] = nums[i];
            } else {
                arrayTwo[i - arrayOne.length] = nums[i];
            }
        }

        arrayOne = mergeSort(arrayOne);
        arrayTwo = mergeSort(arrayTwo);

        return merge(arrayOne, arrayTwo);
    }

    private static Integer[] merge(Integer[] arrayOne, Integer[] arrayTwo) {
        Integer[] result = new Integer[arrayOne.length + arrayTwo.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arrayOne.length && j < arrayTwo.length) {
            if (arrayOne[i] < arrayTwo[j])
                result[k++] = arrayOne[i++];
            else
                result[k++] = arrayTwo[j++];
        }

        while (i < arrayOne.length) {
            result[k++] = arrayOne[i++];
        }

        while (j < arrayTwo.length) {
            result[k++] = arrayTwo[j++];
        }

        return result;
    }

    private int binarySearch(Integer[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target)
                return mid;
            else if (target > nums[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}

package pro.sky;

import pro.sky.exceptions.NullParamExceptions;

import java.util.Arrays;

public class StringListImpl implements StringList {
    String[] strtingArrayList = new String[0];

    @Override
    public String add(String item) {
        if(item == null)
            throw new NullParamExceptions("Итем равняется NULL");
        strtingArrayList = Arrays.copyOf(strtingArrayList, strtingArrayList.length + 1);
        strtingArrayList[strtingArrayList.length - 1] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        return null;
    }


    @Override
    public String set(int index, String item) {
        return null;
    }

    @Override
    public String remove(String item) {
        return null;
    }

    @Override
    public String remove(int index) {
        return null;
    }

    @Override
    public boolean contains(String item) {
        return false;
    }

    @Override
    public int indexOf(String item) {
        return 0;
    }

    @Override
    public int lastIndexOf(String item) {
        return 0;
    }

    @Override
    public String get(int index) {
        return null;
    }

    @Override
    public boolean equals(StringList otherList) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public String[] toArray() {
        return new String[0];
    }

}

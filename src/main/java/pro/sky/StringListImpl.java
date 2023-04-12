package pro.sky;

import pro.sky.exceptions.ElementsNotFoundException;
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
        if (item == null)
            throw new NullParamExceptions("Итем равняется NULL");
        if (this.strtingArrayList.length < 1) {
            throw new IndexOutOfBoundsException("наш лист пустой");
        }
        if (index > strtingArrayList.length)
            throw new IndexOutOfBoundsException("Ошибка: Индекс выходит за пределы");

        strtingArrayList = Arrays.copyOf(strtingArrayList, strtingArrayList.length + 1);
        for (int i = strtingArrayList.length - 1; i > index; i--) {
            strtingArrayList[i] = strtingArrayList[i - 1];
        }
        strtingArrayList[index] = item;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if(item == null)
            throw new NullParamExceptions("Итем равняется NULL");
        if (index >= strtingArrayList.length)
            throw new IndexOutOfBoundsException("Ошибка: Индекс выходит за пределы");

        strtingArrayList[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {

        if(this.strtingArrayList.length < 1)
            throw new ElementsNotFoundException("Элемент не найден");

        if (!isInArray(item)) {
            throw new ElementsNotFoundException("Элемент не найден");
        }
        String[] newArray = new String[this.strtingArrayList.length - 1];
        for (int i = 0, k = 0; i < this.strtingArrayList.length; i++) {
            if (!this.strtingArrayList[i].equals(item)) {
                newArray[k] = this.strtingArrayList[i];
                k++;
            }
        }
        this.strtingArrayList = newArray;
        return item;
    }

    @Override
    public String remove(int index) {

        if(this.strtingArrayList.length<1)
            throw new IndexOutOfBoundsException("Ошибка: Индекс выходит за пределы и список пуст ");

        if (index >= this.strtingArrayList.length)
            throw new IndexOutOfBoundsException("мы вышли за пределы");

        String result = "";

        String[] newArray = new String[this.strtingArrayList.length - 1];
        for (int i = 0, k = 0; i < this.strtingArrayList.length; i++) {
            if (i != index) {
                newArray[k] = this.strtingArrayList[i];
                k++;
            } else {
                result = this.strtingArrayList[i];
            }
        }
        this.strtingArrayList = newArray;
        return result;
    }



    @Override
    public boolean contains(String item) {
        for (String s : this.strtingArrayList) {
            if (item.equals(s))
                return true;
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < this.strtingArrayList.length; i++) {
            if (this.strtingArrayList[i].equals(item))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = this.strtingArrayList.length - 1; i >= 0; i--)
        {
            if (this.strtingArrayList[i].equals(item))
                return i;
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if(this.strtingArrayList.length < 1 || this.strtingArrayList.length < index)
            throw  new IndexOutOfBoundsException("Index out of bounds");
        return this.strtingArrayList[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if(otherList == null)
            throw new NullParamExceptions("Null обнаружен!!");
        if(this.strtingArrayList.length != otherList.size())
            return false;

        String[] tmpArray = otherList.toArray();

        for(int i = 0; i < this.strtingArrayList.length; i ++){
            if(!this.strtingArrayList[i].equals(tmpArray[i]))
                return false;
        }
        return true;
    }

    @Override
    public int size() {
        return this.strtingArrayList.length;
    }

    @Override
    public boolean isEmpty() {
        return this.strtingArrayList.length == 0;
    }

    @Override
    public void clear() {
        this.strtingArrayList = new String[0];
    }

    @Override
    public String[] toArray() {
        String[] result = new String[this.strtingArrayList.length];
        System.arraycopy(this.strtingArrayList, 0, result, 0, result.length);
        return result;
    }

    private boolean isInArray(String item) {
        for (String s : this.strtingArrayList) {
            if (item.equals(s))
                return true;
        }
        return false;
    }

}

package pro.sky;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.exceptions.ElementsNotFoundException;
import pro.sky.exceptions.IndexOutBoundsException;
import pro.sky.exceptions.NullParamExceptions;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class IntegerArrayListImplTest {
    IntegerArrayListImpl integerArrayList = new IntegerArrayListImpl();
    @BeforeEach
    void cleanListBeforeEachTest() {
        integerArrayList = new IntegerArrayListImpl();
    }

    @Test
    void add_NullParam_ThrowsNullParamException() {
        assertThrows(NullParamExceptions.class, () -> integerArrayList.add(null));
    }

    @Test
    void add_CorrectParams_ReturnsAdded() {

        Integer testInteger = 3;

        assertEquals(testInteger, integerArrayList.add(testInteger));
    }

    @Test
    void add_CorrectParams_ActuallyAdds() {
        Integer testInteger = 3;

        integerArrayList.add(testInteger);

        assertTrue(Arrays.asList(integerArrayList.toArray()).contains(testInteger));
    }


    @Test
    void indexAdd_NullParam_ThrowsNullParamException() {
        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;
        int indexUnderTest = 5;

        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);

        assertThrows(NullParamExceptions.class, () -> integerArrayList.add(indexUnderTest, null));
    }

    @Test
    void indexAdd_ArrayIsEmpty_ThrowIndexOutOfBoundsException() {
        int indexUnderTest = 5;

        assertThrows(IndexOutOfBoundsException.class, () -> integerArrayList.add(indexUnderTest, 8));
    }

//    @Test
//    void indexAdd_IndexOutOfBounds_ThrowIndexOutOfBoundsException() {
//
//        Integer testInteger = 0;
//        Integer testInteger1 = 1;
//        Integer testInteger2 = 2;
//        int indexUnderTest = 5;
//
//        integerArrayList.add(testInteger);
//        integerArrayList.add(testInteger1);
//        integerArrayList.add(testInteger2);
//
//        assertThrows(IndexOutBoundsException.class, () -> integerArrayList.add(indexUnderTest, 8));
//    }

    @Test
    void indexAdd_CorrectParams_ReturnsString() {

        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;
        Integer expectedInteger = 8;
        int indexUnderTest = 3;

        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);

        assertEquals(expectedInteger, integerArrayList.add(indexUnderTest, expectedInteger));
    }

    @Test
    void indexAdd_CorrectParams_AddedCorrectly() {

        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;
        Integer expectedInteger = 8;
        int indexUnderTest = 3;

        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);
        integerArrayList.add(indexUnderTest, expectedInteger);

        Integer[] testArray = integerArrayList.toArray();

        assertEquals(expectedInteger, testArray[indexUnderTest]);
    }


    @Test
    void set_NullParam_ThrowsNullParamException() {
        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;
        int indexUnderTest = 5;

        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);

        assertThrows(NullParamExceptions.class, () -> integerArrayList.set(indexUnderTest, null));
    }

//    @Test
//    void set_arrayIsEmpty_ThrowsIndexOutOfBoundsException() {
//
//        Integer testInteger = 5;
//        int indexUnderTest = 5;
//
//        assertThrows(IndexOutBoundsException.class, () -> integerArrayList.set(indexUnderTest, testInteger));
//    }

//    @Test
//    void set_IndexOutOfBounds_ThrowsIndexOutOfBoundsException() {
//
//        Integer testInteger = 0;
//        Integer testInteger1 = 1;
//        Integer testInteger2 = 2;
//        Integer integerUnderTest = 5;
//        int indexUnderTest = 5;
//
//        integerArrayList.add(testInteger);
//        integerArrayList.add(testInteger1);
//        integerArrayList.add(testInteger2);
//
//        assertThrows(IndexOutBoundsException.class, () -> integerArrayList.set(indexUnderTest, integerUnderTest));
//    }

    @Test
    void set_CorrectParams_ReturnsString() {

        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;
        Integer expectedInteger = 8;
        int indexUnderTest = 2;

        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);

        assertEquals(expectedInteger, integerArrayList.set(indexUnderTest, expectedInteger));
    }

    @Test
    void set_CorrectParams_setCorrectly() {

        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;
        Integer expectedInteger = 8;
        int indexUnderTest = 2;

        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);

        integerArrayList.set(indexUnderTest, expectedInteger);
        Integer[] testArray = integerArrayList.toArray();

        assertEquals(expectedInteger, testArray[2]);
    }

    @Test
    void remove_arrayIsEmpty_ThrowsIndexOutOfBoundsException() {
        Integer integerUnderTest = 5;

        assertThrows(ElementsNotFoundException.class, () -> integerArrayList.remove(integerUnderTest));
    }

    @Test
    void remove_NonExistentString_ThrowsElementNotFoundException() {

        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;
        Integer integerUnderTest = 5;


        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);

        assertThrows(ElementsNotFoundException.class, () -> integerArrayList.remove(integerUnderTest));
    }

    @Test
    void remove_CorrectParams_ReturnsString() {

        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;
        Integer expectedInteger = 8;

        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);
        integerArrayList.add(expectedInteger);

        assertEquals(expectedInteger, integerArrayList.remove(expectedInteger));
    }

    @Test
    void remove_CorrectParams_CorrectlyRemoved() {

        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;
        Integer expectedInteger = 8;

        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);
        integerArrayList.add(expectedInteger);
        integerArrayList.remove(expectedInteger);
        Integer[] testArray = integerArrayList.toArray();

        assertFalse(Arrays.asList(testArray).contains(expectedInteger));
        assertFalse(Arrays.asList(testArray).contains(null));
    }


//    @Test
//    void indexRemove_arrayIsEmpty_ThrowsIndexOutOfBoundsException() {
//        int indexUnderTest = 3;
//
//        assertThrows(IndexOutBoundsException.class, () -> integerArrayList.remove(indexUnderTest));
//    }

//    @Test
//    void indexRemove_indexOutOfBounds_ThrowsIndexOutOfBoundsException() {
//
//        Integer testInteger = 0;
//        Integer testInteger1 = 1;
//        Integer testInteger2 = 2;
//        int indexUnderTest = 5;
//
//
//        integerArrayList.add(testInteger);
//        integerArrayList.add(testInteger1);
//        integerArrayList.add(testInteger2);
//
//        assertThrows(IndexOutBoundsException.class, () -> integerArrayList.remove(indexUnderTest));
//    }

    @Test
    void indexRemove_CorrectParams_ReturnsString() {

        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;
        Integer expectedInteger = 8;
        int indexUnderTest = 3;

        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);
        integerArrayList.add(expectedInteger);

        assertEquals(expectedInteger, integerArrayList.remove(indexUnderTest));
    }

    @Test
    void indexRemove_CorrectParams_CorrectlyRemoved() {

        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;
        Integer expectedInteger = 8;
        int indexUnderTest = 3;

        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);
        integerArrayList.add(expectedInteger);
        integerArrayList.remove(indexUnderTest);
        Integer[] testArray = integerArrayList.toArray();

        assertFalse(Arrays.asList(testArray).contains(expectedInteger));
        assertFalse(Arrays.asList(testArray).contains(null));
    }


    @Test
    void contains_arrayIsEmpty_ReturnsFalse() {
        Integer integerUnderTest = 8;
        assertFalse(integerArrayList.contains(integerUnderTest));
    }

    @Test
    void remove_StringNonExistent_ReturnsFalse() {

        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;
        Integer integerUnderTest = 8;


        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);

        assertFalse(integerArrayList.contains(integerUnderTest));
    }

    @Test
    void contains_CorrectParams_ReturnsTrue() {

        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;
        Integer integerUnderTest = 8;

        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);
        integerArrayList.add(integerUnderTest);

        assertTrue(integerArrayList.contains(integerUnderTest));
    }


    @Test
    void indexOf_arrayIsEmpty_ReturnsNegative() {
        Integer integerUnderTest = 8;
        assertEquals(-1, integerArrayList.indexOf(integerUnderTest));
    }

    @Test
    void indexOf_IntegerNonExistent_ReturnsNegative() {

        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;
        Integer integerUnderTest = 8;

        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);

        assertEquals(-1, integerArrayList.indexOf(integerUnderTest));
    }

    @Test
    void indexOf_CorrectParams_ReturnsCorrectIndex() {

        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;
        Integer integerUnderTest = 8;
        int indexUnderTest = 3;

        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);
        integerArrayList.add(integerUnderTest);

        assertEquals(indexUnderTest, integerArrayList.indexOf(integerUnderTest));
    }


    @Test
    void lastIndexOf_arrayIsEmpty_ReturnsNegative() {
        Integer integerUnderTest = 5;
        assertEquals(-1, integerArrayList.lastIndexOf(integerUnderTest));
    }

    @Test
    void lastIndexOf_StringNonExistent_ReturnsNegative() {

        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;
        Integer integerUnderTest = 8;


        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);

        assertEquals(-1, integerArrayList.lastIndexOf(integerUnderTest));
    }

    @Test
    void lastIndexOf_CorrectParams_ReturnsCorrectIndex() {

        Integer testInteger = 2;
        Integer testInteger1 =3;
        Integer testInteger2 =2;
        Integer integerUnderTest = 2;
        int indexUnderTest = 3;

        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);
        integerArrayList.add(integerUnderTest);

        assertEquals(indexUnderTest, integerArrayList.lastIndexOf(integerUnderTest));
    }


//    @Test
//    void get_arrayIsEmpty_ThrowsIndexOutOfBoundsException() {
//        int indexUnderTest = 3;
//
//        assertThrows(IndexOutBoundsException.class, () -> integerArrayList.get(indexUnderTest));
//    }

//    @Test
//    void get_indexOutOfBounds_ThrowsIndexOutOfBoundsException() {
//
//        Integer testInteger = 0;
//        Integer testInteger1 =1;
//        Integer testInteger2 =2;
//        int indexUnderTest = 5;
//
//
//        integerArrayList.add(testInteger);
//        integerArrayList.add(testInteger1);
//        integerArrayList.add(testInteger2);
//
//        assertThrows(IndexOutBoundsException.class, () -> integerArrayList.get(indexUnderTest));
//    }

    @Test
    void get_CorrectParams_ReturnsString() {

        Integer testInteger = 0;
        Integer testInteger1 =1;
        Integer testInteger2 =2;
        Integer expectedInteger = 8;
        int indexUnderTest = 3;

        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);
        integerArrayList.add(expectedInteger);

        assertEquals(expectedInteger, integerArrayList.get(indexUnderTest));
    }

    @Test
    void equals_NullParam_ThrowsNullParamException() {
        assertThrows(NullParamExceptions.class, () -> integerArrayList.equals(null));
    }

    @Test
    void equals_EmptyList_ReturnsFalse() {

        IntegerArrayListImpl testIntegerArrayList = new IntegerArrayListImpl();
        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;

        testIntegerArrayList.add(testInteger);
        testIntegerArrayList.add(testInteger1);
        testIntegerArrayList.add(testInteger2);

        assertFalse(integerArrayList.equals(testIntegerArrayList));
    }

    @Test
    void equals_NonMatchingLists_ReturnsFalse() {

        IntegerArrayListImpl testIntegerArrayList = new IntegerArrayListImpl();
        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;


        testIntegerArrayList.add(testInteger);
        testIntegerArrayList.add(testInteger1);
        testIntegerArrayList.add(testInteger2);
        integerArrayList.add(testInteger2);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger);

        assertFalse(integerArrayList.equals(testIntegerArrayList));
    }


    @Test
    void equals_MatchingLists_ReturnsTrue() {

        IntegerArrayListImpl testIntegerArrayList = new IntegerArrayListImpl();
        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;


        testIntegerArrayList.add(testInteger);
        testIntegerArrayList.add(testInteger1);
        testIntegerArrayList.add(testInteger2);
        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);

        assertTrue(integerArrayList.equals(testIntegerArrayList));
    }

    @Test
    void testSize() {
        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;

        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);
        Integer[] testArray = integerArrayList.toArray();

        assertEquals(3, testArray.length);
    }


    @Test
    void isEmpty_EmptyList_ReturnsTrue() {
        assertTrue(integerArrayList.isEmpty());
    }
    @Test
    void isEmpty_NonEmptyList_ReturnsFalse(){
        integerArrayList.add(5);
        assertFalse(integerArrayList.isEmpty());
    }

    @Test
    void testClear() {
        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;

        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);
        Integer[] testArray = integerArrayList.toArray();

        assertTrue(testArray.length != 0);

        integerArrayList.clear();
        testArray = integerArrayList.toArray();

        assertEquals(0, testArray.length);
    }

    @Test
    void testToArray() {

        IntegerArrayListImpl testIntegerArrayList = new IntegerArrayListImpl();
        Integer testInteger = 0;
        Integer testInteger1 = 1;
        Integer testInteger2 = 2;


        testIntegerArrayList.add(testInteger);
        testIntegerArrayList.add(testInteger1);
        testIntegerArrayList.add(testInteger2);
        integerArrayList.add(testInteger);
        integerArrayList.add(testInteger1);
        integerArrayList.add(testInteger2);

        assertEquals(Arrays.asList(testIntegerArrayList.toArray()), Arrays.asList(integerArrayList.toArray()));
    }


}
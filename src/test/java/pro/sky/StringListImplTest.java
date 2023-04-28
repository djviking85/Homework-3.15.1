package pro.sky;


import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import pro.sky.exceptions.ElementsNotFoundException;
import pro.sky.exceptions.NullParamExceptions;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
//@ContextConfiguration(classes = {StringListImpl.class})
//@ExtendWith(SpringExtension.class)
class StringListImplTest {

    StringListImpl stringArrayList = new StringListImpl();
    @BeforeEach
    void cleanListBeforeEachTest(){
        stringArrayList = new StringListImpl();
    }

    @Test
    void add_NullParam_ThrowsNullParamException() {
        assertThrows(NullParamExceptions.class, () -> stringArrayList.add(null));
    }

    @Test
    void add_CorrectParams_ReturnsAdded() {

        String testString = "Test";

        assertEquals(testString, stringArrayList.add(testString));
    }

    @Test
    void add_CorrectParams_ActuallyAdds() {
        String testString = "Test";

        stringArrayList.add(testString);

        assertTrue(Arrays.asList(stringArrayList.toArray()).contains(testString));
    }

    @Test
    void indexAdd_NullParam_ThrowsNullParamException() {
        String testString = "Test";
        String testString1 = "Test1";
        String testString2 = "Test2";
        int indexUnderTest = 5;

        stringArrayList.add(testString);
        stringArrayList.add(testString1);
        stringArrayList.add(testString2);

        assertThrows(NullParamExceptions.class, () -> stringArrayList.add(indexUnderTest,null));
    }
    @Test
    void indexAdd_ArrayIsEmpty_ThrowIndexOutOfBoundsException() {
        int indexUnderTest = 5;

        assertThrows(IndexOutOfBoundsException.class, () -> stringArrayList.add(indexUnderTest,"Test"));
    }

    @Test
    void indexAdd_IndexOutOfBounds_ThrowIndexOutOfBoundsException() {

        String testString = "Test";
        String testString1 = "Test1";
        String testString2 = "Test2";
        int indexUnderTest = 5;

        stringArrayList.add(testString);
        stringArrayList.add(testString1);
        stringArrayList.add(testString2);

        assertThrows(IndexOutOfBoundsException.class, () -> stringArrayList.add(indexUnderTest,"Test"));
    }

    @Test
    void indexAdd_CorrectParams_ReturnsString() {

        String testString = "Test";
        String testString1 = "Test1";
        String testString2 = "Test2";
        String expectedString = "Expected";
        int indexUnderTest = 3;

        stringArrayList.add(testString);
        stringArrayList.add(testString1);
        stringArrayList.add(testString2);

        assertEquals(expectedString, stringArrayList.add(indexUnderTest, expectedString));
    }

    @Test
    void indexAdd_CorrectParams_AddedCorrectly() {

        String testString = "Test";
        String testString1 = "Test1";
        String testString2 = "Test2";
        String expectedString = "Expected";
        int indexUnderTest = 3;

        stringArrayList.add(testString);
        stringArrayList.add(testString1);
        stringArrayList.add(testString2);
        stringArrayList.add(indexUnderTest, expectedString);

        String[] testArray = stringArrayList.toArray();

        assertEquals(expectedString, testArray[indexUnderTest]);
    }

    @Test
    void set_NullParam_ThrowsNullParamException() {
        String testString = "Test";
        String testString1 = "Test1";
        String testString2 = "Test2";
        int indexUnderTest = 5;

        stringArrayList.add(testString);
        stringArrayList.add(testString1);
        stringArrayList.add(testString2);

        assertThrows(NullParamExceptions.class, () -> stringArrayList.set(indexUnderTest,null));
    }

    @Test
    void set_arrayIsEmpty_ThrowsIndexOutOfBoundsException() {

        String testString = "Test";
        int indexUnderTest = 5;

        assertThrows(IndexOutOfBoundsException.class, () -> stringArrayList.set(indexUnderTest, testString));
    }

    @Test
    void set_IndexOutOfBounds_ThrowsIndexOutOfBoundsException() {

        String testString = "Test";
        String testString1 = "Test1";
        String testString2 = "Test2";
        String stringUnderTest = "Test3";
        int indexUnderTest = 5;

        stringArrayList.add(testString);
        stringArrayList.add(testString1);
        stringArrayList.add(testString2);

        assertThrows(IndexOutOfBoundsException.class, () -> stringArrayList.set(indexUnderTest, stringUnderTest));
    }

    @Test
    void set_CorrectParams_ReturnsString() {

        String testString = "Test";
        String testString1 = "Test1";
        String testString2 = "Test2";
        String expectedString = "Expected";
        int indexUnderTest = 2;

        stringArrayList.add(testString);
        stringArrayList.add(testString1);
        stringArrayList.add(testString2);

        assertEquals(expectedString, stringArrayList.set(indexUnderTest, expectedString));
    }

    @Test
    void set_CorrectParams_setCorrectly() {

        String testString = "Test";
        String testString1 = "Test1";
        String testString2 = "Test2";
        String expectedString = "Expected";
        int indexUnderTest = 2;

        stringArrayList.add(testString);
        stringArrayList.add(testString1);
        stringArrayList.add(testString2);

        stringArrayList.set(indexUnderTest, expectedString);
        String[] testArray = stringArrayList.toArray();

        assertEquals(expectedString, testArray[2]);
    }


    @Test
    void remove_arrayIsEmpty_ThrowsIndexOutOfBoundsException() {
        String stringUnderTest = "Test3";

        assertThrows(ElementsNotFoundException.class, () -> stringArrayList.remove(stringUnderTest));
    }

    @Test
    void remove_NonExistentString_ThrowsElementNotFoundException() {

        String testString = "Test";
        String testString1 = "Test1";
        String testString2 = "Test2";
        String stringUnderTest = "Tested";


        stringArrayList.add(testString);
        stringArrayList.add(testString1);
        stringArrayList.add(testString2);

        assertThrows(ElementsNotFoundException.class, () -> stringArrayList.remove(stringUnderTest));
    }

    @Test
    void remove_CorrectParams_ReturnsString() {

        String testString = "Test";
        String testString1 = "Test1";
        String testString2 = "Test2";
        String expectedString = "Expected";

        stringArrayList.add(testString);
        stringArrayList.add(testString1);
        stringArrayList.add(testString2);
        stringArrayList.add(expectedString);

        assertEquals(expectedString, stringArrayList.remove(expectedString));
    }

    @Test
    void remove_CorrectParams_CorrectlyRemoved() {

        String testString = "Test";
        String testString1 = "Test1";
        String testString2 = "Test2";
        String expectedString = "Expected";

        stringArrayList.add(testString);
        stringArrayList.add(testString1);
        stringArrayList.add(testString2);
        stringArrayList.add(expectedString);
        stringArrayList.remove(expectedString);
        String[] testArray = stringArrayList.toArray();

        assertFalse(Arrays.asList(testArray).contains(expectedString));
        assertFalse(Arrays.asList(testArray).contains(null));
    }



    @Test
    void indexRemove_arrayIsEmpty_ThrowsIndexOutOfBoundsException() {
        int indexUnderTest = 3;

        assertThrows(IndexOutOfBoundsException.class, () -> stringArrayList.remove(indexUnderTest));
    }

    @Test
    void indexRemove_indexOutOfBounds_ThrowsIndexOutOfBoundsException() {

        String testString = "Test";
        String testString1 = "Test1";
        String testString2 = "Test2";
        int indexUnderTest = 5;


        stringArrayList.add(testString);
        stringArrayList.add(testString1);
        stringArrayList.add(testString2);

        assertThrows(IndexOutOfBoundsException.class, () -> stringArrayList.remove(indexUnderTest));
    }

    @Test
    void indexRemove_CorrectParams_ReturnsString() {

        String testString = "Test";
        String testString1 = "Test1";
        String testString2 = "Test2";
        String expectedString = "Expected";
        int indexUnderTest = 3;

        stringArrayList.add(testString);
        stringArrayList.add(testString1);
        stringArrayList.add(testString2);
        stringArrayList.add(expectedString);

        assertEquals(expectedString, stringArrayList.remove(indexUnderTest));
    }

    @Test
    void indexRemove_CorrectParams_CorrectlyRemoved() {

        String testString = "Test";
        String testString1 = "Test1";
        String testString2 = "Test2";
        String expectedString = "Expected";
        int indexUnderTest = 3;

        stringArrayList.add(testString);
        stringArrayList.add(testString1);
        stringArrayList.add(testString2);
        stringArrayList.add(expectedString);
        stringArrayList.remove(indexUnderTest);
        String[] testArray = stringArrayList.toArray();

        assertFalse(Arrays.asList(testArray).contains(expectedString));
        assertFalse(Arrays.asList(testArray).contains(null));
    }


    @Test
    void contains_arrayIsEmpty_ReturnsFalse() {
        String stringUnderTest = "Test";
        assertFalse(stringArrayList.contains(stringUnderTest));
    }

    @Test
    void remove_StringNonExistent_ReturnsFalse() {

        String testString = "Test";
        String testString1 = "Test1";
        String testString2 = "Test2";
        String stringUnderTest = "TestString";


        stringArrayList.add(testString);
        stringArrayList.add(testString1);
        stringArrayList.add(testString2);

        assertFalse(stringArrayList.contains(stringUnderTest));
    }

    @Test
    void indexRemove_CorrectParams_ReturnsTrue() {

        String testString = "Test";
        String testString1 = "Test1";
        String testString2 = "Test2";
        String stringUnderTest = "TestString";

        stringArrayList.add(testString);
        stringArrayList.add(testString1);
        stringArrayList.add(testString2);
        stringArrayList.add(stringUnderTest);

        assertTrue(stringArrayList.contains(stringUnderTest));
    }


    @Test
    void indexOf_arrayIsEmpty_ReturnsNegative() {
        String stringUnderTest = "Test";
        assertEquals(-1, stringArrayList.indexOf(stringUnderTest));
    }

    @Test
    void indexOf_StringNonExistent_ReturnsNegative() {

        String testString = "Test";
        String testString1 = "Test1";
        String testString2 = "Test2";
        String stringUnderTest = "TestString";


        stringArrayList.add(testString);
        stringArrayList.add(testString1);
        stringArrayList.add(testString2);

        assertEquals(-1,stringArrayList.indexOf(stringUnderTest));
    }

    @Test
    void indexOf_CorrectParams_ReturnsCorrectIndex() {

        String testString = "Test";
        String testString1 = "Test1";
        String testString2 = "Test2";
        String stringUnderTest = "TestString";
        int indexUnderTest = 3;

        stringArrayList.add(testString);
        stringArrayList.add(testString1);
        stringArrayList.add(testString2);
        stringArrayList.add(stringUnderTest);

        assertEquals(indexUnderTest,stringArrayList.indexOf(stringUnderTest));
    }


    @Test
    void lastIndexOf_arrayIsEmpty_ReturnsNegative() {
        String stringUnderTest = "Test";
        assertEquals(-1, stringArrayList.lastIndexOf(stringUnderTest));
    }

    @Test
    void lastIndexOf_StringNonExistent_ReturnsNegative() {

        String testString = "Test";
        String testString1 = "Test1";
        String testString2 = "Test2";
        String stringUnderTest = "TestString";


        stringArrayList.add(testString);
        stringArrayList.add(testString1);
        stringArrayList.add(testString2);

        assertEquals(-1,stringArrayList.lastIndexOf(stringUnderTest));
    }

    @Test
    void lastIndexOf_CorrectParams_ReturnsCorrectIndex() {

        String testString = "Test";
        String testString1 = "Test";
        String testString2 = "Test";
        String stringUnderTest = "Test";
        int indexUnderTest = 3;

        stringArrayList.add(testString);
        stringArrayList.add(testString1);
        stringArrayList.add(testString2);
        stringArrayList.add(stringUnderTest);

        assertEquals(indexUnderTest,stringArrayList.lastIndexOf(stringUnderTest));
    }

    @Test
    void get_arrayIsEmpty_ThrowsIndexOutOfBoundsException() {
        int indexUnderTest = 3;

        assertThrows(IndexOutOfBoundsException.class, () -> stringArrayList.get(indexUnderTest));
    }

    @Test
    void get_indexOutOfBounds_ThrowsIndexOutOfBoundsException() {

        String testString = "Test";
        String testString1 = "Test1";
        String testString2 = "Test2";
        int indexUnderTest = 5;


        stringArrayList.add(testString);
        stringArrayList.add(testString1);
        stringArrayList.add(testString2);

        assertThrows(IndexOutOfBoundsException.class, () -> stringArrayList.get(indexUnderTest));
    }

    @Test
    void get_CorrectParams_ReturnsString() {

        String testString = "Test";
        String testString1 = "Test1";
        String testString2 = "Test2";
        String expectedString = "Expected";
        int indexUnderTest = 3;

        stringArrayList.add(testString);
        stringArrayList.add(testString1);
        stringArrayList.add(testString2);
        stringArrayList.add(expectedString);

        assertEquals(expectedString, stringArrayList.get(indexUnderTest));
    }



    @Test
    void equals_NullParam_ThrowsNullParamException(){
        assertThrows(NullParamExceptions.class, () -> stringArrayList.equals(null));
    }
    @Test
    void equals_EmptyList_ReturnsFalse() {

        StringListImpl testStringArrayList = new StringListImpl();
        String testString = "Test";
        String testString1 = "Test1";
        String testString2 = "Test2";

        testStringArrayList.add(testString);
        testStringArrayList.add(testString1);
        testStringArrayList.add(testString2);

        assertFalse(stringArrayList.equals(testStringArrayList));
    }

    @Test
    void equals_NonMatchingLists_ReturnsFalse() {

        StringListImpl testStringArrayList = new StringListImpl();
        String testString = "Test";
        String testString1 = "Test1";
        String testString2 = "Test2";


        testStringArrayList.add(testString);
        testStringArrayList.add(testString1);
        testStringArrayList.add(testString2);
        stringArrayList.add(testString2);
        stringArrayList.add(testString1);
        stringArrayList.add(testString);

        assertFalse(stringArrayList.equals(testStringArrayList));
    }


    @Test
    void equals_MatchingLists_ReturnsTrue() {

        StringListImpl testStringArrayList = new StringListImpl();
        String testString = "Test";
        String testString1 = "Test1";
        String testString2 = "Test2";


        testStringArrayList.add(testString);
        testStringArrayList.add(testString1);
        testStringArrayList.add(testString2);
        stringArrayList.add(testString);
        stringArrayList.add(testString1);
        stringArrayList.add(testString2);

        assertTrue(stringArrayList.equals(testStringArrayList));
    }

    @Test
    void testClear() {
        String testString = "Test";
        String testString1 = "Test1";
        String testString2 = "Test2";

        stringArrayList.add(testString);
        stringArrayList.add(testString1);
        stringArrayList.add(testString2);
        String[] testArray = stringArrayList.toArray();

        assertTrue(testArray.length != 0);

        stringArrayList.clear();
        testArray = stringArrayList.toArray();

        assertEquals(0, testArray.length);
    }

    @Test
    void testisEmpty_EmptyList() {
        assertTrue(stringArrayList.isEmpty());
    }

    @Test
    void testSize() {
        String testString = "Test";
        String testString1 = "Test1";
        String testString2 = "Test2";

        stringArrayList.add(testString);
        stringArrayList.add(testString1);
        stringArrayList.add(testString2);
        String[] testArray = stringArrayList.toArray();

        assertEquals(3, testArray.length);
    }




    @Test
    void testToArray() {

        StringListImpl testStringArrayList = new StringListImpl();
        String testString = "Test";
        String testString1 = "Test1";
        String testString2 = "Test2";


        testStringArrayList.add(testString);
        testStringArrayList.add(testString1);
        testStringArrayList.add(testString2);
        stringArrayList.add(testString);
        stringArrayList.add(testString1);
        stringArrayList.add(testString2);

        assertEquals(Arrays.asList(testStringArrayList.toArray()), Arrays.asList(stringArrayList.toArray()));
    }

}
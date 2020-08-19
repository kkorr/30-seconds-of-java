/*
 * MIT License
 *
 * Copyright (c) 2017-2019 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

/*
 * Tests for 30 Seconds of Java code library
 *
 */
class ArrayLibraryTest {
  /**
   * Tests for {@link ArrayLibrary#arrayConcat(Object[], Object[])}.
   */
  @Test
  void testArrayConcat() {
    var integers = ArrayLibrary.arrayConcat(new Integer[5], new Integer[5]);
    assertEquals(integers.length, 10);
    var strings = ArrayLibrary.arrayConcat(new String[0], new String[0]);
    assertEquals(strings.length, 0);
    assertThrows(NullPointerException.class, () -> ArrayLibrary.arrayConcat(null, null));
  }

  /**
   * Tests for {@link ArrayLibrary#multiArrayConcat(Object[], Object[][])}.
   */
  @Test
  void testNArrayConcat() {
    var single = ArrayLibrary.multiArrayConcat(new Integer[1]);
    assertEquals(single.length, 1);
    var multiple
            = ArrayLibrary.multiArrayConcat(new String[5],
            new String[12],
            new String[3],
            new String[8]);
    assertEquals(multiple.length, 28);
    assertThrows(NullPointerException.class, () -> ArrayLibrary
            .multiArrayConcat(null, null, null, null));
  }

  /**
   * Tests for {@link ArrayLibrary#allEqual(Object[])}.
   */
  @Test
  void testAllEqual() {
    var intArray = new Integer[5];
    assertTrue(ArrayLibrary.allEqual(intArray));
    intArray[0] = 1;
    assertFalse(ArrayLibrary.allEqual(intArray));
    var stringArray = new String[10];
    Arrays.fill(stringArray, "Hello World");
    assertTrue(ArrayLibrary.allEqual(stringArray));
    stringArray[3] = "Bye World";
    assertFalse(ArrayLibrary.allEqual(stringArray));
    var doubleArray = new Double[1];
    assertTrue(ArrayLibrary.allEqual(doubleArray));
    assertThrows(NullPointerException.class, () -> ArrayLibrary.allEqual(null));
  }

  /**
   * Tests for {@link ArrayLibrary#findMax(int[])}.
   */
  @Test
  void test_findMax() {
    assertEquals(9, ArrayLibrary.findMax(new int[] {1, 2, 4, 9, 8, 1}));
    assertEquals(-8, ArrayLibrary.findMax(new int[] {-43, -23, -51, -10, -8, -65, -9}));
    assertEquals(0, ArrayLibrary.findMax(new int[] {-4, -3, -2, -1, 0}));
    assertEquals(1, ArrayLibrary.findMax(new int[] {1, 1, 1, 1, 1, 1}));
  }
}
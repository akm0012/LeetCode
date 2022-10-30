package arrays

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

/**
 * Todo: Status: started, but 1 edge case is not covered. Got bored of this question.
 *
 * Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.
 * Note that elements beyond the length of the original array are not written. Do the above modifications to the input array in place and do not return anything.
 *
 * Example 1:
 * Input: arr = [1,0,2,3,0,4,5,0]
 * Output: [1,0,0,2,3,0,0,4]
 * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 */
class DuplicateZeros {

    fun duplicateZeros(arr: IntArray) {

        val numOfZeros = arr.count { it == 0 }

        var startingIndex = arr.size - numOfZeros - 1

        var i = arr.size - 1
        while (i >= 0 && startingIndex >= 0) {

            arr[i] = arr[startingIndex]

            if (arr[startingIndex] == 0) {
                i--
                arr[i] = 0
            }

            startingIndex--
            i--
        }
    }

    @Test
    fun test1() {

        val arrayStart = intArrayOf(1, 0, 2, 3, 0, 4, 5, 1)

        duplicateZeros(arrayStart)

        val arrayEndExpected = intArrayOf(1, 0, 0, 2, 3, 0, 0, 4)

        assertArrayEquals(arrayEndExpected, arrayStart)
    }

    // Todo: There is a bug that is shown in this test case
    @Test
    fun test2() {

        val arrayStart = intArrayOf(1, 0, 2, 3, 0, 4, 0, 1)

        duplicateZeros(arrayStart)

        val arrayEndExpected = intArrayOf(1, 0, 0, 2, 3, 0, 0, 4)

        assertArrayEquals(arrayEndExpected, arrayStart)
    }
}

package arrays

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

/**
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

    fun duplicateZeros(arr: IntArray): Unit {
        arr.forEachIndexed { index, value ->
            if (value == 0 && index + 1 < arr.size) {
                (index..arr.size).forEachIndexed { innerIndex, innerValue ->
                    if (innerIndex + 1 < arr.size) {
                        arr[innerIndex + 1] = arr[innerIndex]
                    }
                }
            }
        }
    }

    @Test
    fun test1() {

        var arrayStart = intArrayOf(1, 0, 2, 3, 0, 4, 5, 0)

        duplicateZeros(arrayStart)

        val arrayEndExpected = intArrayOf(1, 0, 0, 2, 3, 0, 0, 4)

        assertEquals(arrayEndExpected, arrayStart)
    }
}

/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package e01

import kotlin.test.*

class AppTest {
    @Test fun testAppHasAGreeting() {
        val classUnderTest = App()
        assertNotNull(classUnderTest.greeting, "app should have a greeting")
    }

    @Test fun testSearchReturnedNull() {
        val classUnderTest = App()
        val arrayUnderTest = arrayOf(1, 2, 3)
        assertNull(classUnderTest.search(arrayUnderTest, 4), "an index (integer) was returned, expected null")
    }

    @Test fun testSearchReturnedAnIndex() {
        val classUnderTest = App()
        val arrayUnderTest = arrayOf(1, 2, 3)
        assertNotNull(classUnderTest.search(arrayUnderTest, 3), "null was returned, expected an index (integer)")
    }

    @Test fun testSearchWasGivenAnEmptyArrayAsArgument() {
        val classUnderTest = App()
        assertFailsWith<IllegalArgumentException>("argument array shouldn't be empty") { classUnderTest.search(emptyArray<Int>(), 3) }
    }
}
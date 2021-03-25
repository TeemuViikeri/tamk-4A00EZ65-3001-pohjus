/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package e02

import kotlin.test.*

class AppTest {
    @Test fun testAppHasAGreeting() {
        val classUnderTest = App()
        assertNotNull(classUnderTest.greeting, "app should have a greeting")
    }

    @Test fun testIsPalindrome() {
        assertTrue("abba".isPalindrome(), "string was not a palindrome, expected it to be a one")
    }

    @Test fun testIsNotPalindrome() {
        assertFalse("abc".isPalindrome(), "string was a palindrome, didn't expect it to be one")
    }

    @Test fun testIsPalindromeWhenCaseIsIgnored() {       
        assertTrue("abBa".isPalindrome(ignoreCase = true), "string was not a case insensitive palindrome, expected it to be one")
    }

    @Test fun testIsPalindromeWhenCaseAndWhitespacesAreIgnored() {
        assertTrue("aB ba".isPalindrome(ignoreCase = true, ignoreWhiteSpaces = true), "string was not a case insensitive and/or whitespace ignored palindrome, expected it to be both")
    }
}

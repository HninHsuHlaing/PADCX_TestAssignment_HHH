package com.zg.burgerjoint

import org.hamcrest.BaseMatcher
import org.hamcrest.Description
import org.hamcrest.Matcher

//import org.hamcrest.Matcher
//import java.util.regex.Matcher
fun <T> first(matcher: Matcher<T>): Matcher<T> {
    return object :BaseMatcher<T>(){

        var isFirst : Boolean = true

        override fun describeTo(description: Description?) {
            description?.appendText("FIRST_ITEM_DESCRIPTION")
        }

        override fun matches(item: Any?): Boolean {
            if (isFirst && matcher.matches(item)) {
                isFirst = false
                return true
            }
            return false
        }
    }
}


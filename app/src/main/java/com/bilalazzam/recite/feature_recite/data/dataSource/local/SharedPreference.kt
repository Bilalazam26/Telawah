package com.bilalazzam.recite.feature_recite.data.dataSource.local

import android.content.SharedPreferences
import android.util.Log
import com.bilalazzam.recite.feature_recite.presentation.util.Constants

private const val TAG = "SharedPreference"
object SharedPreference {
    private var sharedPreference: SharedPreferences? = null

    fun set(sharedPreferences: SharedPreferences) {
        sharedPreference = sharedPreferences
    }

    fun getCurrentPage(): Int? {
        val currentPage = sharedPreference?.getInt(Constants.CURRENT_PAGE_KEY, 1)
        Log.d(TAG, "getCurrentPage: $currentPage")
        return currentPage
    }

    fun setCurrentPage(currentPage: Int) {
        with(sharedPreference?.edit()) {
            this?.putInt(Constants.CURRENT_PAGE_KEY, currentPage)
            this?.apply()
        }
    }

    fun setBookmarkedPage(pageNumber: Int) {
        with(sharedPreference?.edit()) {
            this?.putInt(Constants.BOOKMARKED_PAGE_KEY, pageNumber)
            this?.apply()
            Log.d(TAG, "setBookmarkedPage: $pageNumber")
        }
    }

    fun getBookmarkedPage(): Int? {
        return sharedPreference?.getInt(Constants.BOOKMARKED_PAGE_KEY, -1)
    }
}
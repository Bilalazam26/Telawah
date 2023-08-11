package com.bilalazzam.recite.feature_recite.presentation.util

import android.content.Context
import com.bilalazzam.recite.R

fun numberToString(context: Context, number: Int): String {
    return when(number) {
        1 -> context.getString(R.string.the_first)
        2 -> context.getString(R.string.the_second)
        3 -> context.getString(R.string.the_third)
        4 -> context.getString(R.string.the_forth)
        5 -> context.getString(R.string.the_fifth)
        6 -> context.getString(R.string.the_sixth)
        7 -> context.getString(R.string.the_seventh)
        8 -> context.getString(R.string.the_eighth)
        9 -> context.getString(R.string.the_ninth)
        10 -> context.getString(R.string.the_tenth)
        11 -> context.getString(R.string.the_eleventh)
        12 -> context.getString(R.string.the_twelfth)
        13 -> context.getString(R.string.the_thirteenth)
        14 -> context.getString(R.string.the_fourteenth)
        15 -> context.getString(R.string.the_fifteenth)
        16 -> context.getString(R.string.the_sixteenth)
        17 -> context.getString(R.string.the_seventeenth)
        18 -> context.getString(R.string.the_eighteenth)
        19 -> context.getString(R.string.the_nineteenth)
        20 -> context.getString(R.string.the_twentieth)
        21 -> context.getString(R.string.the_twenty_first)
        22 -> context.getString(R.string.the_twenty_second)
        23 -> context.getString(R.string.the_twenty_third)
        24 -> context.getString(R.string.the_twenty_fourth)
        25 -> context.getString(R.string.the_twenty_fifth)
        26 -> context.getString(R.string.the_twenty_sixth)
        27 -> context.getString(R.string.the_twenty_seventh)
        28 -> context.getString(R.string.the_twenty_eighth)
        29 -> context.getString(R.string.the_twenty_ninth)
        30 -> context.getString(R.string.the_thirty)
        else -> "not valid!"
    }
}
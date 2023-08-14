package com.bilalazzam.recite.feature_recite.presentation.util

sealed class TabItem (
    val title: String
) {
    class SorahIndex(title: String): TabItem(
        title = title
    )
    class JozzaIndex(title: String): TabItem(
        title = title
    )

    class PageIndex(title: String): TabItem (
        title = title
    )
}

package com.bilalazzam.recite.feature_recite.presentation.util

import android.content.Context
import androidx.compose.runtime.Composable
import com.bilalazzam.recite.R
import com.bilalazzam.recite.feature_recite.domain.model.Jozza
import com.bilalazzam.recite.feature_recite.domain.model.Sorah
import com.bilalazzam.recite.feature_recite.presentation.moshafContent.components.jozzaIndex.JozzaIndexScreen
import com.bilalazzam.recite.feature_recite.presentation.moshafContent.components.pageIndex.PageIndexScreen
import com.bilalazzam.recite.feature_recite.presentation.moshafContent.components.sorahIndex.SorahIndexScreen

typealias ComposableFun = @Composable () -> Unit

sealed class TabItem (
    val title: String,
    val screen: ComposableFun
) {
    class SorahIndex(sorahList: List<Sorah>, onSorahClick: (Int) -> Unit, context: Context): TabItem(
        title = context.getString(R.string.sorah_index),
        screen = {
            SorahIndexScreen(
                sorahList = sorahList,
                onSorahClick = onSorahClick
            )
        }
    )
    class JozzaIndex(jozzaList: List<Jozza>, onJozzaClick: (Int) -> Unit, context: Context): TabItem(
        title = context.getString(R.string.jozza_index),
        screen = {
            JozzaIndexScreen(
                jozzaList = jozzaList,
                onJozzaClick = onJozzaClick,
                context = context
            )
        }
    )

    class PageIndex(onPageClick: (Int) -> Unit, context: Context): TabItem (
        title = context.getString(R.string.pages),
        screen = {
            PageIndexScreen(
                onPageClick = onPageClick
            )
        }
    )
}

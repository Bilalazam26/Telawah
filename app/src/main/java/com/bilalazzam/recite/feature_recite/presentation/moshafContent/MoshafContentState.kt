package com.bilalazzam.recite.feature_recite.presentation.moshafContent

import com.bilalazzam.recite.feature_recite.domain.model.Jozza
import com.bilalazzam.recite.feature_recite.domain.model.Sorah

data class MoshafContentState(
    var sorahList: List<Sorah>,
    var jozzaList: List<Jozza>
)

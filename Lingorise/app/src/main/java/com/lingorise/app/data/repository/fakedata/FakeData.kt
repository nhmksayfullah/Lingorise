package com.lingorise.app.data.repository.fakedata

import com.lingorise.app.domain.model.ProgressData
import com.lingorise.app.ui.theme.LingoriseGreen
import com.lingorise.app.ui.theme.LingoriseRed
import com.lingorise.app.ui.theme.LingoriseSkyBlue
import com.lingorise.app.ui.theme.LingoriseYellow


fun fakeProgressData(): List<ProgressData> {
    return listOf(
        ProgressData(3f, 9f,"Listening", LingoriseGreen),
        ProgressData(6f, 9f,"Speaking", LingoriseYellow),
        ProgressData(4.5f, 9f,"Reading", LingoriseRed),
        ProgressData(7f, 9f,"Writing", LingoriseSkyBlue)
    )
}
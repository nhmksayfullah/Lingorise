package com.lingorise.app.data.repository.fakedata

import com.lingorise.app.domain.model.SpotlightData

val spotlight1 = SpotlightData(
    url = "https://www.lingorise.com/fakecontent/watch/watch1.mp4",
    title = "How to learn English quickly: 10 tips"
)

val spotlight2 = SpotlightData(
    url = "https://www.lingorise.com/fakecontent/watch/watch2.mp4",
    title = "Read everything you can get your hands on"
)

val spotlight3 = SpotlightData(
    url = "https://www.lingorise.com/fakecontent/watch/watch3.mp4",
    title = "12 effective tips to learn English fast and easy"
)

val fakeSpotlight = listOf(spotlight1, spotlight2, spotlight3)
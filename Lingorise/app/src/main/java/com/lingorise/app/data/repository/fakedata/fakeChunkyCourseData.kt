package com.lingorise.app.data.repository.fakedata

import com.lingorise.app.R
import com.lingorise.app.core.chunkeycourse.Chunk
import com.lingorise.app.core.chunkeycourse.ChunkType
import com.lingorise.app.domain.model.CourseData
import com.lingorise.app.domain.model.SpotlightData

const val fakeLongDescription = "The placeholder text, beginning with the line “Lorem ipsum dolor sit amet, consectetur adipiscing elit”, looks like Latin because in its youth, centuries ago, it was Latin.\n" +
        "\n" +
        "Richard McClintock, a Latin scholar from Hampden-Sydney College, is credited with discovering the source behind the ubiquitous filler text. In seeing a sample of lorem ipsum, his interest was piqued by consectetur—a genuine, albeit rare, Latin word. Consulting a Latin dictionary led"


val chunk1 = Chunk(
    chunkType = ChunkType.Quiz,
    chunk = quiz1
)

val chunk2 = Chunk(
    chunkType = ChunkType.Quiz,
    chunk = quiz2
)

//val chunk3 = Chunk(
//    chunkType = ChunkType.Quiz,
//    chunk = quiz3
//)
val chunkVideo = SpotlightData(
    url = "https://www.lingorise.com/fakecontent/watch/chunk1.MOV",
    "Sophisticated"
)

val chunk3 = Chunk(
    chunkType = ChunkType.Video,
    chunk = chunkVideo
)

val fakeChunks = listOf( chunk3, chunk1, chunk2)


val course1 = CourseData(
    1,
    R.drawable.icon_vocabulary,
    "Vocabulary 001",
    "Sophisticated",
    "In this course, we will learn about Sophisticated. It is a very good vocabulary for IELTS writing. After completing this course, you can use this word in perfect situation.",
    fakeProgressData()[0],
    fakeChunks
)

val course2 = CourseData(
    2,
    R.drawable.icon_conversation,
    "Conversation 001",
    "Sophisticated, Generous, Precious",
    fakeLongDescription,
    fakeProgressData()[1],
    fakeChunks
)

val course3 = CourseData(
    3,
    R.drawable.icon_vocabulary,
    "Vocabulary 002",
    "Generous",
    fakeLongDescription,
    fakeProgressData()[2],
    fakeChunks
)

val course4 = CourseData(
    4,
    R.drawable.icon_conversation,
    "Conversation 002",
    "Sophisticated, Generous, Precious",
    fakeLongDescription,
    fakeProgressData()[3],
    fakeChunks
)

fun fakeCourseList1 (): List<CourseData> {
    return listOf(course1)
}
fun fakeCourseList2 (): List<CourseData> {
    return listOf(course2, course3, course4)
}
fun fakeCurrentCourseList (): List<CourseData> {
    return listOf(course1)
}



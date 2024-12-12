package com.lingorise.app.core.gamebox.quizer.ui

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lingorise.app.core.corecomponents.buttons.CoreFilledButton
import com.lingorise.app.core.corecomponents.sheets.CoreBottomSheetScreen
import com.lingorise.app.core.gamebox.quizer.QuizState
import com.lingorise.app.core.gamebox.quizer.model.Quiz
import com.lingorise.app.data.repository.fakedata.fakeQuizData
import com.lingorise.app.data.repository.fakedata.quiz1
import com.lingorise.app.ui.theme.LingoriseSkyBlue
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun QuizScreen(
    quiz: Quiz,
    onSuccess: () -> Unit
) {

    var solution by remember {
        mutableStateOf(-1)
    }
    val scope = rememberCoroutineScope()
    var label by remember {
        mutableStateOf("")
    }
    var quizState by remember {
        mutableStateOf(QuizState.NOT_SELECTED)
    }
    var massage by remember {
        mutableStateOf("Wow, Great!")
    }



    CoreBottomSheetScreen(sheetContent = { state ->

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {

            when (quizState) {
                QuizState.CORRECT -> {
                    SampleCorrectSheetContent(
                         bodyLabel = quiz.answer.correctMassage.toString()
                    ) {
                        //Log.d("answer", "correct sheet")
                        onSuccess()
                    }
                }
                QuizState.WRONG -> {
                    SampleWrongSheetContent(
                        bodyLabel = massage
                    ) {
                        //Log.d("answer", "wrong sheet")
                        scope.launch {
                            state.hide()
                        }
                    }
                }
                else -> {
                    SampleNotSelectedSheetContent {
                        //Log.d("answer", "not selected sheet")
                        scope.launch {
                            state.hide()
                        }
                    }
                }
            }
        }

    }) { state ->
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            SimpleQuizView(quiz = quiz) {
                solution = it.index
            }

        }
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {

            CoreFilledButton(
                label = "Check Answer",
                buttonColor = LingoriseSkyBlue,
                modifier = Modifier.padding(16.dp)
            ) {
                scope.launch {
                    state.show()
                }

                when (solution) {
                    -1 -> {
                        quizState = QuizState.NOT_SELECTED
                        Log.d("answer", "not selected")

                    }
                    quiz.answer.index -> {
                        quizState = QuizState.CORRECT

                        Log.d("answer", "correct")
                    }

                    else -> {
                        quizState = QuizState.WRONG
                        Log.d("answer", "wrong")
                        massage = quiz.options[solution-1].wrongMassage.toString()
                    }
                }
            }

        }



    }



}

@Preview(showBackground = true)
@Composable
fun QuizScreenPreview() {
    QuizScreen(quiz = quiz1) {

    }

}
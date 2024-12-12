package com.domesoft.gamebox.quizer

import kotlin.random.Random


val randomizedList = mutableListOf<Quiz>()

fun randomizeQuiz(quizList: List<Quiz>): List<Quiz> {

    for (item in quizList) {
        val requiredOptionSequence = createOptionSequence()
        val requiredOption1 = requiredOptionSequence[0]
        val requiredOption2 = requiredOptionSequence[1]
        val requiredOption3 = requiredOptionSequence[2]
        val requiredOption4 = requiredOptionSequence[3]
        demoItem(
            requiredOption1,
            requiredOption2,
            requiredOption3,
            requiredOption4,
            item
        )
    }

    return randomizedList
}


fun createOptionSequence(): MutableList<Int> {
    val options = mutableListOf<Int>()

    val option1 = Random.nextInt(1, 4)


    when (option1) {
        1 -> {
            options.add(0, 1)
            val option2 = add2ndOptions(1)
            options.add(1, option2)
            val option3 = add3rdOption(option1, option2)
            options.add(2, option3)
            val option4 = add4thOption(option1, option2, option3)
            options.add(3, option4)

        }
        2 -> {
            options.add(0, 2)
            val option2 = add2ndOptions(2)
            options.add(1, option2)
            val option3 = add3rdOption(option1, option2)
            options.add(2, option3)
            val option4 = add4thOption(option1, option2, option3)
            options.add(3, option4)
        }
        3 -> {
            options.add(0, 3)
            val option2 = add2ndOptions(3)
            options.add(1, option2)
            val option3 = add3rdOption(option1, option2)
            options.add(2, option3)
            val option4 = add4thOption(option1, option2, option3)
            options.add(3, option4)
        }
        4 -> {
            options.add(0, 4)
            val option2 = add2ndOptions(4)
            options.add(1, option2)
            val option3 = add3rdOption(option1, option2)
            options.add(2, option3)
            val option4 = add4thOption(option1, option2, option3)
            options.add(3, option4)
        }
    }
    return options
}
fun add2ndOptions(correctOption: Int): Int {
    val option2 = when (correctOption) {
        1 -> {
            Random.nextInt(2, 4)
        }
        2 -> {
            Random.nextInt(3, 4)
        }
        3 -> {
            Random.nextInt(1, 2)
        }
        4 -> {
            Random.nextInt(1, 3)
        }
        else -> 0
    }
    return option2
}
fun add3rdOption(option1: Int, option2: Int): Int {
    val option3 = when (option1) {
        1 -> {
            when (option2) {
                2 -> {
                    Random.nextInt(3, 4)
                }
                3 -> {
                    4
                }
                4 -> {
                    Random.nextInt(2, 3)
                }
                else -> 0
            }
        }
        2 -> {
            when (option2) {
                1 -> {
                    Random.nextInt(3, 4)
                }
                3 -> {
                    1
                }
                4 -> {
                    3
                }
                else -> 0
            }
        }
        3 -> {
            when (option2) {
                1 -> {
                    2
                }
                2 -> {
                    4
                }
                4 -> {
                    Random.nextInt(1, 2)
                }
                else -> 0
            }
        }
        4 -> {
            when (option2) {
                1 -> {
                    Random.nextInt(2, 3)
                }
                2 -> {
                    1
                }
                3 -> {
                    Random.nextInt(1, 2)
                }
                else -> 0
            }
        }
        else -> 0
    }
    return option3
}
fun add4thOption(option1: Int, option2: Int, option3: Int): Int {
    val option4 = when (option1) {
        1 -> {
            when (option2) {
                2 -> {
                    when (option3) {
                        3 -> {
                            4
                        }
                        4 -> {
                            3
                        }
                        else -> 0
                    }
                }
                3 -> {
                    when (option3) {
                        2 -> {
                            4
                        }
                        4 -> {
                            2
                        }
                        else -> 0
                    }
                }
                4 -> {
                    when (option3) {
                        2 -> {
                            3
                        }
                        3 -> {
                            2
                        }
                        else -> 0
                    }
                }
                else -> 0
            }

        }
        2 -> {
            when (option2) {
                1 -> {
                    when (option3) {
                        3 -> {
                            4
                        }
                        4 -> {
                            3
                        }
                        else -> 0
                    }
                }
                3 -> {
                    when (option3) {
                        1 -> {
                            4
                        }
                        4 -> {
                            1
                        }
                        else -> 0
                    }
                }
                4 -> {
                    when (option3) {
                        1 -> {
                            3
                        }
                        3 -> {
                            1
                        }
                        else -> 0
                    }
                }
                else -> 0
            }
        }
        3 -> {
            when (option2) {
                1 -> {
                    when (option3) {
                        2 -> {
                            4
                        }
                        4 -> {
                            2
                        }
                        else -> 0
                    }
                }
                2 -> {
                    when (option3) {
                        1 -> {
                            4
                        }
                        4 -> {
                            1
                        }
                        else -> 0
                    }
                }
                4 -> {
                    when (option3) {
                        1 -> {
                            2
                        }
                        2 -> {
                            1
                        }
                        else -> 0
                    }
                }
                else -> 0
            }
        }
        4 -> {
            when (option2) {
                1 -> {
                    when (option3) {
                        2 -> {
                            3
                        }
                        3 -> {
                            2
                        }
                        else -> 0
                    }
                }
                2 -> {
                    when (option3) {
                        1 -> {
                            3
                        }
                        3 -> {
                            1
                        }
                        else -> 0
                    }
                }
                3 -> {
                    when (option3) {
                        1 -> {
                            2
                        }
                        2 -> {
                            1
                        }
                        else -> 0
                    }
                }
                else -> 0
            }
        }
        else -> 0

    }
    return option4
}


fun addItem(o1: Int, o2: Int, o3: Int, o4: Int, item: Quiz) {
    var option1 = ""
    var option2 = ""
    var option3 = ""
    var option4 = ""

    when (o1) {
        1 -> {
            option1 = item.option1
            when (o2) {
                2 -> {
                    option2 = item.option2
                    when (o3) {
                        3 -> {
                            option3 = item.option3
                            when (o4) {
                                4 -> {
                                    option4 = item.option4
                                }
                            }
                        }
                        4 -> {
                            option3 = item.option4
                            when (o4) {
                                3 -> {
                                    option4 = item.option3
                                }
                            }
                        }
                    }
                }
                3 -> {
                    option2 = item.option3
                    when (o3) {
                        2 -> {
                            option3 = item.option2
                            when (o4) {
                                4 -> {
                                    option4 = item.option4
                                }
                            }
                        }
                        4 -> {
                            option3 = item.option4
                            when (o4) {
                                2 -> {
                                    option4 = item.option2
                                }
                            }
                        }
                    }
                }
                4 -> {
                    option2 = item.option4
                    when (o3) {
                        2 -> {
                            option3 = item.option2
                            when (o4) {
                                3 -> {
                                    option4 = item.option3
                                }
                            }
                        }
                        3 -> {
                            option3 = item.option3
                            when (o4) {
                                2 -> {
                                    option4 = item.option2
                                }
                            }
                        }
                    }
                }
            }
        }
        2 -> {
            option1 = item.option2
            when (o2) {
                1 -> {
                    option2 = item.option1
                    when (o3) {
                        3 -> {
                            option3 = item.option3
                            when (o4) {
                                4 -> {
                                    option4 = item.option4
                                }
                            }

                        }
                        4 -> {
                            option3 = item.option4
                            when (o4) {
                                3 -> {
                                    option4 = item.option3
                                }
                            }
                        }
                    }

                }
                3 -> {
                    option2 = item.option3
                    when (o3) {
                        1 -> {
                            option3 = item.option1
                            when (o4) {
                                4 -> {
                                    option4 = item.option4
                                }
                            }
                        }
                        4 -> {
                            option3 = item.option4
                            when (o4) {
                                1 -> {
                                    option4 = item.option1
                                }
                            }
                        }
                    }
                }
                4 -> {
                    option2 = item.option4
                    when (o3) {
                        1 -> {
                            option3 = item.option1
                            when (o4) {
                                3 -> {
                                    option4 = item.option3
                                }
                            }
                        }
                        3 -> {
                            option3 = item.option3
                            when (o4) {
                                1 -> {
                                    option4 = item.option1
                                }
                            }
                        }
                    }
                }
            }
        }
        3 -> {
            option1 = item.option3
            when (o2) {
                1 -> {
                    option2 = item.option1
                    when (o3) {
                        2 -> {
                            option3 = item.option2
                            when (o4) {
                                4 -> {
                                    option4 = item.option4
                                }
                            }

                        }
                        4 -> {
                            option3 = item.option4
                            when (o4) {
                                2 -> {
                                    option4 = item.option2
                                }
                            }
                        }
                    }

                }
                2 -> {
                    option2 = item.option2
                    when (o3) {
                        1 -> {
                            option3 = item.option1
                            when (o4) {
                                4 -> {
                                    option4 = item.option4
                                }
                            }

                        }
                        4 -> {
                            option3 = item.option4
                            when (o4) {
                                1 -> {
                                    option4 = item.option1
                                }
                            }
                        }
                    }

                }
                4 -> {
                    option2 = item.option4
                    when (o3) {
                        1 -> {
                            option3 = item.option1
                            when (o4) {
                                2 -> {
                                    option4 = item.option2
                                }
                            }

                        }
                        2 -> {
                            option3 = item.option2
                            when (o4) {
                                1 -> {
                                    option4 = item.option1
                                }
                            }
                        }
                    }
                }
            }
        }
        4 -> {
            option1 = item.option4
            when (o2) {
                1 -> {
                    option2 = item.option1
                    when (o3) {
                        2 -> {
                            option3 = item.option2
                            when (o4) {
                                3 -> {
                                    option4 = item.option3
                                }
                            }

                        }
                        3 -> {
                            option3 = item.option3
                            when (o4) {
                                2 -> {
                                    option4 = item.option2
                                }
                            }

                        }
                    }

                }
                2 -> {
                    option2 = item.option2
                    when (o3) {
                        1 -> {
                            option3 = item.option1
                            when (o4) {
                                3 -> {
                                    option4 = item.option3
                                }
                            }

                        }
                        3 -> {
                            option3 = item.option3
                            when (o4) {
                                1 -> {
                                    option4 = item.option1
                                }
                            }
                        }
                    }
                }
                3 -> {
                    option2 = item.option3
                    when (o3) {
                        1 -> {
                            option3 = item.option1
                            when (o4) {
                                2 -> {
                                    option4 = item.option2
                                }
                            }
                        }
                        2 -> {
                            option3 = item.option2
                            when (o4) {
                                1 -> {
                                    option4 = item.option1
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    randomizedList.add( Quiz(item.question, option1, option2, option3, option4, item.answer) )

}


fun demoItem(o1: Int, o2: Int, o3: Int, o4: Int, item: Quiz){
    var option1 = ""
    var option2 = ""
    var option3 = ""
    var option4 = ""

    when(o1){
        1 -> option1 = item.option1
        2 -> option2 = item.option1
        3 -> option3 = item.option1
        4 -> option4 = item.option1
    }
    when(o2){
        1 -> option1 = item.option2
        2 -> option2 = item.option2
        3 -> option3 = item.option2
        4 -> option4 = item.option2
    }
    when(o3){
        1 -> option1 = item.option3
        2 -> option2 = item.option3
        3 -> option3 = item.option3
        4 -> option4 = item.option3
    }
    when(o4){
        1 -> option1 = item.option4
        2 -> option2 = item.option4
        3 -> option3 = item.option4
        4 -> option4 = item.option4
    }

    randomizedList.add( Quiz(item.question, option1, option2, option3, option4, item.answer) )

}



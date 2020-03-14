package data

data class Student (
    val firstname: String,
    val surname: String,
val pris : Boolean
)

val studentList =
    arrayListOf(
        Student("Sheldon", "Cooper",true),
        Student("Leonard", "Hofstadter",true),
        Student("Howard", "Wolowitz",true)
    )
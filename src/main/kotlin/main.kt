import kotlinx.html.H1
import kotlinx.html.InputType
import kotlinx.html.dom.append
import kotlinx.html.js.*
import data.Student
import data.studentList
import kotlinx.html.DIV
import kotlinx.html.TagConsumer
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLSelectElement
import org.w3c.dom.events.Event
import kotlin.browser.document
import kotlin.dom.clear

var ascending = true

fun main() {
    document.getElementById("root")!!
        .append {
            h1 {
                attributes += "id" to "header"
                +"Students"
                onClickFunction = onClickFunction()
            }
            ol {
                attributes += "id" to "listStudents"
                studentList.map {
                    li {
                        +"${it.firstname} ${it.surname}"
                    }
                }
            }

            input(options = arrayListOf("red", "yellow", "purple"))


        }
}

private fun changeAllFontsColor(newColor: String): (Event) -> Unit {
    return {
        val root = document.getElementById("root")!!
        root.setAttribute("style", "color:${newColor}")
    }
}
fun TagConsumer<HTMLElement>.input(
    classes: String? = null,
    options: List<String>,
    block: DIV.() -> Unit = {}
): HTMLElement = div(classes) {
    options.forEach {
        input(InputType.radio) {
            attributes += "id" to "selectPurple"
            attributes += "name" to "contact"
            attributes += "value" to it
                onClickFunction = changeAllFontsColor(value)


        }
        +it
    }
    block()
}
private fun H1.onClickFunction(): (Event) -> Unit {
    return {
        val listStudents = document.getElementById("listStudents")!!
        listStudents.clear()
        listStudents.append {
            if (ascending)
                studentList.sortBy { it.firstname }
            else
                studentList.sortByDescending { it.firstname}
            ascending = !ascending
            attributes += "id" to "firstname"
            studentList.map {
                li {
                    +"${it.firstname} ${it.surname}"
                }
            }
        }

    }
}

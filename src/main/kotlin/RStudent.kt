import data.Student
import react.*

interface RStudentProps : RProps {
    var student: Student
}

class RStudent : RComponent<RStudentProps, RState>() {
    override fun RBuilder.render() {
        +"${props.student.firstname} ${props.student.surname}"
    }
}

fun RBuilder.rstudent(student: Student) =
    child(
        functionalComponent<RStudentProps> {
            +"${it.student.firstname} ${it.student.surname}"
        }
    ){
        attrs.student = student
    }
//    child(RStudent::class){
//        attrs.student = student
//    }
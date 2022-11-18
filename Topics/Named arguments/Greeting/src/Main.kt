import java.awt.geom.Area

fun greetUser(
    name: String,
    admin: Boolean = false,
    smith: Boolean = false,
    honorific: String = "",
    greet: String = "Greetings"
): String {
    return if (!admin && !smith) {
        "$greet, $honorific $name"
    } else {
        "Matrix Error"
    }
}

fun greetNeo() = greetUser(
    name = "Anderson",
    honorific = "Mr.",
    greet = "Hello"
)
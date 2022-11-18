// you do not need to understand how it works, ignore it
data class Pirate(val name: String)

// Do not touch the lines above

fun main() {
    // fix the declaration below
    var captain = Pirate("Hector Barbossa")
    println(captain.name)
    // put your code here

    val pirate = Pirate("Jack Sparrow")
    captain = pirate
    print(captain.name)
}
    fun main(args: Array<String>) {
        if (args.size < 3) {
            val array = arrayOf("first", "second", "third")
            main(array)
        } else {
            for (str in args) {
                println(str)
            }
        }
    }
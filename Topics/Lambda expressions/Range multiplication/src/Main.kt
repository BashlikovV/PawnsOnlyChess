    val lambda: (Long, Long) -> Long = { a: Long, b: Long ->
        var sum: Long =  1
        for (i in a..b) sum *= i
        sum
    }
fun main() {
    fun part1(input: List<String>): Int {
        var sumCount = 0
        input.forEach {
            val resultFOrString = convertStringToNumber(it).toInt()
            sumCount += resultFOrString
            println("Sum For $it => ${resultFOrString}")
        }
        println("Final Sum => $sumCount")
        return sumCount
    }


    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 281)

    val input = readInput("Day01")
    part1(input).println()
}


fun convertStringToNumber(input: String): String {
    var newString = input.toLowerCase()
    val hashMap = hashMapOf<Int, String>()
    val result = "\\d".toRegex().findAll(input)
    result.firstOrNull()?.let {
        hashMap.put(it.range.first, it.value)
    }
    result.lastOrNull()?.let {
        hashMap.put(it.range.first, it.value)
    }

    checkAndReplace(newString, "nine", 9)?.let {
        hashMap.putAll(it)
    }
    checkAndReplace(newString, "eight", 8)?.let {
        hashMap.putAll(it)
    }
    checkAndReplace(newString, "seven", 7)?.let {
        hashMap.putAll(it)
    }
    checkAndReplace(newString, "six", 6)?.let {
        hashMap.putAll(it)
    }
    checkAndReplace(newString, "five", 5)?.let {
        hashMap.putAll(it)
    }
    checkAndReplace(newString, "four", 4)?.let {
        hashMap.putAll(it)
    }
    checkAndReplace(newString, "three", 3)?.let {
        hashMap.putAll(it)
    }
    checkAndReplace(newString, "two", 2)?.let {
        hashMap.putAll(it)
    }
    checkAndReplace(newString, "one", 1)?.let {
        hashMap.putAll(it)
    }
    val keys = hashMap.keys

    var smallestNumber: Int? = null
    var largestNumber: Int? = null

    keys.forEach { key ->
        smallestNumber.let {
            if (it == null || key < it) {
                smallestNumber = key
            }
        }

        largestNumber.let {
            if (it == null || key > it) {
                largestNumber = key
            }
        }
    }
    return "${hashMap[smallestNumber]}${hashMap[largestNumber]}"
}

fun checkAndReplace(string: String, spellNumber: String, numbericValue: Int): HashMap<Int, String> {
    var pair = hashMapOf<Int, String>()
    val result = string.indexOf(spellNumber)
    if (result != -1) {
        pair.put(result, numbericValue.toString())
    }

    val resultLast = string.lastIndexOf(spellNumber)
    if (resultLast != -1) {
        pair.put(resultLast, numbericValue.toString())
    }

    return pair
}

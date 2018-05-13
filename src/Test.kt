val vowels:  CharArray = charArrayOf('a', 'e', 'i', 'o', 'u')

fun main(args: Array<String>) {
    var name = readLine().toString()
    var translation = translator(name)

    println(translation)
}

fun translator(word: String): String {
    // Read-only
    val code: String = "ay"

    // Mutable
    var translation: String
    var consanant_cluster: String

    // Initialize variables
    translation = word

    var beginsWithVowel: Boolean = false
    for (vowel in vowels) {
        if (translation[0] == vowel) {
            beginsWithVowel = true
            break
        }
    }
    if (!beginsWithVowel) {
        consanant_cluster = getConsonantCluster(translation)
        translation = translation.substringAfter(consanant_cluster)
        translation = translation.plus(consanant_cluster.plus(code))
    } else {
        translation = translation.plus(code)
    }
    return translation
}

fun getConsonantCluster(word: String): String {
    val test_cases:  CharArray = charArrayOf('a', 'e', 'i', 'o', 'u')

    var position: IntArray

    position = IntArray(5)

    var i: Int = 0
    for(vowel in test_cases) {
        var index = word.indexOf(vowel)
        if (index >= 0) position[i] = index else position[i] = word.length
        ++i
    }

    var first_vowel: Int = word.length
    for(index in position) {
        if (index < first_vowel) first_vowel = index
    }

    return word.substring(0, first_vowel)
}
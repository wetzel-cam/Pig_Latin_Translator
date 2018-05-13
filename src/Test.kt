fun main(args: Array<String>) {
    var name = readLine().toString()

    var consonant: String = name.subSequence(0, 1).toString()
    var subSeq: String = name.subSequence(1, name.length).toString()
    var translation = subSeq.plus(consonant.plus("ay"))

    println(translation)
}

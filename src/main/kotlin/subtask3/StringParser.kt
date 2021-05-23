package subtask3

class StringParser {

    // TODO: Complete the following function
    fun getResult(inputString: String): Array<String> {
        var list : MutableList<String> = mutableListOf<String>()
        list = getParsers(inputString)
    return list.toTypedArray()
    }
    fun getParsers(str : String) : MutableList<String> {
        val list : MutableList<String> = mutableListOf<String>()
        val p1 = Regex("""\(.+?\)|\[.+?\]|<.+?>""")
        val parsers : Sequence<MatchResult> = p1.findAll(str, 0)
        parsers.forEach()
        {
                matchResult ->
            var parser = matchResult.value.toString().subSequence(1,matchResult.value.length-1).toString()
            list.add(parser)
            if (p1.containsMatchIn(str)){
                list.addAll(getParsers(parser))
            }
        }
        return list
    }
}

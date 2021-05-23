package subtask3

class StringParser {

    // TODO: Complete the following function
    fun getResult(inputString: String): Array<String> {
        var list : MutableList<String> = mutableListOf<String>()
        list = getParsers(inputString)
    return list.toTypedArray()
    }
    fun getParsers(str : String) : MutableList<String> {
//        val list : MutableList<String> = mutableListOf<String>()
//        val p1 = Regex("""\(.+?\(.+?\).+?\)|\[.+?\[.+?\].+?\]|<.+?<.+?>.+?>|\(.+?\)|\[.+?\]|<.+?>""")
//        val parsers : Sequence<MatchResult> = p1.findAll(str, 0)
//        parsers.forEach()
//        {
//                matchResult ->
//            var parser = matchResult.value.toString().subSequence(1,matchResult.value.length-1).toString()
//            list.add(parser)
//            if (p1.containsMatchIn(str)){
//                list.addAll(getParsers(parser))
//            }
//        }
//        return list
        val list = mutableListOf<String>()
        val p1 = Regex("""<.+?>""")
        val p2 = Regex("""<.+?<.+?>.+?>|<.+?>|\(.+?\(.+?\).+?\)|\[.+?\[.+?].+?]|\(.+?\)|\[.+?]""")
        val parsers : Sequence<MatchResult> = p2.findAll(str, 0)
        parsers.forEach()
        {
                matchResult ->
            var parser = matchResult.value.subSequence(1,matchResult.value.length-1).toString()
            list.add(parser)
            if (p1.containsMatchIn(parser)){
                var pr = p1.find(parser,0)
                list.add(pr?.value?.subSequence(1,pr.value.length-1).toString())
            }
            if (p2.containsMatchIn(parser)){
                list.addAll(getParsers(parser))
            }

        }
        return list
    }
}

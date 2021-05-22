package subtask1

class HappyArray {

    // TODO: Complete the following function
    fun convertToHappy(sadArray: IntArray): IntArray {
        val list = sadArray.toMutableList()
        var i: Int
        var counterSadElem: Int
        do {
            counterSadElem = 0
            i = 1
            while (i < list.size - 1) {
                if (list[i] > (list[i - 1] + list[i + 1])) {
                    list.removeAt(i)
                    counterSadElem++
                    i--
                }
                i++
            }
        } while (counterSadElem != 0)
        return list.toIntArray()
    }
}

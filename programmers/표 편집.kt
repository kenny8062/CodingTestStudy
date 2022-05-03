import java.util.Stack
class Solution {
    fun solution(n: Int, k: Int, cmd: Array<String>): String {
        var answer= StringBuilder()
        var idx = k
        val stack = Stack<Int>()
        var listSize = n
        
        for (i in cmd) {
            var tmp = i.split(" ")
            when (tmp[0]) {
                "D" -> {
                    idx += tmp[1].toInt()
                }
                "U" -> {
                    idx -= tmp[1].toInt()
                }
                "C" -> {
                    listSize--
                    stack.push(idx)
                    if (idx == listSize) idx--
                }
                "Z" -> {
                    listSize++
                    if(stack.pop()<=idx) idx++
                }
            }
        }
        for(i in 0 until listSize) answer.append('O')
        while(!stack.isEmpty()){
            answer.insert(stack.pop(),'X')
        }
        return answer.toString()
    }
}

class Solution {
    fun solution(N: Int, number: Int): Int {
        var answer = -1
        var dp = Array(9){mutableSetOf<Int>()}
        dp[1].add(N)
        for(i in 2..8){
            var tmp = ""
            repeat(i){
                tmp +=N
            }
            dp[i].add(tmp.toInt())
            for(j in 1 until i){
                dp[i].addAll(op(dp[j],dp[i-j]))
            }
        }
        for(i in dp.indices){
            dp[i].forEach { 
                if(it==number){
                    return i
                }
            }
        }
        return answer
    }
    fun op(first : Set<Int>,second: Set<Int>) : Set<Int>{
       var tmpSet = mutableSetOf<Int>()
       for(i in first){
           for(j in second){
               tmpSet.add(i+j)
               tmpSet.add(i*j)
               if(i>j) tmpSet.add(i-j)
               if(i>=j) tmpSet.add(i/j)    
           }
       }
        return tmpSet
    }
}

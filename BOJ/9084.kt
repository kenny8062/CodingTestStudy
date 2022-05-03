import java.util.*
fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val tkNum = nextInt()
    for(i in 0 until tkNum){
        val num = nextInt()
        var arr = IntArray(num){nextInt()}
        val target = nextInt()
        val dp = IntArray(target+1)
        dp[0]=1
        for(j in arr){
            for(k in j..target){
                dp[k]+=dp[k-j]
            }
        }
        println(dp[target])
    }
}

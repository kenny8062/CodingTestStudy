import java.util.*
import kotlin.math.min

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val target = nextInt()
    val num = nextInt()
    val arr = Array(num){IntArray(2){nextInt()}}
    var dp = IntArray(1001){Int.MAX_VALUE}
    dp[0]=0
    for(i in arr.indices){
        for(j in 1 until arr[i][1]){
            dp[j]= min(dp[j],arr[i][0])
        }
        for (j in arr[i][1]..target) {
            dp[j] = min(dp[j], dp[j - arr[i][1]] + arr[i][0])
        }
    }
    println(dp[target])
}

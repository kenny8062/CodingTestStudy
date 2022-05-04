import java.util.*
import kotlin.math.max

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val num = nextInt()
    var arr = IntArray(num){nextInt()}
    val dp = IntArray(num)
    dp[0]=arr[0]
    for(i in 1 until arr.size){
        dp[i]= max(dp[i-1]+arr[i],arr[i])
    }
    println(dp.maxOrNull())
}

import java.util.*
fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val tkNum = nextInt()
    for(i in 0 until tkNum){
        val num = nextInt()
        var arr = Array(2){IntArray(num){nextInt()} }
        var dp = Array(2){IntArray(num)}
        if(num==1){
            println(Math.max(arr[0][0],arr[1][0]))
            continue
        }
        dp[0][0]=arr[0][0]
        dp[1][0]=arr[1][0]
        dp[0][1]=arr[1][0]+arr[0][1]
        dp[1][1]=arr[0][0]+arr[1][1]
        for(j in 2 until num){
            for(k in 0..1){
                when(k) {
                    0 -> {
                        dp[k][j] = max(dp[k][j - 2], dp[k+1][j-2],dp[k+1][j-1]) + arr[k][j]
                    }
                    1 ->{
                        dp[k][j] = max(dp[k][j - 2], dp[k-1][j-2],dp[k-1][j-1]) + arr[k][j]
                    }
                }
            }
        }
        println(Math.max(dp[0][num-1],dp[1][num-1]))
    }
}
fun max(first : Int,second : Int,third : Int) : Int{
    var max = -1
    if(first>max) max=first
    if (second>max) max=second
    if(third>max) max = third
    return max
}

import java.util.*
fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val num = nextLong()
    var ans :Long= 0
    var start :Long= 0
    var end :Long= num
    while(start<=end){
        var mid = (start + end)/2
        if(mid*(mid+1)/2<=num){
            ans = mid
            start = mid+1
        }else{
            end = mid-1
        }
    }
    println(ans)
}

import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs

fun main(args: Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))
    var token =StringTokenizer(br.readLine())
    val num :Int= token.nextToken().toInt()
    token = StringTokenizer(br.readLine())
    var arr = IntArray(num){token.nextToken().toInt()}
    var ans = intArrayOf(0,0)
    var min = Int.MAX_VALUE
    arr.sort()
    var start = 0
    var end = num-1
    while(start<end){
        var tmp = arr[start]+arr[end]
        if(abs(tmp)<min) {
            ans[0] = arr[start]
            ans[1] = arr[end]
            min = abs(tmp)
        }
        if(tmp<0){
            start++
        }else if(tmp>0){
            end--
        }else{
            println(arr[start].toString() + " " + arr[end].toString())
            return
        }
    }
    println(ans[0].toString() + " " + ans[1].toString())
}

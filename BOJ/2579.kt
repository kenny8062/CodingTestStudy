import java.util.*
import kotlin.math.max
fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val num = nextInt()
    val arr = Array(num) { nextInt() }
    val arr2 = IntArray(num)
    if(num==1){
        println(arr[0])
        return
    }else if(num==2){
        println(arr[0]+arr[1])
        return
    }
    arr2[0]=arr[0]
    arr2[1]=arr[0]+arr[1]
    arr2[2]=max(arr[0],arr[1]) + arr[2]
    for(i in 3 until arr2.size){
        arr2[i]=max(arr2[i-3]+arr[i-1],arr2[i-2]) + arr[i]
    }
    println(arr2[num-1])
}

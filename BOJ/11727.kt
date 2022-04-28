import java.util.*
fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val num = nextInt()
    val arr = IntArray(num)
    when (num) {
        1 -> {
            println(1)
        }
        2 -> {
            println(3)
        }
        else -> {
            arr[0]=1
            arr[1]=3
            for(i in 2 until num){
                arr[i]=(arr[i-1]+arr[i-2]*2)%10007
            }
            println(arr[num-1])
        }
    }
}

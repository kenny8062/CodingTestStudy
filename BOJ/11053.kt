import java.util.*
fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val num = nextInt()
    val arr = Array(num) { nextInt() }
    val arr2 = IntArray(num)
    arr2[0]=1
    for(i in 1 until arr.size){
        for(j in i-1 downTo 0){
            if(arr[i]>arr[j]&&arr2[i]<=arr2[j]){
                arr2[i]=arr2[j]+1
            }
        }
        if(arr2[i]==0) arr2[i]=1
    }
    println(arr2.maxOrNull())
}

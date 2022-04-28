import java.util.*
fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val num = nextInt()
    var arr = IntArray(num+1)
    if(num==0) {
        println(0)
    }else if(num==1){
        println(1)
    }else{
        arr[0]=0
        arr[1]=1
        for (i in 2..num){
            arr[i]=arr[i-1]+arr[i-2]
            if(i==num){
                println(arr[i])
                return
            }
        }
    }
}

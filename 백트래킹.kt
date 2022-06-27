var ans = mutableListOf<Int>()
fun main(){
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    var num = br.readLine().split(" ").map{it.toInt()}
    var opr = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    backT(num[0],1,opr,num)
    println("${ans.maxOrNull()}")
    println("${ans.minOrNull()}")
}
fun backT(start : Int,dept:Int, opr :IntArray,num : List<Int>){
    if(dept==num.size){
        ans.add(start)
        return
    }
    for(i in 0..3){
        if (opr[i]>0){
            var tmp = cal(start,num[dept],i)
            opr[i]--
            backT(tmp,dept+1,opr,num)
            opr[i]++
        }else continue
    }
}
fun cal(a : Int,b: Int, c: Int): Int{
    when(c){
        0 -> return a+b
        1 -> return a-b
        2 -> return a*b
        3 -> return a/b
    }
    return 0
}

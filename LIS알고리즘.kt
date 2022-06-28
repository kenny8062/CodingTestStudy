//백준 2643 
fun main(){
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    var mut = mutableListOf<Pair<Int,Int>>()
    var dp = IntArray(n){1}
    repeat(n){
        var tmp = br.readLine().split(" ").map{it.toInt()}
        if(tmp[0]>tmp[1]) mut.add(Pair(tmp[0],tmp[1]))
        else mut.add(Pair(tmp[1],tmp[0]))
    }
    mut.sortWith(compareBy<Pair<Int, Int>> { -it.first }.thenBy { -it.second })

    for(i in mut.indices){
        for(k in 0 until i){
            if(mut[i].second<=mut[k].second){
                dp[i]= Math.max(dp[i],dp[k]+1)
            }
        }
    }
    println(dp.maxOrNull())
}

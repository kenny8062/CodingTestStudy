// 백준 11404 플로이드
fun main(){
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val gr = Array(n){IntArray(n){10000001} }
    for(i in gr.indices){
        gr[i][i]=0
    }
    repeat(m){
        val (s,n,e) = br.readLine().split(" ").map{ it.toInt()}
        gr[s-1][n-1]=Math.min(e,gr[s-1][n-1])

    }
    for(k in 0 until n){
        for(j in 0 until n){
            for(i in 0 until n){
                if(gr[j][i]>gr[j][k]+gr[k][i]){
                    gr[j][i]=gr[j][k]+gr[k][i]
                }
            }
        }
    }
    repeat(n){
        for(i in gr[it]){
            if(i==10000001) print("0 ")
            else print("$i ")
        }
        println()
    }
}

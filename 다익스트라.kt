import java.util.*
fun main(){
    val br = System.`in`.bufferedReader()
    val (v,e) = br.readLine().split(" ").map { it.toInt() }
    val gr = Array(v+1){mutableListOf<Pair<Int,Int>>()}
    val start = br.readLine().toInt()
    val dist = IntArray(v+1){Int.MAX_VALUE}
    repeat(e){
        val (s,n,w) = br.readLine().split(" ").map{it.toInt()}
        gr[s].add(Pair(w,n))
    }

    val heap = PriorityQueue<Pair<Int,Int>> {a,b -> if(a.first>b.first) 1 else -1}
    heap.add(Pair(0,start))
    dist[start]=0
    while (!heap.isEmpty()){
        val (w,n) = heap.poll()
        if(w!=dist[n]) continue
        for(i in gr[n]){
            if(i.first+dist[n]<dist[i.second]){
                dist[i.second]=i.first+dist[n]
                heap.add(Pair(dist[i.second],i.second))
            }
        }
    }
    for(i in 1 until dist.size){
        if(dist[i]==Int.MAX_VALUE) println("INF")
        else println(dist[i])
    }
}

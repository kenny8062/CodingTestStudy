//백준1197
import java.util.PriorityQueue

fun main(){
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val (v,e) = br.readLine().split(" ").map { it.toInt() }
    var gr = Array(v){ mutableListOf<Pair<Int,Int>>()}
    val visit = BooleanArray(v)
    repeat(e){
        var tmp = br.readLine().split(" ").map { it.toInt() }
        gr[tmp[0]-1].add(Pair(tmp[2],tmp[1]-1))
        gr[tmp[1]-1].add(Pair(tmp[2],tmp[0]-1))
    }


    bw.write(prim(gr,visit).toString())
    bw.flush()
    bw.close()
    br.close()
}

fun prim(gr : Array<MutableList<Pair<Int,Int>>>, visit : BooleanArray): Int{
    val heap = PriorityQueue<Pair<Int,Int>>{a,b -> if(a.first>b.first) 1
    else -1}
    heap.add(Pair(0,0))
    var ans = 0
    while (!heap.isEmpty()){
        var (w,next) = heap.poll()
        if(!visit[next]) {
            visit[next]=true
            ans += w
            for (i in gr[next]) {
                if (!visit[i.second]) {
                    heap.add(i)
                }
            }
        }
    }
    return ans
}

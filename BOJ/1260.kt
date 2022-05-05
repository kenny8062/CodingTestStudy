import java.util.*
fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var n =nextInt()
    val m = nextInt()
    val v = nextInt()
    var gr = Array(n){IntArray(n)}
    var visit = BooleanArray(n)
    repeat(m){
        var i = nextInt()
        var k = nextInt()
        gr[i-1][k-1]=1
        gr[k-1][i-1]=1
    }
    dfs(v-1,gr,visit)
    visit= BooleanArray(n)
    println("")
    bfs(v-1,gr,visit)
}
fun dfs(n: Int, gr : Array<IntArray>, visit : BooleanArray){
    visit[n]=true
    print("${n+1} ")
    for(i in gr.indices){
        if(gr[n][i]==1 && !visit[i]){
            dfs(i,gr,visit)
        }
    }
}
fun bfs(n : Int,gr : Array<IntArray>,visit : BooleanArray){
    var que = LinkedList<Int>()
    que.add(n)
    visit[n]=true
    while (!que.isEmpty()){
        var tmp = que.poll()
        for(i in gr.indices){
            if(gr[tmp][i]==1&&!visit[i]){
                que.add(i)
                visit[i]=true
            }
        }
        print("${tmp+1} ")
    }
}

import java.util.*
var answer = 0
fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val num = nextInt()
    var arr = IntArray(num){nextInt()}
    var tr = Array(num){ mutableListOf<Int>()}
    var visit = BooleanArray(num)
    var root = 0
    var target = nextInt()
    for(i in arr.indices){
        if (arr[i]!=-1){
            tr[i].add(arr[i])
            tr[arr[i]].add(i)
        }else root = i
    }
    if(target==root) println(0)
    else{
        dfs(root,target,visit,tr)
        println(answer)
    }

}
fun dfs(n : Int,target : Int,visit : BooleanArray,tr : Array<MutableList<Int>>){
    visit[n]= true
    var childcnt = 0
    for(i in 0 until tr[n].size){
        var tmp = tr[n][i]
        if(!visit[tmp]&&tmp!=target){
            childcnt++
            dfs(tmp,target,visit,tr)
        }
    }
    if(childcnt==0) answer++
}

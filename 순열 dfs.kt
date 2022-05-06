var answer= mutableListOf<MutableList<String>>()
fun main(){
    var arr = arrayOf("a","b","c","d","e")
    var visit = BooleanArray(arr.size)
    var mutL = mutableListOf<String>()
    dfs(0,5,visit,arr, mutL)
    answer.forEach {
        it.forEach { print("$it ") }
        println("")
    }
}
//len = 몇개 뽑을지 n = 현재 node의 위치
fun dfs(n : Int,len : Int,visit : BooleanArray,arr : Array<String>,mutL : MutableList<String>){
    if(n==len) {
        var a = mutableListOf<String>()
        a.addAll(mutL)
        answer.add(a)
        return
    }
    for(i in 0 until arr.size){
        if(!visit[i]){
            mutL.add(arr[i])
            visit[i]=true
            dfs(n+1,len,visit,arr,mutL)
            mutL.remove(arr[i])
            visit[i]=false
        }
    }
}

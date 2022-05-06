var answer= mutableListOf<MutableList<String>>()
fun main(){
    var arr = arrayOf("a","b","c","d","e")
    var visit = BooleanArray(arr.size)
    var mutL = mutableListOf<String>()
    dfs(0,0,5,visit,arr, mutL)
}
//len = 몇개 뽑을지 , cnt 현재 뽑은 개수, n = 현재 node의 위치 
fun dfs(n : Int,cnt : Int,len : Int,visit : BooleanArray,arr : Array<String>,mutL : MutableList<String>){
    if(cnt==len) {
        var a = mutableListOf<String>()
        a.addAll(mutL)
        mutL.forEach { print("$it ") }
        println("333")
        answer.add(a)
        return
    }
    for(i in n until arr.size){
        if(!visit[i]){
            mutL.add(arr[i])
            visit[i]=true
            dfs(i,cnt+1,len,visit,arr,mutL)
            mutL.remove(arr[i])
            visit[i]=false
        }
    }
}

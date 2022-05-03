class Solution {
    var mutList = mutableListOf<Array<String>>()
    var banSize =0
    fun solution(user_id: Array<String>, banned_id: Array<String>): Int {
        var answer = 0
        banSize = banned_id.size
        var visit = BooleanArray(user_id.size)
        var mutBan = mutableListOf<String>()
        var mutSet = mutableSetOf<MutableSet<String>>()
        perm(0,user_id,mutBan,visit)
        
        for(i in mutList){
            if(check(i,banned_id)){
                mutSet.add(i.toMutableSet())
            }
        }
        
        return mutSet.size
    }
    fun check(userId : Array<String>,banId : Array<String>):Boolean{
        for(j in banId.indices){
            if(userId[j].length!=banId[j].length) return false
            for(k in 0 until banId[j].length){
                if(banId[j][k]=='*') continue
                else if(banId[j][k]!=userId[j][k]){
                    return false
                }
            }
        }
        return true
    }
    fun perm(n : Int, user_id : Array<String>, mutBan : MutableList<String>,visit : BooleanArray){
        if(n==banSize){
            mutList.add(mutBan.toTypedArray())
            return
        }
        for(i in 0 until user_id.size){
            if(!visit[i]){
                mutBan.add(user_id[i])
                visit[i]=true
                perm(n+1,user_id,mutBan,visit)
                mutBan.remove(user_id[i])
                visit[i]=false
            }
        }
    }
}

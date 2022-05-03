class Solution {
    fun solution(gems: Array<String>): IntArray {
        var answer = intArrayOf(-1,100000)
        var items = mutableSetOf<String>()
        var hm = HashMap<String,Int>()
        var start = 0
        var end = 0
        for(i in gems){
            items.add(i)
        }
        if(items.size==1) return intArrayOf(1,1)
        var itemSize = items.size
        var tmp = -1
        while(end<gems.size||start<gems.size){
            if(tmp!=end){
                if(!hm.contains(gems[end])){
                    hm.put(gems[end],1)
                }else{
                    hm[gems[end]]=hm[gems[end]]!! + 1
                }
            }
            if(hm.size==itemSize){
                if(end-start<answer[1]-answer[0]){
                    answer[0]=start+1
                    answer[1]=end+1
                }
                if(hm[gems[start]]==1){
                    hm.remove(gems[start])
                }else{
                    hm[gems[start]]= hm[gems[start]]!! - 1
                }
                start++
                tmp=end
            }else{
                end++
                if(end==gems.size) break
            }
        }
        return answer
    }
}

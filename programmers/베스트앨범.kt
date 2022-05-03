   fun solution(genres: Array<String>, plays: IntArray): IntArray {
        var answer = mutableListOf<Int>()
        var hm = HashMap<String,Triple2>()
        for(i in genres.indices){
            if(hm.contains(genres[i])){
                hm[genres[i]]!!.total += plays[i]
                if(plays[i]>hm[genres[i]]!!.first.play){
                    hm[genres[i]]!!.second=hm[genres[i]]!!.first
                    hm[genres[i]]!!.first=Pair2(plays[i],i)
                }else if(plays[i]>hm[genres[i]]!!.second.play){
                    hm[genres[i]]!!.second=Pair2(plays[i],i)
                }
            }else{
                hm.put(genres[i],Triple2(plays[i],Pair2(plays[i],i)))
            }
        }
        var sortlist=hm.toList().sortedByDescending { it.second.total }
        for(i in sortlist){
            answer.add(i.second.first.num)
            if(i.second.second.num!=-1){
                answer.add(i.second.second.num)
            }
        }
        return answer.toIntArray()
    }
    data class Triple2(var total : Int, var first : Pair2, var second : Pair2=Pair2())
    data class Pair2(var play : Int=-1, var num : Int=-1)

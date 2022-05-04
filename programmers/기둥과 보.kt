class Solution {
    fun solution(n: Int, build_frame: Array<IntArray>): Array<IntArray> {
        var answer = mutableListOf<IntArray>()
        var table = Array(n+2){Array(n+1){Pair2()}}
        for(i in table[0].indices){
            table[0][i].pill=true
        }
        for(i in build_frame){
            var row=i[1]
            var col=i[0]
            if(i[3]==1){
                if (i[2]==0){
                    if(checkPill(table,row,col)){
                        table[row+1][col].pill=true
                    }
                }else{
                    if(checkPap(table,row,col)){
                        table[row][col].papR=true
                        table[row][col+1].papL=true
                    }
                }
            }else{
                if (i[2]==0){
                    if(deletePill(table,row, col)){
                        table[row+1][col].pill=false
                    }
                }else{
                    if(deletePap(table,row,col)){
                        table[row][col].papR=false
                        table[row][col+1].papL=false
                    }
                }
            }
        }
        for(i in 0 until table[0].size){
            for(j in 1 until table.size){
                if(table[j][i].pill){
                    answer.add(intArrayOf(i,j-1,0))
                }
                if(table[j][i].papR){
                    answer.add(intArrayOf(i,j,1))
                }
            }
        }
        answer.sortWith(compareBy<IntArray> { it[0] }.thenBy { it[1] }.thenBy { it[2] })
        return answer.toTypedArray()
    }
    fun checkPill(table: Array<Array<Pair2>>,row : Int,col : Int) : Boolean{
        if(table[row][col].pill||table[row][col].papL||table[row][col].papR) return true
        return false
    }

    fun checkPap(table: Array<Array<Pair2>>,row : Int,col : Int) : Boolean{
        if(table[row][col].pill||table[row][col+1].pill||(table[row][col].papL&&table[row][col+1].papR)) return true
        return false
    }
    fun deletePill(table: Array<Array<Pair2>>,row : Int,col : Int): Boolean{
        table[row+1][col].pill=false
        if(table[row+2][col].pill){
            if(!checkPill(table,row+1,col)) {
                table[row+1][col].pill=true
                return false
            }
        }
        if (table[row+1][col].papR){
            if(!checkPap(table,row+1,col)){
                table[row+1][col].pill=true
                return false
            }
        }
        if(table[row+1][col].papL){
            if (!checkPap(table,row+1,col-1)){
                table[row+1][col].pill=true
                return false
            }
        }
        table[row+1][col].pill=true
        return true
    }
    fun deletePap(table: Array<Array<Pair2>>,row : Int,col : Int): Boolean{
        table[row][col].papR=false
        table[row][col+1].papL=false
        if(table[row][col].papL){
            if(!checkPap(table,row,col-1)){
                table[row][col].papR=true
                table[row][col+1].papL=true
                return false
            }
        }
        if(table[row][col+1].papR){
            if(!checkPap(table,row,col+1)){
                table[row][col].papR=true
                table[row][col+1].papL=true
                return false
            }
        }
        if(table[row+1][col].pill){
            if (!checkPill(table,row,col)){
                table[row][col].papR=true
                table[row][col+1].papL=true
                return false
            }
        }
        if(table[row+1][col+1].pill){
            if(!checkPill(table,row,col+1)){
                table[row][col].papR=true
                table[row][col+1].papL=true
                return false
            }
        }
        table[row][col].papR=true
        table[row][col+1].papL=true
        return true
    }

    data class Pair2(var pill : Boolean=false,var papL :Boolean = false,var papR :Boolean = false)
}

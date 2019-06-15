package com.codingblocks.calculator



// Stateful programing way
fun doesSomething(list:List<Person>, job:String):List<Person>{


    val newList = mutableListOf<Person>()
    for (item in list){
        if(item.getJob() == "Maintainer"){
            newList.add(item)
        }
    }

    return newList
}










val lambda  = { param1:Int, param2:Int ->
    // logic
    // last
    10
}





// easy concise way, Functional way
fun alsoDoesSomething(list:List<Person>, job:String):List<Person>{
    return list.filter { it.getJob() == "Maintainer" }
}










































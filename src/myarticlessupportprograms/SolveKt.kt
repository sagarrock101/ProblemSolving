package myarticlessupportprograms

import kotlinx.coroutines.*

fun main() {
    val coroutineScope = CoroutineScope(Dispatchers.Main)
    GlobalScope.launch {
        val registeredUserList = getListOfRegisteredUsers(this)
        println(registeredUserList.await().toString())
        println("afa")
    }
    println("afa")
    hOf {
        return@hOf
    }
}

inline fun hOf(crossinline lambda: () -> Unit) {
    normalFunction { lambda() }
}

fun normalFunction(aLambda: () -> Unit) {

    return

}


package myarticlessupportprograms

import kotlinx.coroutines.*

fun getListOfRegisteredUsers(scope: CoroutineScope) = scope.async {
    delay(3000)
    listOf("m", "n", "o", "p")
}
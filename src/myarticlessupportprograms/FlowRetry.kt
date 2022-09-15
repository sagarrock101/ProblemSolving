package myarticlessupportprograms

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

fun simple(): Flow<Int> = flow {
    for (i in 1..3) {
        println(i)
    }
}

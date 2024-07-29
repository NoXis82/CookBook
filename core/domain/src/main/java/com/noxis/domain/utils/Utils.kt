package com.noxis.domain.utils

import java.io.IOException


fun Throwable.onRepositoryError(): RepositoryError {
    return when (this) {
        //TODO тут расширить обработку ошибок
        is IOException -> {
            RepositoryError.DataBaseError.SQLITE_ERROR
        }

        else -> {
            RepositoryError.DataBaseError.SQLITE_ERROR
        }
    }
}

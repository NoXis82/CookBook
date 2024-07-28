package com.noxis.domain.utils

sealed interface RepositoryError : Error {

    enum class DataBaseError : RepositoryError {
        SQLITE_ERROR
        //todo расширить список
    }
}

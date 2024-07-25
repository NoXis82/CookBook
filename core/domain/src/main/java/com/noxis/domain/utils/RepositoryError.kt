package com.noxis.domain.utils

sealed interface RepositoryError : Error {

    enum class DataBaseError : Error {
        SQLITE_ERROR
        //todo расширить список
    }
}
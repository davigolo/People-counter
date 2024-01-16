package com.example.peoplecounter

data class AsyncResult<T>(
    val state: STATE,
    val data: T? = null,
    val errorMessage: String? = null,
    val exception: Throwable? = null
) {
    enum class STATE {
        SUCCESS,
        ERROR,
        EXCEPTION
    }

    companion object {
        fun <T> succes(data: T): AsyncResult<T> {
            return AsyncResult(
                state = STATE.SUCCESS,
                data = data
            )
        }

        fun <T> error(data: T, errorMessage: String): AsyncResult<T> {
            return AsyncResult(
                state = STATE.ERROR,
                data = data,
                errorMessage = errorMessage
            )
        }

        fun <T> exception(exception: Throwable?): AsyncResult<T> {
            return AsyncResult(
                state = STATE.EXCEPTION,
                exception = exception
            )
        }
    }

}
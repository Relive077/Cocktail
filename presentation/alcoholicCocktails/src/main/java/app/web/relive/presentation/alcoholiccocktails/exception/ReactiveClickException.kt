package app.web.relive.presentation.alcoholiccocktails.exception

class ReactiveClickException(
    msg: String,
    cause: Throwable?,
    stack: Array<StackTraceElement>
) : Throwable("$msg ::: ${stack.joinToString()}", cause, true, true)
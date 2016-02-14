package io.github.dector.quotes.usecases

interface UseCase<Request, Response> {

    fun execute(request: Request): Response
}
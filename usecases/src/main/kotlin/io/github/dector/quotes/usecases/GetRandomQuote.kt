package io.github.dector.quotes.usecases

import io.github.dector.quotes.domain.Quote
import io.github.dector.quotes.storage.DataRequest
import io.github.dector.quotes.storage.DataSource

class GetRandomQuote(val dataSource: DataSource<Quote>) : UseCase<Unit, Quote> {

    override fun execute(request: Unit): Quote {
        return dataSource.get(DataRequest(random = true))
    }
}
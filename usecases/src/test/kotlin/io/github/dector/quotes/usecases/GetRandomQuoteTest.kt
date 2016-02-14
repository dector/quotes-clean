package io.github.dector.quotes.usecases

import com.nhaarman.mockito_kotlin.reset
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.github.dector.quotes.domain.Author
import io.github.dector.quotes.domain.Quote
import io.github.dector.quotes.storage.DataRequest
import io.github.dector.quotes.storage.DataSource
import org.mockito.Mock
import org.mockito.MockitoAnnotations.initMocks
import org.testng.Assert.*
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test

class GetRandomQuoteTest {

    @Mock
    lateinit var dataSource: DataSource<Quote>

    lateinit var usecase: GetRandomQuote

    @BeforeTest
    fun setUpTest() {
        initMocks(this)

        usecase = GetRandomQuote(dataSource)
    }

    @AfterTest
    fun tearDownTest() {
        reset(dataSource)
    }

    @Test
    fun execute() {
        val quote = Quote(Author("name"), "text")

        whenever(dataSource.get(DataRequest(random = true))).thenReturn(quote)

        val result = usecase.execute(Unit)

        assertEquals(result, quote)
    }
}
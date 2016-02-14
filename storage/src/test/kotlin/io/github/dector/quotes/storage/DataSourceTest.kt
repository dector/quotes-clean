package io.github.dector.quotes.storage

import io.github.dector.quotes.domain.Quote
import org.mockito.Mockito.*
import org.testng.Assert
import org.testng.Assert.assertEquals
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test

class DataSourceTest {

    lateinit var dataSource: DataSource<Quote>

    @BeforeTest
    fun setUpTest() {
        dataSource = mock()
    }

    @AfterTest
    fun tearDownTest() {
        reset(dataSource)
    }

    @Test
    fun testNothing() {
        whenever(dataSource.count()).thenReturn(100)

        assertEquals(dataSource.count(), 100)
    }
}

inline fun <reified T : Any> mock() = mock(T::class.java)

fun <T> whenever(methodCall: T) = `when`(methodCall)
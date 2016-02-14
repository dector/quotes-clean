package io.github.dector.quotes.storage

interface DataSource<Data> {

    fun count(): Long

    fun get(request: DataRequest): Data
}
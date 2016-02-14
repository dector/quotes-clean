package io.github.dector.quotes.domain

data class Quote(val author: Author, val text: String)

data class Author(val name: String)

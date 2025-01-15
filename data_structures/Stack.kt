package data_structures

interface Stack<T> {
    fun push(element: T)
    fun pop(): T?
    fun peek(): T?
    fun isEmtpy(): Boolean
    fun isFull(): Boolean
}

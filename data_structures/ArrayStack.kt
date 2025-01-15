package data_structures

class ArrayStack<T> : Stack<T> {
    private var top: Int = -1
    private var capacity: Int = 16
    private var elements: Array<Any?> = arrayOfNulls(capacity)

    override fun push(element: T) {
        if (isFull()) {
            increaseCapacity()
        }
        this.elements[++top] = element
    }

    @Suppress("UNCHECKED_CAST")
    override fun pop(): T? {
        if (isEmtpy()) {
            println("Stack is empty.")
            return null
        }

        val lastElement = elements[top]
        this.elements[top--] = null

        if (top <= capacity / 4) {
            decreaseCapacity()
        }
        return lastElement as T
    }

    @Suppress("UNCHECKED_CAST")
    override fun peek(): T? {
        if (isEmtpy()) {
            println("Stack is empty.")
            return null
        }
        return elements[top] as T
    }

    override fun isEmtpy(): Boolean {
        return top == -1
    }

    override fun isFull(): Boolean {
        return top == capacity -1
    }

    private fun increaseCapacity() {
        this.capacity *= 2
        this.elements = elements.copyOf(capacity)
        println("Resized to $capacity")
    }

    private fun decreaseCapacity() {
        this.capacity /= 2
        this.elements = elements.copyOf(capacity)
        println("Resized to $capacity")
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ArrayStack<*>

        if (top != other.top) return false
        if (capacity != other.capacity) return false
        if (!elements.contentEquals(other.elements)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = top
        result = 31 * result + capacity
        result = 31 * result + elements.contentHashCode()
        return result
    }

    override fun toString(): String {
        return "ArrayStack(top=$top, capacity=$capacity, elements=${elements.contentToString()})"
    }
}

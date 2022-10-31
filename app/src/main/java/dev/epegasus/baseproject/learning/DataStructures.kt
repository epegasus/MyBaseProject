package dev.epegasus.baseproject.learning

import java.util.*
import kotlin.collections.ArrayDeque

/**
 * Data Structure
 *      i)  Primitive
 *          a) Integer
 *          b) Float
 *          c) Character
 *          d) Boolean
 *      ii) Non-Primitive
 *          a) Linear
 *              1) Arrays
 *              2) Stack
 *              3) Queue
 *              4) Linked List
 *          b) Non-linear
 *              1) Tree
 *              2) Graph
 *              3) Trie
 *              4) Hash Table
 */


fun main() {
    linear()
    nonLinear()
}

/* --------------------------------- Linear --------------------------------- */

fun linear() {
    arrays()
    stack()
    queue()
    linkedList()
}

fun arrays() {
    val cars = arrayOf("Volvo", "BMW", "Ford", "Mazda")
    val list = listOf("Volvo", "BMW", "Ford", "Mazda")

    val a = "Volvo" in list
    println(a)

    val b = cars.contains("Volvo")
    println(b)

    if ("Volvo" in cars) {
        println("It exists!")
    } else {
        println("It does not exist.")
    }
}

fun stack() {
    // Stack Using 'java.util'
    val stack = java.util.ArrayDeque<Int>()
    stack.push(1)
    stack.push(2)
    stack.push(3)
    stack.push(4)
    println(stack)           // --> [4, 3, 2, 1]
    println(stack.isEmpty()) // --> false
    println(stack.peek() ?: "Null")    // --> 4
    println(stack)           // --> [4, 3, 2, 1]
    println(stack.pop())     // --> 4
    println(stack)           // --> [3, 2, 1]
    stack.push(9)
    println(stack)           // --> [9, 3, 2, 1]

    // Stack Using 'kotlin.collections'
    val stackKotlin = ArrayDeque<Int>()
    stackKotlin.add(6)
    stackKotlin.addFirst(5)
    stackKotlin.add(4)
    stackKotlin.add(3)
    stackKotlin.add(2)
    stackKotlin.add(1)
    stackKotlin.add(0)
    stackKotlin.add(-5)
    stackKotlin.add(-3)
    println(stackKotlin)
    stackKotlin.removeLast()
    println(stackKotlin)
}

fun queue() {
    val queue: Queue<Int> = LinkedList()
    queue.add(1)
    queue.add(2)
    queue.add(3)
    queue.add(4)
    queue.add(5)
    println()
    println(queue)
    queue.poll()
    println(queue)
    println("Removing ${queue.remove()}")
    println(queue)
    println("Peeking: " + queue.peek())
}

fun linkedList() {
    // Linked List
    val planets = LinkedList<String>();
    planets.addAll(listOf("Earth", "Venus", "Mars"))
    println("Planets = $planets")
    planets[0]

    // Real Linked List
    val myLinkedList = MyLinkedList()
    myLinkedList.addNode(5)
    myLinkedList.addNode(10)
    myLinkedList.addNode(20)
    myLinkedList.addNode(1)
    println("linkedList: Size: ${myLinkedList.getSize()}")
    println("linkedList: Head: ${myLinkedList.getHead()}")
    println("linkedList: Tail: ${myLinkedList.getTail()}")
    println("linkedList: All:  ${myLinkedList.getAll()}")
    myLinkedList.addNode(9)
    println("linkedList: All:  ${myLinkedList.getAll()}")
    myLinkedList.removeLastNode()
    println("linkedList: All:  ${myLinkedList.getAll()}")

}

class MyLinkedList {

    private var head: Node? = null
    private var tail: Node? = null
    private val nodeList = ArrayList<Node>()
    private val lastNodeIndex get() = nodeList.size - 1

    fun addNode(value: Any) {
        // tail is always the latest node
        tail = Node(value)
        // if first node is inserting, update head as well
        if (head == null) {
            head = tail
            nodeList.add(head!!)
        } else {
            // check if head needs to be updated
            if (nodeList.size == 1)
                head!!.nextNode = tail
            // update node address in recent node
            val recentNode = nodeList[lastNodeIndex]
            recentNode.nextNode = tail
            nodeList[lastNodeIndex] = recentNode
            nodeList.add(tail!!)
        }
    }

    fun removeLastNode() {
        nodeList.removeLast()
        val lastNode = nodeList[lastNodeIndex]
        lastNode.nextNode = null
        tail = lastNode
        nodeList[lastNodeIndex] = lastNode
    }

    /**
     * @return
     *  true: if deleted
     *  false: if value not found
     */
    /*fun removeNode(value: Any): Boolean {
        val node: Node? = nodeList.find { it.value == value }
        node?.let {
            val indexOf = nodeList.indexOf(it)
        }
    }*/

    fun getSize(): Int {
        return nodeList.size
    }

    fun getHead(): Node? {
        return head
    }

    fun getTail(): Node? {
        return tail
    }

    fun getAll(): List<Node> {
        return nodeList
    }

    inner class Node(val value: Any?) {
        var nextNode: Node? = null

        override fun toString(): String {
            return "\nCurrent: ${this.hashCode()} - Value: $value - Address: ${nextNode.hashCode()}"
        }
    }
}

/* ------------------------------ Non Linear ------------------------------ */

fun nonLinear() {

}

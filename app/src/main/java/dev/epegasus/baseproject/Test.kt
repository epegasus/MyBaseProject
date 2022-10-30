package dev.epegasus.baseproject

import org.w3c.dom.Node
import java.util.*
import kotlin.collections.ArrayDeque

fun main() {

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

    // Sorting
    val sortList = listOf(1, 4, 3, 2, 5, 6)
    sortList.sorted()



    // Stack Using 'java.util'
    val stack = java.util.ArrayDeque<Int>()
    stack.push(1)
    stack.push(2)
    stack.push(3)
    stack.push(4)
    println(stack)           // --> [4, 3, 2, 1]
    println(stack.isEmpty()) // --> false
    println(stack.peek())    // --> 4
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


    // Linked List
    val planets = LinkedList<String>();
    planets.addAll(listOf("Earth", "Venus", "Mars"))
    println("Planets = $planets")
    planets[0]



}
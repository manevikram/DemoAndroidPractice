package com.demo.practice.solid_principles.SRP

/**
 * Created by Vikram Mane on 9/1/24.
 */

fun main() {
    /*var program = Program()
    val circle = Circle(5.0)
    println(program.calculateArea(circle))
    program.showShapeMessage(circle)*/
    val circle : I2DShape = Circle(5.0)
    val rectangle : I2DShape = Rectangle(3.0,5.0)
    val square : I2DShape = Square(4.0)
    val cube : I3DShape = Cube(4.0)
    println("Area of Circle : ${circle.getArea()}")
    println("Area of Rectangle : ${rectangle.getArea()}")
    println("Are of Square : ${square.getArea()}")
    println("Volume of Cube : ${cube.getVolume()}")
    val printer : IPrinter = PrintMessage()
    printer.showShapeMessage(circle)
    printer.showShapeMessage(rectangle)
    printer.showShapeMessage(square)
    printer.showShapeMessage(cube)
}

// Below Program class is breaching the Single Responsibility Principle
/*class Program {

    fun calculateArea(circle: Circle): Double{
        return Math.PI * circle.radius * circle.radius
    }

    fun showShapeMessage(circle: Circle){
        println("Its circle")
    }
}*/

interface IShape {

}

interface I2DShape : IShape {
    fun getArea() : Double
}

interface I3DShape : IShape {
    fun getVolume() : Double
}

interface IPrinter {
    fun showShapeMessage(shape : IShape)
}

class PrintMessage : IPrinter {
    override fun showShapeMessage(shape: IShape){
        println(shape.toString())
    }
}

class Circle (private val radius : Double) : I2DShape {
    override fun getArea() : Double {
        return Math.PI.times(radius).times(radius)
    }
}

class Rectangle (private val length : Double, private val breadth : Double) : I2DShape {
    override fun getArea() : Double {
        return length.times(breadth)
    }
}

class Square (private val side : Double) : I2DShape {
    override fun getArea(): Double {
        return side.times(side)
    }
}

class Cube (private val side : Double) : I3DShape {

    // Below override function is breaching the Interface Segregation Principle
    /* override fun getArea(): Double {
        return 0.0
    }*/
    override fun getVolume(): Double {
        return side.times(side).times(side)
    }

}
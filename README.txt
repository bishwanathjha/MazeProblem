Maze Problem
Author: Bishwanath Jha
Date: 10-OCT-2016
-------------------------
This solution of maze problem written in java.

Java version used:
openjdk version "1.8.0_91"
OpenJDK Runtime Environment (build 1.8.0_91-8u91-b14-3ubuntu1~16.04.1-b14)
OpenJDK 64-Bit Server VM (build 25.91-b14, mixed mode)

Javac version used:
javac 1.8.0_91
--------------------------

We have created different classes for this Like:

FileParser.java -- Reads text file from the project
Maze.java -- Represent the Maze object
Main.java -- Main controller file that execute this

The we could have multiple solver to solve so we have created a directory called Solver
Recursive.java -- It implements Solver interface and it traverse the nodes in maze

While traversing the actual part is represented as 7 and the false path is represented as 5

We have included unit test cases for the classes using JUnit
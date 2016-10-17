Maze Problem
Author: Bishwanath Jha
Date: 10-OCT-2016
Laguage used: JAVA
----------------------
Problem: Problem is very similary to maze problems that used to appear in newspapers on weekends
wherein you entered the maze from a side/point and had to find your way out. In between
there will be no. of false paths or demons on the way and you were supposed to go back and
find a new way to exit. 1's are the ones on which you can walk, 0's are the blocked walls.
You must enter from left side and exit from the right side. Only single entry and single exit.


Java version used:
------------------
openjdk version "1.8.0_91"
OpenJDK Runtime Environment (build 1.8.0_91-8u91-b14-3ubuntu1~16.04.1-b14)
OpenJDK 64-Bit Server VM (build 25.91-b14, mixed mode)


Javac version used:
------------------
javac 1.8.0_91


We have created different classes for this Like:

src/Maze/FileParser.java -- Reads text file from the project
src/Maze/Maze.java -- Represent the Maze object
src/Maze/Main.java -- Main controller file that execute this

The we could have multiple solver to solve so we have created a directory called Solver
Recursive.java -- It implements Solver interface and it traverse the nodes in maze

While traversing the actual part is represented as 7 and the false path is represented as 5

src/Test: We have included unit test cases for the classes using JUnit

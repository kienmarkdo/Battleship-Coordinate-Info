# Battleship-Coordinate-Info
A program that takes a Battleship coordinate as user input and returns relevant information; An introductory exercise for me to apply fundamental software engineering methods to design a small piece of software.

# Battleship Program (Requirement Analysis)
Aim: To write a simple stand-alone Java program from scratch.

Simple geometrical reasoning is at the core of Battleships. One important notion is
adjacency, with two sub-types: edge adjacency and corner adjacency. For example,
the square (4,3) is edge-adjacent to the square (3,3), it is corner-adjacent to the
square (3,2), and it is not adjacent to the square (6,7).

Write a program that reads a square from the user, and prints out three lists:
1) a list of all edge-adjacent squares,
2) a list of all corner-adjacent squares, and
3) a list of all squares which are not adjacent at all.


This version of battleships is played on a **9 by 9 board**. The lower-left square is (0,0).
As noted, the program will read from the console a short specification. The format specifications which this program can handle are: 

<table style="width:100%">
  <tr>
    <td>(5, 5)</td>
    <td>3 0</td>
    <td>4,1</td>
    <td>a7</td>
    <td>b 2</td>
  </tr>
</table>

# Software Engineering Skills
- Design
  - Created a Use Case Model using draw.io to better visualize the software as part of the Design phase
- Implementation
  - Implemented the software in Java
  - Applied some creativity and implemented the program functionalities using a mixture of linked lists and arrays as opposed to using a 2D array
  - Wrote JUnit tests for unit testing
- Integration and System Testing
  - Thoroughly tested the entire software with test cases that covered all possibile bugs
  - Documented the results in a text file with clean formatting

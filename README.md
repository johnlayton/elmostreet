# elmostreet

### Solution demonstration

Run the tests;
```
./gradlew test
```

Run the application;
```
./gradlew run -Pscenarios="['./src/test/resources/scenario1.txt', './src/test/resources/scenario2.txt']" 
```

### Solution Description

Main application will take argument being the locations of the files containing the senarios.

Robot class will hold the location and orientation of the robot.  It will also process the commands and ensure that the robot remains on the table

Command Parser class will be responsible for parsing the command input.

Command class is the abstract concept of a command with sub classing for concrete commands, Place, Report, Left, Right, Move.

Table class will hold the dimensions of the table and allow the robot processing the commands to ensure that it does fall from the table.

### Problem Description

The application is a simulation of a toy robot moving on a square tabletop, of dimensions 5 units x 5 units.

There are no other obstructions on the table surface.

The robot is free to roam around the surface of the table, but must be prevented from falling to destruction. Any movement that would result in the robot falling from the table must be prevented, however further valid movement commands must still be allowed.

Create an application that can read in commands of the following form -

```
PLACE X,Y,F MOVE
LEFT
RIGHT REPORT
```

Where PLACE will put the toy robot on the table in position X,Y and facing NORTH, SOUTH, EAST or WEST. The origin (0,0) can be considered to be the SOUTH WEST most corner.

It is required that the first command to the robot is a PLACE command, after that, any sequence of commands may be issued, in any order, including another PLACE command. The application should discard all commands in the sequence until a valid PLACE command has been executed.

Where MOVE will move the toy robot one unit forward in the direction it is currently facing.

Where LEFT and RIGHT will rotate the robot 90 degrees in the specified direction without changing the position of the robot.

Where REPORT will announce the X,Y and F of the robot. This can be in any form, but standard output is sufficient.

A robot that is not on the table can choose to ignore the MOVE, LEFT, RIGHT and REPORT commands.

Input can be from a file, or from standard input, as the developer chooses.

Provide test data to exercise the application.

It is not required to provide any graphical output showing the movement of the toy robot.

Constraints:
The toy robot must not fall off the table during movement. This also includes the initial placement of the toy robot. Any move that would cause the robot to fall must be ignored.
Option2: Robot Movement (Cont.)

Example Input and Output:

a)---------------- 
```
PLACE 0,0,NORTH 
MOVE
REPORT
```
```
Output: 0,1,NORTH
```
b)---------------- 
```
PLACE 0,0,NORTH 
LEFT
REPORT
```
```
Output: 0,0,WEST
```
c)---------------- 
```
PLACE 1,2,EAST 
MOVE
MOVE
LEFT
MOVE
REPORT
```
```
Output: 3,3,NORTH
```
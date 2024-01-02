# Hi Marker!
Thank you for marking my assignment!
I have created a script to compile and run the Java files and tests for your convenience. Please feel free to use it!
Thank you!

./script.sh <command_line_arguments_to_the_coin_change_problem>

e.g.
```
G4PCV44VFV:cmpt360-asn1 trang.nguyen$ ./script.sh 28 200 100 50 25 10 5 1 3 4 28
Desired amount: 28
Given coin values: [1, 3, 4, 5, 10, 25, 28, 50, 100, 200]
The number of possibilities: 164
The minimum number of coins: 1
(1@28, )
```

./test.sh

e.g.
```
G4PCV44VFV:cmpt360-asn1 trang.nguyen$ ./test.sh
added manifest
adding: test/(in = 0) (out= 0)(stored 0%)
adding: test/ChangeTest.class(in = 3123) (out= 1314)(deflated 57%)
adding: main/(in = 0) (out= 0)(stored 0%)
adding: main/ChangePosibilitySearch.class(in = 3481) (out= 1848)(deflated 46%)
adding: main/Change.class(in = 1539) (out= 974)(deflated 36%)
JUnit version 4.13.2
..........
Time: 4.5

OK (10 tests)

G4PCV44VFV:cmpt360-asn1 trang.nguyen$ 
```

## Problem:
### Written Question
6. (10 pts) Design a recursive algorithm that counts up all the ways that change can be made using an unlimited number of coins of given de-nomination. For example, using the standard Canadian coins (including the obsolete penny), $0.28 can be made in 13 distinct ways:
<br>• one quarter and three pennies
<br>• two dimes, one nickel, and three pennies
<br>• two dimes and eight pennies
<br>• one dime, three nickels, and three pennies
<br>• one dime, two nickels, and eight pennies
<br>• one dime, one nickel, and thirteen pennies
<br>• one dime and eighteen pennies
<br>• five nickels and three pennies
<br>• four nickels and eight pennies
<br>• three nickels and thirteen pennies
<br>• two nickels and eighteen pennies
<br>• one nickel and twenty-three pennies
<br>• twenty-eight pennies
<br>Show that all possibilities are counted – i.e. that your algorithm is correct. What is its time complexity?

Solution: [written.pdf](written.pdf)

### Programming Question
Implement your making change algorithm in Java, as a class called Change. It should also emit the minimum number of coins required.
You need to accept the total amount ot be made as the first command-
line argument, and then the denominations of the acceptable coins as
the remaining command-line arguments. For example,
```
java Change 28 200 100 50 25 10 5 1
```
emits
```
23: with a minimum of 4 coins: 1@25, 3@1
```
Note that some examples, much like the question about making numbers on A0, are impossible:
```
java Change 5 7 2
```
emits
```
impossible
```
But as you learned on A0, any number greater than 6 is possible with
those two coins.

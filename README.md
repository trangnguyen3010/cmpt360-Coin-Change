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
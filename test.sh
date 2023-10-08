javac -d ./out/ ./src/main/*.java
jar -cvf ./lib/Change.jar -C ./out .
javac -cp :./lib/Change.jar:./lib/hamcrest-core-1.3.jar:./lib/junit-4.13.2.jar -d ./out ./src/test/ChangeTest.java
cd ./out
java -cp :../lib/Change.jar:../lib/hamcrest-core-1.3.jar:../lib/junit-4.13.2.jar org.junit.runner.JUnitCore test.ChangeTest
cd ..
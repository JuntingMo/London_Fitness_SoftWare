# London Fitness Digital Gym System
*Created by EBU6304-2021 Software Engineering Group 45*

This is the final version of a digital Gym System software.

## Install
This project uses VLC media player. 
Please download the latest version of the VLC from https://www.videolan.org and install it in your computer.


## Usage
### Run the program using jar file(Recommend)

You can simply open the folder called "LondonFitness_Jar"and run the jar file in CMD to get full functions.

```c
java -jar LondonFitness.jar
```

We provide several videos and images in this folder so please do not delete them while running the application.

### Run the program using source code(Optional)

If you want to see the source code, please open the folder called **"LondonFitness_Code"**. Since you need to run several outside jar files to run the code properly, we do not recommend this method.
#####  Before running

You need to copy the folders **"LondonFitness_Jar/img"**, **"LondonFitness_Jar/video"** and paste them in the **"LondonFitness_Code"** repository. (We only upload the images and videos once because of the limitation of the file size.)
You also need to get jar files from **"LondonFitness_Code/lib"**, including:

* hamcrest-core-1.3.jar
* jna-5.2.0.jar
* jna-platform-5.2.0.jar
* junit-4.11.jar
* junit-platform-console-standalone-1.7.1.jar（for JUnit Test)
* vlcj-4.7.0.jar
* vlcj-natives-4.1.0.jar

##### Run
###### For Windows(Recommend)

Compile these files in CMD under **"LondonFitness_Code"** directory using command below:

```c
javac -cp .;lib/vlcj-4.7.0.jar;lib/hamcrest-core-1.3.jar;lib/jna-5.2.0.jar;lib/jna-platform-5.2.0.jar;lib/junit-4.11.jar;lib/vlcj-natives-4.1.0.jar;junit-platform-console-standalone-1.7.1.jar *.java
```
Then run it using command below:
```c
java -cp .;lib/vlcj-4.7.0.jar;lib/hamcrest-core-1.3.jar;lib/jna-5.2.0.jar;lib/jna-platform-5.2.0.jar;lib/junit-4.11.jar;lib/vlcj-natives-4.1.0.jar;junit-platform-console-standalone-1.7.1.jar Interface
```
###### For Mac OS

Compile these files in CMD under **"LondonFitness_Code"** directory using command below:

```c
javac -cp .:lib/vlcj-4.7.0.jar:lib/hamcrest-core-1.3.jar:lib/jna-5.2.0.jar:lib/jna-platform-5.2.0.jar:lib/junit-4.11.jar:lib/vlcj-natives-4.1.0.jar:junit-platform-console-standalone-1.7.1.jar *.java
```
Then run it using command below:
```c
java -cp .:lib/vlcj-4.7.0.jar:lib/hamcrest-core-1.3.jar:lib/jna-5.2.0.jar:lib/jna-platform-5.2.0.jar:lib/junit-4.11.jar:lib/vlcj-natives-4.1.0.jar:junit-platform-console-standalone-1.7.1.jar Interface
```


## Test
### Junit test
We wrote some JUnit test in the folder **"LondonFitness_Code/test"**.
You should move the java files in this folder into **"LondonFitness_Code"** and compile this test file in CMD in this directory. 
To run the "ValidationTest.java", please use command below:

```c
javac -cp lib/junit-platform-console-standalone-1.7.1.jar Check.java ValidationTest.java
```
```c
java -jar lib/junit-platform-console-standalone-1.7.1.jar -cp . -c ValidationTest
```
To run the "ReadTxtTest.java", please use command below:

```c
javac -cp lib/junit-platform-console-standalone-1.7.1.jar ReadTxt.java MemberConfig.java ReadTxtTest.java
```
```c
java -jar lib/junit-platform-console-standalone-1.7.1.jar -cp . -c ReadTxtTest
```


A Simple Teaching Game
==========================

A copy of a game I wrote for an assignment in my first year (2010).


Run Instructions
================

For Windows Users:

1. Unzip the file.
2. Open the 'src' folder in this directory.
3. Run a_simple_game.bat
4. Follow the instructions in game.

**Note:** if you have problems running, please refer to 'For all other Operating Systems'


For all other operatings Systems:

1. Unzip the file.
2. Open a terminal/command line in the src file (or navigate to it).
3. Enter: `java -classpath "./uk/ac/aber/dcs/adb9/cs12420/a_simple_teaching_game/version/_1/_4/_1;." uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._1._4._1.Application`
4. Follow the instructions in game.


Troubleshooting
===============

If the application fails to run.

Try:

```sh
javac -classpath "./uk/ac/aber/dcs/adb9/cs12420/a_simple_teaching_game/version/_1/_4/_1;." *.java`
java -classpath "./uk/ac/aber/dcs/adb9/cs12420/a_simple_teaching_game/version/_1/_4/_1;." uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._1._4._1.Application
```


If this still fails, try:

```sh
java -classpath "<location of src folder in your user directory>/uk/ac/aber/dcs/adb9/cs12420/a_simple_teaching_game/version/_1/_4/_1;." uk.ac.aber.dcs.adb9.cs12420.a_simple_teaching_game.version._1._4._1.Application
```

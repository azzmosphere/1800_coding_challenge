1.0 NAME

eighthundred-challenge

2.0 SYNOPSIS

 java -jar /path/to/jar/eighthundred-challenge -d /path/to/dictionary.txt [number1] ... [numberN]

 java -jar build/libs/eighthundred-challenge-1.0.0.jar -d ~/tmp/dictionary3.txt 2255.63 1603

3.0 DESCRIPTION

Reads the contents of the dictionary file and using the standard mapping for alpha representation on telephony handsets
creates all possible dictionary representations for a number, when all elements in the number can be matched.

if a number can not be mapped to a alpha then the number is used, but there is no two consequentive non alpha matches:

examples

java -jar build/libs/eighthundred-challenge-1.0.0.jar -d ~/tmp/dictionary3.txt 22551.63 1603
dictionary = /Users/aaron.spiteri/tmp/dictionary3.txt
Words for number :22551.63
++++
CALL1ME
CALL-1ME

Words for number :1603
++++
1M0E



The output on the screen is displayed as:

Words for number : N
++++
Match1
...
MatchN

4.0 OPTIONS

 -d [dictionary] the dictionary file to use

5.0 DESIGN

The program first parses the dictionary file into a ordered tree representation.  Each LHS full branch represents a 
word in the dictionary.  For instance:

       C------>M
    A          E---> E
  L                  E
L------>L            T
        E
        D

represents the words "CALL", "CALLED", "ME", "MEET"

The LHS branches are known as children, and the RHS branches are known as siblings. 

For each number that is given the transverser will first recursivly check siblings for a match then recursivly check 
children, if all slots can not be filled but a full word has been found, it will use the '-' character to represent 
a word boundry.  All non alpha characters are ignored in the dictionary and all non numeric characters are ignored in 
the transverser.

Mapping from numeric characters to alpha chracters is done by using bit masks on the numeric character side, and a 
binary representation on the alpha side.

EG: 

A = 0x0001
B = 0x0010
C = 0x0100

2 = 0x0111

For the numeric representation "225563" the transverser will do the following:

"C"->"M" -> "A" -> "L" -> "L" (add word) (set boundry) -> "E" -> "M" -> "E" (slots filled) (add word CALL-ME to results)

When a numeric character can not be mapped to a alpha character and there has been no previous representations of the 
character then the program will use the numeric character as part of the output, for instance:

2125563

would produce:

C1ALL-ME

20125563

would produce no output.

6.0 CAVEATS

Currently the program reads the dictionary file by slurping all lines into a array, this will not work for large 
dictionary files.

Creating the dictionary can be expensive with a estimated complexity of O(log n) for insertion.  It would be more 
efficient to save a representation of the dictionary to file an map it straight into the object.  

7.0 FUTURE IMPLEMENTATIONS

* Create a cached dictionary
* Allow for output to be JSON or another common format so that the progam can be bound to another app as part of a API.
* Allow for dictionary to be read from other sources apart from a text based file.
* Allow for large text file reads when creating dictionary.
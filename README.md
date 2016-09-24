1.0 NAME

2.0 SYNOPSIS

3.0 DESCRIPTION

4.0 OPTIONS

5.0 DESIGN

5.1 Dictionary Tree
The solution will use a bredth first search to find corresponding words for a given Full National Number (FNN) or part 
thereoff. A FNN will be considered a string of numeric characters that is terminated by the EOL character.  A list of
FNNs can be provided to the program.

The program will work in three distinct stages. The first step will be to parse the dictionary file.

Parsing of the dictionary file will create a tree representation of the words within the file. For example if we have
the following dictionary:

CALL
ME
CAP
CAPE

The tree representation would be:


0:   [C,      M]
1:   [A],    [E]
2: [P, P, L]
3: [E]   [L]

Branch "0" is contains two nodes that have the values "C" and "M", 
* the C node has a edge that joins it to the node with the value "A"
* the A node points to two nodes which both have the value "P", these will be referred to as P1 and P2.
* P1 points to the node "E", the E node is a final node and completes a word.
* P2 is a final node and complets a word.
* To the left of the C is the node with the value "M", this node contains one edge which has the node with the value "E"

5.2 Numeric Char Map

Each numeric character contains a bit mask which corresponds to a character representation, 

the bit masks to character representations are defined as follows:

A : 0x00000000000000000000000001
B : 0x00000000000000000000000010
C : 0x00000000000000000000000100
D : 0x00000000000000000000001000
E : 0x00000000000000000000010000
F : 0x00000000000000000000100000
G : 0x00000000000000000001000000
H : 0x00000000000000000010000000
I : 0x00000000000000000100000000
J : 0x00000000000000001000000000
K : 0x00000000000000010000000000
L : 0x00000000000000100000000000
M : 0x00000000000001000000000000
N : 0x00000000000010000000000000
O : 0x00000000000100000000000000
P : 0x00000000001000000000000000
Q : 0x00000000010000000000000000
R : 0x00000000100000000000000000
S : 0x00000001000000000000000000
T : 0x00000010000000000000000000
U : 0x00000100000000000000000000
V : 0x00001000000000000000000000
W : 0x00010000000000000000000000
X : 0x00100000000000000000000000
Y : 0x01000000000000000000000000
Z : 0x10000000000000000000000000


The tree in section 5.1 can now be represented as:

[0x00000000000000000000000100,                               0x00000000000001000000000000]
[0x00000000000000000000000001]                              [0x00000000000000000000010000]
[0x00000000001000000000000000, 0x00000000001000000000000000]
[0x00000000000000000000010000]


encoding on the phone the program will use is:
|| Digit  | Characters || Bitmask
+-------- +------------+-----------------------------
| 2       | A B C      | 0x00000000000000000000000111
| 3       | D E F      | 0x00000000000000000000111000
| 4       | G H I      | 0x00000000000000000111000000
| 5       | J K L      | 0x00000000000000111000000000
| 6       | M N O      | 0x00000000000111000000000000
| 7       | P Q R S    | 0x00000001111000000000000000
| 8       | T U V      | 0x00001110000000000000000000
| 9       | W X Y Z    | 0x11110000000000000000000000


Creating the tree will use the following algorithm

function (word, firstNode)
    currentNode = firstNode
    for each letter in word
             if curentNode.has(letter) && !lastLetter(currentNode.get(letter))
                 currentNode = currentNode.get(letter).nextNode

1-800-CODING-CHALLENGE

* should be a command line application that reads from files specified as command-line arguments or STDIN when no 
  files are given.
 
* Each line of these files will contain a single phone number.

* For each phone number read, your program should output all possible word replacements from a dictionary.

* Your program should try to replace every digit of the provided phone number with a letter from a dictionary word

** if no match can be made, a single digit can be left as is at that point.

* No two consecutive digits can remain unchanged and the program should skip over a number (producing no output) if a 
  match cannot be made.
  
* Your program should allow the user to set a dictionary with the -d command-line option,

* The dictionary is expected to have one word per line.

* All punctuation and whitespace should be ignored in both phone numbers and the dictionary file.

* The program should not be case sensitive, letting "a" == "A". Output should be capital letters and digits separated at 
  word boundaries with a single dash (-),
  
* one possible word encoding per line.

* 2255.63

One possible line of output is
CALL-ME

Dictonary File would be

CaLL
mE

encoding on the phone the program will use is:
|| Digit  | Characters ||
+-------- +------------+
| 2       | A B C      |
| 3       | D E F      |
| 4       | G H I      |
| 5       | J K L      |
| 6       | M N O      | 
| 7       | P Q R S    |
| 8       | T U V      |
| 9       | W X Y Z    |

2 = C 
2 = A
5 = L
5 = L

6 = M
3 = E

Data Structure


     [C, M]
     |   |
  [A]   [E]
   |
  [L]
   |
  [L]
  
Dictonary

CALL
ME
CAP
CAPE

   [C,  M]
    |      |
   [A]     [E]
    |     
  [P, P, L]
   |     |
 [E]    [L]

2255.63

CALL-ME
2C***
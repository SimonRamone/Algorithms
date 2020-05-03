# COMP20290 Algorithm Repository
Simonas Ramonas (18763829)

Contains all algorithms implemented as part of the practicals, 
performance graphs for the algorithms and completed practical sheets.

## Lab 1

### Russian Peasant Multiplication
An algorithm for multiplication that uses doubling, halving, and addition.

* RussianPeasantMultiplication.java
* Performance graph for various couples of numbers.
* Analysis of Algorithms practical sheet.

#### Compile

```
javac RussianPeasantMultiplication.java
```

#### Then run

```
java RussianPeasantMultiplication
```

#### Expected result after running

```
4464 * 9389 = 41912496
The time taken 31
```

## Lab 2

### Complexity Analysis
Two algorithms with different complexity that count the number of triples in a
file of N integers that sums to 0.

* ThreeSumA.java
* ThreeSumB.java
* In.class
* Text files with different amount of integers.
* Performance graph for visualizing the vastly different performance.
* Complexity Analysis practical sheet.

#### First compile both files

```
javac ThreeSumA.java
```

```
javac ThreeSumB.java
```

#### Then run them, entering the integer file after

```
java ThreeSumA 1Kints.txt
```

#### Expected result after running

```
70
the time taken 338
```

#### And run the second algorithm

```
java ThreeSumB 1Kints.txt
```

#### Expected result after running

```
count =70
the time taken 95
```

## Lab 3

### Recursion

#### Fibonacci and Towers of Hanoi

Two algorithms for calculating the first n numbers of Fibonacci sequence, 
one is iterative and the other is rcursive.

A recursive algorithm for calculating the moves for n disks to solve Towers of Hanoi.

* Fibonacci.java
* Hanoi.java
* Performance graphs.
* Recursion practical sheet.

#### Compile

```
javac Fibonacci.java
```

#### Then run

```
java Fibonacci
```

#### Expected result after running

```
0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 6765 10946 17711 28657 46368 75025 121393 196418 317811 514229 832040 1346269 2178309 3524578 5702887 9227465 14930352 24157817 39088169 63245986 
The time taken iterative: 22

0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 6765 10946 17711 28657 46368 75025 121393 196418 317811 514229 832040 1346269 2178309 3524578 5702887 9227465 14930352 24157817 39088169 63245986 
The time taken recursive: 971
```

#### And compile algorithm for Hanoi

```
javac Hanoi.java
```

#### Then run

```
java Hanoi
```

#### Expected result after running

```
Move disk from A to B
Move disk from B to C
Move disk from C to A
Move disk from A to B
Move disk from B to C
Move disk from C to A
Move disk from A to B
Move disk from B to C

The time taken 23
Min moves: 7
```

## Lab 4

### Elementary Sorting

Selection sort, insertion sort and Bogo sort.

A recursive algorithm for calculating the moves for n disks to solve Towers of Hanoi.

* sortingAlgorithms.java
* Performance graph.
* Elementary Sorting practical sheet.

#### Compile

```
javac sortingAlgorithms.java
```

#### Then run

```
java sortingAlgorithms
```

#### Example result after running

```
The time taken for selection 1k int 5

The time taken for selection 10k int 50

The time taken for selection 100k int 3255

The time taken for insertion 1k int 4

The time taken for insertion 10k int 28

The time taken for insertion 100k int 1770

The time taken for bogo 5 int 0

The time taken for bogo 10 int 737
```

## Lab 5

### Advanced Sorting Algorithms

Merge sort and enhanced merge sort and performance difference compared to insertion sort.

* sortingAlgorithms.java
* Performance graph.
* Advanced Sorting Algorithms practical sheet.

#### Compile

```
javac sortingAlgorithms.java
```

#### Then run

```
java sortingAlgorithms
```

#### Example result after running

```
The time taken for insertion 1k int 4

The time taken for insertion 10k int 27

The time taken for insertion 100k int 1759

The time taken for mergeSort 1k int 1

The time taken for mergeSort 10k int 3

The time taken for mergeSort 100k int 39

The time taken for mergeSortEnhanced 1k int 0

The time taken for mergeSortEnhanced 10k int 4

The time taken for mergeSortEnhanced 100k int 41
```

## Lab 6

### Efficient Sorting Algorithms

Quick sort and performance difference compared to merge sort.

* sortingAlgorithms.java
* KnuthShuffle.java
* Sorts.java
* quickSort.java
* Performance graph.
* Efficient Sorting Algorithms practical sheet.

#### Compile

```
javac sortingAlgorithms.java
```

#### Then run

```
java sortingAlgorithms
```

#### Example result after running

```
The time taken for quickSort 1k int 1

The time taken for quickSort 10k int 1

The time taken for quickSort 100k int 9

The time taken for enhancedQuickSort 1k int 5

The time taken for enhancedQuickSort 10k int 44

The time taken for enhancedQuickSort 100k int 2827

The time taken for mergeSortEnhanced 1k int 1

The time taken for mergeSortEnhanced 10k int 3

The time taken for mergeSortEnhanced 100k int 44
```

## Lab 7

### Substring Search Algorithms
Brute force search and Knuth–Morris–Pratt algorithms, finds index of a substring. test1.txt contains 3 sets of two strings so six in total. Where one of the two strings contains the substring in the middle while the other contains it at the end. The substring to search is after each string. The strings are of varying length (1k chars, 5k chars and 10k chars).

* bruteForceSearch.java
* KMPsearch.java
* test1.txt
* Performance graph.
* Substring Search practical sheet.

#### First compile both files

```
javac bruteForceSearch.java
```

```
javac KMPsearch.java
```

#### Then run them

```
java bruteForceSearch
```

#### Example result after running

```
500
the time taken 0.347696
990
the time taken 0.205766
2500
the time taken 0.471708
4990
the time taken 0.621288
4500
the time taken 1.061575
9990
the time taken 0.81057
```

#### And run the second algorithm

```
java KMPsearch
```

#### Example result after running

```
500
the time taken 0.489292
990
the time taken 0.213525
2500
the time taken 0.667367
4990
the time taken 0.633086
4500
the time taken 1.819359
9990
the time taken 1.349931
```

## Lab 8

### Tries

A trie is a tree-like data structure whose nodes store the letters of an alphabet. By structuring the nodes in a particular way, words and strings can be retrieved from the structure by traversing down a branch path of the tree.Tries can be extremely useful in searching for a word in a dictionary of words. It is ​important to note that a trie will only work if there are no words that are pre-fixes of an other word in the input set.

Trie.java builds a trie from a string array of words. The searches for words that are and aren't in the trie and prints 'Not present in trie' or 'Present in trie' for each.

* Trie.java
* Tries practical sheet.

#### Compile

```
javac Trie.java
```

#### Then run

```
java Trie
```

#### Example result after running

```
Not present in trie
Present in trie
Not present in trie
Present in trie
Not present in trie
Not present in trie
Present in trie
Present in trie
```

## Lab 9

### Run Length Compression

RunLengthEncoding.java takes in a string as a command line argument and returns a compressed string that uses Run Length Encoding. Works best when there are many repeating chars one after another.

* RunLengthEncoding.java
* Run Length Compression practical sheet.
* Files and algorithms to help complete the practical sheet.

#### Compile

```
javac RunLengthEncoding.java
```

#### Then run

```
java RunLengthEncoding
```

## Huffman Compression Assignment

**Simonas Ramonas (18763829)**

**Shijie Liu (18439314)**

Huffman.java provides static methods for compressing and decompressing text input using Huffman coding.

* Huffman.java and other source files
* Text files for testing
* Huffman Trie Drawing
* Huffman Compression Algorithm Analysis

#### Compile

```
javac Huffman.java
```

#### Compress

```
java Huffman compress < input.txt > output.txt
```

#### Decompress

```
java Huffman decompress < input.txt > output.txt
```
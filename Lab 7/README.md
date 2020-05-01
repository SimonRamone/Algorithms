# Substring Search Algorithms
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

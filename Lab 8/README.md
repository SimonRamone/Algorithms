# Tries

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


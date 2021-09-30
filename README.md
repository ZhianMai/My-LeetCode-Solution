# My LeetCode Solution Examples (Java)

Many posted solutions on leetcode are with improper style or logic, making them less readable.

This repo is a collection of some of my leetcode solutions. They will
* follow the Google Java Coding style guide (yes, indentation +2 spaces);
* be optimal solutions;
* be easy to read with clear logic.

## Highlited Solutions

- ### BinarySearch/BinarySearch.java 
  :link:[link](Binary%20Search/BinarySearch.java)
- I included four ways to write binary search on a sorted array, and I consider that these four ways are "Design Pattern" for most of the binary search problems, such as first occurrence, last occurrence, first smallest larger than target, last largest smaller than target...

<br />

- ### DFS/JumpGameIII.java 
  :link:[link](DFS/JumpGameIII.java)

- One of my favorite solutions! In general, it needs a boolean[] to record what elements has been visited, but I recorded the visited elements by making it negative instead of using a boolean[] array. Since the DFS needs to add and minus current element, so its mathematical symbol (+ or -) doesn't matter!

<br />

- ### DFS/CombinationSizeK.java
  :link:[link](DFS/CombinationSizeK.java)

- For solving fixed-length output problems using back-tracking method, I prefer to use Java array, which is fixed-size, instead of mutable class, such as StringBuilder and List. I implemented using Java array methods and using ArrayList methods. On my computer, for fixed k = 2, the performance threshold is n = 6200. Once n beyond 6200, the ArrayList method would significantly slow down, despite the fact that their runtime O() is the same.

<br />

- ### DFS/GeneratingParentheses.java
  :link:[link](DFS/GeneratingParentheses.java)

- Yes, I like DFS problem! I did not use StringBuilder here, and the total lines of code is only 13. It's easier to read and maintain. Since it gets rid of append-remove, the dfs method needs to know which index (or the depth of recursion tree) is currently traversing.

<br />

- ### DP/MinimumCostCuttingStick.java
  :link:[link](DP/MinimumCostCuttingStick.java)

- This should be considred one of the most difficult problems in DP problem set! The main logic code has only 15 lines, but the comments are twice of it.

<br />

- ### Strings/LongestPalindromicSubstring.java
  :link:[link](Strings/LongestPalindromicSubstring.java)

- Check odd and even length of substring at the same time by specifying the begin & end index of substring.

<br />

- ### Strings/string/
  :link:[link](Strings/string/decode)
  
- It's a problem form a coding challenge. Since I cannot access the original platform anymore, so I implemented it and provided Junit testing.

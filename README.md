# My LeetCode Sample Solutions (in Java)
<br />

## Prologue
Consider LeetCode is an online gaming platform! Players are smart guys around the world, and the fun is to compete them on runtime ranking.

This repo is a collection of some of my leetcode solutions. Many posted solutions on leetcode are with improper style or logic, making them less readable. So I would like to post my solution codes here.

### Rules of code
My solution code will:
* follow the Google Java Coding style guide (yes, indentation +2 spaces);
* follw some items (rules) in the book <i>Effective Java</i>, such as:
  * class name should be norn, whereas function name should be verb;
  * single method for single functionality;
  * function parameter list should not be too long;
  * reuse object if possible, etc.
   <br /><br />
But... this book is very thick, so I may violate some rules unintentionaly :(
* be optimized for runtime first, then for memory usage. But if the optimized solution is hard to read and understand, I may discard it;
* be easy to read and understand with clear logic.

I also appreciate Uncle Bob's saying: <i>good code can be understood without commenting.</i>

### Follow-ups for problems
For each solution, try to answer two follow-ups:
* How to run this solution with a lot of input data (1TB) on a PC which has limited memory (100MB)?
* How ro run this solution on a distributed cluster, like a leading node distribute work to many worker nodes?

These two questions are very similiar to answer: 

* Which part of the solution can run in parallel or multi-threaded?
* If this part of the solution cannot run in parallel due to consistent state transfer, is it possible to change to parallelable implementation, like binary reduction, or k-way merge using heap?
* If this part of the solution can run in parallel, how to minimize data transfer? 
<br />

## Highlited Solutions
The solutions below are my favorite or representative for solving similar problems. I may provide some analysis or thought for some of them.

- ### BinarySearch/BinarySearch.java 
  :link:[link](Binary%20Search/BinarySearch.java)
- I included four ways to write binary search on a sorted array:
  - while (left <= right)
  - while (left < right)
  - while (left < right), with mid += (right - left) % 2
  - while (left < right - 1)
- I consider that these four ways are "Design Pattern" for most of the binary search problems, such as first occurrence, last occurrence, first smallest larger than target, last largest smaller than target...

<br />

- ### BinarySearch/MountainArraySearch.java 
  :link:[link](Binary%20Search/MountainArraySearch.java)
- Is binary search can only apply to sorted array? I don't think so. Like the library book problem: there is an unscaned book in a group of scanned book, how to find it out with fewest scan. Is the book "sorted"? If it's not, why can it use binary search? 
- There existes an element a[i] in an array a[n], such that for all elements a[j] in a[n], if it can exclude at least ONE of the three situations recursively:
  - i == j;
  - i < j;
  - i > j.  

- then element a[i] can be found in a[n] using binary search.

<br />

- ### Binary Tree/PreorderInorderBuildingTree.java
  :link:[link](Binary%20Tree/PreorderInorderBuildingTree.java)
- This is one of the tree deserializing problem. Similiar problems are:
  - select two from in-order, pre-order, post-order, and level-order traversal to build binary tree;
  - select one from four types of traversal to build binary search tree.

- I summarized the rules of solving tree deserializing problems.
  - To build a tree, if for each tree node, one can confirm: <b>its value, AND the sets of node for its left and right children</b>, then the tree can be constructed.
  - Pre-order traversal can confirm the value of current node, which is the first element, but cannot confirm sets of left and right children. But if given the size of left or right children, then it can confirm the set of left and right children.
  - In-order traversal cannot confirm the value of current node. But if given the value of current node, it can confirm the set of left and right children.
  - Post-order traversal is similar to in-order traversal.
  - Level-order traversal can confirm the value of current node but cannot confirm the sets of left and right children node. But if provide a list of left or children nodes, then it can divide into left children level-order traversal and right children level-order traversal. This is the most difficult one of all tree desrializing problems.

- To build binary tree (including binary search tree) with:
  - Pre-order and post-order. It cannot confirm each nodes left and right children sets, so the solution is not unique. Example: linked-list style tree has same in-order and post-order.
  - Pre-order and in-order. Get the node value from pre-order, than use it to split left children node set and right children node set from in-order. Tree can be built because two requirements are met.
  - Post-order and in-order. Very similiar to the pre-order and in-order.
  - Pre-order/Post-order and level-order. It's impossible, because the left and right children set cannot be obtained from them.
  - Level-order and in-order. Get the value of current node value, than use it to split left children node set and right children node set from in-order. Then use the children set to split level-order traversal into left children level-order and right children level-order traversal. <b>The current level-order traversal is merged by left children level-order and right children level-order traversal.</b>

- To build binary search tree with:
  - In-order traversal only. It cannot confirm the current value of the node, since it's a sorted array :(
  - Pre-order, post-order, or level-order only. Recall the most important property of binary search tree: <b>for each node in binary search tree, all nodes in its left subtree are smaller than its value, and all nodes in its right subtree are larger than its value.</b> So the current root value can be obtained from any of these traversals, then use the BST property to split it into left and right subtree xx-order traversal.

<br/>

- ### DFS/JumpGameIII.java 
  :link:[link](DFS/JumpGameIII.java)
- One of my favorite solutions! In general, it needs a boolean[] to record what elements has been visited, but I marked the visited elements by flipping it negative instead of using a boolean[] array. Since the DFS needs to add and minus current element, so its mathematical symbol (+ or -) doesn't matter!

<br />

- ### DFS/CombinationSizeK.java
  :link:[link](DFS/CombinationSizeK.java)
- For solving fixed-length output problems using back-tracking method, I prefer to use Java array, which is fixed-size, instead of mutable class, such as StringBuilder and List. I implemented it using both Java array methods and using ArrayList methods for performance testing. On my computer, for fixed k = 2, the performance threshold is n = 6200. Once n beyond 6200, the ArrayList method would significantly slow down, despite the fact that their runtime O() is the same.

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

<br />

- ### Stack & Queue/EatingLunch.java
  :link:[link](Stack%20%26%20Queue/EatingLunch.java)
- The input are data in a stack and a queue, and it's interesting to solve this probelm without using a stack or a queue. If using a stack and a queue, the runtime would be O(n^2) and space would be O(n). But now the runtime is O(n) and space is O(1)!


<br />

- ### DFS/PartitionKSubsets.java
  :link:[link](DFS/PartitionKSubsets.java)
- Efficient DFS logic can significantly reduce the runtime.

<br />

- ### Arrays/ContainerWithMostWater.java
  :link:[link](Arrays/ContainerWithMostWater.java)
- I got this problem on the Leetcode mock OA. It's hard to believe I could come out the greedy algorithm to solve this problem within the time limit. In general, this kind of problem are usually fall into DP category. But the most difficult part is to prove its correctness.
- Suppose the solution is (arr[i], arr[j]), then there is no arr[h] such that h < i && arr[h] > arr[i]; and there is no arr[k] such that k > j && arr[j] < arr[k] neither, otherwise (arr[i], arr[j]) is not the solution. So using greedy algorithm to shrink left and right pointer, it would eventually reach index i and j by left and right pointer. 


<br />

- ### DP/LongestCommonSubsequence.java
  :link:[link](DP/LongestCommonSubsequence.java)
- This is a 2-D array DP, but I optimize it to Space O(m) by using mod operation to alternate two 1-D arrays. The similiar problem edit distance can also be optimized in this way.

<br />

- ### DFS/NQueens.java
  :link:[link](DFS/NQueens.java)
- N-queens, the most complicated problems I have had on LeetCode.

<br/>

## Epilogue
Failure is like compile/runtime error, often comes first before getting success. If the first pass get success, then it means the problem is very simple or I'm well-prepared. But all I need is that one success, and once I got it, the number of failure won't bother me anymore. Not being allowed to join the top level class does not mean my skill can not reach the top level forever, right?

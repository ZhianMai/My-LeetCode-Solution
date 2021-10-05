# My LeetCode Sample Solutions (in Java)
<br />

<p align="center">
  <img src="/Problem%20Solver.jpg" />
  <br />
  <i>Problem Solver</i>
</p>

## Prologue
Consider LeetCode is an online gaming platform! Players are smart guys around the world, and the fun is to compete them on runtime ranking.

This repo is a collection of some of my leetcode solutions. Many posted solutions on leetcode are with improper style or logic, making them less readable. So I would like to share my solution codes with some thoughts and analysis here.
<br />

### Problem-solving methodology
Memorizing solution codes can hardly bring one's ability to higher level. If the problem is slightly modified, can the solution code still work? What I'm aiming for is to develop a strong problem analyzing and solving ability that can help solving new problems. This ability includes:
- The input and output data schema and restrictions;
- What the problem is, how to break it down, and how to solve it;
- Starting from brute force approach, find duplicated or unnecessary operation and try to simplify it by better data structure and algorithm;
- <b>Variables have clear semantics</b>, such as the pointer is inclusive or exclusive to current element, and what i, j, k stands for in for-loop. With clear semantics for each variables, off-by-one errors can mostly avoid.
- Improvement analysis based on TC & SC O(*).

### Rules for code
My solution code will:
* follow the Google Java Coding style guide (yes, indentation +2 spaces);
* follow some items (rules) in the book <i>Effective Java</i>, such as:
  * class name should be norn, whereas function name should be verb;
  * single method for single functionality;
  * function parameter list should not be too long;
  * reuse object if possible, etc.
   <br /><br />
But... this book is very thick, so I may violate some rules unintentionaly :(
* be optimized for runtime first, then for memory usage. But if the optimized solution is hard to read and understand, I may discard it;
* be easy to read and understand with clear logic.

I also appreciate Uncle Bob's saying: <i>good code can be understood without commenting.</i>
<br />

### Follow-ups for problems
For each solution, try to answer two follow-ups:
* How to run this solution with a lot of input data (1TB) on a PC which has limited memory (100MB)?
* How ro run this solution on a distributed cluster, like a leading node distributing work to many worker nodes?

These two questions are very similiar to answer: 

* Which part of the solution can run in parallel or multi-threaded?
* If this part of the solution cannot run in parallel due to consistent state transfer, is it possible to change to parallelable implementation, like binary reduction, or k-way merge using heap?
* If this part of the solution can run in parallel, how to minimize data transfer? 

### Legacy
I used to take notes on Google doc :link:[link](https://docs.google.com/document/d/19Kqqg7O1uSLHrBmcvUBuL8otUgsI0nNc3m3-W3wviXI/edit?usp=sharing), but that was not a very good choice, since it does not support code block. So I moved some of my notes to here.

## Highlited Solutions
The solutions below are my favorite or representative for solving similar problems. I may provide some analysis or thought for some of them.

* [Binary Search](#binary_search)
* [Binary Tree](#binary_tree)
* [DFS](#d_f_s)
* [DP](#d_p)
* [Stack & Queue](#stack_and_queue)
* [Arrays](#array_s)
* [Strings](#string_s)
* [Linked List](#linked_list)

<br />

<a name="binary_search"></a>
### Binary Search
<hr />

#### BinarySearch/BinarySearch.java 
  :link:[link](Binary%20Search/BinarySearch.java)

I included four ways to write binary search on a sorted array:
  - while (left <= right)
  - while (left < right)
  - while (left < right), with mid += (right - left) % 2
  - while (left < right - 1)

I consider that these four ways are "Design Pattern" for most of the binary search problems, such as first occurrence, last occurrence, first smallest larger than target, last largest smaller than target, closest to target...

When coding binary search, always remember three rules:
  - On each iteration, the search space should reduce half. But exceptions may apply, like problem "Search first occurence minimum in mountain array", which includes left++ or right-- inside while loop.
  - In situation when doing left = mid + 1 or right = mid - 1, do not accidently exclude the target.
  - When the search space is about to exit the while loop, make sure it won't fall into infinite loop by testing:
    - no such target;
    - target placed at each index. 
  
<br />

#### BinarySearch/MountainArraySearch.java 
  :link:[link](Binary%20Search/MountainArraySearch.java)
- Is binary search can only apply to sorted array? I don't think so. Like the library book problem: there is an unscaned book in a group of scanned book, how to find it out with fewest scan. Is the book "sorted"? If it's not, why can it use binary search? 
- There existes an element a[i] in an array a[n], such that for all elements a[j] in a[n], if it can exclude at least ONE of the three situations recursively:
  - i == j;
  - i < j;
  - i > j.  

- then element a[i] can be found in a[n] using binary search.

<br />

<a name="binary_tree"></a>
### Binary Tree
<hr />

#### Binary Tree/MultipleNodesDeletion.java
  :link:[link](Binary%20Tree/MultipleNodesDeletion.java)
- This is the most difficult tree recursion problem I have solved. In general, for solving tree-recursion problem, one needs to figure out:
  - For current node, what do I get from parent node?
  - What should I do?
  - What should I pass to children node? 
- It seems that many such problems using post-order traversal is easier than pre-order traversal.

<br />

#### Binary Tree/PreorderInorderBuildingTree.java
  :link:[link](Binary%20Tree/PreorderInorderBuildingTree.java)
- This is one of the tree deserializing problems. Similiar problems are:
  - select two from in-order, pre-order, post-order, and level-order traversal to build binary tree;
  - select one from four types of traversal to build binary search tree.

- I summarized the rules of solving tree deserializing problems.
  - To build a tree, if for each tree node, one can confirm: <b>its value, AND the sets of node for its left and right subtree</b>, then the tree can be constructed.
  - Pre-order traversal can confirm the value of current node, which is the first element, but cannot confirm sets of left and right subtrees' node. But if given the size of left or right subtree node set, then it can confirm the set of left and right subtrees' nodes.
  - In-order traversal cannot confirm the value of current node. But if given the value of current node, it can confirm the set of left and right subtrees' nodes.
  - Post-order traversal is similar to pre-order traversal.
  - Level-order traversal can confirm the value of current node, but cannot confirm the sets of left and right subtrees' nodes. But if provided a list of left or right subtree's nodes, then it can divide into left subtree level-order traversal and right subtree level-order traversal. This is the most difficult one of all tree desrializing problems.

- To build binary tree (including binary search tree) with:
  - Pre-order and post-order. It cannot confirm each nodes left and right subtrees' node sets, so the solution is not unique. Example: linked-listed binary tree has same in-order and post-order results.
  - Pre-order and in-order. Get the node value from pre-order, than use it to split left subtree's node set and right subtree's node set from in-order. Tree can be built because two requirements are met.
  - Post-order and in-order. Very similiar to the pre-order and in-order.
  - Pre-order/Post-order and level-order. It's impossible, because the left and right subtrees' node set cannot be obtained from them.
  - Level-order and in-order. Get the value of current node value, than use it to split left subtree's node set and right subtree's node set from in-order. Then use the subtree's node set to split level-order traversal into left subtree level-order and right subtree level-order traversal. <b>The current level-order traversal is merged from left subtree level-order and right subtree level-order traversal.</b>

- To build binary search tree with:
  - In-order traversal only. It cannot confirm the current value of the node, since it's a sorted array :(
  - Pre-order, post-order, or level-order only. Recall the most important property of binary search tree: <b>for each node in binary search tree, all nodes in its left subtree are smaller than its value, and all nodes in its right subtree are larger than its value.</b> So the current root value can be obtained from any of these traversals, then use the BST property to split it into left and right subtrees' xx-order traversal.

<br/>

<a name="d_f_s"></a>
### DFS
<hr />

DFS is usually for solving premutation & combination problems. Most of the time only traversing all possibilities can solve the problem. When solving DFS, the problems below should be addressed:
- What input is, and what output is.
- How many levels (how deep) for the DFS recursion tree?
- Each level has what input, what to do, and what for next DFS call?
- For the last level, how to verify and store the solutions.

The last level should not do heavy work that requires TC or SC greater than O(n), like using a hashmap to deduplicate, or sorting the result. If so, break these heavy work to all previous level to finish.

#### DFS/JumpGameIII.java 
  :link:[link](DFS/JumpGameIII.java)
- One of my favorite solutions! In general, it needs a boolean[] to record what elements has been visited, but I marked the visited elements by flipping it negative instead of using a boolean[] array. Since the DFS needs to add and minus current element, so its mathematical symbol (+ or -) doesn't matter!
- Unlike previous jump games, this time the game does not fall into DP category.

<br />

#### DFS/CombinationSizeK.java
  :link:[link](DFS/CombinationSizeK.java)
- For solving fixed-length output problems using back-tracking method, I prefer to use Java array, which is fixed-size, instead of mutable class, such as StringBuilder and List. I implemented it using both Java array methods and using ArrayList methods for performance testing. On my computer, for fixed k = 2, the performance threshold is n = 6200. Once n beyond 6200, the ArrayList method would significantly slow down, despite the fact that their runtime O() is the same.

<br />

#### DFS/GeneratingParentheses.java
  :link:[link](DFS/GeneratingParentheses.java)
- Yes, I like DFS problem! I did not use StringBuilder here, and the total lines of code is only 13. It's easier to read and maintain. Since it gets rid of append-remove, the dfs method needs to know which index (or the depth of recursion tree) is currently traversing.

<br />

#### DFS/PartitionKSubsets.java
  :link:[link](DFS/PartitionKSubsets.java)
- I provided two ways to do DFS. It shows that efficient DFS logic can significantly reduce the runtime.

<br />

#### DFS/NQueens.java
  :link:[link](DFS/NQueens.java)
- N-queens, the most complicated problems I have had on LeetCode.
- Use boolean tables to mark down placed queen position to support O(1) look up when placing new queen.

<br/>

<a name="d_p"></a>
### DP
<hr />

#### DP/MinimumCostCuttingStick.java
  :link:[link](DP/MinimumCostCuttingStick.java)
- This should be considred one of the most difficult problems in DP problem set! The main logic code has only 15 lines, but the comments are twice of it.

<br />

#### DP/LongestCommonSubsequence.java
  :link:[link](DP/LongestCommonSubsequence.java)
- This is a 2-D array DP, but I optimize it to Space O(m) by using mod operation to alternate two 1-D arrays. Some similiar problems like edit distance can also be optimized in this way.

<br />

#### DP/JumpGame.java
  :link:[link](DP/JumpGame.java)
- This is a very good example for DP "reverse-engineering" thinking. Solving this problem can use either top-down or bottom-up DP method.
- Greedy method can also solve this problem, and it has both top-down or bottom-up methods as well.
- I included four ways to solve this problem.

<br/>

#### DP/DungeonGame.java
  :link:[link](DP/DungeonGame.java)
- This is another very good example for DP "reverse-engineering" thinking that the DP form is filled in bottom-up order. If one wants to fill DP form out in top-down order, then dp[i][j] means "Minimum DP needed to reach matrix[i][j] from matrix[0][0]", and I don't think there exists such a transition function. But if to fill DP form out in bottom-up order, then dp[i][j] means "Minimum DP needed to reach matrix[n - 1][m - 1] from matrix[0][0]", and this makes more sense.
- This problem can reduce the space complexcity to O(1) by using the input matrix as DP table. But modifying the input data is not a good practice (how if it's immutable?), and the logic is more complicated, since the DP form contains a dummy row and dummy column.

<br/>

<a name="stack_and_queue"></a>
### Stack and Queue
<hr />

#### Stack & Queue/EatingLunch.java
  :link:[link](Stack%20%26%20Queue/EatingLunch.java)
- The input are data in a stack and a queue, and it's interesting to solve this probelm without using a stack or a queue. If using a stack and a queue, the runtime would be O(n^2) and space would be O(n). But now the runtime is O(n) and space is O(1)!

<br />

<a name="array_s"></a>
### Arrays
<hr />

#### Arrays/ContainerWithMostWater.java
  :link:[link](Arrays/ContainerWithMostWater.java)
- I got this problem on the Leetcode mock OA. It's hard to believe I could come out the greedy algorithm to solve this problem within the time limit. In general, this kind of problem are usually fall into DP category. But the most difficult part is to prove its correctness.
- Suppose the solution is (arr[i], arr[j]), then there is no arr[h] such that h < i && arr[h] > arr[i]; and there is no arr[k] such that k > j && arr[j] < arr[k] neither, otherwise (arr[i], arr[j]) is not the solution. So using greedy algorithm to shrink left and right pointer, it would eventually reach index i and j by left and right pointer. 

<br />

<a name="string_s"></a>
### Strings
<hr />

#### Strings/LongestPalindromicSubstring.java
  :link:[link](Strings/LongestPalindromicSubstring.java)
- Check odd and even length of substring at the same time by specifying the begin & end index of substring.

<br />

#### Strings/string/
  :link:[link](Strings/string/decode)
  
- It's a problem form a coding challenge. Since I cannot access the original platform anymore, so I implemented it and provided Junit testing.

<br />

<a name="linked_list"></a>
### Linked List
<hr />


#### LinkedList/MergingKLists.java
  :link:[link](LinkedList/MergingKLists.java)
  
- This is a classical problem of k-input problems, like finding maximum / minimum / medinum from k arrays.
- There're typcial three ways to approach these problems:
  - Iteration each input;
  - Binary reduction on each two inputs recursively (divide and conquer);
  - Do them concurrently.

- I included three ways to solve this problem using the three approaches above.

<br />

## Epilogue
Failure is like compile/runtime error, often comes first before getting success. If the first pass get success, then it indicates the problem is simple or I'm well-prepared. But all I need is that one success, and once I got it, the number of failure won't bother me anymore. Not being allowed to join the top level class does not mean my skill can not reach the top level forever, right?

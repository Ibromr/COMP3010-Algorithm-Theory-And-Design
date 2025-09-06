### First a little Dynamic Programming

# Longest Common Subsequence (LCS) 
The **Longest Common Subsequence (LCS)** problem focuses on finding the longest sequence that appears in both strings, maintaining the order but not necessarily consecutively.

## Example:
- **String 1**: `ABCBDAB`
- **String 2**: `BDCABB`
- The **longest common subsequence (LCS)** is: `BDAB`.

## Key Concepts

### Subsequence
A **subsequence** is formed by deleting some or no elements from the original sequence, without altering the order of the remaining elements.

### Longest Common Subsequence (LCS)
The **LCS** is the longest sequence that appears in both strings in the same order, but not necessarily consecutively.

## Dynamic Programming Approach

### Problem
The challenge is to find the longest subsequence common to both strings in an efficient manner.

### Optimal Substructure
The LCS of two strings can be divided into smaller subproblems:
1. **If the last characters of the two strings match**, the character is included in the LCS.
2. **If the last characters do not match**, the maximum LCS is determined by either excluding the last character of the first string or the second string.

### Memoization (Top-Down)
Results of subproblems (already solved parts) are stored to avoid recalculating them.

### Tabulation (Bottom-Up)
The solution is built iteratively, starting from the smallest subproblems, by filling up a table.

## Time Complexity
- The naive recursive approach has **exponential time complexity**.
- With dynamic programming (using either memoization or tabulation), the problem is solved in **O(m * n)** time, where **m** and **n** are the lengths of the two strings.

## Space Complexity
- The space complexity is **O(m * n)** for storing solutions to subproblems.
- The space can be optimized by storing only **two rows** of the table, reducing space requirements.

## Summary
The **LCS problem** applies dynamic programming to solve the problem efficiently by storing solutions to overlapping subproblems, which avoids redundant calculations. This approach is far more efficient than brute-force recursive methods.

# Greedy Algorithms - Overview

Greedy algorithms are a class of algorithms for optimization problems. At each step, the algorithm makes the choice that seems the best at the moment, with the aim of finding a global optimal solution. They are typically more efficient than dynamic programming approaches for certain problems. Though greedy algorithms do not always guarantee an optimal solution, they work well for many problems.

## Key Concepts

### Local vs. Global Optimum
- **Greedy Choice**: A locally optimal choice made at each step.
- **Goal**: The hope is that local optimal choices will lead to a global optimum.

## When to Use Greedy Algorithms?
- Greedy algorithms are ideal for problems where a sequence of locally optimal choices leads to a global optimum.
- These algorithms work best when the problem exhibits the **Greedy Choice Property** and **Optimal Substructure**.

### Example: Activity-Selection Problem
In the activity-selection problem, a set of activities needs to use a shared resource, like a conference room, and the goal is to select the maximum number of non-overlapping activities.

- **Greedy Strategy**: Choose the activity that finishes the earliest, leaving space for other activities.
- **Result**: The greedy algorithm efficiently selects the maximum number of compatible activities.

## Greedy Algorithm Approach

### 1. Activity-Selection Problem
The problem involves a set of activities, each with a start and finish time, and the goal is to choose the maximum number of non-overlapping activities.

- Activities are sorted by finish time.
- The algorithm selects the first activity that finishes, then continues by selecting the next compatible activity.

### 2. Greedy Choice Justification
- **Theorem**: The activity that finishes first will always be part of the optimal solution.
- **Proof**: Selecting any other activity with a later finish time reduces the total number of compatible activities.

## Time Complexity

Both recursive and iterative greedy algorithms operate in **O(n)** time, assuming the activities are already sorted by finish time.

Greedy algorithms serve as powerful tools for solving optimization problems where locally optimal choices lead to globally optimal solutions. The activity-selection problem serves as a classic example of how a greedy approach can solve such problems efficiently.

In developing a greedy algorithm, the following steps are usually followed:
1. Identify the problem's optimal substructure.
2. Develop a recursive solution based on this structure.
3. Prove that the greedy choice will lead to an optimal solution.
4. Convert the recursive solution to an iterative one.

Greedy algorithms are efficient but require careful testing to ensure that local choices do not lead to suboptimal solutions. The two critical components for a greedy algorithm to work are:

- **Greedy-Choice Property**: Making locally optimal choices at each step leads to a globally optimal solution.
- **Optimal Substructure**: The problem's solution contains optimal solutions to its subproblems, which is similar to dynamic programming in some cases.

A dynamic programming approach can be more involved than a greedy one, as it solves subproblems first and then combines their solutions. For example, the **0-1 knapsack problem** requires dynamic programming, as a greedy approach does not always provide the optimal solution.


- **Greedy algorithms** work best when local optimal choices can lead to a global optimum, following the **Greedy-Choice Property** and **Optimal Substructure**.
- **Dynamic programming** is more suitable when solutions depend on subproblems, especially when overlapping subproblems are involved.
- The key difference between greedy algorithms and dynamic programming is that greedy algorithms make decisions based only on current conditions, while dynamic programming considers the full problem by solving subproblems first.

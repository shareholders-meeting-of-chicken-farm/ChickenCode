# CLAUDE.md - AI Assistant Guide for ChickenCode

## Project Overview

ChickenCode is a collaborative LeetCode solutions repository managed by the "Minhe Chicken Farm" team (three shareholders). The repository contains Java solutions to LeetCode problems, organized by weekly study sessions.

**License:** Apache License 2.0

## Repository Structure

```
ChickenCode/
├── week01/ - week08/     # Weekly problem directories
│   └── leetcode_XXXX/    # Individual problem folders (XXXX = problem number)
│       └── Solution_username_vN.java
├── README.md             # Project rules (in Chinese)
├── LICENSE               # Apache 2.0
├── .gitignore            # Python-focused (template artifact)
└── CLAUDE.md             # This file
```

### Directory Organization

- **Weekly folders** (`week01` through `week08`): Each week contains 2-7 LeetCode problems
- **Problem folders**: Named `leetcode_XXXX` or `LeetCode_XXXX` (lowercase preferred)
- **Solution files**: Multiple solutions per problem from different contributors

## Programming Language

**Primary Language: Java**
- Standard Java with no external dependencies
- Uses Java standard library (`java.util`, `java.util.concurrent.locks`)
- Solutions are standalone classes designed for direct LeetCode submission
- No build system (Maven/Gradle) - files are submitted directly to LeetCode

## Code Conventions

### File Naming

```
Solution_[username]_v[version].java
```

- `username`: Contributor identifier (e.g., `momo262`)
- `version`: Iteration number starting from `v0` (e.g., `v0`, `v1`, `v2`)
- Prefer lowercase `solution_` prefix (inconsistently used in codebase)

**Examples:**
- `Solution_momo262_v0.java` (first solution)
- `Solution_momo262_v1.java` (improved solution)

### Package Naming

Package names must match the problem folder name:

```java
package leetcode_1254;  // Matches folder name
```

### Class Structure

```java
package leetcode_XXXX;

public class Solution_username_vN {
    // Instance variables for shared state
    private int someField;

    // Main algorithm method (signature from LeetCode)
    public ReturnType mainMethod(Parameters params) {
        // Implementation
    }

    // Helper methods
    private void helperMethod() {
        // Supporting logic
    }
}
```

### Coding Patterns

The codebase demonstrates several common algorithm patterns:

1. **DFS (Depth-First Search)**: Graph traversal, island problems
   ```java
   private void travel(int[][] grid, int row, int col) {
       if (grid[row][col] == 1) return;
       grid[row][col] = 1;  // Mark visited
       // Recursive calls in 4 directions
   }
   ```

2. **Concurrency**: Thread synchronization problems
   ```java
   private static Object lock = new Object();
   synchronized (lock) {
       while (!condition) { lock.wait(); }
       // Critical section
       lock.notifyAll();
   }
   ```

3. **Memoization**: Dynamic programming with cached results
   ```java
   private static int[][] memo = new int[14][14];
   ```

4. **ReentrantLock**: Complex synchronization scenarios
   ```java
   public static List<ReentrantLock> lockList = new ArrayList<>();
   ```

### Code Style Guidelines

- Inline comments for algorithm explanation
- No error handling (LeetCode guarantees valid input)
- Helper methods extracted for clarity
- Instance variables for shared state across recursive calls

## Development Workflow

### Team Rules (from README.md)

1. **Problem Selection**: 2-3 problems per week, selected in rotation
2. **Branch Workflow**: Contributors create personal branches
3. **Naming**: Files named as `problemNumber-submitter.java`
4. **Verification**: Solutions must pass LeetCode before committing
5. **Code Review**: Request merge from another team member
6. **Deadline**: Saturday midnight (China time), with penalties for incomplete work

### Git Workflow

1. Create a feature branch
2. Add solution to appropriate `weekXX/leetcode_XXXX/` folder
3. Verify solution passes on LeetCode
4. Commit with descriptive message
5. Request merge from team member

### Commit Message Convention

```
solve question leetcode XXXX,YYYY,ZZZZ
```

Example: `solve question leetcode 1226,1227,1232,1233,1234`

## Problem Categories

The repository covers diverse algorithm topics:

| Category | Problem Examples | Key Concepts |
|----------|------------------|--------------|
| Graph | 1254 (Closed Islands) | DFS, BFS, flood fill |
| Concurrency | 1114-1117 | Synchronization, locks, thread ordering |
| Math | 1250 (GCD), 1252 | Number theory, optimization |
| DP | 1240 (Tiling) | Recursion, memoization |
| Strings | 1249, 1255 | Manipulation, scoring |

## For AI Assistants

### When Adding New Solutions

1. Identify the correct week folder (or create new week if needed)
2. Create problem folder: `leetcode_XXXX/`
3. Name file: `Solution_[username]_v0.java`
4. Match package name to folder name
5. Follow existing code patterns in the repository

### When Reviewing Solutions

- Verify algorithm correctness
- Check for edge cases
- Ensure code follows existing conventions
- Solutions should be self-contained (no external dependencies)

### Common Tasks

- **Find all solutions for a problem**: `week*/leetcode_XXXX/*.java`
- **Find solutions by contributor**: `**/Solution_username_*.java`
- **Compare solution versions**: Read `v0`, `v1`, etc. files

### What Not to Do

- Don't add build configurations (Maven, Gradle)
- Don't add external dependencies
- Don't modify the LeetCode-required method signatures
- Don't add unit tests (LeetCode handles verification)

## Contributors

Active contributors based on commit history:
- zhangdafeng
- HaoyuanPeng
- momo262
- liyukun.daxia

## Quick Reference

| Item | Convention |
|------|------------|
| Language | Java (standard library only) |
| Package | `leetcode_XXXX` |
| Class | `Solution_username_vN` |
| Folder | `weekXX/leetcode_XXXX/` |
| Testing | LeetCode submission |
| License | Apache 2.0 |

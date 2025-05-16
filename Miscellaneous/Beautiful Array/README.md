# 🧠 Beautiful Array Cheat Sheet

## 🔹 Problem Summary
Return a permutation of `[1..n]` such that for **every** `i < k < j`:
```
2 * nums[k] != nums[i] + nums[j]
```
I.e., no element is the average of any two others.

---

## 🔑 Key Observations
- We need to **avoid arithmetic progressions** of length 3.
- A brute-force way to check all triplets is too slow (O(n³)).
- Greedy and standard backtracking don’t help — no local rule gives a global solution.

---

## 🧠 Core Insight
You can **construct a beautiful array recursively**:
- Start with `n = 1 → [1]` is trivially beautiful.
- Use divide-and-conquer to build larger arrays.

---

## 🧱 Construction Approach

To build a beautiful array of size `n`:

1. Build a beautiful array of size `(n + 1) / 2`  
   → map it to **odd numbers** using:  
   `2 * x - 1`

2. Build a beautiful array of size `n / 2`  
   → map it to **even numbers** using:  
   `2 * x`

3. Combine the two arrays → this is the beautiful array for `n`.

📌 **Why this works:**
- Odd + even numbers are **far apart** numerically.
- No arithmetic progression can span across them.
- Subarrays are also beautiful, and the mapping preserves that.

---

## 🧠 Mental Model

Think of this as a recursive tree:
```
BA(n) → odd-part from BA((n+1)/2), even-part from BA(n/2)
```

---

## 📌 Final Tip (When to Use This)

Use this pattern when:
- You're asked to return a permutation of `[1..n]` with **no arithmetic progressions / no element as an average of two others**.
- Constraints are large, and brute-force won’t cut it.
- The problem guarantees a solution exists — usually hinting a constructive method is expected.

---

## 🛠 Time and Space Complexity
- **Time:** O(n log n)
- **Space:** O(n) (due to recursion + result array)

---

## ✅ Example

For `n = 5`, the output might be:
```
[1, 5, 3, 2, 4]
```
Which satisfies the beautiful array condition.

---

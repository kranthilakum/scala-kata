#### 99 Problems

1. Find the last element of a list
2. Find the last but one element of a list
3. Find the K'th element of a list
4. Find the number of elements of a list
5. Reverse a list
6. Find out whether a list is a palindrome. A palindrome can be read forward or backward, e.g. [x, a, m, a, x]
7. Flatten a nested list structure. Transform a list, possibly holding lists as elements into a flat list by replacing each list with its elements (recursively)
8. Eliminate consecutive duplicates of list elements. If a list contains repeated elements they should be replaced with a single copy of the element. The order of the elements should not be changed.
9. Pack consecutive duplicates of list elements into sublists. If a list contains repeated elements they should be placed in separate sublists.
10. Run-length encoding of a list. Use the result of problem P9 to implement the so-called run-length encoding data compression method. Consecutive duplicates of elements are encoded as terms [N, E] where N is the number of duplicates of the element E.
11. Modified run-length encoding. Modify the result of problem P10 in such a way that if an element has no duplicates it is simply copied into the result list. Only elements with duplicates are transferred as [N, E] terms.
12. Decode a run-length encoded list. Given a run-length code list generated as specified in problem P11. Construct its uncompressed version.
13. Run-length encoding of a list (direct solution).
Implement the so-called run-length encoding data compression method directly. I.e. don't explicitly create the sublists containing the duplicates, as in problem P09, but only count them. As in problem P11, simplify the result list by replacing the singleton terms [1, X] by X.
14. Duplicate the elements of a list.
15. Duplicate the elements of a list a given number of times.
16. Drop every N'th element from a list.
17. Split a list into two parts; the length of the first part is given.
18. Extract a slice from a list. Given two indices, I and K, the slice is the list containing the elements between the I'th and K'th element of the original list (both limits included). Start counting the elements with 1.
19. Rotate a list N places to the left
20. Remove the K'th element from a list
21. Insert an element at a given position into a list
22. Create a list containing all integers within a given range
23. Extract a given number of randomly selected elements from a list. The selected items shall be put into a result list. Hint: Use the built-in random number generator random/2 and the result of problem P20
24. Lotto: draw N different random numbers from the set 1..M. The selected numbers shall be put into a result list.
25. Generate a random permutation of the elements of a list. Hint: Use the solutino of problem P23.
26. Generate the combinations of K distinct objects chosen from the N elements of a list. In how many ways can a committee of 3 be chosen from a group of 12 people? We all know that there are C(12,3) = 220 possibilities (C(N,K) denotes the well-known binomial coefficients). For pure mathematicians, this result may be great. But we want to really generate all the possibilities (via backtracking).

#### Scala 99 problems
- [99 problems in Prolog](http://www.ic.unicamp.br/~meidanis/courses/mc336/2009s2/prolog/problemas/)
- [solutions to 99 problems in Scala](http://aperiodic.net/phil/scala/s-99/)

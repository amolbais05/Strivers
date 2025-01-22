package arrays.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindNextGreaterPermutation
{
    // Brute Force
    // Approach:
    /*
    1. Generate all possible permutations of elements present in SORTED Order. permutation which is just larger than the given permutation.
        (Need to use recursion)

    2. Do Linear search to find the permutation that is just larger than the current permutation.

    3. If we find a permutation just larger than the current one, print it.

    4. If there doesn't exist a next permutation, then the first one will be the answer.

     */


    // Better Solution : C++ STL Library

    // Intuition behind optimal solution
    /**
    1. Longest prefix match, find the break point : a[i] < a[i+1]

    2. find > A, the next greater element but smallest one from the right side. So that you stay close.
     If break point does not exist: reverse the whole array.

    3. Swap the break point and the smallest greater element.

    4. Place the rest of the elements in the increasing order. (ascending order)

    * */

    // optimal
    public static List<Integer> nextGreaterPermutation(List<Integer> A) {
            int n = A.size(); // size of the array.

            // Step 1: Find the break point:
            int ind = -1; // break point
            for (int i = n - 2; i >= 0; i--) {
                if (A.get(i) < A.get(i + 1)) {
                    // index i is the break point
                    ind = i;
                    break;
                }
            }

            // If break point does not exist:
            if (ind == -1) {
                // reverse the whole array:
                Collections.reverse(A);
                return A;
            }

            // Step 2: Find the next greater element
            //         and swap it with arr[ind]:

            for (int i = n - 1; i > ind; i--) {
                if (A.get(i) > A.get(ind)) {
                    int tmp = A.get(i);
                    A.set(i, A.get(ind));
                    A.set(ind, tmp);
                    break;
                }
            }

            // Step 3: reverse the right half:
            List<Integer> sublist = A.subList(ind + 1, n);
            Collections.reverse(sublist);

            return A;
        }
        // TC : O(N)
        // SC : O(1)

        public static void main(String[] args) {
            List<Integer> A = Arrays.asList(2, 1, 5, 4, 3, 0, 0);
            List<Integer> ans = nextGreaterPermutation(A);

            System.out.print("The next permutation is: [");
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i) + " ");
            }
            System.out.println("]");

        }

    }
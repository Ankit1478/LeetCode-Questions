# Length of longest subarray
## Easy
<div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given an array <strong>A[] </strong>of size <strong>N</strong>, return length of the longest subarray of non- negative integers.</span></p>

<p><span style="font-size:18px"><strong>Note: </strong>Subarray here means a continuous part of the array.</span><br>
&nbsp;</p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input : </strong>
N = 9
A[] = {2, 3, 4, -1, -2, 1, 5, 6, 3}
<strong>Output : </strong>
4
<strong>Explanation :</strong>
The subarray [ 1, 5, 6, 3] has longest length 4 and
contains no negative integers</span></pre>

<div>&nbsp;</div>

<div><span style="font-size:18px"><strong>Example 2:</strong></span></div>

<pre><span style="font-size:18px"><strong>Input : </strong>
N = 10
A[] = {1, 0, 0, 1, -1, -1, 0, 0, 1, 0}
<strong>Output : </strong>
4
<strong>Explanation :</strong>
Subarrays [1, 0, 0, 1] and [0, 0, 1, 0] have
equal lengths but sum of first one is greater
so that will be the output.
</span></pre>

<p><br>
<br>
<span style="font-size:18px"><strong>Your Task:&nbsp;&nbsp;</strong><br>
You don't need to read input or print anything. Your task is to complete the function <strong>longestSubarray()</strong>&nbsp;which takes the array <strong>A[]</strong> and its size <strong>N</strong><strong> </strong>as inputs and returns the length of the longest subarray of non-negative integers.</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:</strong> O(N)<br>
<strong>Expected Auxiliary Space:</strong> O(1)</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 &lt;= N &lt;= 10<sup>5</sup><br>
-10<sup>5&nbsp;</sup>&lt;= A[i] &lt;= 10<sup>5</sup></span></p>
</div>
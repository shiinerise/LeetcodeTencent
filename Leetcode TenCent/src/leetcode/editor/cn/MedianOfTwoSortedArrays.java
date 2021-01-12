package leetcode.editor.cn;
//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
// Related Topics 数组 二分查找 分治算法 
// 👍 3594 👎 0

//[4]寻找两个正序数组的中位数
public class MedianOfTwoSortedArrays{
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[]{}, new int[]{1}));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length, n = nums2.length;
            int q = m + n;
            if(q % 2 == 1) {
                int k = (q >> 1) + 1;
                return findK(nums1, 0, nums2,0,  k);
            }else {
                int k = q >> 1;
                return (findK(nums1, 0, nums2, 0, k) + findK(nums1, 0, nums2, 0, k+1)) / 2.0;
            }
        }

        // 找第K小的数，k从1开始, a, b分别为nums1和nums2的起始位置
        public int findK(int[] nums1, int a, int[] nums2, int b, int k) {
            int m = nums1.length, n = nums2.length;

            if(a >= m) return nums2[b+k-1];

            if(b >= n) return nums1[a+k-1];

            if(k == 1) return nums1[a] <= nums2[b] ? nums1[a]: nums2[b];

            // 找第k/2小的数,若不足k/2个数字则赋值整型最大值，以便淘汰另一数组的前k/2个数字
            int mid1 = (a+k/2-1 < m) ? nums1[a+k/2-1]: Integer.MAX_VALUE;
            int mid2 = (b+k/2-1 < n) ? nums2[b+k/2-1]: Integer.MAX_VALUE;

            if(mid1 <= mid2) return findK(nums1, a+k/2, nums2, b, k-k/2);
            else return findK(nums1, a, nums2, b+k/2, k-k/2);
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
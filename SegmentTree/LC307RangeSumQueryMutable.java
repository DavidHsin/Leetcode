/**
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.

Example:

Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
 */

class NumArray {
    
    public class SegmentTree<E> {

        private E[] tree;
        private E[] data;
        private Merger<E> merger;

        public SegmentTree(E[] arr, Merger<E> merger){

            this.merger = merger;

            data = (E[])new Object[arr.length];
            for(int i = 0 ; i < arr.length ; i ++)
                data[i] = arr[i];

            tree = (E[])new Object[4 * arr.length];
            buildSegmentTree(0, 0, arr.length - 1);
        }

        // 在treeIndex的位置创建表示区间[l...r]的线段树
        private void buildSegmentTree(int treeIndex, int l, int r){

            if(l == r){
                tree[treeIndex] = data[l];
                return;
            }

            int leftTreeIndex = leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);

            int mid = l + (r - l) / 2;
            buildSegmentTree(leftTreeIndex, l, mid);
            buildSegmentTree(rightTreeIndex, mid + 1, r);

            tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
        }

        public int getSize(){
            return data.length;
        }

        public E get(int index){
            if(index < 0 || index >= data.length)
                throw new IllegalArgumentException("Index is illegal.");
            return data[index];
        }

        // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
        private int leftChild(int index){
            return 2*index + 1;
        }

        // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
        private int rightChild(int index){
            return 2*index + 2;
        }


        /**
                  查询[2, 5]
                                  A[0...7]
                  查询[2, 3]          /            \       查询[4, 5]
                         A[0...3]        A[4...7]
                         /     \  查询  查询   /     \
                    A[0...1]  A[2...3] A[4...5]  A[6...7]
                    /     \    /   \     /   \    /    \
                   A[0]  A[1] A[2] A[3] A[4] A[5] A[6] A[7]

         * */
        //返回区间[queryL, queryR]前闭后闭的值
        public E query(int queryL, int queryR) {

            //边界检查
            if(queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length || queryL > queryR) {
                throw new IllegalArgumentException("Index is illegal.");
            }

            return query(0, 0, data.length - 1, queryL, queryR);
        }

        //在以treeIndex为根的线段树中[l...r]的范围里，搜索区间[queryL...queryR]的值
        //这里l = 0, r = data.length - 1
        private E query(int treeIndex, int l, int r, int queryL, int queryR) {

            //base case
            if(l == queryL && r == queryR) {
                return tree[treeIndex];
            }

            //recursive rules
            //分为三种，向左找，向右找，左右都有
            int mid = l + (r - l) / 2;
            int leftTreeIndex = leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);

            if(queryL >= mid + 1) {		//一头扎向右孩子
                return query(rightTreeIndex, mid + 1, r, queryL, queryR);
            }else if(queryR <= mid) {	//一头扎向左孩子
                return query(leftTreeIndex, l, mid, queryL, queryR);
            }

            //左孩子和有孩子都有的时候
            E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
            E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
            return merger.merge(leftResult, rightResult);
        }

        //将index位置的值，更新为e
        public void set(int index, E e) {

            if(index < 0 || index >= data.length) {
                throw new IllegalArgumentException("Index is illegal.");
            }

            data[index] = e;
            set(0, 0, data.length - 1, index, e);
        }

        //在以treeIndex为根的线段树中更新index的值为e
        private void set(int treeIndex, int l, int r, int index, E e) {

            //更新操作其实类似于二分查找
            //base case
            if(l == r) {
                tree[treeIndex] = e;
                return;
            }

            //recursive rules
            int mid = l + (r - l) / 2;
            int leftTreeIndex = leftChild(treeIndex);
            int rightTreeIndex = rightChild(treeIndex);
            if(index >= mid + 1) {
                set(rightTreeIndex, mid + 1, r, index, e);
            }else {
                set(leftTreeIndex, l, mid, index, e);
            }

            //此时一旦index的节点发生改变，其祖辈中包含index节点的都需要发生改变
            tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
        }

        @Override
        public String toString(){
            StringBuilder res = new StringBuilder();
            res.append('[');
            for(int i = 0 ; i < tree.length ; i ++){
                if(tree[i] != null)
                    res.append(tree[i]);
                else
                    res.append("null");

                if(i != tree.length - 1)
                    res.append(", ");
            }
            res.append(']');
            return res.toString();
        }
    }
    
    public interface Merger<E> {

        E merge(E a, E b);
    }
    
    private SegmentTree<Integer> segTree;

    public NumArray(int[] nums) {
        
        if(nums.length != 0) {
            Integer[] data = new Integer[nums.length];
            for(int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            segTree = new SegmentTree<>(data, (a, b) -> a + b);
        }
    }
    
    public void update(int i, int val) {
        if(segTree == null) {
            throw new IllegalArgumentException("Error!");
        }
        segTree.set(i, val);
    }
    
    public int sumRange(int i, int j) {
        if(segTree == null) {
            throw new IllegalArgumentException("Error!");
        }
        return segTree.query(i, j);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
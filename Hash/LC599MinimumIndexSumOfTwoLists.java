/**
Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.

Example 1:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".
Example 2:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
Output: ["Shogun"]
Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
Note:
The length of both lists will be in the range of [1, 1000].
The length of strings in both lists will be in the range of [1, 30].
The index is starting from 0 to the list length minus 1.
No duplicates in both lists.
 */

class Solution1 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        
        //create a hashmap
        Map<String, Integer> dataSet = new HashMap<String, Integer>();
        for(int i = 0; i < list1.length; i++) {
            dataSet.put(list1[i], i);
        }
        
        List<String> res = new ArrayList<>();
        int globalDistance = list1.length + list2.length;
        int sum = 0;
        
        //comparison
        for(int j = 0; j < list2.length; j++) {
            if(dataSet.containsKey(list2[j])) {
                sum = j + dataSet.get(list2[j]);
                if(sum < globalDistance) {
                    res.clear();        //importance
                    res.add(list2[j]);
                    globalDistance = sum;
                }else if(sum == globalDistance) {
                    res.add(list2[j]);
                }
            }
        }
        return res.toArray(new String[res.size()]);
    }
}

/**
 * Time complexity: O(n)
 */


class Solution2 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        
        List<String> res = new ArrayList<>();
        int globalDistance = list1.length + list2.length;
        int sum = 0;
        
        //comparison
        for(int i = 0; i < list1.length; i++) {
            for(int j = 0; j < list2.length; j++) {
                /**
                if using "list1[i] == list2[j]", it doesn't work
                so we have use equals to compare the content rather than reference
                */
                if(list1[i].equals(list2[j])) { 
                    sum = i + j;
                    if(sum < globalDistance) {
                        res.clear();        //importance
                        res.add(list2[j]);
                        globalDistance = sum;
                    }else if(sum == globalDistance) {
                        res.add(list2[j]);
                    }
                }
            }
        }
        return res.toArray(new String[res.size()]);
    }
}

/**
 * Time complexity: O(n^2)
 * */
 */
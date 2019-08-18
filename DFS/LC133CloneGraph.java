/**
Given a reference of a node in a connected undirected graph, 
return a deep copy (clone) of the graph. 
Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.


Example:

1-2
| |
4-3


Input:
{"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}

Explanation:
Node 1's value is 1, and it has two neighbors: Node 2 and 4.
Node 2's value is 2, and it has two neighbors: Node 1 and 3.
Node 3's value is 3, and it has two neighbors: Node 2 and 4.
Node 4's value is 4, and it has two neighbors: Node 1 and 3.
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        
        Map<Node, Node> map = new HashMap<>();
        return cloneGraphHelper(node, map);
        
    }
    
    public Node cloneGraphHelper(Node node, Map<Node, Node> map) {
//         //base case 1
//         if(node == null) {
//             return null;
//         }
        
//         //base case 2
//         if(lookup.containsKey(node)) {
//             return lookup.get(node);
//         }
        
//         //recursive rule
//         Node copyNode = new Node(node.val);
//         lookup.put(copyNode.val, copyNode);
//         for(Node neighbor : node.neighbors) {
//             copyNode.neighbors.add(cloneGraphHelper(neighbor, lookup));
//         }
//         return copyNode;
        
    	if(map.containsKey(node)) return map.get(node);
    	Node ret = new Node(node.val, new ArrayList());
    	map.put(node, ret);
    	for(Node child: node.neighbors){
    		ret.neighbors.add(cloneGraphHelper(child, map));
    	}
    	return ret;
    }
}
/**
 * Problem #133
 */

class DeepCopyGraph {
  public Node cloneGraph(Node node) {
    if (node == null) {
      return null;
    }
    
    Map<Node, Node> nodeMap = new HashMap<>();
    Queue<Node> queue = new LinkedList<>();
    queue.offer(node);
    
    while (!queue.isEmpty()) {
      Node curr = queue.poll();
      nodeMap.put(curr, new Node(curr.val));
      
      for (Node neighbor: curr.neighbors) {
        if (!nodeMap.containsKey(neighbor)) {
          queue.offer(neighbor);
        }
      }
    }
    
    for (Map.Entry<Node, Node> entry : nodeMap.entrySet()) {
      Node newNode = entry.getValue();
      newNode.neighbors = new ArrayList<>();
      
      for (Node nei : entry.getKey().neighbors) {
        newNode.neighbors.add(nodeMap.get(nei));
      }
    }
    
    return nodeMap.get(node);
  }
}
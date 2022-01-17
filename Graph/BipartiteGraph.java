/**
 * Problem #785
 */
class BipartiteGraph {
  public boolean isBipartite(int[][] graph) {
    // color[i] == 0: not colored, or 1 || -1
    int color[] = new int[graph.length];
    
    for(int i = 0; i < graph.length; i++) {
      // Graph is not connected, so run DFS on each unvisited nodes
      if(color[i] == 0 && !validColor(graph, color, 1, i)) {
        return false;
      }
    }
    return true;
  }

  boolean validColor(int[][] graph, int[] colors, int color, int node) {
    if(colors[node] != 0) {
      return colors[node] == color;
    }
    
    colors[node] = color;
    
    for(int nei : graph[node]) {
      if(!validColor(graph, colors, color * -1, nei)) {
        return false;
      }
    }
    return true;
  }
}
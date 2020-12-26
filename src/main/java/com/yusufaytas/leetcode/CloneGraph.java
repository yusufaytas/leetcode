package com.yusufaytas.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

  public Node cloneGraph(final Node node) {
    if (node == null) {
      return null;
    }
    final Map<Node, Node> visited = new HashMap<>();
    return copyNode(node, visited);
  }

  public Node copyNode(final Node node, final Map<Node, Node> visited) {
    if (visited.containsKey(node)) {
      return visited.get(node);
    }
    final Node copyNode = new Node(node.val, new ArrayList<>());
    visited.put(node, copyNode);
    for (final Node neighbourNode : node.neighbors) {
      copyNode.neighbors.add(copyNode(neighbourNode, visited));
    }
    return copyNode;
  }

  private static class Node {

    public int val;
    public List<Node> neighbors;

    public Node() {
    }

    public Node(int _val, List<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }
}

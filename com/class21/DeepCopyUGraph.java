package com.class21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.class5.GraphNode;

public class DeepCopyUGraph {
    public List<GraphNode> copy(List<GraphNode> graph) {
        if (graph == null) {
            return graph;
        }

        Map<GraphNode, GraphNode> map = new HashMap<>();
        for (GraphNode node : graph) {
            if (!map.containsKey(node)) {
                map.put(node, new GraphNode(node.val));
                DFS(node, map);
            }
        }
        return new ArrayList<GraphNode>(map.values());
    }

    private void DFS(GraphNode seed, Map<GraphNode, GraphNode> map) {
        GraphNode copy = map.get(seed);
        for (GraphNode nei : seed.neighbors) {
            if (!map.containsKey(nei)) {
                map.put(nei, new GraphNode(nei.val));
                DFS(nei, map);
            }
            copy.neighbors.add(map.get(nei));
        }
    }
    
}

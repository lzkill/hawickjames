package com.lzkill.build;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.graph.DirectedPseudograph;

import com.lzkill.etc.Utils;
import com.lzkill.graph.Edge;

public class GraphBuilder {

	public static DirectedPseudograph<String, Edge> buildFromFile(String file)
			throws FileNotFoundException, IOException {

		DirectedPseudograph<String, Edge> g = new DirectedPseudograph<String, Edge>(
				Edge.class);
		Map<String, String> vertices = new HashMap<String, String>();
		BufferedReader E = null;
		E = new BufferedReader(new FileReader(file));
		String line, edge[];
		try {
			while ((line = E.readLine()) != null) {
				edge = line.split(";");

				if (edge.length > 1) {

					String fromStr = edge[0];
					String toStr = edge[1];
					String from, to = null;

					from = vertices.get(fromStr);
					if (from == null) {
						from = new String(fromStr);
						vertices.put(fromStr, from);
						g.addVertex(from);
					}

					to = vertices.get(toStr);
					if (to == null) {
						to = new String(toStr);
						vertices.put(toStr, to);
						g.addVertex(to);
					}

					g.addEdge(from, to, new Edge());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		E.close();
		return g;
	}

	public static void buildRandomically(Graph<String, Edge> graph,
			int nVertices, int nEdges) {
		Map<Integer, String> vertices = new HashMap<Integer, String>();

		for (int i = 0; i < nVertices; i++) {
			String vStr = Integer.toString(i);
			String v = null;

			v = vertices.get(vStr);
			if (v == null) {
				v = new String(vStr);
				vertices.put(i, v);
				graph.addVertex(v);
			}
		}

		for (int j = 0; j < nEdges; j++) {
			int from = Utils.randInt(0, vertices.size() - 1);
			int to = Utils.randInt(0, vertices.size() - 1);
			graph.addEdge(vertices.get(from), vertices.get(to), new Edge());
		}
	}
}

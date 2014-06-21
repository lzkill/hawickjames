package com.lzkill.test;

import static org.junit.Assert.assertTrue;

import org.jgrapht.alg.cycle.JohnsonSimpleCycles;
import org.jgrapht.alg.cycle.SzwarcfiterLauerSimpleCycles;
import org.jgrapht.alg.cycle.TarjanSimpleCycles;
import org.jgrapht.alg.cycle.TiernanSimpleCycles;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.junit.Test;

import com.lzkill.build.GraphBuilder;
import com.lzkill.cycle.HawickJamesSimpleCycles;
import com.lzkill.etc.Utils;
import com.lzkill.graph.Edge;

public class AlgorithmsComparisonTest {

	@Test
	public void test() {

		DefaultDirectedGraph<String, Edge> g = null;
		int nGraphs = 100;
		int nVertices = 30;
		int nEdges = 50;

		for (int i = 0; i < nGraphs; i++) {

			g = new DefaultDirectedGraph<String, Edge>(Edge.class);

			GraphBuilder.buildRandomically(g, Utils.randInt(1, nVertices),
					Utils.randInt(0, nEdges));

			HawickJamesSimpleCycles<String, Edge> hj = new HawickJamesSimpleCycles<String, Edge>(
					g);
			long cyclesHawickJames = 0;
			cyclesHawickJames = hj.findSimpleCycles().size();

			hj = null;
			System.gc();

			JohnsonSimpleCycles<String, Edge> j = new JohnsonSimpleCycles<String, Edge>(
					g);
			long cyclesJhonson = 0;
			cyclesJhonson = j.findSimpleCycles().size();

			j = null;
			System.gc();

			SzwarcfiterLauerSimpleCycles<String, Edge> sl = new SzwarcfiterLauerSimpleCycles<String, Edge>(
					g);
			long cyclesSzwarcfiterLauer = 0;
			cyclesSzwarcfiterLauer = sl.findSimpleCycles().size();

			sl = null;
			System.gc();

			TarjanSimpleCycles<String, Edge> tj = new TarjanSimpleCycles<String, Edge>(
					g);
			long cyclesTarjan = 0;
			cyclesTarjan = tj.findSimpleCycles().size();

			tj = null;
			System.gc();

			TiernanSimpleCycles<String, Edge> tn = new TiernanSimpleCycles<String, Edge>(
					g);
			long cyclesTiernan = 0;
			cyclesTiernan = tn.findSimpleCycles().size();

			tn = null;

			assertTrue(cyclesHawickJames == cyclesJhonson);
			assertTrue(cyclesJhonson == cyclesSzwarcfiterLauer);
			assertTrue(cyclesSzwarcfiterLauer == cyclesTarjan);
			assertTrue(cyclesTarjan == cyclesTiernan);

			g = null;

			System.gc();
		}
	}
}

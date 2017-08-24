package ggibsen.interview.datastruct.array;

import java.util.*;

/**
 * Created by greg on 8/21/17.
 */
public class GraphNodes2DArray {
    public static void main(String[] args) {
        int[][] parentChildTupleArray = new int[][] {
                {4, 5}, {4, 8}, {8, 9}, {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}
        };

        GraphNodes2DArray objectGraph = new GraphNodes2DArray();
        objectGraph.parseNodeArray(parentChildTupleArray);

        Map<Integer,List<Integer>> countsOfParentNodes = objectGraph.getCountsOfParentNodes();

        for (int count = 0; count < Math.min(2,countsOfParentNodes.size()); count++ ) {
            List<Integer> nodes = countsOfParentNodes.get(count);
            System.out.println("Num "+count+ " parents: "+nodes);
        }
    }

    private Map<Integer,Integer> nodeToCount = new HashMap<Integer,Integer>();

    public void parseNodeArray(int[][] nodePairs) {

        for (int numPairs = 0; numPairs < nodePairs.length; numPairs++ ) {

                Integer nodeParent = nodePairs[numPairs][0];
                Integer nodeChild = nodePairs[numPairs][1];

                if ( nodeToCount.containsKey(nodeChild) ) {
                    // inc count of child
                    Integer count = nodeToCount.get(nodeChild);
                    count++;
                    nodeToCount.put(nodeChild, count);
                    System.out.println("inc count of child " +nodeChild+", #: "+count);
                }
                else  {
                    // initialize count of child 1
                    nodeToCount.put(nodeChild, 1);
                    System.out.println("init count of child " +nodeChild);
                }
                if ( !nodeToCount.containsKey(nodeParent) ) {
                    // initialize count of parent 0
                    nodeToCount.put(nodeParent, 0);
                    System.out.println("init count of parent " +nodeParent);
                }

//                Integer numParentsCount = nodeToCount.get(node);
//                if ( numParentsCount != null ) {
//                    // if child count again
//                    if ( index == 1 ) {
//                        numParentsCount++;
//                        nodeToCount.put(node, numParentsCount);
//                        System.out.println("adding to visited " +node);
//                    }
//                    // if parent
//                    else if (index == 0 && ) {
//
//                    }
//                }
//                else {
//                    System.out.println("initial visit" +node);
//                    nodeToCount.put(node, 0);
//                }
        }

    }



    public Map<Integer,List<Integer>> getCountsOfParentNodes() {
        Map<Integer,List<Integer>> countsOfParentNodes = new HashMap<Integer,List<Integer>>();

        Iterator<Integer> nodes = nodeToCount.keySet().iterator();

        while ( nodes.hasNext()) {
      /*
      1  0
      3  2
      2  0

      */
            Integer node = nodes.next();
//            System.out.println("node "+node);


            Integer count = nodeToCount.get(node);
             System.out.println(node+ " has: "+count);
            if ( count != 0 || count != 1 ) {
                List<Integer> nodeList = countsOfParentNodes.get(count);
                if ( nodeList == null ) {
                    nodeList = new ArrayList<Integer>();
                    countsOfParentNodes.put(count, nodeList);
                }
                nodeList.add(node);
                System.out.println("adding to list" +count+", "+node);
            }
        }
        return countsOfParentNodes;
    }

}


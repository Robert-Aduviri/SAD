/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.operators;

import algorithm.Algorithm;
import algorithm.Node;
import algorithm.Problem;
import algorithm.Solution;
import entity.UnidadTransporte;
import java.awt.geom.Point2D;
import util.Constants;
import util.Randomizer;

/**
 *
 * @author robert
 */
public class Mutation {

    public static Solution mutation(Solution s, Algorithm algorithm, Problem problem) {
        if(!Randomizer.doIt(algorithm.getMutationRate())) return s;
        Node[][] nodes = s.getNodes();
        int idxStart = Randomizer.randomInt(nodes.length);
        int idxI, idxJ;
        for (idxI = idxJ = idxStart; idxI >= 0 || idxJ < nodes.length; idxI--, idxJ++) { //find a non_empty route
            if (idxI >= 0 && nodes[idxI].length>0) {
                idxJ = -1;
                break;
            }
            if (idxJ < nodes.length && nodes[idxJ].length>0) {
                idxI = -1;
                break;
            }
        }
        if(idxI<0 && idxJ==nodes.length)
            throw new AssertionError("no full routes found");
        idxI = Math.max(idxI,idxJ);
        idxJ = Randomizer.randomInt(nodes[idxI].length);
        
        changePosition(nodes, algorithm, problem, idxI, idxJ);
        
        s.setNodes(nodes);
        return s;
    }

    private static void changePosition(Node[][] nodes, Algorithm algorithm, Problem problem, int idxI, int idxJ) {
        UnidadTransporte vehicle = problem.getVehicles().get(0);
        double speed = vehicle.getTipoUnidadTransporte().getVelocidadPromedio();
        Node node = nodes[idxI][idxJ];
        double bestPayoff = -Double.MAX_VALUE;        
        int iRoute = -1, jRoute = -1;
        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes[i].length; j++) {
                double travelCost, toNode, fromNode;
                if (j > 0) {
                    travelCost = Point2D.distance(nodes[i][j - 1].getX(), nodes[i][j - 1].getY(),
                            nodes[i][j].getX(), nodes[i][j].getY()) / speed;
                    toNode = Point2D.distance(nodes[i][j - 1].getX(), nodes[i][j - 1].getY(),
                            node.getX(), node.getY()) / speed;
                } else {
                    travelCost = Point2D.distance(Constants.WAREHOUSE_LONGITUDE, Constants.WAREHOUSE_LATITUDE,
                            nodes[i][j].getX(), nodes[i][j].getY()) / speed;
                    toNode = Point2D.distance(Constants.WAREHOUSE_LONGITUDE, Constants.WAREHOUSE_LATITUDE,
                            node.getX(), node.getY()) / speed;
                }                
                fromNode = Point2D.distance(node.getX(), node.getY(),
                            nodes[i][j].getX(), nodes[i][j].getY()) / speed;
                double payoff = ObjectiveFunction.objectiveFunction(vehicle, nodes[i][j],
                        algorithm, 0, 0, 0, travelCost, 0)
                        - ObjectiveFunction.objectiveFunction(vehicle, node,
                        algorithm, 0, 0, 0, toNode, 0)
                        - ObjectiveFunction.objectiveFunction(vehicle, nodes[i][j],
                        algorithm, 0, 0, 0, fromNode, 0);
                if(payoff > bestPayoff){
                    bestPayoff = payoff;
                    iRoute = i;
                    jRoute = j;
                }
            }            
        }
        Node[] fromRoute = nodes[idxI];
        Node[] toRoute = nodes[iRoute];
        Node[] newFromRoute = new Node[fromRoute.length-1];
        Node[] newToRoute = new Node[toRoute.length+1];        
        System.arraycopy(fromRoute, 0, newFromRoute, 0, idxJ);
        for (int i = idxJ+1; i < fromRoute.length; i++) {
            newFromRoute[i-1] = fromRoute[i];            
        }
        System.arraycopy(toRoute, 0, newToRoute, 0, jRoute);
        toRoute[jRoute] = node;
        System.arraycopy(toRoute, jRoute, newToRoute, jRoute + 1, toRoute.length - jRoute);
        nodes[idxI] = newFromRoute;
        nodes[iRoute] = newToRoute;        
    }
    
}

package gp_project;

import java.util.logging.*;

public class FunctionGenerator {

	public Tree GenerateFullTree(int maxDepth) {
		GPConfig config = GPConfig.getInstance();
		Tree tree = new Tree(config.getRandOperator());
		int currentDepth = 1;
		addChildrenFullMethod(tree.getRootNode(), currentDepth, maxDepth);
		return tree;
	}

	void addChildrenFullMethod(Node node, int currentD, int maxD) {
		GPConfig config = GPConfig.getInstance();
		if (config == null | node == null) {
			throw new IllegalArgumentException("INVALID");

		}

		if (currentD == maxD) {
			node.setRightNode(new Node(config.getRandOperand()));
			node.setLeftNode(new Node(config.getRandOperand()));
			return;
		} else {

			node.setRightNode(new Node(config.getRandOperator()));
			node.setLeftNode(new Node(config.getRandOperator()));
		}

		addChildrenFullMethod(node.getRightNode(), currentD + 1, maxD);
		addChildrenFullMethod(node.getLeftNode(), currentD + 1, maxD);

		return;
	}
}
package com.xxl.job.executor.study.exam;

import lombok.Builder;
import lombok.Data;
import sun.reflect.generics.tree.Tree;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-12-30 10:55
 * @description：有效括号的嵌套度
 */
public class exam_003 {
    public static void main(String[] args) {
        TreeNode  treeNode = new TreeNode("0",null,null);
        TreeNode  treeNode1 = new TreeNode("1",null,null);
        TreeNode  treeNode2 = new TreeNode("2",treeNode,null);
        TreeNode  treeNode3 = new TreeNode("3",null,null);
        TreeNode  treeNode4 = new TreeNode("4",null,null);
        TreeNode  treeNode5 = new TreeNode("5",treeNode1,treeNode);
        TreeNode  treeNode6 = new TreeNode("6",treeNode3,treeNode2);
        TreeNode  treeNode7 = new TreeNode("7",treeNode5,treeNode4);
        TreeNode  treeNode8 = new TreeNode("8",treeNode6,treeNode7);
        Stack<TreeNode> stack = new Stack<>();
        preOrderIteration(treeNode8,stack);
        System.out.println(stack);
//        print(treeNode8);


    }

    public static void print(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        System.out.println(treeNode.value);
        print(treeNode.left);
        print(treeNode.right);
    }

    public static void preOrderIteration(TreeNode head,Stack<TreeNode> stack) {
        if(head == null){
            return;
        }
        stack.push(head);
        if(head.left != null){
            stack.push(head.left);
        }
        if(head.right != null){
            stack.push(head.right);
        }


    }
}
@Data
class TreeNode{
    String value;
    TreeNode left;
    TreeNode right;

    TreeNode(String value,TreeNode left,TreeNode right){
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

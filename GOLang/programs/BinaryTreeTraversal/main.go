package main

import (
	"fmt"
)

type Node struct {
	data  int
	right *Node
	left  *Node
}
type bst struct {
	tree *Node
}

func (bs *bst) display(node *Node) {
	if node == nil {
		return
	} else {
		bs.display(node.left)
		fmt.Print(node.data, " ,")
		bs.display(node.right)
	}
}

func main() {

	tree := &Node{10, nil, nil}
	tree.left = &Node{5, nil, nil}
	tree.left.left = &Node{2, nil, nil}
	tree.left.right = &Node{6, nil, nil}
	tree.right = &Node{11, nil, nil}
	tree.right.right = &Node{13, nil, nil}
	tree.right.left = &Node{12, nil, nil}

	bs := &bst{tree: tree}
	bs.display(bs.tree)
}

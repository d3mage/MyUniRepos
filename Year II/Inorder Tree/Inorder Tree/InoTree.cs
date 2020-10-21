using System;
using System.Collections.Generic;
using System.Text;

namespace Inorder_Tree
{
    public class BinaryTree<T> : IEnumerable<T> where T : IComparable
    {
        private BinaryTree<T> _leftTree { get; set; }
        private BinaryTree<T> _rightTree { get; set; }

        public T Node { get; set; }

        public BinaryTree(T node)
        {
            Node = node;
        }

        public void Insert(T item)
        {
            if (Node.CompareTo(item) > 0)
            {
                if (_leftTree == null)
                    _leftTree = new BinaryTree<T>(item);
                else
                    _leftTree.Insert(item);
            }
            else
            {
                if (_rightTree == null)
                    _rightTree = new BinaryTree<T>(item);
                else
                    _rightTree.Insert(item);
            }
        }
       
        public bool isInTree(T toFind)
        {
            if (toFind == null) return false; 
            foreach(T node in this)
            {
                if(node.Equals(toFind))
                {
                    return true; 
                }
            }
            return false; 
        }
        public void Print()
        {
            foreach(T node in this)
            {
                Console.WriteLine(node.ToString());
            }
        }

        System.Collections.Generic.IEnumerator<T> System.Collections.Generic.IEnumerable<T>.GetEnumerator()
        {
            if (_leftTree != null)
            {
                foreach (T item in _leftTree)
                {
                    yield return item;
                }
            }
            yield return Node;

            if (_rightTree != null)
            {
                foreach (T item in _rightTree)
                {
                    yield return item;
                }
            }
        }

        System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
        {
            throw new NotImplementedException();
        }
    }
}

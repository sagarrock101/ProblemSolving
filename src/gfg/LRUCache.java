package gfg;

import java.util.HashMap;

class LRUCache
{
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    int capacity;
    HashMap<Integer,Node> map = new HashMap<>();
    LRUCache(int cap)
    {
        this.capacity = cap;
        head.next = tail;
        tail.prev = head;
    }


    public int get(int key)
    {
        if(map.containsKey(key)){
            Node t = map.get(key);
            remove(t);
            insert(t);
            return t.value;
        }else{
            return -1;
        }

    }


    public void set(int key, int value)
    {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size()==capacity){
            remove(tail.prev);
        }
        insert(new Node(key,value));
    }
    private void remove(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void insert(Node node){
        map.put(node.key,node);
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;
    }
}
class Node{
    Node prev,next;
    int key,value;
    Node(int _key,int _value){
        key=_key;
        value=_value;
    }
}
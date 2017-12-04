package org.zwx.cache;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.LRUCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LruCache {

    private static Logger LOG = LoggerFactory.getLogger(LruCache.class);

    class Node{
        String userId;
        UserAccount userAccount;

        Node previous;
        Node next;

        public Node(String userId, UserAccount userAccount) {
            this.userId = userId;
            this.userAccount = userAccount;
        }
    }


    private int capacity;
    private Map<String, Node> cache = new HashMap<>();

    private Node head;
    private Node end;

    public LruCache(int capacity) {
        this.capacity = capacity;
    }

    public UserAccount remove(Node node) {
        if (node.previous == null) {
            head = node.next;
        } else {
            node.previous.next = node.next;
        }

        if (node.next == null) {
            end = node.previous;
        } else {
            node.next.previous = node.previous;
        }
        return node.userAccount;
    }

    public UserAccount getUserAccount(String userId) {
        if (cache.containsKey(userId)) {
            Node node = cache.get(userId);
            remove(node);
            setHead(node);
            return node.userAccount;
        }
        return null;
    }

    public void setHead(Node node) {

        node.previous = null;
        node.next = head;

        if (head != null) {
            head.previous = node;
        }
        head = node;
        if (end == null) {
            end = head;
        }
    }


    public boolean invalid(String userId) {
        if (cache.containsKey(userId)) {
            Node beRemoved = cache.remove(userId);
            remove(beRemoved);
            LOG.info("{} be remove!", beRemoved.userAccount);
            return true;
        }
        return false;
    }

    public void setCapacity(int capacity) {
        if (this.capacity < capacity)
        {
            LOG.info("capacity is over size");
            cache.clear();
            head = null;
            end = null;
        } else {
            this.capacity = capacity;
        }
    }

    public void set(String userId, UserAccount account) {
        if (cache.containsKey(userId)) {
            Node node = cache.get(userId);
            node.userAccount = account;
            remove(node);
            setHead(node);

        }else {
            Node node = new Node(userId, account);
            if (this.capacity <= cache.size())
            {
                cache.remove(userId);
                remove(end);
            }
            setHead(node);
            cache.put(userId, node);
        }

    }

    public void clear() {
        head = null;
        end = null;
        cache.clear();
    }

    public boolean contain(String userId) {
        return cache.containsKey(userId);
    }

    public UserAccount lruData() {
        return end.userAccount;
    }

    public List<UserAccount> getCacheDataInListForm() {
        Node temp = head;
        List<UserAccount> lst = new ArrayList<>();
        while (temp != null) {
            lst.add(temp.userAccount);
            temp = head.next;
        }
        return lst;
    }

    public boolean isFull() {
        return  cache.size()<= this.capacity;
    }

}

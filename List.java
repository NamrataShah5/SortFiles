public class List{
        private class ListNode {   // constructs node
                private ListNode next;
                private ListNode prev;
                private int data;
                public ListNode(int data) {
                        this.data=data;
                }
        }
        private ListNode front=null;  // constructs front,back,cursor pointers
        private ListNode back=null;
        private ListNode cursor=null;
        int index=-1;  // cursor is null so index is -1
        private int length=0;
        int length() { //returns length of list
                return length;
        }
        int index() {  //returns position of cursor
                if(cursor==null) { return -1; }
                return index;
        }
        int front() {  // return first element of list
                if(length()>0) {
                        return front.data;
                }
                return -1;
        }
        int back() {  // returns last element of list
                if(length()>0) {
                        return back.data;
                }
                return -1;
        }
        int get() {  // returns cursor element
                if(index()>=0 && length()>0) {
                        return cursor.data;
                }
                return -1;
        }
        boolean equals(List L) {  //compares two lists for equality in data and length
            if(L.length()!=length()) { return false; }
            ListNode t1 = L.front;
            ListNode t2 = front;
            while( t1!=null && t2!=null) {
                    if(t1.data!=t2.data) {
                            return false;
                    }
                    t1=t1.next;
                    t2=t2.next;
            }
            return true;
    }
    void clear() { // clears the list
      front=back=null;
      length=0;
      index=-1;
    }
    void movePrev() { //moves cursor back one
            if(cursor!=null) {
                    if(cursor.prev!=null) {
                            cursor=cursor.prev;
                            index--;
                    }
                    else {
                            cursor=null;
                    }
            }
    }
    void moveNext() { // moves cursor up one
        if(cursor!=null) {
                if(cursor.next!=null) {
                        cursor=cursor.next;
                        index=index()+1;
                }
                else {
                        cursor=null;
                        index = -1;
                }
        }
}
void moveFront() { //moves cursor to front of list 
        if(front!=null) {
                cursor=front;
                index=0;
        }
}
void moveBack() { //moves cursor to back of list
        if(back!=null) {
                cursor=back;
                index=length()-1;
        }
}
void prepend(int data) { //inserts element to front of list
    ListNode node = new ListNode(data);
    if(front!=null) {
            node.next=front;
            node.prev=null;
            front.prev=node;
    }
    length++;
    if(cursor!=null) {
            index++;
    }
    if(length == 1){ back=node; }
    if(length>1) {
      while(back.next!=null) {
            back=back.next;
      }
    }
    front=node;
}
void append(int data) {  //inserts element to back of list
    ListNode node = new ListNode(data);
    if(back!=null) {
            back.next=node;
            node.prev=back;
            node.next=null;
    }
    back=node;
    length++;
    if (length == 1) front=node;
}
void insertBefore(int data) { //insert before the cursor element
    ListNode node = new ListNode(data);
    if(length()>0 && index>=0) {
            if(cursor!=null) {
                    node.next=cursor;
                    if(cursor.prev!=null) {
                            node.prev=cursor.prev;
                            cursor.prev.next=node;
                            cursor.prev=node;
                    }
                    else {
                            node.prev=null;
                            cursor.prev=node;
                            front = node;
                    }
                    index++;
                    length++;
            }
    }
}
void insertAfter(int data) {  //inserts after cursor element
    ListNode node = new ListNode(data);
    if(length()>0 && index>=0) {
            if(cursor!=null) {
                    node.prev=cursor;
                    if(cursor.next!=null) {
                            node.next=cursor.next;
                            cursor.next=node;
                            cursor.next.prev=node;
                    }
                    else {
                            cursor.next=node;
                            node.next=null;
                            back=node;
                    }
            length++;
            if(length==1) { front=node; }
            }
    }
}
void deleteFront() { //deletes front element and sets front to next element in list
    if(length()>0) {
            if(front!=null && cursor!=null) {
                    if(cursor==front) {
                            cursor=null;
                            index=-1;
                    }
                    else { index--; }
            }
            if(front!=null) {
                    if(front.next!=null) {
                            front=front.next;
                            front.prev=null;
                    }
                    else { front=null; }
            }
            length--;
            if(length==1) { front = back; }
            if(length<0) { length=0; }
    }
}
void deleteBack() { // deletes back element and points back to previous element
    if(length()>0) {
            if(cursor!=null && back!=null) {
                    if(cursor==back) { cursor=null; index=-1; }
                    back=back.prev;
                    back.next=null;

            }
    }
    length--;
    if(length<0) { length=0; }
    if(length==1) { back = front; }
}
void delete() { // sets cursor to null and deletes the cursor element as well
    if(length()>0 || index()>=0) {
            if(cursor==front) { front=front.next; front.prev=null;}
            else if(cursor.prev!=null && cursor.next==null) { back=back.prev; back.next=null; }
            else {
               cursor.prev.next=cursor.next;
               cursor.next.prev=cursor.prev;
            }
            cursor=null;
            length--;
            index=-1;
    }
}
List copy() { // copies data of list into new list
    List L = new List();
    for(ListNode n=front; n!=null; n=n.next) {
            L.append(n.data);
    }
    return L;
}
public String toString() { // gets string representation of list
String p = new String();
ListNode t=front;
while(t!=null) {
    p=p+String.valueOf(t.data);
    if(t.next!=null) { p=p+" "; }
    t=t.next;
}
return p;
}
}



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;
import leetcode.Structures.ListNode;

/**
 *
 * @author lzhang
 */
public class IntersectionList {
    public IntersectionList(){
        ListNode headA = ListNode.GenerateList(new int[]{3});
        ListNode headB = ListNode.GenerateList(new int[]{2, 3});
        ListNode intersect = getIntersectionNode(headA, headB);
        ListNode.DisplayList(intersect);
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLength = findLength(headA);
        int bLength = findLength(headB);
        
        if(aLength == 0 || bLength == 0){
            return null;
        }
        
        ListNode aCompNode = headA;
        ListNode bCompNode = headB;
        int diffLen = 0;
        if(aLength < bLength){
            diffLen = bLength - aLength;
            for(int i = 0; i < diffLen; i++){
                if(bCompNode.val != aCompNode.val){
                    bCompNode = bCompNode.next;
                }
                else{
                    return bCompNode;
                }
            }
        }
        else if(aLength > bLength){
            diffLen = aLength - bLength;
            for(int i = 0; i < diffLen; i++){
                if(aCompNode.val != bCompNode.val){
                    aCompNode = aCompNode.next;
                }
                else{
                    return aCompNode;
                }
            }
        }
        
        while(aCompNode != null && bCompNode != null){
            if(aCompNode.val == bCompNode.val){
                return aCompNode;
            }
            else{
                aCompNode = aCompNode.next;
                bCompNode = bCompNode.next;
            }
        }
        
        
        return null;
    }
    
    private int findLength(ListNode head){
        int length = 0;
        ListNode headLen = head;
        while(headLen != null){
            length++;
            headLen = headLen.next;
        }
        
        return length;
    }
}

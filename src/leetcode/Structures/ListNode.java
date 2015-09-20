/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.Structures;

/**
 *
 * @author lzhang
 */
public class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
    
    public static void DisplayList(ListNode head){
        while(head != null){
            if(head.next == null){
                System.out.println(head.val);
            }
            else{
                System.out.print(head.val + " -> ");
            }
            head = head.next;
        }
    }
    
    public static ListNode GenerateList(int[] list){
        if(list.length == 0){
            return null;
        }
        else{
            ListNode head = new ListNode(list[0]);
            ListNode ret = head;
            for(int i = 1; i < list.length; i++){
                head.next = new ListNode(list[i]);
                head = head.next;
            }
            
            return ret;
        }
    }
    
}

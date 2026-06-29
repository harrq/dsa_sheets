// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Main {
    
    public static class Node{
        Node child[]=new Node[26];
        boolean eow=false;
        Node(){
            for(int i =0;i<26;i++){
                child[i]=null;
            }
        }
    }
    
    public static Node root=new Node();
    
    public static void insert(String s){
      Node curr=root;
        for(int level=0;level<s.length();level++){
              int idx=s.charAt(level)-'a';
            if(curr.child[idx]==null){
                curr.child[idx]=new Node();
            }
            
            curr = curr.child[idx];
            
        }
        curr.eow=true;
    }
    
    public static boolean rec(String key){
      
        if(key.length()==0){
            return true;
        }
        for(int i=1;i<=key.length();i++){
        if(search(key.substring(0,i)) && rec(key.substring(i))){
            return true;
        }}
        
        return false;
    }
    
    public static boolean search(String key){
        Node curr=root;
        for(int i=0;i<key.length();i++){
            int idx=key.charAt(i)-'a';
            if(curr.child[idx]==null){
                return false;
            }
            curr=curr.child[idx];
        }
        return curr.eow==true;
    }
    public static void main(String[] args) {
        
        String words[]={"i","like","sam","samsung","ice","harsh"};
        for(int i=0;i<words.length;i++){
        insert(words[i]);}
        
        String key="i";
        System.out.print(rec(key));
        
        
    }
}

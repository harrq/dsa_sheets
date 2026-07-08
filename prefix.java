public class prefix{
   
    public static class Node{
        Node child[]=new Node[26];
        boolean eow=false;
        int freq=1;
        
        Node(){
            for(int i=0;i<26;i++){
                child[i]=null;
            }
        }
    } 
    
    public static Node root=new Node();
    
    public static void insert(String str){
        Node curr=root;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(curr.child[ch-'a']==null){
                curr.child[ch-'a']=new Node();
            }else{
                curr.child[ch-'a'].freq++;
            }
           curr=curr.child[ch-'a'];
        }
        curr.eow=true;
        
    }
    
   
    public static void uniquePrefix(Node root,String ans){
        if(root==null){
            return;
        }

        if(root.freq==1){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<26;i++){
            if(root.child[i]!=null){
                char ch=(char)('a'+i);
                uniquePrefix(root.child[i],ans+ch);
            }
        }
    }
   
    
   
    public static void main(String[] args) {
        String arr[]={"zebra","dog","duck","dove"};
         for(int i=0;i<arr.length;i++){
             insert(arr[i]);
         }
         root.freq=-1;
          uniquePrefix(root,"");
    
}   
}

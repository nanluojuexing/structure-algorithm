package dailyPractice;

/**
 * 字符串 A(B(C(,),),E(,)) 转为二叉树
 */
public class string_tree {

    /**
     * 二叉树类
     */
   public  class TreeNode {
        TreeNode left;
        TreeNode right;
        char value;

        public TreeNode(char value) {
            this.left = null;
            this.right = null;
            this.value = value;
        }
    }

    /**
     * 记录之前的节点
     */
    public  class TreeNodeBox{
        private TreeNode treeNode;
        private int pos;
    }


    public static void main(String[] args) {
        String s = "A(B(C(,),),E(,))";
        TreeNodeBox node = new string_tree().build(s);
        TreeNode treeNode = node.treeNode;
        System.out.println(treeNode);
    }

    public  TreeNodeBox build(String s){

        TreeNodeBox treeNodeBox = new TreeNodeBox();

        TreeNode root = new TreeNode(s.charAt(0));
        int count = 1;
        for (;;) {
            if(s.charAt(count) == '('){
                if(s.charAt(count+1) != ','){
                    String s1 = s.substring(count + 1);
                    TreeNodeBox treeNode = build(s1);
                    root.left = treeNode.treeNode;
                    count += treeNode.pos;
                }
            }else if(s.charAt(count)==','){
                if(s.charAt(count+1) != ')'){
                    String s2 = s.substring(count + 1);
                    TreeNodeBox right = build(s2);
                    root.right = right.treeNode;
                    count += right.pos ;
                }
            }else if(s.charAt(count)==')'){
                count +=1;
                break;
            }
            count += 1;
        }
        treeNodeBox.treeNode = root;
        treeNodeBox.pos =count;
        return treeNodeBox;
    }

}

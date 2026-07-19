/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    
    void recover_BST_inorder(TreeNode*root, TreeNode*&first, TreeNode*&middle, TreeNode*&last, TreeNode*&prev) {
        if(root){
            recover_BST_inorder(root->left, first, middle, last, prev);
            
            if(prev && root->val < prev->val){
                if(!first){
                    first = prev;
                    middle = root;
                }
                else{
                    last = root;
                }
            }
            prev = root;
            
            recover_BST_inorder(root->right, first, middle, last, prev);
        }
    }
    
    void recoverTree(TreeNode* root) {
        TreeNode*first, *middle, *last, *prev;
        first = middle = last = prev = NULL;
        
        recover_BST_inorder(root, first, middle, last, prev);
        
        if(first && last){
            int temp = first->val;
            first->val = last->val;
            last->val = temp;
        }
        else{
            int temp = first->val;
            first->val = middle->val;
            middle->val = temp;
        }
        return;
    }
};
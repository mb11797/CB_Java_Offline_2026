class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();

        for(int asteroid: asteroids){
            while(!stk.isEmpty() && stk.peek() > 0 && asteroid < 0){
                if(stk.peek() == Math.abs(asteroid)){
                    stk.pop();
                    asteroid = 0;
                    break;
                }
                else if(stk.peek() < Math.abs(asteroid)){
                    stk.pop();
                }
                else{
                    // stk.peek() > Math.abs(asteroid)
                    asteroid = 0;
                    break;
                }
            }
            if(asteroid != 0){
                stk.push(asteroid);
            }
        }

        int[] ans = new int[stk.size()];
        for(int i=ans.length-1; i>=0; i--){
            ans[i] = stk.pop();
        }

        return ans;
    }
}


/*
class Solution {
  public int[] asteroidCollision(int[] asteroids) {
    int top = -1;
    for(int asteroid : asteroids){
      boolean alive = true;
      while(alive && top >= 0 && asteroid < 0 && asteroids[top] > 0){
       
        if(asteroids[top] > -asteroid){
          alive = false;
        }
        else if(asteroids[top] == -asteroid){
          top--;
          alive = false;
        }
        else{
          top--;
        }
      }
      if(alive){
        asteroids[++top] = asteroid;
      }
    }
    return Arrays.copyOfRange(asteroids, 0, top + 1);
  }
}
*/
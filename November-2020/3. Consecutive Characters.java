class Solution {
    public int maxPower(String s) {
        char[] ch = s.toCharArray();
        int[] power = new int[s.length()];
        
        int powermax = power[0] = 1;
        for(int i = 1; i < ch.length; i++) {
            if(ch[i] == ch[i - 1]) 
                power[i] = power[i - 1] + 1;
            else 
                power[i] = 1;
            
            if(power[i] > powermax) 
                powermax = power[i];
        }
        
        return powermax;
    }
}

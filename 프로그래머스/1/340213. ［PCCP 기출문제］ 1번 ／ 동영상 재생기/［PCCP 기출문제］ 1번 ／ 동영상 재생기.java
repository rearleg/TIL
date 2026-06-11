import java.util.*;

class Solution {
    public String solution(String a, String b, String c, String d, String[] commands) {
        
        
        int len = Integer.parseInt(a.substring(0, 2)) * 60 + Integer.parseInt(a.substring(3, 5));
        int pos = Integer.parseInt(b.substring(0, 2)) * 60 + Integer.parseInt(b.substring(3, 5));
        int opStart = Integer.parseInt(c.substring(0, 2)) * 60 + Integer.parseInt(c.substring(3, 5));
        int opEnd = Integer.parseInt(d.substring(0, 2)) * 60 + Integer.parseInt(d.substring(3, 5));
        if(isOp(pos, opStart, opEnd)) pos = opEnd;
        
        for (String cmd : commands) {
            if (cmd.equals("prev")) pos = prev(pos);
            else pos = next(pos, len);
            if(isOp(pos, opStart, opEnd)) pos = opEnd;
            
        }
        
        StringBuilder sb = new StringBuilder();
        if(pos / 60 < 10) sb.append('0');
        sb.append(pos / 60).append(":");
        if(pos % 60 < 10) sb.append('0');
        sb.append(pos % 60);
        
        return sb.toString();
    }
    
    
    static int prev(int pos) {
        int newPos = pos-= 10;
        return newPos < 0 ? 0 : newPos;
    }
    
    static int next(int pos, int len) {
        int newPos = pos += 10;
        return newPos >= len ? len : newPos;
    }
    
    static boolean isOp(int pos, int opStart, int opEnd) {
        return opStart <= pos && pos <= opEnd;
    }
    
    
}
public class Solution {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        if(dirs.length == 0 || dirs.length == 1) return "/";
        
        LinkedList<String> res = new LinkedList<>();
        
        for(int i = 1; i < dirs.length; ++i){
            if(".".equals(dirs[i]) || "".equals(dirs[i])) continue;
            else if("..".equals(dirs[i])) res.pollLast();
            else res.offer(dirs[i]);
        }

        StringBuffer sb = new StringBuffer();
        if(res == null || res.size() == 0) return "/";
        
        for(int i = 0; i < res.size(); ++i){
            sb.append("/").append(res.get(i));
        }
        return sb.toString();
    }
}
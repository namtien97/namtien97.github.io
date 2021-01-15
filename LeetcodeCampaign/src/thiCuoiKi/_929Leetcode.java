package thiCuoiKi;
import java.util.HashSet;
import java.util.Set;

public class _929Leetcode {
    static public int numUniqueEmails(String[] emails) {
        Set set = new HashSet();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < emails.length; i++) {
            String [] emailArr = emails[i].split("@");
            if(temp!=null){
                temp.delete(0,temp.length());
            }
            for (int j = 0; j < emailArr[0].length(); j++) {
                char c = emails[i].charAt(j);
                if(c=='.'){
                    continue;
                }else if (c=='+'){
                    break;
                }else{
                    temp.append(c);
                }
            }
            temp.append('@');
            temp.append(emailArr[1]);
            set.add(temp.toString());
        }
        return set.size();
    }

    public static void main(String[] args) {
        String[] emails = {"fg.r.u.uzj+o.pw@kziczvh.com", "r.cyo.g+d.h+b.ja@tgsg.z.com", "fg.r.u.+o.f.duzj@kziczvh.com", "r.cyo.g+ng.r.iq@tgsg.z.com", "fg.r.u.uzj+lp.k@kziczvh.com", "r.cyo.g+n.h.e+n.g@tgsg.z.com", "fg.r.u.uzj+k+p.j@kziczvh.com", "fg.r.u.uzj+w.y+b@kziczvh.com", "r.cyo.g+x+d.c+f.t@tgsg.z.com", "r.cyo.g+x+t.y.l.i@tgsg.z.com", "r.cyo.g+brxxi@tgsg.z.com", "r.cyo.g+z+dr.k.u@tgsg.z.com", "r.cyo.g+d+l.c.n+g@tgsg.z.com", "fg.r.u.uzj+vq.o@kziczvh.com", "fg.r.u.uzj+uzq@kziczvh.com", "fg.r.u.uzj+mvz@kziczvh.com", "fg.r.u.uzj+taj@kziczvh.com", "fg.r.u.uzj+fek@kziczvh.com"};
        String[] emails2 = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(emails));
    }
}

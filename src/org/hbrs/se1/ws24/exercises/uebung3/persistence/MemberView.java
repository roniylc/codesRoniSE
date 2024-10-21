package org.hbrs.se1.ws24.exercises.uebung3.persistence;
import org.hbrs.se1.ws24.exercises.uebung2.Member;
import java.util.ArrayList;
import java.util.List;

public class MemberView {

    public void dump(List<Member> members) {
        for (Member member : members) {
            System.out.println(member.toString());
        }
    }
}

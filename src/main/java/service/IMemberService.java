package service;

import vo.Member;

public interface IMemberService {
	Member getMemberLogin(Member paramMember);
	int addMember(Member paramMember);
	}
	

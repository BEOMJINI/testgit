package s1_Member;

import java.util.Scanner;

import s_Util.Util;

public class MemberController {
	private MemberController() {
	}

	private static MemberController instance = new MemberController();

	public static MemberController getInstance() {
		return instance;
	}

	private MemberDAO mDao; // = new MemberDAO();
	private Scanner sc;

	// 로그인 메뉴 , 회원가입 메뉴 , init
	// setAdmin
	public void init() {
		mDao = new MemberDAO();
		mDao.getMlist().add(new Member(1, "admin", "admin", "admin"));
		sc = Util.sc;
	}

//	/** admin 세팅 */
//	public void setAdmin() {
//		mDao.getMlist().add(new Member(1, "admin", "admin", "admin"));
//
//	}

//	public void name() {
//		System.out.println(mDao.getMlist().get(0).getId());
//	}

	/** 로그인 페이지 */
	public String loginMenu() {
		System.out.println("\n[로그인]");
		System.out.print("# ID ->  ");
		String id = sc.next();
		System.out.print("# PW ->  ");
		String pw = sc.next();
		if (mDao.checkLogin(id, pw) == true) {
			// System.out.printf("\n[%s 로그인]\n",id);
			return id;
		}
		return "";
	}

	/** 회원가입 페이지 */
	public void joinMenu() {
		System.out.println("\n[회원가입]");
		while (true) {
			System.out.print("# ID ->  ");
			String id = sc.next();
			if (mDao.checkId(id) == true) {
				System.out.println("[중복된 아이디]\n다른 아이디를 사용해주세요.");
				continue;
			}
			System.out.print("# PW ->  ");
			String pw = sc.next();
			System.out.print("# NAME ->  ");
			String name = sc.next();
			mDao.getMlist().add(new Member(mDao.Num(), id, pw, name));
			System.out.printf("\n[%s 가입 완료]\n", id);
			break;
		}
	}

	/** admin회원관리 1.회원목록 출력 */
	public void printMember() {
		System.out.println("\n[회원목록]");
		System.out.println(mDao.toString());
	}
}

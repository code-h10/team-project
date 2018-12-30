package member.service;

import java.util.ArrayList;

import member.dao.MemberDAO;
import member.vo.MemberVO;


public class MemberService {
	private static MemberService service = new MemberService();
	public MemberDAO dao = MemberDAO.getInstance();
	private MemberService(){}
	
	public static MemberService getInstance(){
		return service;
	}
	public void memberUserInsert(MemberVO member){
		dao.memberUserInsert(member);
	}
	
	public MemberVO memberSellerLogin(String mail, String passwd){
		MemberVO member = dao.memberSellerLogin(mail, passwd);
		return member;
	}
	
	public MemberVO memberLogin(String mail, String passwd){
		MemberVO member = dao.memberLogin(mail,passwd);
		return member;
	}
	
	public int memberUserUpdate(MemberVO member){
		int result = dao.memberUserUpdate(member);
		return result;
	}
	
	public int memberSellerUpdate(MemberVO member){
		int result = dao.memberSellerUpdate(member);
		return result;
	}
	
	public void memberSaleInsert(MemberVO member){
		dao.memberSaleInsert(member);
	}
	
	public int memberSaleUpdate(MemberVO member){
		int result = dao.memberSaleUpdate(member);
		return result;
	}
	
	public ArrayList<MemberVO> memberSaleList(){
		ArrayList<MemberVO> list = dao.memberSaleList();
		return list;
	}
}

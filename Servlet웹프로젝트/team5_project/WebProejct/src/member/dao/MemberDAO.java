package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import member.vo.MemberVO;

public class MemberDAO {
	private static MemberDAO dao = new MemberDAO();
	private MemberDAO(){}
	public static MemberDAO getInstance(){
		return dao;
	}
	
	public Connection connect(){
		Connection conn = null;
		String server = "jdbc:mysql://localhost:3306/test_db?useUnicode=true&characterEncoding=utf8&autoReconnect=true&useSSL=false";
		String did = "javaDB";
		String dpw = "javaDB";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(server, did, dpw);
		}catch(Exception ex){
			System.out.println("오류 발생 : " + ex);
		}
		return conn;
	}
	public void close(Connection conn, PreparedStatement ps, ResultSet rs){
		if(rs != null){
			
			try{
				rs.close();
				
			}catch(Exception ex){
				System.out.println("오류 발생 : "+ ex);
			}
		}
		close(conn,ps);
	}
	public void close(Connection conn, PreparedStatement ps){
		if(ps != null){
			try{
				ps.close();
			}catch(Exception ex){
				System.out.println("오류 발생 : " + ex);
			}
		}
		if(conn != null){
			try{
				conn.close();
			}catch(Exception ex){
				System.out.println("오류 발생 : " + ex);
			}
		}
	}
	
	
	// 사용자 정보 등록
	public void memberUserInsert(MemberVO member){
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			
				conn = connect();
				if(member.getDivision().equals("0")){
					pstmt= conn.prepareStatement("insert into users (mail,passwd, name, address, phone,division) values(?,?,?,?,?,?)");
					pstmt.setString(1, member.getMail());
					pstmt.setString(2, member.getPasswd());
					pstmt.setString(3, member.getName());
					pstmt.setString(4, member.getAddress());
					pstmt.setString(5, member.getPhone());
					pstmt.setString(6, member.getDivision());
					pstmt.executeUpdate();
				}else if(member.getDivision().equals("1")){
					
					pstmt= conn.prepareStatement("insert into users (mail,passwd, name, address, phone,division) values(?,?,?,?,?,?)");
					pstmt.setString(1, member.getMail());
					pstmt.setString(2, member.getPasswd());
					pstmt.setString(3, member.getName());
					pstmt.setString(4, member.getAddress());
					pstmt.setString(5, member.getPhone());
					pstmt.setString(6, member.getDivision());
					pstmt.executeUpdate();
					
					pstmt = conn.prepareStatement("insert into seller (sellername,selleraddress,sellerhours,sellerphone) values(?,?,?,?)");
					pstmt.setString(1, member.getSellerName());
					pstmt.setString(2, member.getSellerAddress());
					pstmt.setString(3, member.getSellerHours());
					pstmt.setString(4, member.getSellerPhone());
					pstmt.executeUpdate();
				}

		}catch(Exception ex){
			System.out.println("오류 발생 : " + ex);
		}finally{
			close(conn,pstmt);
		}
	}
	
	// 상품 정보 등록
	public void memberSaleInsert(MemberVO member){
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = connect();
			pstmt = conn.prepareStatement("insert into saleinfo (saleclass, salename,saleoption, salefoodinfo, saleprice) values(?,?,?,?,?)");
			pstmt.setString(1, member.getSaleClass());
			pstmt.setString(2, member.getSaleName());
			pstmt.setString(3, member.getSaleOption());
			pstmt.setString(4, member.getSaleFoodinfo());
			pstmt.setString(5, member.getSaleprice());
			pstmt.executeUpdate();
		}catch(Exception ex){
			System.out.println("오류 : " + ex);
		}finally{
			close(conn,pstmt);
		}
	}
	
	
	public MemberVO memberSellerLogin(String mail, String passwd){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO member = null;
		
		try{
			conn = connect();
			pstmt = conn.prepareStatement("select * from users, seller where users.division=1 and users.mail=? and users.passwd=?");
			pstmt.setString(1, mail);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				member = new MemberVO();
				member.setUser_id(rs.getString(1));
				member.setMail(rs.getString(2));
				member.setPasswd(rs.getString(3));
				member.setName(rs.getString(4));
				member.setAddress(rs.getString(5));
				member.setPhone(rs.getString(6));
				member.setDivision(rs.getString(7));
				
				member.setSeller_id(rs.getString(1));
				member.setSellerName(rs.getString(2));
			
				
				
			}
		}catch(Exception ex){
			System.out.println("오류 발생 : " + ex);
		}finally{
			close(conn,pstmt);
		}
		return member;
	}
	
	// 사용자 로그인 정보 불러오기
	public MemberVO memberLogin(String mail, String passwd){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO member = null;
		try{
			conn = connect();
			pstmt = conn.prepareStatement("select * from users where users.mail=? and users.passwd=?");
			pstmt.setString(1, mail);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();
			if(rs.next()){
				member = new MemberVO();
				member.setUser_id(rs.getString(1));
				member.setMail(rs.getString(2));
				member.setPasswd(rs.getString(3));
				member.setName(rs.getString(4));
				member.setAddress(rs.getString(5));
				member.setPhone(rs.getString(6));
				member.setDivision(rs.getString(7));
			}
		
		}catch(Exception ex){
			System.out.println("오류 발생 : " + ex);
		}finally{
			close(conn,pstmt);
		}
		return member;
	}
	
	// 사용자 정보 업데이트
	public int memberUserUpdate(MemberVO member){
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = connect();
			pstmt = conn.prepareStatement("update users set mail=?, passwd=?, name=?, address=?, phone=?, division=? where user_id=?");
			pstmt.setString(1, member.getMail());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getAddress());
			pstmt.setString(5, member.getPhone());
			pstmt.setString(6, member.getDivision());
			pstmt.setString(7, member.getUser_id());
			result = pstmt.executeUpdate();
		}catch(Exception ex){
			System.out.println("오류 발생 : " + ex);
		}finally{
			close(conn,pstmt);
		}
		return result;
	}
	
	
	// 판매자 정보 업데이트
	public int memberSellerUpdate(MemberVO member){
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = connect();
			pstmt = conn.prepareStatement("update seller set sellername=?, selleraddress=?, sellerhours=?, sellerphone=? where seller_id=?");
			pstmt.setString(1, member.getSellerName());
			pstmt.setString(2, member.getSellerAddress());
			pstmt.setString(3, member.getSellerHours());
			pstmt.setString(4, member.getSellerPhone());
			pstmt.setString(7, member.getSeller_id());
			result = pstmt.executeUpdate();
		}catch(Exception ex){
			System.out.println("오류 발생 : " + ex);
		}finally{
			close(conn,pstmt);
		}
		return result;
	}
	
	// 판매정보 변경
	public int memberSaleUpdate(MemberVO member){
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = connect();
			pstmt = conn.prepareStatement("update saleinfo set saleclass=?, salename=?, saleoption=?, salefoodinfo=?, saleprice=? where sale_id=?");
			pstmt.setString(1, member.getSaleClass());
			pstmt.setString(2, member.getSaleName());
			pstmt.setString(3, member.getSaleOption());
			pstmt.setString(4, member.getSaleFoodinfo());
			pstmt.setString(5, member.getSaleprice());
			result = pstmt.executeUpdate();
		}catch(Exception ex){
			System.out.println("오류 발생 : " + ex);
		}finally{
			close(conn, pstmt);
		}
		return result;
	}
	
	
	// 판매정보 목록
	public ArrayList<MemberVO> memberSaleList(){
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO member = null;
		
		try{
			conn = connect();
			pstmt = conn.prepareStatement("select * from saleinfo");
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				member = new MemberVO();
				member.setSale_id(rs.getString(1));
				member.setSaleClass(rs.getString(2));
				member.setSaleName(rs.getString(3));
				member.setSaleOption(rs.getString(4));
				member.setSaleFoodinfo(rs.getString(5));
				member.setSaleprice(rs.getString(6));
				list.add(member);
			}
		}catch(Exception ex){
			System.out.println("오류 발생 : " + ex);
		}finally{
			close(conn, pstmt, rs);
		}
		return list;
	}
}
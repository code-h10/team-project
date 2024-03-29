package member.vo;

public class MemberVO {
	//사용자정보변수
	private String user_id;
	private String mail;
	private String passwd;
	private String name;
	private String address;
	private String phone;
	private String division;
	
	// 판매정보변수
	private String sale_id;
	private String sale_class;
	private String sale_name;
	private String sale_option;
	private String sale_foodinfo;
	private String sale_price;
	
	//판매자정보변수
	private String seller_id;
	private String sellername;
	private String selleraddress;
	private String sellerhours;
	private String sellerphone;
	//private String seller_proof;
	
	// 사용자 정보
	public String getUser_id(){
		return user_id;
	}
	public void setUser_id(String user_id){
		this.user_id = user_id;
	}
	public String getMail(){
		return mail;
	}
	public void setMail(String mail){
		this.mail = mail;
	}
	
	public String getPasswd(){
		return passwd;
	}
	public void setPasswd(String passwd){
		this.passwd = passwd;
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public String getAddress(){
		return address;
	}
	public void setAddress(String address){
		this.address = address;
	}
	
	public String getPhone(){
		return phone;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
	public String getDivision(){
		return division;
	}
	public void setDivision(String division){
		this.division = division;
	}
	
	
	
	
	
	// 판매자정보
	public String getSeller_id(){
		return seller_id;
	}
	public void setSeller_id(String seller_id){
		this.seller_id = seller_id;
	}
	public String getSellerName(){
		return sellername;
	}
	public void setSellerName(String sellername){
		this.sellername = sellername;
	}
	public String getSellerAddress(){
		return selleraddress;
	}
	public void setSellerAddress(String selleraddress){
		this.selleraddress = selleraddress;
	}
	public String getSellerHours(){
		return sellerhours;
	}
	public void setSellerHours(String sellerhours){
		this.sellerhours = sellerhours;
	}
	public String getSellerPhone(){
		return sellerphone;
	}
	public void setSellerPhone(String sellerphone){
		this.sellerphone = sellerphone;
	}

	
	// 판매 정보
	public String getSale_id(){
		return sale_id;
	}
	public void setSale_id(String sale_id){
		this.sale_id = sale_id;
	}
	public String getSaleClass(){
		return sale_class;
	}
	public void setSaleClass(String saleclass){
		this.sale_class = saleclass;
	}
	public String getSaleName(){
		return sale_name;
	}
	public void setSaleName(String salename){
		this.sale_name = salename;
	}
	public String getSaleOption(){
		return sale_option;
	}
	public void setSaleOption(String saleoption){
		this.sale_option = saleoption;
	}
	public String getSaleFoodinfo(){
		return sale_foodinfo;
	}
	public void setSaleFoodinfo(String salefoodinfo){
		this.sale_foodinfo = salefoodinfo;
	}
	public String getSaleprice(){
		return sale_price;
	}
	public void setSaleprice(String saleprice){
		this.sale_price = saleprice;
	}
	
}

package vo;

public class ComplaintVo {
	private static int cid;
	private static String name;
	private static String address;
	private static String contact;
	private static String S3key;
	public  String getName() {
		return name;
	}
	public  void setName(String name) {
		ComplaintVo.name = name;
	}
	public String getAddress() {
		return address;
	}
	public  void setAddress(String address) {
		ComplaintVo.address = address;
	}
	public String getContact() {
		return contact;
	}
	public  void setContact(String contact) {
		ComplaintVo.contact = contact;
	}
	public String getS3key() {
		return S3key;
	}
	public  void setS3key(String s3key) {
		S3key = s3key;
	}
	public  int getCid() {
		return cid;
	}
	public  void setCid(int cid) {
		ComplaintVo.cid = cid;
	}
}

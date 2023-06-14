package dto;

public class MemberDTO {
    private String name;
    private String nid;
    private String id;
    private String contactNo;
    private String email;
    private String address;
    private String subs;

    public MemberDTO(String updateMemberId) {
        this.id=updateMemberId;
    }



    @Override
    public String toString() {
        return "MemberDTO{" +
                "name='" + name + '\'' +
                ", nid='" + nid + '\'' +
                ", id='" + id + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", subs='" + subs + '\'' +
                '}';
    }

    public MemberDTO(String name, String nid, String id, String contactNo, String email, String address, String subs) {
        this.setName(name);
        this.setNid(nid);
        this.setId(id);
        this.setContactNo(contactNo);
        this.setEmail(email);
        this.setAddress(address);
        this.setSubs(subs);
    }

    public MemberDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSubs() {
        return subs;
    }

    public void setSubs(String subs) {
        this.subs = subs;
    }
}

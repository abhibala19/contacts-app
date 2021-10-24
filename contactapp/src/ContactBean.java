import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ContactBean {
    private String contactName;
    private String tags;
    private String address;

    private String petName;
    private Date dob;
    private List<String> email;
    private  List<String> phoneNo;

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public ContactBean() {
    }

    public ContactBean(String contactName, String tags, String address, String petName, Date dob, List<String> email, List<String> phoneNo) {
        this.contactName = contactName;
        this.tags = tags;
        this.address = address;
        this.petName = petName;
        this.dob = dob;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ContactBean{");
        sb.append("contactName='").append(contactName).append('\'');
        sb.append(", tags='").append(tags).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", petName='").append(petName).append('\'');
        sb.append(", dob=").append(dob);
        sb.append(", email=").append(email);
        sb.append(", phoneNo=").append(phoneNo);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactBean that = (ContactBean) o;
        return Objects.equals(contactName, that.contactName) &&
                Objects.equals(tags, that.tags) &&
                Objects.equals(address, that.address) &&
                Objects.equals(petName, that.petName) &&
                Objects.equals(dob, that.dob) &&
                Objects.equals(email, that.email) &&
                Objects.equals(phoneNo, that.phoneNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactName, tags, address, petName, dob, email, phoneNo);
    }

    public List<String> getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(List<String> phoneNo) {
        this.phoneNo = phoneNo;
    }

    public List<String> getEmail() {
        return email;
    }

    public void setEmail(List<String> email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getTags() {
        return tags;
    }

    public String getContactName() {
        return contactName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Registrar {

	@Id
	@GenericGenerator(name="ut" , strategy="increment")
	@GeneratedValue(generator="ut")
	@Column(name="RID")
	private Integer RID;
	private Integer SID;
	private String CID;
	
	public void setRID(Integer i) {
		RID = i;
	}
	
	public Integer getRID() {
		return RID;
	}
	
	public Integer getSID() {
		return SID;
	}
	
	public void setSID(Integer i) {
		SID = i;
	}
	
	public String getCID() {
		return CID;
	}
	
	public void setCID(String s) {
		CID = s;
	}
}

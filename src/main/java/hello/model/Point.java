package hello.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "EPC_POINTS")
public class Point {

	private String id;
	private int x;
	private int y;
	private int sequence;
	private Polygone polygone;
	
	public Point() {}
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name="EPC_POT_ID")
	public String getId(){
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name="EPC_POT_X", nullable = false)
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	@Column(name="EPC_POT_Y", nullable = false)
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	@Column(name="EPC_POT_SEQUENCE", nullable = false)
	public int getSequence() {
		return sequence;
	}
	
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EPC_POC_POL_ID", nullable = false)
	@JsonIgnore()
	public Polygone getPolygone(){
		return polygone;
	}
	
	public void setPolygone(Polygone polygone) {
		this.polygone = polygone;
	}
}

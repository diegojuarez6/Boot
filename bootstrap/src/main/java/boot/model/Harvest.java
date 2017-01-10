package boot.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="harvests")
public class Harvest implements Serializable {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=45)
	private String site;
	@Column(length=45)
	private String siteCode;
	@Column(length=45)
	private String station;
	@Column(length=45)
	private String sampleDate;
	@Column(length=45)
	private String variable;
	
	public Harvest(String site, String siteCode, String station, String sampleDate, String variable) {
		super();
		this.site = site;
		this.siteCode = siteCode;
		this.station = station;
		this.sampleDate = sampleDate;
		this.variable = variable;
	}
	
	public Harvest(){
		this("","","","","");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public String getSampleDate() {
		return sampleDate;
	}

	public void setSampleDate(String sampleDate) {
		this.sampleDate = sampleDate;
	}

	public String getVariable() {
		return variable;
	}

	public void setVariable(String variable) {
		this.variable = variable;
	}

	@Override
	public String toString() {
		return "Harvest [id=" + id + ", site=" + site + ", siteCode=" + siteCode + ", station=" + station
				+ ", sampleDate=" + sampleDate + ", variable=" + variable + "]";
	}
	
	
}

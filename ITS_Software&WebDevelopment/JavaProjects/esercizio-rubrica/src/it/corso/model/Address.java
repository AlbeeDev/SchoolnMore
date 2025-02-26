package it.corso.model;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;

public class Address {
	
	private int id;
	private String street;
	private String civic;
	private String cap;
	private String town;
	private String province;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCivic() {
		return civic;
	}

	public void setCivic(String civic) {
		this.civic = civic;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Override
	public String toString() {
		return "Address{" +
				"id=" + id +
				", street='" + street + '\'' +
				", civic='" + civic + '\'' +
				", cap='" + cap + '\'' +
				", town='" + town + '\'' +
				", province='" + province + '\'' +
				'}';
	}
}
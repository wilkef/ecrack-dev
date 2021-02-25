package com.wilkef.ecrack.setup.admin.dto;

public class ManageInstructorDTO {
	private Integer instructorId;
	private String name;
	private String designation;
	private String image;

	public Integer getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(Integer instructorId) {
		this.instructorId = instructorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "InstructorDTO [instructorId=" + instructorId + ", name=" + name + ", designation=" + designation
				+ ", image=" + image + "]";
	}
}

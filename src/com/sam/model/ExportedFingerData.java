package com.sam.model;

import java.io.Serializable;

import com.mantra.model.Data;

public class ExportedFingerData implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private Data isoTemplateData;
	private Data bmpData;
	private Data isoImageData;
	private Data ansiTemplateData;
	private Data rawData;
	private Data wsqData;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Data getIsoTemplateData() {
		return isoTemplateData;
	}

	public void setIsoTemplateData(Data isoTemplateData) {
		this.isoTemplateData = isoTemplateData;
	}

	public Data getBmpData() {
		return bmpData;
	}

	public void setBmpData(Data bmpData) {
		this.bmpData = bmpData;
	}

	public Data getIsoImageData() {
		return isoImageData;
	}

	public void setIsoImageData(Data isoImageData) {
		this.isoImageData = isoImageData;
	}

	public Data getAnsiTemplateData() {
		return ansiTemplateData;
	}

	public void setAnsiTemplateData(Data ansiTemplateData) {
		this.ansiTemplateData = ansiTemplateData;
	}

	public Data getRawData() {
		return rawData;
	}

	public void setRawData(Data rawData) {
		this.rawData = rawData;
	}

	public Data getWsqData() {
		return wsqData;
	}

	public void setWsqData(Data wsqData) {
		this.wsqData = wsqData;
	}
}

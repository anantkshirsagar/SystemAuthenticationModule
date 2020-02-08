package com.sam.dbservice;

import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dbmanager.objectify.Objectify;
import com.mantra.model.Data;
import com.sam.model.ExportedFingerData;
import com.sam.service.AbstractDBService;

public class ScannerDBService extends AbstractDBService {

	private static final Logger LOG = LoggerFactory.getLogger(ScannerDBService.class);

	public void saveFingerData(ExportedFingerData exportData) throws SQLException, IOException, ClassNotFoundException {
		connectionSettings.build();
		String query = "insert into finger_print_data(ansi_data, iso_data, bmp_data, raw_data, wsq_data) values(?,?,?,?,?)";
		PreparedStatement prepareStatement = connectionSettings.getConnection().prepareStatement(query);
		prepareStatement.setObject(1, Objectify.serialize(exportData.getAnsiTemplateData()));
		prepareStatement.setObject(2, Objectify.serialize(exportData.getIsoImageData()));
		prepareStatement.setObject(3, Objectify.serialize(exportData.getBmpData()));
		prepareStatement.setObject(4, Objectify.serialize(exportData.getRawData()));
		prepareStatement.setObject(5, Objectify.serialize(exportData.getWsqData()));
		LOG.debug("Finger data saved {}", prepareStatement.executeUpdate());
		connectionSettings.closeConnection();
	}

	public ExportedFingerData getFingerData() throws SQLException, ClassNotFoundException, IOException {
		connectionSettings.build();
		ExportedFingerData exportData = new ExportedFingerData();
		String query = "select * from finger_print_data limit 1";
		PreparedStatement prepareStatement = connectionSettings.getConnection().prepareStatement(query);

		ResultSet resultSet = prepareStatement.executeQuery();
		if (resultSet.next()) {
			InputStream ansiStream = resultSet.getBinaryStream("ansi_data");
			InputStream isoStream = resultSet.getBinaryStream("iso_data");
			InputStream bmpStream = resultSet.getBinaryStream("bmp_data");
			InputStream rawStream = resultSet.getBinaryStream("raw_data");
			InputStream wsqStream = resultSet.getBinaryStream("wsq_data");

			exportData.setId(resultSet.getLong("id"));
			exportData.setAnsiTemplateData((Data) Objectify.deserialize(IOUtils.toByteArray(ansiStream)));
			exportData.setIsoImageData((Data) Objectify.deserialize(IOUtils.toByteArray(isoStream)));
			exportData.setBmpData((Data) Objectify.deserialize(IOUtils.toByteArray(bmpStream)));
			exportData.setRawData((Data) Objectify.deserialize(IOUtils.toByteArray(rawStream)));
			exportData.setWsqData((Data) Objectify.deserialize(IOUtils.toByteArray(wsqStream)));
		}
		connectionSettings.closeConnection();
		return exportData;
	}

	public void deleteFingerData() throws ClassNotFoundException, SQLException {
		connectionSettings.build();
		String query = "delete from finger_print_data";
		PreparedStatement prepareStatement = connectionSettings.getConnection().prepareStatement(query);
		LOG.debug("Query {}", prepareStatement);
		LOG.debug("Finger data removed {}", prepareStatement.executeUpdate());
		connectionSettings.closeConnection();
	}
}

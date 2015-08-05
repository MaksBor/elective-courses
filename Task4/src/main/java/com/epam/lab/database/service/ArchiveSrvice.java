package com.epam.lab.database.service;

import java.util.List;



import com.epam.lab.database.model.Archive;
import com.epam.lab.hibernate.dao.ArchiveDAO;


public class ArchiveSrvice {

	public static void addDaybook(Archive archive) {
		ArchiveDAO.addArchive(archive);
	}

	public static void delArchive(Integer id) {
		ArchiveDAO.deleteArchive(id);;
	}

	public static void updateArchive(Archive archive) {
		ArchiveDAO.updateArchive(archive);
	}

	public static List<Archive> getAllArchive() {
		return ArchiveDAO.getAllArchive();
	}

	public static Archive getArchive(Integer id) {
		return ArchiveDAO.getArchive(id);
	}
	public static List<Archive> getAllArchiveStudetn(Integer idStudent){
		return ArchiveDAO.getAllArchiveStudetn(idStudent);
	
	}
	public static List<Archive> getAllArchiveLecture(Integer idLector){
		return ArchiveDAO.getAllArchiveLecture(idLector);
	}
}

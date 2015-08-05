package com.epam.lab.database.service;

import java.util.List;

import com.epam.lab.database.dao.DaybookDAO;

import com.epam.lab.database.model.Daybook;


public class DaybookService {

	public static void addDaybook(Daybook daybook) {
		DaybookDAO.addDaybook(daybook);
	}

	public static void delDaybook(Integer id) {
		DaybookDAO.delDaybook(id);
	}

	public static void updateDaybook(Daybook daybook) {
		DaybookDAO.updateDaybook(daybook);
	}

	public static List<Daybook> getAllDaybook() {
		return DaybookDAO.getAllDaybook();
	}

	public static Daybook getDaybook(Integer id) {
		return DaybookDAO.getDaybook(id);
	}
}
